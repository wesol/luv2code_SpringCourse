package com.mw.springdemo;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Hit the ball, more strongly!";
    }

    @Override
    public String getDailyFortune() {
        return "Great! :)";
    }
}
