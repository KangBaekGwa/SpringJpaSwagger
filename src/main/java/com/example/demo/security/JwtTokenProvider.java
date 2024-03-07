package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Slf4j
@Service
//어떤값이 들어왔을때 어떻게 처리하겠다 --> Security 버전 비지니스 로직과 유사하다.
public class JwtTokenProvider {

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.access-token-expiration}")
    private long accessExpirationTime;

    @Value("${jwt.refresh-token-expiratio}")
    private long refreshExpirationTime;

    /*
     * todo List
     * 1. 토큰에서 LoginId 가져오기
     * 2. claims 원하는 claim 값 추출
     * 3. 토큰에서 모든 claims 추출
     * 4. 토큰 key 디코드
     * 5,6, 토큰 생성
     * 7. 토큰 유효성 검사
     * 8. 토큰 만료 여부 검사
     */

    public String getMemberLoginId(String token){
        String loginId = extractClaim(token, Claims::getSubject);
        return loginId;
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSiginKey())
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    private Key getSiginKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generatedToken(UserDetails userDetails){
        return generateToken(Map.of(), userDetails);
    }

    public String generateToken(Map<String, Objects> extractClaim, UserDetails userDetails){
        return buildToken(extractClaim, userDetails, accessExpirationTime);
    }

    public String buildToken(Map<String, Objects> extractClaim, UserDetails userDetails, long expirationTime){
        return Jwts.builder()
                .setClaims(extractClaim)
                .claim("role", "MEMBER")
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getSiginKey())
                .compact();
    }

    //todo Refresh Token generate

    public boolean validationToken(String token) {
        try
        {
            Jwts.parserBuilder()
                    .setSigningKey(getSiginKey())
                    .build()
                    .parseClaimsJwt(token);
            return true;

        }
        //todo Exception Handling.
        catch (ExpiredJwtException e) {
            log.error("Token Expired");
            return false;
        }
        catch (MalformedJwtException | IllegalArgumentException e) {
            log.error("Toekn Invalid");
            return false;
        }
    }

}
