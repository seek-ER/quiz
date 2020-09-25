import React from 'react';
import './App.css';
import 'jquery/dist/jquery.min.js';
import 'popper.js/dist/popper.js';
import 'bootstrap/dist/js/bootstrap.min.js';
import {Route, BrowserRouter, Switch, Link, NavLink} from "react-router-dom";
import Shop from "./component/Shop";
import Order from "./component/Order";
import AddProducts from "./component/AddProducts";

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <header className="App-header">
                    <NavLink className={'header-link'} to={'/'}>商城</NavLink>
                    <NavLink className={'header-link'} to={'/order'}>订单</NavLink>
                    <NavLink className={'header-link'} to={'/addProducts'}>添加商品</NavLink>
                </header>
                <div className={'App-body'}>
                    <Switch>
                        <Route exact path='/' component={Shop}/>
                        <Route exact path='/order' component={Order}/>
                        <Route exact path='/addProducts' component={AddProducts}/>
                    </Switch>
                </div>
                <footer className={'App-footer'}>
                    TWC Created by Lingzhen Kong.
                </footer>
            </BrowserRouter>
        </div>
    );
}

export default App;
