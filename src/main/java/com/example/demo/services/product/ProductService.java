package com.example.demo.services.product;

import com.example.demo.models.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);

    List<Product> readAll();



}
