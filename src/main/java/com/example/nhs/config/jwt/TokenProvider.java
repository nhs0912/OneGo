package com.example.nhs.config.jwt;

import com.example.nhs.member.domain.Member;
import com.example.nhs.token.domain.RefreshToken;
import com.example.nhs.token.repository.RefreshTokenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TokenProvider {
    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;

    public String generateAccessToken(Member member, Duration expiredAt) {
        Date now = new Date();
        return makeToken(new Date(now.getTime() + expiredAt.toMillis()), member);
    }

    public String generateRefreshToken(Member member, Duration expiredAt) {
        Date now = new Date();
        return Jwts.builder()
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(now)
                .setSubject(member.getEmployeeId()) //내용 sub : 멤버아이디
                .claim("id", member.getId())// 클래임 id : Member id
                .setExpiration(new Date(now.getTime() + expiredAt.toMillis()))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();
    }

    //JWT Token 생성 method
    private String makeToken(Date expiry, Member member) {

        Date now = new Date();
        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE) //헤더 typ : JWT
                //내용 iss : nhs0912@nate.com
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(now)//내용 iat : 현재시간
                .setExpiration(expiry) //내용 exp : expiry 멤버 변숫값
                .setSubject(member.getEmployeeId()) //내용 sub : 멤버아이디
                .claim("id", member.getId())// 클래임 id : Member id
                //  서명  비밀값과 함께 해시값을 HS256 식으로 암호화
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();
    }

    public boolean checkRefreshToken(String token) {
        if (!validToken(token)) {
            return false;
        }
        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByMemberId(getMemberId(token));

        return refreshToken.isPresent() && token.equals(refreshToken.get().getRefreshToken());
    }

    //JWT token 유효성 검증 method
    public boolean validToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey()) // 비밀값으로 복호화
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false; //복호화 과정에서 에러가 나면 유효하지 않은 토큰
        }
    }

    //토큰 기반으로 인증 정보를 가져오는 메서드
    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        Set<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
        return new UsernamePasswordAuthenticationToken(new User(claims.getSubject(), "", authorities), token, authorities);
    }

    //Token 기반으로 유저 ID를 가져오는 메서드
    public Long getMemberId(String token) {
        Claims claims = getClaims(token);
        return claims.get("id", Long.class);
    }

    public String getEmployeeId(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }


    private Claims getClaims(String token) {
        return Jwts.parser() //클레임 조회
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody();
    }
}
