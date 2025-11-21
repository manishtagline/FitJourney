package com.example.fitjourney.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtTokenProvider tokenProvider;
	private final CustomUserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String header = request.getHeader("Authorization");
		String token = null;
		String email = null;

		try {

			if (header != null && header.startsWith("Bearer ")) {
				token = header.substring(7);
				email = tokenProvider.getEmailFromToken(token);
				log.debug("JWT Token found for email: {}", email);
			} else {
				log.trace("No Authorization header or not a Bearer token");
			}

			if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				var userDetails = userDetailsService.loadUserByUsername(email);
				if (tokenProvider.validateToken(token)) {
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());

					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);

					log.info("Authenticated user of email: {}", email);
				} else {
					log.warn("Invalid or expired JWT for user of email: {}", email);
				}
			}

		} catch (Exception ex) {

			log.error("JWT authentication error: {}", ex.getMessage());
		}

		filterChain.doFilter(request, response);
	}
}
