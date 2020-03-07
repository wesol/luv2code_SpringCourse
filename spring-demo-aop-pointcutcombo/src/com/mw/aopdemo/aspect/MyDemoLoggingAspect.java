package com.mw.aopdemo.aspect;


import com.mw.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

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
