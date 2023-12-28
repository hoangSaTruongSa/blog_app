package com.vti.BlogApp;

import com.vti.BlogApp.entity.Role;
import com.vti.BlogApp.entity.User;
import com.vti.BlogApp.repository.RoleRepository;
import com.vti.BlogApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class BlogAppApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var user = new User();
		user.setName("Nguyễn Văn Bộ");
		user.setUsername("bo.nv");
		user.setEmail("bonv6@gmail.com");
		user.setPassword(passwordEncoder.encode("123456Aa@"));
		var adminRole= roleRepository.findByType(Role.Type.ADMIN);
		var userRole = roleRepository.findByType(Role.Type.USER);
		user.setRoles(Set.of(adminRole, userRole));
		userRepository.save(user);
	}
}
