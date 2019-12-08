package com.mw.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VolleyballApp {
    public static void main(String[] args) {
        //load the context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeActivity3#-applicationContext.xml");

        //retrieve bean
        Coach coach = context.getBean("volleyballCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        //close the context
        context.close();


    }
}
