// const express = require("express")
// const cors = require("cors")
// const { post } = require("./api.service")
import express from "express"
import cors from "cors"
import { post } from "./api.service.js"

const app = express()

app.use(cors({origin : "*", methods:["POST", "GET", "PATCH"]}))

app.use(express.json())

app.post("/product", async (req, res) => {    
    const response = await post("product", {...req.body})
    res.json(response.data)
})

app.listen(1000, () => {

})