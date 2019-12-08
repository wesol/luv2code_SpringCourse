package com.mw.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {


    @Autowired //#4
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println(">> TennisCoach: in no-arg constructor");
    }

    @Autowired //#1
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    // @Autowired //#2
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.out.println(">> TennisCoach: in setFortuneService");
    }

    //    @Autowired //#3 - THIS WORKING TOO! :)
    //    public void doWhatever(FortuneService fortuneService) {
    //        this.fortuneService = fortuneService;
    //        System.out.println(">> TennisCoach: in doWhatever");
    //    }


    @Override
    public String getDailyWorkout() {
        return "Practise your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @PostConstruct
    public void doMyStartUpStuff() {
        System.out.println(">>Tennis coach: @PostConstruct method");
    }

    @PreDestroy
    public void doMyStopStuff() {
        System.out.println(">>Tennis coach: @PreDestroy method");
    }
}
