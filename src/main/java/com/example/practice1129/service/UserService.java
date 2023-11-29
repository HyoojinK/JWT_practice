package com.example.practice1129.service;

import com.example.practice1129.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Value("${jwt.secret}")
    private  String secretKey;

    private Long expiredMs = 1000 * 60 * 60l;

    public String login(String userName, String password){
        // 인증과정 생략
        return JwtUtil.createJwt(userName, secretKey, expiredMs);


    }

}

