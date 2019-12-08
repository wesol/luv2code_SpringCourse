package com.mw.springdemo;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach() {
        System.out.println("TrackCoach: no-arg contructor");
    }

    public TrackCoach(FortuneService fortuneService) {
        System.out.println("TrackCoach: 1-arg contructor");
        this.fortuneService = fortuneService;
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("TrackCoach: setFortuneService() method");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it: " + fortuneService.getFortune();
    }

    private void starting() {
        System.out.println("TrackCoach is starting");
    }

    private void destroyMethod() {
        System.out.println("TrackCoach is stopping");
    }
}
