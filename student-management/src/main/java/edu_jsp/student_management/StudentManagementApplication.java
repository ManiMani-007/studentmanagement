package edu_jsp.student_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu_jsp.student_management.dao.Student;
import edu_jsp.student_management.repository.studentresp;

@SpringBootApplication
public class StudentManagementApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}
	    @Autowired
        private studentresp resp;
        

	@Override
	public void run(String... args) throws Exception {
		
		
		Student s1= new Student("tangle","tangle@123",32);
		resp.save(s1);
		
	}

}
