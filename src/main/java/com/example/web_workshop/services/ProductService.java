package com.example.web_workshop.services;

import com.example.web_workshop.dto.ProductDTO;
import com.example.web_workshop.entities.Product;
import com.example.web_workshop.repositories.ProductRepository;
import com.example.web_workshop.services.exceptions.DatabaseException;
import com.example.web_workshop.services.exceptions.ResourceNotFoundException;
import com.example.web_workshop.services.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.web_workshop.services.mapper.ProductMapper.forProductDTO;
import static com.example.web_workshop.services.mapper.ProductMapper.toProduct;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapper::forProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper::forProductDTO)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
    }

    public ProductDTO create(ProductDTO productDTO){
        Product product = toProduct(productDTO);
        Product savedProduct = productRepository.save(product);
        return forProductDTO(savedProduct);
    }

    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
        Product productToUpdate = toProduct(productDTO);
        existingProduct.setName(productToUpdate.getName());
        existingProduct.setPrice(productToUpdate.getPrice());
        existingProduct.setDescription(productToUpdate.getDescription());
        Product updatedProduct = productRepository.save(existingProduct);
        return forProductDTO(updatedProduct);
    }


}