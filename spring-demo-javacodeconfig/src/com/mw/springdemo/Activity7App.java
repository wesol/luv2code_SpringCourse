package com.mw.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Activity7App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(SportConfig.class);
        Coach coach = context.getBean("new7Coach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        context.close();
    }
}
