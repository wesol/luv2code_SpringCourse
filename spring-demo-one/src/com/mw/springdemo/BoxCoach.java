package com.mw.springdemo;

public class BoxCoach implements Coach {

    private FortuneService fortuneService;

    public BoxCoach() {
    }

    public BoxCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void setFortuneService(RandomFortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Try harder";
    }

    @Override
    public String getDailyFortune() {
        return "BoxCoach: " + fortuneService.getFortune();
    }
}
