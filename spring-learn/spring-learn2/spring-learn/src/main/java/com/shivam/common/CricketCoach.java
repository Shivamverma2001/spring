package com.shivam.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice bowling for atleast 15 min";
    }
}
