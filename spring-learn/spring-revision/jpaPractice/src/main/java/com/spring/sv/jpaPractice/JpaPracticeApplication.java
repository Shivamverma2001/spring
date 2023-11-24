package com.spring.sv.jpaPractice;

import com.spring.sv.jpaPractice.dao.StudentDAO;
import com.spring.sv.jpaPractice.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaPracticeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			//createStudent(studentDAO);
			readStudent(studentDAO);
//			readAllStudent(studentDAO);
//			readAllStudentByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteStudents(studentDAO);
		};
	}

	private void deleteStudents(StudentDAO studentDAO) {
		int n=studentDAO.deleteAll();
		System.out.println(n);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(2);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student s=studentDAO.findById(2);
		s.setFirstName("shivaay");
		studentDAO.update(s);
	}

	private void readAllStudentByLastName(StudentDAO studentDAO) {
		List<Student> studentList=studentDAO.findByLastName("verma");

		for (Student s:studentList){
			System.out.println(s);
		}
	}

	private void readAllStudent(StudentDAO studentDAO) {
		List<Student> studentList=studentDAO.findAll();

		for (Student s:studentList){
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student=new Student("Shivam4","verma","shiv@gmail.com");
		studentDAO.save(student);
		Student answer=studentDAO.findById(student.getId());
		System.out.println(answer.toString());
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student=new Student("Shivam","verma","shiv@gmail.com");
		studentDAO.save(student);
		Student student2=new Student("Shivam2","verma","shiv@gmail.com");
		studentDAO.save(student2);
		Student student3=new Student("Shivam3","verma","shiv@gmail.com");
		studentDAO.save(student3);
	}
}
