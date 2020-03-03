package com.mw.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLogAsyncAspect {

    @Before("com.mw.aopdemo.aspect.AspectExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync() {

        System.out.println("\n =====>>>> Logging to cloud in async fashion");
    }
}
