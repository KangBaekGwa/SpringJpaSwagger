package com.example.demo.product.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_code", nullable = false)
    private String code;

    @Column(name = "product_description", nullable = false)
    private String description;

    @Builder
    public Product(String productName, String productCode, String productDescription) {
        this.name = productName;
        this.code = productCode;
        this.description = productDescription;
    }
}
