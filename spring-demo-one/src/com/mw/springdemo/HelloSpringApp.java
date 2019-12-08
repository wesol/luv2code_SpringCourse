package com.mw.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {

        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from spring container
        Coach trackCoach = context.getBean("trackCoach", Coach.class);
        Coach soccerCoach = context.getBean("soccerCoach", Coach.class);

        //call the methonds on the bean
        System.out.println(trackCoach.getDailyWorkout());
        System.out.println(trackCoach.getDailyFortune());
        System.out.println(soccerCoach.getDailyWorkout());
        System.out.println(soccerCoach.getDailyFortune());

        //close the spring context
        context.close();
    }
}
