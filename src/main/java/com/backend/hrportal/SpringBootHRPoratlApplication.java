package com.backend.hrportal;

import com.backend.hrportal.models.ERole;
import com.backend.hrportal.models.Role;
import com.backend.hrportal.models.User;
import com.backend.hrportal.repository.RoleRepository;
import com.backend.hrportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@SpringBootApplication
public class SpringBootHRPoratlApplication implements CommandLineRunner {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private  PasswordEncoder encoder;

	public static void main(String[] args) {
    SpringApplication.run(SpringBootHRPoratlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Optional<Role> userRole=roleRepository.findByName(ERole.user);
		Optional<Role> adminRole=roleRepository.findByName(ERole.admin);
		if(!adminRole.isPresent()){
			roleRepository.save(new Role(ERole.admin));
		}
		if(!userRole.isPresent()){
			roleRepository.save(new Role(ERole.user));
		}

		List<User> listUsers=userRepository.findAll();
		if(listUsers.isEmpty()){
			User user = new User(
					"admin",
					"admin@gmail.com",
					encoder.encode("123456")
			);
			Set<Role> roles = new HashSet<>();
			Role adminRoles = roleRepository.findByName(ERole.admin)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(adminRoles);
			user.setRoles(roles);
			userRepository.save(user);
		}
		System.out.println(roleRepository.findAll().toString());

	}

	@GetMapping("/all")
	public List<Role> list(){

		return roleRepository.findAll();
	}
}
