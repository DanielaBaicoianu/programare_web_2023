package com.example.laborator2.ex1.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OwnerAspects {

    @Around("@annotation(MarkedForLogging)")
    public void aspectForAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        joinPoint.proceed();
        System.out.println("Inside aop.");
    }

}
