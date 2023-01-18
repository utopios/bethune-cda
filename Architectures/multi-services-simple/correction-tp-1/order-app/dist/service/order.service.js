"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.writeOrder = exports.createOrder = void 0;
const api_service_1 = require("./api.service");
const fs = __importStar(require("fs"));
const createOrder = async (orderRequestDto) => {
    let response = null;
    const customer = await (0, api_service_1.getCustomer)(orderRequestDto.customerId);
    const products = [];
    const productsResponse = await (0, api_service_1.getProducts)(orderRequestDto.productIds);
    productsResponse === null || productsResponse === void 0 ? void 0 : productsResponse.forEach(element => {
        const found = products.find(p => p.id == element.id);
        if (found != undefined) {
            found.qty = found.qty + 1;
        }
        else {
            products.push(Object.assign(Object.assign({}, element), { qty: 1 }));
        }
    });
    response = {
        products: products,
        customer: customer
    };
    (0, exports.writeOrder)(response);
    //Update du stock
    response.products.forEach(p => {
        (0, api_service_1.updateStock)(p.id, p.stock - p.qty);
    });
    return response;
};
exports.createOrder = createOrder;
const writeOrder = (order) => {
    const random = Math.floor(Math.random() * 10000);
    if (!fs.existsSync("orders")) {
        fs.mkdirSync("orders");
    }
    fs.writeFileSync(`orders/${random}.json`, JSON.stringify(order), { encoding: 'utf-8', flag: 'w+' });
};
exports.writeOrder = writeOrder;
