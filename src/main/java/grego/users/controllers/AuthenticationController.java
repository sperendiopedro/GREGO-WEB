package grego.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.users.models.LoginDTO;
import grego.users.models.User;
import grego.users.repositories.UserRepository;
import grego.users.service.AuthenticationService;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

	@Autowired
	private PasswordEncoder passwdEncoder; 
	@Autowired
	private AuthenticationManager authenticationManager; 
	@Autowired
	private AuthenticationService authService;

	@Autowired
	private UserRepository userRepo; 
	
	
	
	@PostMapping("/auth")
	public String auth(@RequestBody Authentication auth) {
		return authService.authenticate(auth);
	}
	
	
	
	@PostMapping("/saveUser")
	public ResponseEntity insertUser(@RequestBody User user) {
		if(userRepo.findByEmail(user.getEmail())!= null) return ResponseEntity.badRequest().build(); 
		user.setPsswd(passwdEncoder.encode(user.getPsswd())); 
		userRepo.saveAndFlush(user);
		return ResponseEntity.ok("Usuario salvo com sucesso!"); 
	}

}