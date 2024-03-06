package com.example.demo.cart.application;

import com.example.demo.cart.domain.Cart;
import com.example.demo.cart.dto.CartDto;
import com.example.demo.cart.infrastructor.CartRepository;
import com.example.demo.member.domain.Member;
import com.example.demo.member.infrastructor.MemberRepository;
import com.example.demo.product.domain.Product;
import com.example.demo.product.infrastructor.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImp implements CartService{

    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    //return 생각해야됨.
    @Override
    public boolean createCart(CartDto cartDto) {

        Member member = memberRepository.findById(cartDto.getMember().getId()).orElse(null);
        Product product = productRepository.findById(cartDto.getProduct().getId()).orElse(null);

        if(member == null || product == null) return false;

        cartRepository.save(Cart.builder()
                .product(cartDto.getProduct())
                .member(cartDto.getMember())
                .quantity(cartDto.getQuantity())
                .build());
        return true;
    }
}
