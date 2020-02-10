package com.ds.test.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CentralLogAspect {

    Logger log = LoggerFactory.getLogger(CentralLogAspect.class);

    @Pointcut(value = "execution(* com.ds.test.controller.*.*(..))")
    public void myPointCut() {

    }

    @Around(value = "myPointCut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();

        Object args = pjp.getArgs();
        log.info("Method invoked " + methodName + "()" + "arguments: " + mapper.writeValueAsString(args));

        Object object = pjp.proceed();
        log.info(className + " " + methodName + "()" + " Response: " + mapper.writeValueAsString(object));

        return object;
    }

}
