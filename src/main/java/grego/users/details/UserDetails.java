package grego.users.details;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import grego.users.models.User;
import grego.users.models.UserRoles;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
	
	private static final long serialVersionUID = 1L;
	private User user; 
	private UserRoles roles; 
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.roles == UserRoles.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER")); 
		else return List.of(new SimpleGrantedAuthority("ROLE_USER")); 
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
