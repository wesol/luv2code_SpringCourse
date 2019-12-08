package com.mw.springdemo;

public class New7Coach implements Coach{

    private FortuneService fortuneService;

    public New7Coach(FortuneService fortuneService) {
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
        return "Try 7 times harder!";
    }

    @Override
    public String getDailyFortune() {
        return "You can be in heaven :)";
    }
}
