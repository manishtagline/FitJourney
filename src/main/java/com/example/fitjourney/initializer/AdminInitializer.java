package com.example.fitjourney.initializer;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.fitjourney.entity.Role;
import com.example.fitjourney.entity.User;
import com.example.fitjourney.entity.enums.Roles;
import com.example.fitjourney.repository.RoleRepository;
import com.example.fitjourney.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class AdminInitializer implements CommandLineRunner {
	
	private UserRepository userRepo;
	
	private RoleRepository roleRepo;
	
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		
		roleRepo.findByName("ADMIN")
			.orElseGet(() -> roleRepo.save(new Role(null, Roles.ADMIN)));
		
		roleRepo.findByName("USER")
			.orElseGet(() -> roleRepo.save(new Role(null, Roles.USER)));
		
		String adminEmail = "admin@fitjourney.com";
		String adminPassword = "admin@123";
		
		if(userRepo.findByEmail(adminEmail).isEmpty()) {
			
			User admin = new User();
			admin.setEmail(adminEmail);
			admin.setUsername("Admin");
			admin.setPassword(passwordEncoder.encode(adminPassword));
			admin.setEnabled(true);
			admin.setRoles(Set.of(roleRepo.findByName("ADMIN").get()));
			
			userRepo.save(admin);
			
		    log.info(" FIXED ADMIN CREATED");
            log.info(" Email: {}", adminEmail);
            log.info(" Password: {}", adminPassword);
		} else {
            log.info("Admin user already exists. Skipping creation.");
        }
		
	}

}
 