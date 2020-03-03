package com.mw.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAnalyticsAspect {

    @Before("forDaoPackageNoGetterSetter()")
    public void anyAnalyticMethod() {

        System.out.println("\n =====>>>> Perfoming API analytics()");
    }
}
