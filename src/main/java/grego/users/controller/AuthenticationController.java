package grego.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grego.users.service.AuthenticationService;

@RestController
@RequestMapping("user")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService; 
	
	//THIS IS WHERE WE RECEIVE THE AUTHENTICATION TO GENERATE THE TOKEN
	//WE DO NOT NEED TO REQUEST A BODY, SPRING DOES BY ITS SELF
	@PostMapping("/authenticate")                        
	public String authenticate(Authentication authentication) {
		return authenticationService.authenticate(authentication);  
	}
}
