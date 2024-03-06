package com.example.demo.cart.application;

import com.example.demo.cart.domain.Cart;
import com.example.demo.cart.dto.CartDto;
import com.example.demo.cart.infrastructor.CartRepository;
import com.example.demo.member.domain.Member;
import com.example.demo.member.infrastructor.MemberRepository;
import com.example.demo.product.domain.Product;
import com.example.demo.product.infrastructor.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImp implements CartService{

    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    //return 생각해야됨.
    @Override
    public boolean createCart(CartDto cartDto) {

        Member member = memberRepository.findById(cartDto.getMember_id()).orElse(null);
        Product product = productRepository.findByname(cartDto.getProduct_name()).orElse(null);

        if(member == null || product == null) return false;

        cartRepository.save(Cart.builder()
                .product(product)
                .member(member)
                .quantity(cartDto.getQuantity())
                .build());
        return true;
    }
}
