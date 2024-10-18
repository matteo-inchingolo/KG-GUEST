package com.example.service;
/*
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;*/
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
/*
    private static final String SECRET_KEY = "bCIelJPAJOCBT3cyRUYiNRqojAzFBJSr/Xy6H3x7/" +
            "22QJeXkbqJaDzT8JdwRdZbqHiEkJv4cOkykHvNGvP5L9VdQDOIVYqhjSkh2jtpF0MCkXU8xjCPi" +
            "gEFDcm7TFAEY7w4b+6U5LWsTVzI7dYgxGYOprg7gXBnX9DeuEsc9xyTDbI0SrROVZQgMtYwxQ0kr" +
            "HQWw5cESpcE6yotcwNCE5XJyTq8BDxXLlGVnssSs555PHk1ttd4sLmD9S+S7AvDu5xDl3Mxref7as" +
            "Pc14QA/QpzaiE/AYKxEc/c4hI+TQM9mtZe3wBVJMDmHS8MWyG7oQP+0Op2ia0g8OeD9OjGB2ouTmZO" +
            "/RXzwQP+DO0KdqlU=";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);

        return claimsResolver.apply(claims);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);

        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);

        return Keys.hmacShaKeyFor(keyBytes);
    }
*/
}