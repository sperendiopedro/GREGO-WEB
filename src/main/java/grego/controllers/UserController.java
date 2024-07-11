package grego.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import grego.users.models.User;
import grego.users.repositories.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo; 
	

    @GetMapping("/cadastro")
    public ResponseEntity<User> getUserForm() {
        User user = new User();
        return ResponseEntity.ok(user);
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
