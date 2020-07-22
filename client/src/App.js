import React, { Component } from 'react';
import { Provider } from "react-redux";

import store from "./store";
import Products from "./components/Products";
import Basket from "./components/Basket";

import './App.css';

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <div className="container">
          <h1>BestBuyCart</h1>
          <hr />
          <div className="row">
            <div className="col-md-9">
              <Products />
            </div>
            <div className="col-md-3">
              <Basket />
            </div>
          </div>
        </div>
      </Provider>
    );
  }
}

export default App;
