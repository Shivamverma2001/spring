package com.shivam.springdemo.mvcdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/helloform")
    public String requestForm(){
        return "helloWorld-form";
    }

    @RequestMapping("/processform")
    public String processForm(){
        return "helloform";
    }

    @RequestMapping("/processformversiontwo")
    public String processForm2(HttpServletRequest request, Model model){
        String name=request.getParameter("userName");
        name=name.toUpperCase();
        String result="Yo! "+name;
        model.addAttribute("message",result);
        return "helloform";
    }

//    @GetMapping("/processformversionthree")
//    @PostMapping("/processformversionthree")
    @RequestMapping("/processformversionthree")
    public String processForm3(@RequestParam("userName") String name, Model model){
        name=name.toUpperCase();
        String result="Yo! "+name;
        model.addAttribute("message",result);
        return "helloform";
    }
}
