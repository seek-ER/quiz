import React, {Component} from 'react';
import {PlusCircleOutlined} from '@ant-design/icons';
import {Button} from 'antd';
import Cart from './Cart'
import './shop.css';

class Product extends Component {

    render() {
        console.log('Render product');
        return <span className={'product'}>
            <img src={this.props.picture} alt=""/>
            <div>
                <div>
                    {this.props.name}
                </div>
                <span>
                    {this.props.price}元/
                </span>
                <span>
                    {this.props.unit}
                </span>
                <Button type="primary" shape="circle"
                        onClick={() => this.props.handleClick(this.props.name, this.props.price, this.props.unit)}
                        icon={<PlusCircleOutlined/>}/>
            </div>
            <Cart/>
        </span>
    }
}

export default Product;