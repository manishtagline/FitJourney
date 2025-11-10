package com.example.fitjourney.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.example.fitjourney.entity.User;
import com.example.fitjourney.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.debug("Attempting to load user by email: {}", email);

		User user = userRepository.findByEmail(email).orElseThrow(() -> {
			log.warn("User not found for email: {}", email);
			return new UsernameNotFoundException("User not found with email: " + email);
		});

		log.info("User found: {} (enabled = {})", user.getEmail(), user.isEnabled());

		UserDetails userDetails = org.springframework.security.core.userdetails.User.builder().username(user.getEmail())
				.password(user.getPassword()).roles("USER") 				
				.disabled(!user.isEnabled()).build();

		log.debug("UserDetails object built successfully for: {}", user.getEmail());
		return userDetails;
	}
}
