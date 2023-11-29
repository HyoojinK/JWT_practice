package com.example.practice1129.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    public static String createJwt(String userName, String secretKey, Long expiredMs){
        Claims claims = Jwts.claims();
        claims.put("userName", userName);

        return Jwts.builder().setClaims(claims)     //userName이 claims에 들어감
                .setIssuedAt(new Date(System.currentTimeMillis()))  // 오늘 날짜 넣어야 함
                .setExpiration(new Date(System.currentTimeMillis() + expiredMs))  // 언제까지
                .signWith(SignatureAlgorithm.HS256, secretKey)  // HS256 키로 사인이 되었다
                .compact();
    }
}
