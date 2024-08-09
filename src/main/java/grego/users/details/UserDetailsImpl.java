package grego.users.details;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import grego.users.models.User;

public class UserDetailsImpl implements UserDetails{ 
	private User user;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	} 
	
	public UserDetailsImpl(User user) {
		this.user = user; 
	}
	
	private static final long serialVersionUID = 1L;


	@Override
	public String getPassword() {
		return user.getPsswd();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	
	
}
