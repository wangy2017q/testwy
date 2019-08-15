package com.example.wangy.demo.controller.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyAspect {
    @Pointcut("execution(public * com.example.wangy.demo.service.*.*(..))")
    public void beginLog() {
        log.info("begin log");
    }
    @Before("beginLog()")
    public void beforeLog(JoinPoint joinPoint){
        log.info("执行前");
    }
    @AfterReturning(returning = "obj",pointcut = "beginLog()")
    public void afterReturnLog(Object obj){
        log.info("获取返回值：{}",obj.toString());
    }
}
