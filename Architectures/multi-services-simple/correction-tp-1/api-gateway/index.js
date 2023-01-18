const express = require("express")
const cors = require("cors")
const { post } = require("./api.service")

const app = express()

app.use(cors({origin : "*", methods:["POST", "GET", "PATCH"]}))

app.post("product", async (req, res) => {
    res.json(await post("product", {...req.body}))
})