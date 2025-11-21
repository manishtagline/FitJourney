package com.example.fitjourney.security;

import java.time.Instant;
import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

	@Value("${jwt.secret}")
	private String jwtSecret;
	
	@Value("${jwt.expirationMs}")
	private long jwtExpiration;
	
	
	public String generateToken(Authentication authentication) {
		String email = authentication.getName();

	    Instant now = Instant.now();
	    Instant expiry = now.plusMillis(jwtExpiration);
		SecretKey secret = Keys.hmacShaKeyFor(jwtSecret.getBytes());
		
		return Jwts.builder()
				.setSubject(email)
				.setIssuedAt(Date.from(now))
				.setExpiration(Date.from(expiry))
				.signWith(secret)
				.compact();
	}
	
	public String getEmailFromToken(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(jwtSecret.getBytes())
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			
			Jwts.parserBuilder()
				.setSigningKey(jwtSecret.getBytes())
				.build()
				.parsePlaintextJws(token);
			
				return true;
		} catch (JwtException e) {
			return false;
		}
	}
	
}
