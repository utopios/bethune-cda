import axios from "axios"
import { CustomerResponseDTO } from "~/dto/customer-reponse-dto"
import { ProductResponseDTO } from "~/dto/product-response-dto"

const apiUris = {
    products : "http://localhost:8081",
    customers : "http://localhost:8082", 
}

const getProduct = async (id:Number):Promise<ProductResponseDTO> => {
    const response = await axios.get(`${apiUris.products}/api/products/${id}`)
    return <ProductResponseDTO>response.data
}

export const getProducts = async (ids:Number[]):Promise<ProductResponseDTO[]|null> => {
    const products:ProductResponseDTO[] = [] 
    try {
        for(let id of ids) {
            products.push(await getProduct(id))
        }
        return products
    }catch(ex) {
        console.log(ex)
        return null
    }
}

export const getCustomer = async (id:Number):Promise<CustomerResponseDTO> => {
    const response = await axios.get(`${apiUris.customers}/api/customers/${id}`)
    return <CustomerResponseDTO>response.data
}
