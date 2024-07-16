package grego.users.details;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import grego.users.models.User;
import grego.users.models.UserRoles;

public class UserAuthenticated implements org.springframework.security.core.userdetails.UserDetails {
	
	private static final long serialVersionUID = 1L;
	private User user; 
	private UserRoles roles; 
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(()-> "read"); 
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
