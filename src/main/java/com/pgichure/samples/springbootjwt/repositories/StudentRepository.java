/**
 * 
 */
package com.pgichure.samples.springbootjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.samples.springbootjwt.models.Student;

/**
 * 
 */
public interface StudentRepository extends JpaRepository<Student, Long>{

}
