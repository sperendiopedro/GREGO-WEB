package grego.users.repositories;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import grego.users.details.UserDetailsImpl;
import grego.users.models.User;

public interface UserRepository extends JpaRepository<User, UUID>{
	Optional<User> findByEmail(String email);
}
