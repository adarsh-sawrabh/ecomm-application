import React, { Component } from "react";
import { connect } from "react-redux";

import { addToCart } from "../actions/cartActions";
import { fetchProducts } from "../actions/productActions";
import utils from "../utils";

class Products extends Component {

    componentDidMount() {
        this.props.fetchProducts();
    }

    render() {
        const productItems = this.props.products.map((product) => (
            <div className="col-md-4" key={product.productId}>
                <div className="thumbnail text-center">
                    <img src={`products/${product.imgId}.jpg`} alt={product.productName} />
                    <p>{product.productName}</p>
                    <b>{utils.formatCurrency(product.price)}</b>
                    <button
                        className="btn btn-primary"
                        onClick={(e) => this.props.addToCart(this.props.cartItems, product)}
                    >
                        Add to cart
                </button>
                </div>
            </div>
        ));

        return <div className="row">{productItems}</div>;
    }
}

const mapStateToProps = (state) => ({
    products: state.products.items,
    cartItems: state.cart.items,
});

export default connect(mapStateToProps, { fetchProducts, addToCart })(Products);