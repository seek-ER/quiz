import React, {Component} from 'react';
import {NavLink} from "react-router-dom";

class Shop extends Component{
    constructor(props) {
        super(props);
        this.state={

        };
    }

    render(){
        return(
            <div className={'timer'}>
                <h1>在线倒计时器</h1>
                <div className={'timeMiddle'}>
                    <div className={'timeMiddleLeft'}>
                        <div>
                            设置时间
                            <input type="text"/>
                        </div>
                        <div>
                            <button>
                                start
                            </button>
                        </div>
                    </div>
                    <div className={'timeMiddleRight'}>
                        <input type="text"/>
                    </div>
                </div>
                <div className={'timerEnd'}>
                    <NavLink to={'/'}>回到首页</NavLink>
                </div>
            </div>
        )
    }
}

export default Shop;