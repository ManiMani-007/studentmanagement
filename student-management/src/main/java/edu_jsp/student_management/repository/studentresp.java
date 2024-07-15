package edu_jsp.student_management.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import edu_jsp.student_management.dao.Student;



public interface studentresp  extends JpaRepository<Student, Long>{

}

