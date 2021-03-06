package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by howard on 2017/6/5.
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger log = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.demo.controller.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes  attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        log.info(request.getRequestURI());

        log.info(request.getMethod());

        log.info(request.getRemoteAddr());

        log.info(joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        log.info(""+joinPoint.getArgs());
        log.info(" before");
    }

    @After("log()")
    public void doAfter() {
        log.info(" doAfter");
    }

    @AfterReturning(returning = "obj", pointcut = "log()")
    public  void doAfterReturning(Object obj)
    {

    }
}
