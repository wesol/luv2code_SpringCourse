package com.mw.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoxingApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BoxCoach boxCoach = (BoxCoach) context.getBean("boxCoach", Coach.class);

        System.out.println(boxCoach.getDailyWorkout());

        for (int i = 0; i < 10; i++)
            System.out.println(boxCoach.getDailyFortune());

        context.close();

    }
}
