package com.shivam.rest;

import com.shivam.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    //Constructor Injection
    @Autowired
    public DemoController(@Qualifier("trackcoach") Coach theCoach){
        myCoach=theCoach;
    }

    //Setter method injection
//    @Autowired
//    public void setCoach(Coach theCoach){
//        myCoach=theCoach;
//    }
    @GetMapping("/dailyworkout")
    public  String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
