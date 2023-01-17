import express from "express"
import cors from "cors"
import { OrderRequestDto } from "./dto/order-request-dto"
import { createOrder } from "./service/order.service"
const app = express()
app.use(cors({origin:"*", methods:["POST", "GET"]}))
app.use(express.json())

app.post("/api/order", async (req,res) => {
    const requestDto:OrderRequestDto = <OrderRequestDto>req.body 
    const response = await createOrder(requestDto)
    res.json(response)
})

app.listen(8080, () => {
    console.log("Application is running")
})