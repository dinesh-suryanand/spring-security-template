package com.whatupd.securitytemplate;

import com.whatupd.securitytemplate.model.ApplicationUser;
import com.whatupd.securitytemplate.model.Role;
import com.whatupd.securitytemplate.repository.RoleRepository;
import com.whatupd.securitytemplate.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SecuritytemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritytemplateApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder encoder) {
		return args -> {
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;

			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1,"admin",encoder.encode("password"),roles);
			userRepository.save(admin);
		};
	}
}
