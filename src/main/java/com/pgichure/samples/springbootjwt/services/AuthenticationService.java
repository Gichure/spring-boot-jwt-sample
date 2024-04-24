/**
 * 
 */
package com.pgichure.samples.springbootjwt.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pgichure.samples.springbootjwt.dtos.LoginDto;
import com.pgichure.samples.springbootjwt.dtos.RegisterDto;
import com.pgichure.samples.springbootjwt.models.User;
import com.pgichure.samples.springbootjwt.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService implements AuthenticationServiceI{

	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
    
    private final AuthenticationManager authenticationManager;
    
	public User register(RegisterDto input) {
        User user = new User();
        user.setName(input.getName());
        user.setEmail(input.getEmail());
        user.setUsername(input.getUsername());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public User login(LoginDto input) {
    	
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }
}
