package com.example.fitjourney.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitjourney.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{
	
	Optional<Profile> findByUserUserId(Long userId);
	
}
