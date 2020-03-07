package com.mw.aopdemo.aspect;


import com.mw.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.jws.Oneway;
import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    @Around("execution(* com.mw.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // print out method we are advising on (from advice)
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("========>>> Executing @Around on method: " + method);

        long start = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        double duration = (end - start) / 1000.0d;

        System.out.println("\n====>>> duration executing of " + method + " was : " + duration + "s");

        return result;
    }

    @After("execution(* com.mw.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("========>>> Executing @After (finally) on method: " + method);

    }

    @AfterThrowing(pointcut = "execution(* com.mw.aopdemo.dao.AccountDAO.findAccounts(..))",
                   throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("========>>> Executing @AfterThrowing on method: " + method);

        System.out.println("exception:\n" + exception);
    }

    @AfterReturning(pointcut = "execution(* com.mw.aopdemo.dao.AccountDAO.findAccounts(..))",
                    returning = "result")
    public void returningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("========>>> Executing @AfterReturning on method: " + method);
        System.out.println("========>>> result is: " + result);

        convertAccountNamesToUppercase(result);
    }

    private void convertAccountNamesToUppercase(List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

    @Before("com.mw.aopdemo.aspect.AspectExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        System.out.println("\n =====>>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method signature: " + methodSignature);

        //get args
        Object[] args = joinPoint.getArgs();

        // loop thru args

        for (Object o : args) {
            System.out.println(o);

            if (o instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (Account) o;

                System.out.println("Account name: " + account.getName());
                System.out.println("Account name: " + account.getLevel());
            }
        }
    }
}
