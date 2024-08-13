package grego.users.service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.nimbusds.jwt.JWTClaimsSet;

import grego.users.models.User;


@Service
public class JwtService {

	@Autowired
	private JwtEncoder jwtEncoder;
	
	//authentication interface, Represents the token for an authentication request 
	//or for an authenticated principal once the request has been processed by the AuthenticationManager.authenticate(Authentication) method. 
	public String generateToken(Authentication authentication) {
		Instant now = Instant.now();
		long expiry = 3600L;
		
		//Users permissions. 
		String scopes = authentication.getAuthorities().stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.joining(""));
		//BUILD DA TOKEN
		var claims = JwtClaimsSet.builder()
				     .issuer("teste")
				     .issuedAt(now)
				     .expiresAt(now.plusSeconds(expiry))
				     .subject(authentication.getName())
				     .claim("scope", scopes)
				     .build();
		
		return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue(); 
					
	}
	
		

}
