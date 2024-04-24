/**
 * 
 */
package com.pgichure.samples.springbootjwt.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pgichure.samples.springbootjwt.dtos.LoginDto;
import com.pgichure.samples.springbootjwt.dtos.RegisterDto;
import com.pgichure.samples.springbootjwt.models.User;
import com.pgichure.samples.springbootjwt.services.AuthenticationServiceI;

import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	
	private final AuthenticationServiceI authService;

	@PostMapping(value = "/register")
    public ResponseEntity<User> save(@RequestBody RegisterDto input) {
        User user = authService.register(input);
        return ResponseEntity.ok(user);
    }
	
	@PostMapping(value = "/login")
    public ResponseEntity<User> login(@RequestBody LoginDto input) {
		User user = authService.login(input);
		return ResponseEntity.ok(user);
    }
}
