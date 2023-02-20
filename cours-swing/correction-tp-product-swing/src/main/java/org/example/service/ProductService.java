package org.example.service;

import org.example.dto.RequestProductDTO;
import org.example.dto.ResponseProductDTO;
import org.example.util.RestClient;

public class ProductService {
    private RestClient _restClient;

    public ProductService() {
        _restClient = new RestClient<ResponseProductDTO, RequestProductDTO>();
    }

    public ResponseProductDTO getById(int id) {
       return (ResponseProductDTO) _restClient.get("/api/product/"+id, ResponseProductDTO.class);
    }

    public ResponseProductDTO add(RequestProductDTO productDTO) {
        return (ResponseProductDTO) _restClient.post("/api/product", productDTO, ResponseProductDTO.class);
    }

    public ResponseProductDTO patch(int id, String params, String val) {
        return (ResponseProductDTO) _restClient.patch("/api/product/"+id+"/"+params+"/"+val, ResponseProductDTO.class);
    }
}
