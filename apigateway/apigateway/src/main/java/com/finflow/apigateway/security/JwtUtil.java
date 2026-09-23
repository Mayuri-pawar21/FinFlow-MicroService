package com.finflow.apigateway.security;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

	  private static final String SECRET =
	            "ThisIsMyVerySecretKeyForFinFlowApplication123456789";

	    private static final SecretKey KEY =
	            Keys.hmacShaKeyFor(SECRET.getBytes());

	    public static Claims extractClaims(String token) {
	        return Jwts.parser()
	                .verifyWith(KEY)
	                .build()
	                .parseSignedClaims(token)
	                .getPayload();
	    }

	    public static boolean validateToken(String token) {
	        try {
	            extractClaims(token);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public static String getEmail(String token) {
	        return extractClaims(token).getSubject();
	    }
	    
	    public static String getRole(String token) {
	        return extractClaims(token).get("role", String.class);
	    }
	    
}
