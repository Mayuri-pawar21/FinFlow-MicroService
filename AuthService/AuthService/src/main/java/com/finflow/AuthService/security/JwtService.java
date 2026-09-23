package com.finflow.AuthService.security;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import com.finflow.AuthService.entity.User;


import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	   @Value("${jwt.secret}")
	    private String secretKey;

	    @Value("${jwt.expiration}")
	    private long jwtExpiration;
	    
	    public String generateToken(User user) {

	        return Jwts.builder()
	                .subject(user.getEmail())
	                .claim("role", user.getRole().name())
	                .issuedAt(new Date())
	                .expiration(new Date(System.currentTimeMillis() + jwtExpiration))
	                .signWith(getSigningKey())
	                .compact();
	    }
	    	
	    

	    public String extractUsername(String token) {

	    	 return extractAllClaims(token).getSubject();
	    
	    }

	    public boolean isTokenValid(String token, String username) {

	    	 String extractedUsername = extractUsername(token);

	    	    return extractedUsername.equals(username)
	    	            && extractAllClaims(token)
	    	                     .getExpiration()
	    	                     .after(new Date());
	    }

	    private SecretKey getSigningKey() {

	    	 return Keys.hmacShaKeyFor(secretKey.getBytes());
	    }

	    private Claims extractAllClaims(String token) {

	    	 return Jwts.parser()
	    	            .verifyWith(getSigningKey())
	    	            .build()
	    	            .parseSignedClaims(token)
	    	            .getPayload();
	    }
}
