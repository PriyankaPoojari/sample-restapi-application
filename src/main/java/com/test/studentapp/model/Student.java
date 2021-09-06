package com.test.studentapp.model;

import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	@Id  
	@Column(name="ID") 
	private int id;  
	
	@Column(name="FIRSTNAME")
	private String firstName;  
	
	@Column(name="LASTNAME")  
	private String lastName;
	
	@Column(name="CLASS")  
	private String className;
	
	@Column(name="NATIONALITY")  
	private String nationality;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String toString() {
		return "{"+ id + "," + firstName + "," + lastName + "," + className + "," + nationality + "}";
	}
	
	public boolean checkNull() throws IllegalAccessException {
	    for (Field f : getClass().getDeclaredFields()) {
	    	  if (f.get(this) == null || "".equalsIgnoreCase(f.get(this).toString().trim()))
	            return true;
	    }
	    return false;            
	}
	  
}
