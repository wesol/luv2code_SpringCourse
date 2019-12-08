package com.mw.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NewCoach__ACTIVITY_6 implements Coach {

    private FortuneService fortuneService;

    @Autowired
    public NewCoach__ACTIVITY_6(@Qualifier("practiseActivity5FortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }


    @Override
    public String getDailyWorkout() {
        return "gogo";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
