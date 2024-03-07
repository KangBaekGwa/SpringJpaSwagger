package com.example.demo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter {
    //todo private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService; //기본

    //todo doFilterInternal 추가

}
