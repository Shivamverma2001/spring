package com.spring.sv.curdjpa;

import com.spring.sv.curdjpa.dao.AppDAO;
import com.spring.sv.curdjpa.entity.Course;
import com.spring.sv.curdjpa.entity.Instructor;
import com.spring.sv.curdjpa.entity.InstructorDetail;
import com.spring.sv.curdjpa.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			//deleteInstructorDetailsById(appDAO);

			//createInstructorWithCourses(appDAO);

			//findInstructorWithCourses(appDAO);

			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourseById(appDAO);
			//deleteInstructorById(appDAO);
			//deleteCourse(appDAO);

			saveCourse(appDAO);
		};
	}

	private void saveCourse(AppDAO appDAO) {
		Course course=new Course("Pacman- how to");
		course.addReview(new Review("Great course"));
		course.addReview(new Review("Great course2"));
		course.addReview(new Review("Great course3"));

		appDAO.save(course);
	}

	private void deleteCourse(AppDAO appDAO) {
		int id=1;
		appDAO.deleteCourseById(id);
	}

	private void updateCourseById(AppDAO appDAO) {
		int id=1;
		Course course=appDAO.findCourseById(id);
		course.setTitle("Hi update");
		appDAO.updateCourse(course);
	}

	private void updateInstructor(AppDAO appDAO) {
		int id=3;
		Instructor instructor=appDAO.findById(id);
		instructor.setLastName("Tester");
		appDAO.update(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id=3;
		Instructor instructor=appDAO.findInstructorByIdJoinFetch(id);

		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id=3;
		Instructor instructor=appDAO.findById(id);

		System.out.println("Instructor "+instructor);

		List<Course> courses=appDAO.findCoursesByInstructorId(id);

		instructor.setCourses(courses);
		System.out.println(instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor=new Instructor("shivam","verma","s@gmail.com");
		InstructorDetail instructorDetail=new InstructorDetail("http://www.youtube.com","music listening");
		instructor.setInstructorDetail(instructorDetail);

		Course course1=new Course("CPP");
		Course course2=new Course("Java");

		instructor.add(course1);
		instructor.add(course2);

		System.out.println(instructor.getCourses());

		appDAO.save(instructor);
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
		appDAO.deleteById(3);
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
