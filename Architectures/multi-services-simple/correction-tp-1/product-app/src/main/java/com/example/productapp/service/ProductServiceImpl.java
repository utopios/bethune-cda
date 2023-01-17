package com.example.productapp.service;

import com.example.productapp.dto.request.RequestProductDTO;
import com.example.productapp.dto.response.ResponseProductDTO;
import com.example.productapp.entity.Product;
import com.example.productapp.exception.NotFoundException;
import com.example.productapp.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository _productRepository;
    @Autowired
    private ModelMapper _modelMapper;

    @Override
    public ResponseProductDTO createProduct(RequestProductDTO productDTO) {
        Product product = _modelMapper.map(productDTO, Product.class);
        //On peut ajouter les vérifications sur les différents champs (stock, price,...).
        ResponseProductDTO responseProductDTO =  _modelMapper.map(_productRepository.save(product),ResponseProductDTO.class);
        return responseProductDTO;
    }

    @Override
    public ResponseProductDTO updateStock(int id, int stock) throws NotFoundException {
        Product product = findProduct(id);
        product.setStock(stock);
        return _modelMapper.map(_productRepository.save(product), ResponseProductDTO.class);
    }

    @Override
    public ResponseProductDTO getProduct(int id) throws NotFoundException {
        return _modelMapper.map(findProduct(id), ResponseProductDTO.class);
    }

    private Product findProduct(int id) throws NotFoundException {
        Product product = _productRepository.findById(id).get();
        if(product == null) {
            throw new NotFoundException();
        }
        return product;
    }
}
