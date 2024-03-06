package com.example.demo.cart.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CartOutDto {
    private String product_name;
    private String user_name;
    private Long user_id;
    private Integer quantity;

    public CartOutDto() {
        this.product_name = null;
        this.user_name = null;
        this.user_id = null;
        this.quantity = null;
    }
}
