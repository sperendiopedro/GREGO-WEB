package grego.users.repositories;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import grego.users.models.User;

public interface UserRepository extends JpaRepository<User, UUID>{
	User findByEmail(String email); 
}
