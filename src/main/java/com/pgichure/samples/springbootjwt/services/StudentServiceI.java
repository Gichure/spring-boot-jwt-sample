/**
 * 
 */
package com.pgichure.samples.springbootjwt.services;

import java.util.List;
import java.util.Optional;

import com.pgichure.samples.springbootjwt.models.Student;

/**
 * 
 */
public interface StudentServiceI {

	public List<Student> findAll();

    public Student save(Student student);
    
    public Optional<Student> view(Long id);
    
}
