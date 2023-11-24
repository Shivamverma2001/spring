package com.spring.sv.curdjpa.dao;

import com.spring.sv.curdjpa.entity.Course;
import com.spring.sv.curdjpa.entity.Instructor;
import com.spring.sv.curdjpa.entity.InstructorDetail;

import java.nio.charset.CoderResult;
import java.util.List;

public interface AppDAO {
    public void save(Instructor instructor);
    Instructor findById(int id);
    void deleteById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void update(Instructor instructor);
    void updateCourse(Course course);
    Course findCourseById(int id);
    void deleteCourseById(int id);
    void save(Course course);
}
