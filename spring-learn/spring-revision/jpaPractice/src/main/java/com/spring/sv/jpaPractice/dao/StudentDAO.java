package com.spring.sv.jpaPractice.dao;

import com.spring.sv.jpaPractice.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentDAO {
    public void save(Student theStudent);
    public Student findById(Integer id);
    public List<Student> findAll();
    public List<Student> findByLastName(String lastName);
    public void update(Student theStudent);
    public void delete(Integer id);
    public int deleteAll();
}
