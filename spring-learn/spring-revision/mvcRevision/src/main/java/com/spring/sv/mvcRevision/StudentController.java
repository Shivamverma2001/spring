package com.spring.sv.mvcRevision;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value(("${languages}"))
    private List<String> favouriteLanguages;
    @Value("${operatingSystems}")
    private List<String> favouriteOperatingSystems;
    @GetMapping("/studentRevision")
    public String studentForm(Model model){
        Student student=new Student();

        model.addAttribute("countries",countries);
        model.addAttribute("languages",favouriteLanguages);
        model.addAttribute("operatingSystems",favouriteOperatingSystems);
        model.addAttribute("student",student);
        return "studentForm";
    }
    @PostMapping("/studentValidation")
    public String studentValidation(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "studentForm";
        }else{
            return "studentConfirmation";
        }
    }
}
