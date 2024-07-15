package edu_jsp.student_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu_jsp.student_management.dao.Student;
import edu_jsp.student_management.service.studentservice;

@Controller
public class studentcontroller {

	private studentservice service;

	public studentcontroller(studentservice service) {
		super();
		this.service = service;
	}

	// handler methods to handle list student request and return model and view
	@GetMapping("/students")
	public String liststudent(Model model) {

		model.addAttribute("students", service.getAllstudents());

		return "students";

	}

	@GetMapping("/students/new")
	public String createstudntfrom(Model model) {
		// create student object to hold student form data
		Student student = new Student();

		model.addAttribute("student", student);

		return "create_student";
	}

	@PostMapping("/students")
	public String savestudent(@ModelAttribute("student") Student student) {
		service.savestudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public  String editfrom(@PathVariable Long id,Model model)
	{
	
	  model.addAttribute("student",service.getStudent(id));
	
		return "edit_student";
		
	}
	@PostMapping("/students/{id}")
	public String updateStudent( @PathVariable Long id,
	
		@ModelAttribute("student") Student  student, Model model)
	{
		
		
		//get student from database by id
		Student existingstudent=service.getStudent(id);
		existingstudent.setId(id);
		existingstudent.setName(student.getName());
		existingstudent.setEmail(student.getEmail());
		existingstudent.setAge(student.getAge());
		
		
		//save updated student object
		service.updateStudent(existingstudent);
			return "redirect:/students";
		
	}
	
	//handler method to handle the delete 
	@GetMapping("/students/{id}")
	public String deletestudent(@PathVariable Long id)
	{
	 service.deleteStudent(id);
	return "redirect:/students";
		
	}
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

