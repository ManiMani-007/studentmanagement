package edu_jsp.student_management.service;



import java.util.List;

import org.springframework.stereotype.Service;

import edu_jsp.student_management.dao.Student;
import edu_jsp.student_management.repository.studentresp;



@Service
public  class studentserviceimpl implements studentservice {

	private studentresp resp;

	public studentserviceimpl(studentresp resp) {
		super();
		this.resp = resp;
	}

	@Override
	public List<Student> getAllstudents() {
	
		return resp.findAll();
	}

	@Override
	public Student savestudent(Student student) {
	
		return resp.save(student);
	}

	@Override
	public Student getStudent(Long id) {

		return  resp.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
	
		return resp.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		
          resp.deleteById(id);
	}



	

}