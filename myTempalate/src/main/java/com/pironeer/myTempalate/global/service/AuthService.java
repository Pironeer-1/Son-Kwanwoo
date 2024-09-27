package com.pironeer.myTempalate.global.service;

import com.pironeer.myTempalate.global.dto.response.JwtTokenSet;
import com.pironeer.myTempalate.global.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;

    public JwtTokenSet generateToken(Long userIdx) {
        String token = jwtUtil.createToken(userIdx);

        JwtTokenSet jwtTokenSet = JwtTokenSet.builder()
                .token(token)
                .grantType("Bearer")
                .build();

        return jwtTokenSet;
    }
}
