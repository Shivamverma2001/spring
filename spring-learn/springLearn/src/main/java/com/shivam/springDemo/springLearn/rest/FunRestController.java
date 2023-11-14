package com.shivam.springDemo.springLearn.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // injecting properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String teamInfo(){
        return  "My coach and team name is "+coachName+" "+teamName;
    }


    // expose "/" that return "Hello World"

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    //expose "/workout"
    @GetMapping("/workout")
    public String dailyWorkout(){
        return "Run 5km!";
    }

    @GetMapping("/fortune")
    public String dailyFortune(){
        return "Your day go well!";
    }
}
