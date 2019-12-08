package com.mw.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach coach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        boolean result = (coach == alphaCoach);

        System.out.println("Same object? " + result);
        System.out.println(coach);
        System.out.println(alphaCoach);

        context.close();
    }
}
