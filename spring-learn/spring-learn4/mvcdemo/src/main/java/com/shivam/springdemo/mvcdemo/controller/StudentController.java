package com.shivam.springdemo.mvcdemo.controller;

import com.shivam.springdemo.mvcdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @GetMapping("/studentForm")
    public String studentForm(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudent(@ModelAttribute("student") Student theStudent){
        System.out.println("hi");
        System.out.println("Student details "+theStudent.getFirstName()+" "+theStudent.getLastName());
        return "student-confirmation";
    }
}
