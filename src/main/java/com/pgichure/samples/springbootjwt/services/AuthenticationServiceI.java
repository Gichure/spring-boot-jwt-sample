/**
 * 
 */
package com.pgichure.samples.springbootjwt.services;

import com.pgichure.samples.springbootjwt.dtos.LoginDto;
import com.pgichure.samples.springbootjwt.dtos.RegisterDto;
import com.pgichure.samples.springbootjwt.models.User;

/**
 * 
 */
public interface AuthenticationServiceI {

	
	public User register(RegisterDto input);

    public User login(LoginDto input);   
    
}
