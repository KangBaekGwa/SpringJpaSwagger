package com.example.demo.product.presentation;


import com.example.demo.product.application.ProductService;
import com.example.demo.product.dto.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
@Tag(name = "Product API", description = "PRODUCT_API")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    private final ProductService productService;

    @Tag(name = "Product API")
    @Operation(summary = "product 생성", description = "Product 신규 생성")
    @PostMapping("/create")
    public void createProduct(@RequestBody ProductDto productDto){
        productService.createProduct(productDto);
    }
}
