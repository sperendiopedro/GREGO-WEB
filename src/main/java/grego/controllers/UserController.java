package grego.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.users.models.User;
import grego.users.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo; 
	
	@GetMapping("/cadastro")
    public ResponseEntity<User> getUserForm() {
        User user = new User();
        return ResponseEntity.ok(user);
    }

	
	@GetMapping("/listUser")
	public List<User> listAll(){
		return userRepo.findAll(); 
	}
	
    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User user, BindingResult result) {
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors occurred.");
        }
        userRepo.saveAndFlush(user);
        return ResponseEntity.ok("User saved successfully.");
    }
}
