import axios from 'axios';

import { FETCH_PRODUCTS } from "./types";

export const fetchProducts = () => {
    return (
        (dispatch) => {
            axios.get('http://localhost:8000/products').then(response => {
                dispatch({ type: FETCH_PRODUCTS, payload: response.data.productList });
            });
        }
    );
}