package com.mw.springdemo;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        System.out.println("In BaseballCoach constructor");
        this.fortuneService = fortuneService;
    }

    public BaseballCoach() {

    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Spend 30 minutes on batting practise";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
