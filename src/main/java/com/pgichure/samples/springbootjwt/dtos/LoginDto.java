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
public class LoginDto {
	
	public String username;
	
	public String password;

}
