import { FETCH_PRODUCTS } from "../actions/productActions";

const initState = {
    items: []
};

export default function (state = initState, action) {
    switch (action.type) {
        case FETCH_PRODUCTS:
            return { ...state, items: action.payload };
        default:
            return state;
    }
}