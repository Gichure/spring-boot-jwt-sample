/**
 * 
 */
package com.pgichure.samples.springbootjwt.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgichure.samples.springbootjwt.models.Student;
import com.pgichure.samples.springbootjwt.services.StudentServiceI;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RestController
@RequestMapping(name = "/api/students")
@RequiredArgsConstructor
public class StudentController {
	
	private final StudentServiceI service;
	

	@GetMapping
    public ResponseEntity<List<Student>> list() {
		List<Student> students =  service.findAll();
        return ResponseEntity.ok(students);
    }


    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student input) {
        Student student = service.save(input);
        return ResponseEntity.ok(student);
    }
}
