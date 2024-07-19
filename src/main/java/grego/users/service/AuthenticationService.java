package grego.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	@Autowired
	private JWTService jwtService; 
	
	public String authenticate(Authentication auth) {
			return jwtService.generateToken(auth); 
	}
}