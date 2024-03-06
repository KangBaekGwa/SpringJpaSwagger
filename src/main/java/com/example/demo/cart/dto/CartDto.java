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
    private String product_name;
    private String member_name;
    private long member_id;
    private Integer quantity;
}
