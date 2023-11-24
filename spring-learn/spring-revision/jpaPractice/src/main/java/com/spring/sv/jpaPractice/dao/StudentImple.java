package com.spring.sv.jpaPractice.dao;

import com.spring.sv.jpaPractice.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentImple implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentImple(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        Student s=entityManager.find(Student.class,id);
        return s;
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query=entityManager.createQuery("From Student",Student.class);
        List<Student> answer=query.getResultList();
        return answer;
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query=entityManager.createQuery("From Student where lastName=:theData", Student.class);
        query.setParameter("theData",lastName);
        return  query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        entityManager.remove(id);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("Delete Student", Student.class).executeUpdate();
    }
}
