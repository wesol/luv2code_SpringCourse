package com.mw.springdemo;

import org.springframework.stereotype.Component;

@Component
public class BoxingCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Today you fight with the shadow";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
