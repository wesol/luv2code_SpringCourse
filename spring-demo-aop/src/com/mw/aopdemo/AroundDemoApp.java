package com.mw.aopdemo;

import com.mw.aopdemo.dao.AccountDAO;
import com.mw.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundDemoApp {

    private static Logger logger = Logger.getLogger(AroundDemoApp.class.getName());

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        String prefix = "++ AroundDemoApp: ";
        logger.info(prefix + "Calling getFortune");

        String data = trafficFortuneService.getFortune();
        logger.info(prefix + "My fortune is: " + data);

        logger.info(prefix + "Finished");

        // close the context
        context.close();
    }
}
