package grego.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import grego.users.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService{
	

	@Autowired
	private PasswordEncoder passwdEncoder; 
	
	@Autowired
	private UserRepository userRepo;

	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		if(!email.equals("fulano")) {
			throw new UsernameNotFoundException("Email não encontrado!"); 
		}
		
		return User.builder()
					.username("fulano")
					.password(passwdEncoder.encode("123"))
					.roles("USER", "ADMIN")
					.build();
		
	}


}
