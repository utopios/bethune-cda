// const express = require("express")
// const cors = require("cors")
// const { post } = require("./api.service")
import express from "express"
import cors from "cors"
import { post } from "./api.service.js"

const apis = [
    {
        "product": {
            "verb": "post"
        }
    },
    {
        "customer": {
            "verb": "post"
        }
    },
    {
        "product": {
            "verb": "get",
            "params": ["id"]
        }
    }]

const app = express()

app.use(cors({ origin: "*", methods: ["POST", "GET", "PATCH"] }))

app.use(express.json())

// app.post("/product", async (req, res) => {    
//     const response = await post("product", {...req.body})
//     res.json(response.data)
// })

for (let i = 0; i < apis.length; i++) {
    for (let api in apis[i]) {
        
        switch (apis[i][api].verb) {
            case "post":                
                app.post("/"+api, async (req, res) => {
                    const response = await post(api, { ...req.body })
                    console.log(response)
                    res.json(response.data)
                })
                break
        }
    }
}

app.listen(1000, () => {

})