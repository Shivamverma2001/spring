package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;

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
