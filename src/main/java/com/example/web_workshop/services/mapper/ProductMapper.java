package com.example.web_workshop.services.mapper;

import com.example.web_workshop.dto.ProductDTO;
import com.example.web_workshop.entities.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static ProductDTO forProductDTO(Product product) {
        return mapper.convertValue(product, ProductDTO.class);
    }

    public static Product toProduct(ProductDTO productDTO) {
        return mapper.convertValue(productDTO, Product.class);
    }
}
