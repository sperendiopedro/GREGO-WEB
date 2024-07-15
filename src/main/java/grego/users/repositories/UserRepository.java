package grego.users.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import grego.users.models.User;

public interface UserRepository extends JpaRepository<User, UUID>{
	UserDetails findByEmail(String email); 
}
