package com.projeto.lina.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY = "joaolina";

    private static final long EXPIRATION = 1000 * 60 * 60 * 24; // 24h

    // 🔥 Gerar token
    public String gerarToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // 🔍 Extrair email do token
    public String extrairEmail(String token) {

        return extrairClaims(token).getSubject();
    }

    // ✅ Validar token
    public boolean tokenValido(String token) {

        try {
            extrairClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 🔐 Ler claims
    private Claims extrairClaims(String token) {

        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}