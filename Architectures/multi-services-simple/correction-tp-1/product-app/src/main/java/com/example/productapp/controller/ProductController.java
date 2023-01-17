package com.example.productapp.controller;

import com.example.productapp.dto.request.RequestProductDTO;
import com.example.productapp.dto.response.ResponseProductDTO;
import com.example.productapp.exception.NotFoundException;
import com.example.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")

@CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH})
public class ProductController {
    @Autowired
    private ProductService _productService;

    @PostMapping("")
    public ResponseEntity<ResponseProductDTO> post(@RequestBody RequestProductDTO productDTO) {
        return ResponseEntity.ok(_productService.createProduct(productDTO));
    }

    @PostMapping("{id}")
    public ResponseEntity<ResponseProductDTO> post(@PathVariable int id) {
        try {
            return ResponseEntity.ok(_productService.getProduct(id));
        }catch (NotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("{id}/stock/{newVal}")
    public ResponseEntity<ResponseProductDTO> patch(@PathVariable int id, @PathVariable int newVal) {
        try {
            return ResponseEntity.ok(_productService.updateStock(id, newVal));
        }catch (NotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
