package com.example.web_workshop.controller;

import com.example.web_workshop.entities.Product;
import com.example.web_workshop.entities.User;
import com.example.web_workshop.services.ProductService;
import com.example.web_workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
      List<Product> list = productService.findAll();
      return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = productService.findById(id);
        return ResponseEntity.ok().body(obj);
    }



}
