package com.sv.springdemo.springmvcvalidation;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    @RequestMapping("/customer")
    public String customerForm(Model model){
        model.addAttribute("customer",new Customer());
        return "customer-form";
    }
    @PostMapping("/processCustomerForm")
        public String customerValidation(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "customer-form";
        }
        return "customer-validation";
        }
}
