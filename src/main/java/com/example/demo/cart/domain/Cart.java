package com.example.demo.cart.domain;

import com.example.demo.member.domain.Member;
import com.example.demo.product.domain.Product;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Getter
@Entity
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "cart_quantity", nullable = false)
    private Integer quantity;

    @Builder
    public Cart(Product product, Member member, Integer quantity) {
        this.product = product;
        this.member = member;
        this.quantity = quantity;
    }
}
