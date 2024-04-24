/**
 * 
 */
package com.pgichure.samples.springbootjwt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id")
    private Long studentId;
	
	@Column(name ="name", nullable = false)
    private String name;
	
	@Column(name ="email", nullable = false)
    private String email;
	
	@Column(name ="course", nullable = false)
    private String course;

}
