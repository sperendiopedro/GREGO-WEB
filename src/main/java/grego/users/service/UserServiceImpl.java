package grego.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import grego.users.details.UserDetailsImpl;
import grego.users.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService{

	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepo.findByEmail(email)
				.map(UserDetailsImpl::new)
				.orElseThrow(() -> new UsernameNotFoundException("Email não encontrado!"));
	}

}
