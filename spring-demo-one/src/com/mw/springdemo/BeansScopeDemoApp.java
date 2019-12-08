package com.mw.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansScopeDemoApp {
    public static void main(String[] args) {
        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        //retrieve bean from spring container
        Coach coach = context.getBean("trackCoach2", Coach.class);

        Coach alphaCoach = context.getBean("trackCoach2", Coach.class);

        boolean result = alphaCoach == coach;

        System.out.println("Pointing to the same object? " + result);

        System.out.println("Memory location for the coach: " + coach);
        System.out.println("Memory location for the alphaCoach: " + coach);

        //use methods

        //close the context
        context.close();
    }
}
