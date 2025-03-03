package com.user.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.model.User;
import com.user.role.Role;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username); 
	Optional<User> findByEmail(String email);
	
	Optional<User> findById(Long id);
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
	
	 List<User> findByRole(Role role); // Corrected method name
	    
	    @Query("SELECT u FROM User u WHERE u.id = :id AND u.role = :role")
	    Optional<User> findByIdAndRole(@Param("id") Long id, @Param("role") Role role);
	

}
