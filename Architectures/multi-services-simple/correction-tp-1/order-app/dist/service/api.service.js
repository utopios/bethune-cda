"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.getCustomer = exports.getProducts = void 0;
const axios_1 = __importDefault(require("axios"));
const apiUris = {
    products: "http://localhost:8081",
    customers: "http://localhost:8082",
};
const getProduct = async (id) => {
    const response = await axios_1.default.get(`${apiUris.products}/api/product/${id}`);
    return response.data;
};
const getProducts = async (ids) => {
    const products = [];
    try {
        for (let id of ids) {
            products.push(await getProduct(id));
        }
        return products;
    }
    catch (ex) {
        console.log(ex);
        return null;
    }
};
exports.getProducts = getProducts;
const getCustomer = async (id) => {
    const response = await axios_1.default.get(`${apiUris.customers}/api/customer/${id}`);
    return response.data;
};
exports.getCustomer = getCustomer;
