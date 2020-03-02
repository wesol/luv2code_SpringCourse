package com.mw.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of out related advices for logging

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n =====>>>> Executing @Before advice on addAccount()");

    }
}
