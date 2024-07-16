package grego.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	@Autowired
	private JwtService jwtService; 
	
	public String authenticate(org.springframework.security.core.Authentication auth) {
			return jwtService.generateToken(auth); 
	}
}
