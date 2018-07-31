package com.realestate.properties.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.realestate.properties.domain.Role;
import com.realestate.properties.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${security.jwt.client-id}")
    private String clientID;

    @Value("${security.jwt.client-secret}")
    private String jwtSecret;

    @Value("${security.jwt.expiration-in-sc}")
    private int jwtExpirationInSc;

    public String generateToken(Authentication authentication) throws UnsupportedEncodingException {
        User userPrincipal = (User) authentication.getPrincipal();
        LocalDateTime now2 = LocalDateTime.now();

        return JWT.create()
                .withIssuer(clientID)
                .withSubject(userPrincipal.getEmail())
                .withIssuedAt(Date
                        .from(now2.atZone(ZoneId.systemDefault())
                                .toInstant()))
                .withExpiresAt(Date
                        .from(now2.plusSeconds(jwtExpirationInSc)
                                .atZone(ZoneId.systemDefault())
                                .toInstant()))
                .withArrayClaim("role", userPrincipal
                        .getRoles()
                        .stream()
                        .map(Role::getName)
                        .toArray(String[]::new))
                .withClaim("id", userPrincipal.getId().toString())
                .sign(Algorithm.HMAC256(jwtSecret));
    }

    public boolean validateToken(String authToken) {
        try {
            JWT.require(Algorithm.HMAC256(jwtSecret)).build().verify(authToken);
            return true;
        } catch (JWTVerificationException ex) {
            logger.error("Invalid JWT signature", ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            logger.error("Unsupported JWT token", ex.getMessage());
        }
        return false;
    }
}
