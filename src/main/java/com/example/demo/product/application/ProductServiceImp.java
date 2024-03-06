package com.example.demo.product.application;

import com.example.demo.product.domain.Product;
import com.example.demo.product.dto.ProductDto;
import com.example.demo.product.infrastructor.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;
    @Override
    public Product createProduct(ProductDto productDto) {
        return productRepository.save(Product.builder()
                .productName(productDto.getProductName())
                .productCode(productDto.getProductCode())
                .productDescription(productDto.getProductDescription())
                .build());
    }
}
