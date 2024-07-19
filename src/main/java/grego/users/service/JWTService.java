package grego.users.service;
import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;


@Service
public class JWTService {
	private JwtEncoder encoder; 
	
	public String generateToken(Authentication auth) {
		Instant now = Instant.now(); 
		long expiry = 3600L;
		
		String scopes = auth.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(" "));
	
		var claims = JwtClaimsSet.builder()
				.issuer("GREGO")
				.issuedAt(now)
				.expiresAt(now.plusSeconds(expiry))
				.subject(auth.getName())
				.claim("scopes", scopes)
				.build(); 
		return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue(); 
	}		
	
}