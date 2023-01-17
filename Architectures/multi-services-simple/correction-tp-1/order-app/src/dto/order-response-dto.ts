import { CustomerResponseDTO } from "./customer-reponse-dto";
import { ProductResponseDTO } from "./product-response-dto";
import { WithQty } from "./with-qty";

export interface OrderResponseDto {
    customer:CustomerResponseDTO
    products:(ProductResponseDTO & WithQty)[]
}