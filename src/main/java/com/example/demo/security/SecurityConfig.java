package com.example.demo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf(CsrfConfigurer::disable) //restFull Api 을 쓰기때문에..? 안쓴다..?
                .formLogin(formLogin -> formLogin.disable())
                .sessionManagement(
                        sessionManagement -> sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorizeHttpRequests ->authorizeHttpRequests
                        .requestMatchers(org.springframework.web.cors.CorsUtils::isPreFlightRequest)
                        .permitAll()
                        .requestMatchers(
                                "/api/v1/**",
                                "/swagger-ui/**",
                                "/swagger-resources/**",
                                "/api-docs/**",
                                "/v3/api-docs/**"
                        )
                        .permitAll()
                        .anyRequest().authenticated())
                .authenticationProvider(authenticationProvider);
//                .addFilterBefore((jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class))
//                .addFilterBefore

        return http.build();
    }
}
