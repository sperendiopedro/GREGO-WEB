package grego.cadastros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.users.models.User;
import grego.users.repositories.UserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private PasswordEncoder passwdEncoder; 
	
	@Autowired
	private UserRepository userRepo; 
	
	@GetMapping("/list")
	public List<User> listAll(){
		return userRepo.findAll(); 
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody User user) {
		if(userRepo.findByEmail(user.getEmail())!= null || user.getNome() == null) return new ResponseEntity<>("alo", HttpStatus.BAD_REQUEST); 
		user.setPsswd(passwdEncoder.encode(user.getPsswd())); 
		userRepo.saveAndFlush(user);
		return ResponseEntity.ok("Usuario salvo com sucesso!"); 
	}


}
