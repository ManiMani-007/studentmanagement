package edu_jsp.student_management.service;

import java.util.List;

import edu_jsp.student_management.dao.Student;

public interface studentservice {

	List<Student> getAllstudents();

	Student savestudent(Student student);
	Student getStudent(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudent(Long id);

}
