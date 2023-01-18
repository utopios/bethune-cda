import axios from "axios";
import { response } from "express";

const dico = {
    "product": "http://localhost:8081/api/product",
    "customer": "http://localhost:8082/api/customer",
    "order": "http://localhost:8080/api/order"
}

const getUrl = (api) => {
    const paths = api.split("/")
    const baseUrl = dico[paths[0]]
    const urlApi  = baseUrl + "/" + paths.shift().join("/")
    return urlApi
}

export const post =  async (api, data) => {
    return await axios.post(getUrl(api), data)
}

export const get =  async (api) => {
    return await axios.get(getUrl(api))
}

export const patch =  async (api, data) => {
    return await axios.patch(getUrl(api), data)
}