package com.example.laborator4.aspects;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspects {

    @After("execution (* com.example.laborator4.controller.*.*(..))")
    public void logWhenControllerMethodIsCalled(JoinPoint joinPoint){
        System.out.println(LocalDateTime.now() + " method: " + joinPoint.getSignature().getName()
        + " was called from controller " + joinPoint.getTarget().getClass().getSimpleName());
    }

}
