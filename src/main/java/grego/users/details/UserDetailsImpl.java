package grego.users.details;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import grego.users.models.User;
import grego.users.models.UserRoles;

public class UserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private User user; 
	 
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(() -> "read");  
	}

	@Override
	public String getPassword() {
		return user.getPsswd();
	}

	@Override
	public String getUsername() {
		return user.getEmail(); 
	}
}
