package com.mw.aopdemo;

import com.mw.aopdemo.dao.AccountDAO;
import com.mw.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = accountDAO.findAccounts();

        // display the accounts
        System.out.println("\nMain Program: AfterReturningDemoApp\n-----");

        System.out.println(accounts + "\n");

        // close the context
        context.close();
    }
}
