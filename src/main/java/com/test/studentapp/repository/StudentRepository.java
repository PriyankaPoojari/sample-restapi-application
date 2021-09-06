package com.test.studentapp.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.test.studentapp.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	

}
