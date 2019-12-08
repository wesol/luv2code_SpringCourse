package com.mw.springdemo;

public class VolleyballCoach implements Coach {

    private FortuneService fortuneService;

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Jump higher!";
    }

    @Override
    public String getDailyFortune() {
        return "VolleyballCoach: " + fortuneService.getFortune();
    }

    private void starting() {
        System.out.println("starting");
    }

    private void destroyMethod() {
        System.out.println("Stopping");
    }
}
