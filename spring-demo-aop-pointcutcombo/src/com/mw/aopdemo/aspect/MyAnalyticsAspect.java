package com.mw.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyAnalyticsAspect {

    @Before("com.mw.aopdemo.aspect.AspectExpressions.forDaoPackageNoGetterSetter()")
    public void anyAnalyticMethod() {

        System.out.println("\n =====>>>> Perfoming API analytics()");
    }
}
