import React, {Component} from 'react';
import Product from "./Product";
import './shop.css';

class Shop extends Component{
    constructor(props) {
        super(props);
        this.state = {
            products: [],
        }
    }

    componentDidMount = async () => {
        const URL = 'http://localhost:8080/product';
        const response = await fetch(URL);
        const data = await response.json();

        this.setState({
            products: data
        })
    }

    handleClick = async (productName, productPrice, productUnit) => {
        await fetch("http://localhost:8080/order", {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name: productName,
                price: productPrice,
                unit: productUnit
            })
        }).then(response => {
            if (response.status === 201) {
                alert("添加成功")
            }
        });
    }

    render() {
        console.log('Render all');
        return <div className={'products'}>
            {this.state.products.map(product =>
                <Product
                    name={product.name}
                    price={product.price}
                    unit={product.unit}
                    picture={product.picture}
                    handleClick={this.handleClick}
                />)}
        </div>
    }
}

export default Shop;