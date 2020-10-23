import React, {Component} from 'react';

class AddProducts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: undefined,
            price: undefined,
            unit: undefined,
            pic: undefined
        }
    }

    handleChange = (event) => {
        this.setState({
            [event.target.name]: event.target.value
        })
    }
    handleSubmit = (event) => {
        event.preventDefault();
        fetch("http://localhost:8080/product", {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name: this.state.name,
                price: Number(this.state.price),
                unit: this.state.unit,
                picture: this.state.pic,
            })
        }).then(function(response) {
            if (response.status === 201) {
                alert("添加成功")
            }
            if (response.status === 400) {
                alert("商品名称已存在，请输入新的商品名称")
            }
        });
    }

    render() {
        return (
            <div className={'timer'}>
                <form onSubmit={this.handleSubmit}>
                    <div className={'title'}>添加商品</div>
                    <div className={'subtitle'}>
                        <div >名称：</div>
                        <input
                            className={'context'}
                            type="text"
                            name={'name'}
                            onChange={this.handleChange}
                            value={this.state.name}
                        />
                    </div>
                    <div className={'subtitle'}>
                        <div >价格：</div>
                        <input
                            className={'context'}
                            type="number"
                            min={0}
                            name={'price'}
                            onChange={this.handleChange}
                            value={this.state.price}
                        />
                    </div>
                    <div className={'subtitle'}>
                        <div >单位：</div>
                        <input
                            className={'context'}
                            type="text"
                            name={'unit'}
                            onChange={this.handleChange}
                            value={this.state.unit}
                        />
                    </div>
                    <div className={'subtitle'}>
                        <div >图片：</div>
                        <input
                            className={'context'}
                            type="text"
                            name={'pic'}
                            onChange={this.handleChange}
                            value={this.state.pic}
                        />
                    </div>
                    <input className={'submit'}
                           type="submit"
                           value={'submit'}
                           disabled={!this.state.name || !this.state.price || !this.state.unit ||!this.state.pic }
                    />
                </form>
            </div>
        )
    }
}

export default AddProducts;