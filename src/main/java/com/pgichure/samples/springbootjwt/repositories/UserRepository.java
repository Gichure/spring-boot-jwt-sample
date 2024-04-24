/**
 * 
 */
package com.pgichure.samples.springbootjwt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.samples.springbootjwt.models.User;

/**
 * 
 */
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);
	
}
