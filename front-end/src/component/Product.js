import React, {Component} from 'react';
import './shop.css';

class Product extends Component{

    render() {
        console.log('Render product');
        return <span className={'product'}>
            <div>{this.props.name}</div>
            <img src={this.props.picture} alt=""/>
            <div>
                <span>
                    {this.props.price}
                </span>
                <span>
                    {this.props.unit}
                </span>
            </div>
        </span>
    }
}

export default Product;