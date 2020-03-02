package com.mw.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(public void addAccount())")
    public  void anyNameMethod() {}

    @Before("anyNameMethod()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n =====>>>> Executing @Before advice on addAccount()");

    }
}
