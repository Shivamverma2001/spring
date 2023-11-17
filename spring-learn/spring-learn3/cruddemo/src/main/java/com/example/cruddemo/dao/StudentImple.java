package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
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
    public StudentImple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery=entityManager.createQuery("From Student order by lastName",Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery=entityManager.createQuery("From Student where lastName=:theData",Student.class);
        theQuery.setParameter("theData",lastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student=entityManager.find(Student.class,id);

        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numberOfRowsEffected=entityManager.createQuery("Delete from Student").executeUpdate();

        return numberOfRowsEffected;
    }
}
