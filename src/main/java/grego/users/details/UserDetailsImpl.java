package grego.users.details;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import grego.users.models.User;

//USER AUTHENTICATED (I GUESS)
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	List<GrantedAuthority> authorities = new ArrayList<>();
    try {	
    	if("USER".equals(user.getUserRole())) { 
    		authorities.add(new SimpleGrantedAuthority("ROlE_READ"));
    	}else if("ADMIN".equals(user.getUserRole())) {
    		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    	}
    }catch(Exception e) {
    	throw new RuntimeException("Failed to set authorities", e); 
    }
    	return authorities; 
    	
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }
}
