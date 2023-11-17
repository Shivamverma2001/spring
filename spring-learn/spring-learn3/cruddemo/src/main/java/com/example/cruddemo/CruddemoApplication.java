package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.dao.StudentImple;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//readAllStudent(studentDAO);
			//readAllStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteStudents(studentDAO);
		};
	}

	private void deleteStudents(StudentDAO studentDAO) {
		int numberOfRowsEffected=studentDAO.deleteAll();

		System.out.println(numberOfRowsEffected);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(1);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Integer id=1;
		Student student=studentDAO.findById(id);

		student.setFirstName("Shiv");

		studentDAO.update(student);

		System.out.println(student.toString());
	}

	private void readAllStudentByLastName(StudentDAO studentDAO) {
		List<Student> students=studentDAO.findByLastName("Verma");

		for(Student student:students){
			System.out.println(student.toString());
		}
	}

	private void readAllStudent(StudentDAO studentDAO) {
		List<Student> students=studentDAO.findAll();

		for(Student student:students){
			System.out.println(student.toString());
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent=new Student("Himanshu","Verma","him@gmail.com");

		studentDAO.save(tempStudent);

		System.out.println(tempStudent.getId());

		Student studentInfo=studentDAO.findById(tempStudent.getId());

		System.out.println(studentInfo.toString());
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("it started");
		Student tempStudent=new Student("Shivam","verma","shiv@gmail.com");

		System.out.println("save data");
		studentDAO.save(tempStudent);

		System.out.println("show id");
		System.out.println(tempStudent.toString());
	}
}
