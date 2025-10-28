package com.jake.ex25.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class PerformanceAspect {

	@Around("execution (* com.jake.ex25.service.*.*(..))")
	public Object measureTime(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis();
		Object result = pjp.proceed();
		long end = System.currentTimeMillis();
		
		log.info("=-=-=-= 실행 메소드 : {}, 실행 시간 : {}ms =-=-=-=",pjp.getSignature(), end-start);
		return result;
	}
}
