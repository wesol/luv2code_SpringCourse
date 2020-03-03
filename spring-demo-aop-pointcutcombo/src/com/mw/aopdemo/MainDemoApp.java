package com.mw.aopdemo;

import com.mw.aopdemo.dao.AccountDAO;
import com.mw.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account account = new Account();

        // call the account dao getter/setter methods
        accountDAO.setName("foobar");
        accountDAO.setName("silver");
        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        // call the business method
        accountDAO.addAccount(account, true);
        accountDAO.doWork();




        membershipDAO.addAccount();

        // close the context
        context.close();
    }
}
