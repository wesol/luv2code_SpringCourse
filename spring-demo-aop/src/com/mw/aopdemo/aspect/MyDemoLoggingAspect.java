package com.mw.aopdemo.aspect;


import com.mw.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

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
