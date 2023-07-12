package com.example.nhs.token.service;

import com.example.nhs.token.domain.RefreshToken;
import com.example.nhs.token.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }

    public void saveRefreshToken(Long memberId, String refreshToken) {
        RefreshToken madeRefreshToken = RefreshToken.builder()
                .memberId(memberId)
                .refreshToken(refreshToken)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        refreshTokenRepository.save(madeRefreshToken);
    }
}
