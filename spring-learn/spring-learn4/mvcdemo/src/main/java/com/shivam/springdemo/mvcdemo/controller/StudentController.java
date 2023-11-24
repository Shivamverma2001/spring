package com.shivam.springdemo.mvcdemo.controller;

import com.shivam.springdemo.mvcdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${operatingSystems}")
    private List<String> operatingSystems;

    @GetMapping("/studentForm")
    public String studentForm(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        model.addAttribute("countries",countries);
        model.addAttribute("languages",languages);
        model.addAttribute("operatingSystems",operatingSystems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudent(@ModelAttribute("student") Student theStudent){
        System.out.println("hi");
        System.out.println("Student details "+theStudent.getFirstName()+" "+
                theStudent.getLastName()+" "+theStudent.getCountry()+" "+theStudent.getFavouriteLanguage());
        return "student-confirmation";
    }
}
