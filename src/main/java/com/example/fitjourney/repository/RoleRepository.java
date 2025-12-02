package com.example.fitjourney.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitjourney.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

    Optional<Role> findByName(String name);
	
}
