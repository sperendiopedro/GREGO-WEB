package grego.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.users.models.User;
import grego.users.repositories.UserRepository;
import grego.users.service.AuthenticationService;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

	@Autowired
	private PasswordEncoder passwdEncoder; 
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private AuthenticationService authService;

	@PostMapping("/auth")
	public String authenticate(Authentication auth) {
		return authService.authenticate(auth);
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity insertUser(@RequestBody User user) {
		if(userRepository.findByEmail(user.getEmail())!= null) return ResponseEntity.badRequest().build(); 
		user.setPsswd(passwdEncoder.encode(user.getPsswd())); 
		userRepository.saveAndFlush(user);
		return ResponseEntity.ok("Usuario salvo com sucesso!"); 
	}

}
