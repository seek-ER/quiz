import React, {Component} from 'react';
import {NavLink} from "react-router-dom";
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
            products:data
        })
    }

    handleClick = () => {

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