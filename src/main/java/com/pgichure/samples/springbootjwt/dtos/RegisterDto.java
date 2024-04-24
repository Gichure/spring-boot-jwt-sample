/**
 * 
 */
package com.pgichure.samples.springbootjwt.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
	
	public String username;
	
	public String password;
	
    public String name;
	
    public String email;
	
}
