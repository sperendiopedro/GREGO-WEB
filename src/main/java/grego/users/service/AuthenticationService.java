package grego.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/*
 * RETURNS THE TOKEN FOR AUTHENTICATION
 */


@Service
public class AuthenticationService {
	
	@Autowired
	private JwtService jwtService; 
	
	public String authenticate(Authentication authentication) {
		return jwtService.generateToken(authentication);
	}
	
}	
