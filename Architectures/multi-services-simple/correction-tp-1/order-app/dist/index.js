"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const cors_1 = __importDefault(require("cors"));
const order_service_1 = require("./service/order.service");
const app = (0, express_1.default)();
app.use((0, cors_1.default)({ origin: "*", methods: ["POST", "GET"] }));
app.use(express_1.default.json());
app.post("/api/order", async (req, res) => {
    const requestDto = req.body;
    const response = await (0, order_service_1.createOrder)(requestDto);
    res.json(response);
});
app.listen(8080, () => {
    console.log("Application is running");
});
