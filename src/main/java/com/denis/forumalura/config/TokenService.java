package com.denis.forumalura.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.denis.forumalura.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Forum.hub")
                    .withSubject(user.getLogin())
                    .withClaim("id", user.getId())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar token jwt", e);
        }
    }

//    public String getSubject(String tokenJWT) {
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(secret);
//            return JWT.require(algorithm)
//                    .withIssuer("API Forum.hub")
//                    .build()
//                    .verify(tokenJWT)
//                    .getSubject();
//            return verifier.verify(tokenJWT).getSubject();
//        } catch (JWTVerificationException e) {
//            throw new RuntimeException("Token JWT inválido ou expirado!", e);
//        }
//    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    @Getter
    public static class TokenJWTResponse {
        private final String token;

        public TokenJWTResponse(String token) {
            this.token = token;
        }
    }
}
