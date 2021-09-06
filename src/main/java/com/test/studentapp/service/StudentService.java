package com.test.studentapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.test.studentapp.model.Student;
import com.test.studentapp.repository.StudentRepository;

@Component
public class StudentService {
	@Autowired  
	StudentRepository studentRepository;    
	
	//getting all student records  
	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<Student>();  
		studentRepository.findAll().forEach(student -> students.add(student));  
		return students;  
	}  
	
	//getting a specific record  
	public Student getStudentById(int id){  
		return studentRepository.findById(id).get();  
	}
	
	public boolean existById(int id){  
		return studentRepository.existsById(id);  
	}
	
	public void saveOrUpdate(Student student) {  
		studentRepository.save(student);  
	}  
	
	//deleting a specific record  
	public void delete(int id) 	{  
		studentRepository.deleteById(id);  
	}  
	
	//getting all student records by Class
		public List<Student> getAllStudent(String className) {
			List<Student> students = new ArrayList<Student>();  
			studentRepository.findAll().forEach(student -> {if(student.getClassName().equalsIgnoreCase(className)) {
												students.add(student);
												}});  
			return students;  
		}
	
		  
}
