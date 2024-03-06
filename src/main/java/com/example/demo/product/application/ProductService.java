package com.example.demo.product.application;

import com.example.demo.product.domain.Product;
import com.example.demo.product.dto.ProductDto;

public interface ProductService {
    Product createProduct(ProductDto productDto);
}
