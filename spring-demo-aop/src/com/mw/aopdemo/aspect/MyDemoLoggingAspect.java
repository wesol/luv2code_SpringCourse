package com.mw.aopdemo.aspect;


import com.mw.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    private static Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
    
    @Around("execution(* com.mw.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // print out method we are advising on (from advice)
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("========>>> Executing @Around on method: " + method);

        long start = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        double duration = (end - start) / 1000.0d;

        logger.info("\n====>>> duration executing of " + method + " was : " + duration + "s");

        return result;
    }

    @After("execution(* com.mw.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("========>>> Executing @After (finally) on method: " + method);

    }

    @AfterThrowing(pointcut = "execution(* com.mw.aopdemo.dao.AccountDAO.findAccounts(..))",
                   throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("========>>> Executing @AfterThrowing on method: " + method);

        logger.info("exception:\n" + exception);
    }

    @AfterReturning(pointcut = "execution(* com.mw.aopdemo.dao.AccountDAO.findAccounts(..))",
                    returning = "result")
    public void returningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("========>>> Executing @AfterReturning on method: " + method);
        logger.info("========>>> result is: " + result);

        convertAccountNamesToUppercase(result);
    }

    private void convertAccountNamesToUppercase(List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

    @Before("com.mw.aopdemo.aspect.AspectExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        logger.info("\n =====>>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        logger.info("Method signature: " + methodSignature);

        //get args
        Object[] args = joinPoint.getArgs();

        // loop thru args

        for (Object o : args) {
            logger.info(o.toString());

            if (o instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (Account) o;

                logger.info("Account name: " + account.getName());
                logger.info("Account name: " + account.getLevel());
            }
        }
    }
}
