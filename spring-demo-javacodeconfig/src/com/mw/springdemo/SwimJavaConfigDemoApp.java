package com.mw.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getDailyWorkout());
        System.out.println("email: " + theCoach.getEmail());

        context.close();
    }
}
