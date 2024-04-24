/**
 * 
 */
package com.pgichure.samples.springbootjwt.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pgichure.samples.springbootjwt.helpers.UserPrincipal;
import com.pgichure.samples.springbootjwt.models.User;
import com.pgichure.samples.springbootjwt.repositories.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService implements UserDetailsService{
	
	private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;
	
	// Loads a user's details given their userName.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(UserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }


    // Adds a new user to the repository and encrypting password before saving it.
    public String save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }

}
