package com.mw.springdemo;

public class MyApp {
    public static void main(String[] args) {
        Coach coach = new TrackCoach();
        System.out.println(coach.getDailyWorkout());
    }
}
