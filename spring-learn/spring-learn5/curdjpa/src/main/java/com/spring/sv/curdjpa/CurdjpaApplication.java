package com.spring.sv.curdjpa;

import com.spring.sv.curdjpa.dao.AppDAO;
import com.spring.sv.curdjpa.entity.Instructor;
import com.spring.sv.curdjpa.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CurdjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdjpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//saveData(appDAO);
			//findByInstructorId(appDAO);
			//deleteInstructorById(appDAO);

			//findInstructorDetails(appDAO);
			deleteInstructorDetailsById(appDAO);
		};
	}

	private void deleteInstructorDetailsById(AppDAO appDAO) {
		appDAO.deleteInstructorDetailById(3);
	}

	private void findInstructorDetails(AppDAO appDAO) {
		int id=3;
		InstructorDetail instructorDetail=appDAO.findInstructorDetailById(id);
		System.out.println(instructorDetail);
	}

	private void deleteInstructorById(AppDAO appDAO) {
		System.out.println("hi");
		appDAO.deleteById(1);
		System.out.println("deleted");
	}

	private void findByInstructorId(AppDAO appDAO) {
		int id=1;
		Instructor instructor=appDAO.findById(id);
		System.out.println(instructor.toString());
		System.out.println(instructor.getInstructorDetail());
	}

	private void saveData(AppDAO appDAO) {
		Instructor instructor=new Instructor("shivam","verma","s@gmail.com");
		InstructorDetail instructorDetail=new InstructorDetail("http://www.youtube.com","music listening");
		instructor.setInstructorDetail(instructorDetail);
		System.out.println("Process start");
		appDAO.save(instructor);
		System.out.println("Process Done");
	}
}
