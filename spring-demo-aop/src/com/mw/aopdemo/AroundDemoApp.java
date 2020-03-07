package com.mw.aopdemo;

import com.mw.aopdemo.dao.AccountDAO;
import com.mw.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        String prefix = "++ AroundDemoApp: ";
        System.out.println(prefix + "Calling getFortune");

        String data = trafficFortuneService.getFortune();
        System.out.println(prefix + "My fortune is: " + data);

        System.out.println(prefix + "Finished");

        // close the context
        context.close();
    }
}
