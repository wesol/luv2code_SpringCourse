package com.mw.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectExpressions {

    @Pointcut("execution(* com.mw.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    // create pointcut for accessor methods
    @Pointcut("execution(* com.mw.aopdemo.dao.*.get*(..))")
    public void getter() {}

    // create pointcut for mutator methods
    @Pointcut("execution(* com.mw.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
