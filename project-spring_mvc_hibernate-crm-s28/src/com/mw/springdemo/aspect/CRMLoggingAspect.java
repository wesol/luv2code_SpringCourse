package com.mw.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    //setup logger
    private static Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());

    // setup pointcut declarations
    @Pointcut("execution(* com.mw.springdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.mw.springdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.mw.springdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

}
