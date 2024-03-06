package com.example.demo.cart.dto;

import com.example.demo.member.domain.Member;
import com.example.demo.product.domain.Product;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private Product product;
    private Member member;
    private Integer quantity;
}
