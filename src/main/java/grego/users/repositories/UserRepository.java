package grego.users.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import grego.users.details.UserAuthenticated;
import grego.users.models.User;

public interface UserRepository extends JpaRepository<User, UUID>{
	UserAuthenticated findByEmail(String email); 
}
