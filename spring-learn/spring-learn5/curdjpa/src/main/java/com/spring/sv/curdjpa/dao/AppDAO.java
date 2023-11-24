package com.spring.sv.curdjpa.dao;

import com.spring.sv.curdjpa.entity.Instructor;
import com.spring.sv.curdjpa.entity.InstructorDetail;

public interface AppDAO {
    public void save(Instructor instructor);
    Instructor findById(int id);
    void deleteById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
}
