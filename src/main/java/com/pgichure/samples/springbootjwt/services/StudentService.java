/**
 * 
 */
package com.pgichure.samples.springbootjwt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pgichure.samples.springbootjwt.models.Student;
import com.pgichure.samples.springbootjwt.repositories.StudentRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Service
@RequiredArgsConstructor
public class StudentService implements StudentServiceI{

	private final StudentRepository repository;
	
	public List<Student> findAll() {
        return repository.findAll();
    }

    public Student save(Student student) {
        return repository.save(student);
    }
    
    public Optional<Student> view(Long id) {
    	return repository.findById(id);
    }
}
