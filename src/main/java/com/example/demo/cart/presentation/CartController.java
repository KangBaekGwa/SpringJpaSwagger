package com.example.demo.cart.presentation;

import com.example.demo.cart.application.CartService;
import com.example.demo.cart.dto.CartDto;
import com.example.demo.cart.dto.CartOutDto;
import com.example.demo.common.Dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Cart api", description = "Cart 관련된 api")
@RequestMapping("/Cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {

    private final CartService cartService;

    @Tag(name = "Cart api")
    @Operation(summary = "Cart 생성", description = "Cart 생성 Api")
    @PostMapping
    public ResponseEntity<ResponseDto<CartOutDto>> createCart(@RequestBody CartDto cartDto){
        boolean cart_boolean = cartService.createCart(cartDto);
        log.info("cart_boolean={}", cart_boolean);

        if(!cart_boolean){
            return ResponseEntity.badRequest().body(
                    ResponseDto.
                            <CartOutDto>builder()
                            .Message("실패하였습니다")
                            .httpStatus(HttpStatus.BAD_REQUEST)
                            //.ResultData(new CartOutDto())
                            .build());
        }

        String product_name = cartDto.getProduct().getName();
        String user_name = cartDto.getMember().getName();
        Long user_id = cartDto.getMember().getId();
        Integer quantity = cartDto.getQuantity();

        return ResponseEntity.ok().body(
                ResponseDto.
                        <CartOutDto>builder()
                        .httpStatus(HttpStatus.OK)
                        .Message("장바구니 아이템 담기 성공")
                        .ResultData(new CartOutDto(product_name, user_name, user_id, quantity))
                        .build());
    }

}
