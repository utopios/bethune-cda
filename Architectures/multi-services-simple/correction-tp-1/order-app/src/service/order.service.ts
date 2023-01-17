import { CustomerResponseDTO } from "~/dto/customer-reponse-dto";
import { OrderRequestDto } from "~/dto/order-request-dto";
import { OrderResponseDto } from "~/dto/order-response-dto";
import { ProductResponseDTO } from "~/dto/product-response-dto";
import { WithQty } from "~/dto/with-qty";
import { getCustomer, getProducts } from "./api.service";
import * as fs from "fs"
export const createOrder = async(orderRequestDto:OrderRequestDto):Promise<OrderResponseDto|null> => {
    let response:OrderResponseDto|null = null
    const customer:CustomerResponseDTO = await getCustomer(orderRequestDto.customerId)
    const products:(ProductResponseDTO & WithQty)[] = []
    const productsResponse = await getProducts(orderRequestDto.productIds)
    productsResponse?.forEach(element => {
        const found = products.find(p => p.id == element.id)
        if(found != undefined) {
            found.qty = found.qty + 1
        }else {
            products.push({...found!, qty:1})
        }

    });
    response = {
        products:products,
        customer:customer
    }
    writeOrder(response)
    return response
}

export const writeOrder = (order:OrderResponseDto) => {
    const random = Math.random() * 1000
    fs.writeFileSync(`orders/${random}.json`,JSON.stringify(order))
}