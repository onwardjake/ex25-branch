package com.jake.ex25.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ExceptionAspect {

	@AfterThrowing(pointcut = "execution(* com.jake.ex25.service.*.*(..))", throwing="e")
	public void logError(JoinPoint jp, Exception e) {
		log.info("=-=-=-=-=-=-= 메소드 실행 오류 발생 : {}, 오류 : {} =-=-=-=-=-=-=",jp.getSignature(), e.getMessage());
	}
}
