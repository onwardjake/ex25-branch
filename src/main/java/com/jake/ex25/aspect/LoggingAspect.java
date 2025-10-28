package com.jake.ex25.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
	@Before("execution (* com.jake.ex25.service.*.*(..))")
	public void logBefore(JoinPoint jp) {
		log.info("========== 메소드 실행 전 : {} ==========", jp.getSignature());
	}
	
	@AfterReturning(pointcut = "execution (* com.jake.ex25.service.*.*(..))", returning="result")
	public void logAfter(JoinPoint jp, Object result) {
		log.info("========== 메소드 실행  : {} /// 결과 : {} ==========", jp.getSignature(), result);
	}
}
