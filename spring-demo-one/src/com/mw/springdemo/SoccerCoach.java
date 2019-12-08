package com.mw.springdemo;

public class SoccerCoach implements Coach {

    private FortuneService fortuneService;

    public SoccerCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Go go motherfuckers";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
