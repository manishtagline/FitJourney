package com.example.fitjourney.entity;

import com.example.fitjourney.entity.enums.Roles;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleId;
	
	@Enumerated(EnumType.STRING)
	private Roles role;
	
}
