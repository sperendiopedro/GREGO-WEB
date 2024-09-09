package grego.users.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<User> listAll() {
		return userRepo.findAll();
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		Optional<User> optUser = userRepo.findByEmail(user.getEmail());
		if (optUser.isPresent()) {
			return new ResponseEntity<>("Usuário já existe no sistema!", HttpStatus.CONFLICT);
		}
		try {
			user.setPassword(passwdEncoder.encode(user.getPassword()));
			if(user.getUserRole() == null) {
				user.setUserRole("USER"); 
			}
			userRepo.saveAndFlush(user);
			return new ResponseEntity<>("Usuario salvo com sucesso!", HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
