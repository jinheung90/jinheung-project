package com.jinheung.project.auth;


import com.jinheung.project.auth.dto.ParsedUserDataByJwtToken;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@Component
public class TokenProvider implements InitializingBean {

    private static final String AUTHORITIES_KEY = "Authorities";
    @Value("${token.access-token-secret}")
    private String secret;

    @Value("${token.access-token-expired}")
    private Long mAccessTokenExpiration;

    private Key key;

    @Override
    public void afterPropertiesSet() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);

    }

    public ParsedUserDataByJwtToken getUserIdAndAuthorityByJwtAccessToken(String token) {
        try {
            Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

            List<String> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                    .collect(Collectors.toList());
            return new ParsedUserDataByJwtToken(Long.valueOf(claims.getSubject()), new ArrayList<>(authorities), claims.getExpiration());

        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.warn("잘못된 JWT 서명입니다.");
        } catch (UnsupportedJwtException e) {
            log.warn("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.warn("JWT 토큰이 잘못되었습니다.");
        } catch (ExpiredJwtException e) {
            log.warn("JWT 토큰이 만료.");
        }
        return null;
    }
}
