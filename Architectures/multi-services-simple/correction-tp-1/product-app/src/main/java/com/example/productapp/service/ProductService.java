package com.example.productapp.service;

import com.example.productapp.dto.request.RequestProductDTO;
import com.example.productapp.dto.response.ResponseProductDTO;
import com.example.productapp.exception.NotFoundException;

public interface ProductService {

    public ResponseProductDTO createProduct(RequestProductDTO productDTO);
    public ResponseProductDTO updateStock(int id, int stock) throws NotFoundException;
    public ResponseProductDTO getProduct(int id) throws NotFoundException;
}
