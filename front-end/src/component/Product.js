import React, {Component} from 'react';
import {PlusCircleOutlined} from '@ant-design/icons';
import {Button} from 'antd';
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
                    {this.props.price}
                </span>
                <span>
                    {this.props.unit}
                </span>
                <Button type="primary" shape="circle"
                        onClick={() => this.props.handleClick(this.props.name, this.props.price, this.props.unit)}
                        icon={<PlusCircleOutlined/>}/>
            </div>
        </span>
    }
}

export default Product;