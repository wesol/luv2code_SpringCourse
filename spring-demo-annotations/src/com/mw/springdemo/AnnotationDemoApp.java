package com.mw.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach coach = context.getBean("tennisCoach", Coach.class);
        Coach coach2 = context.getBean("newCoach__ACTIVITY_6", Coach.class);

        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach2.getDailyFortune());
        System.out.println(coach2.getDailyFortune());
        System.out.println(coach2.getDailyFortune());

        context.close();

    }
}
