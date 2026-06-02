package com.itp.amazon.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect 
{

	private static final Logger logger =LoggerFactory.getLogger(LoggingAspect.class);
	
//	@Before("execution(* com.itp.amazon.controller.*.*(..))")   
//	public void loggingBeforeControllerMethods(JoinPoint joinPoint)
//	{
//		logger.info("Method Started {}",joinPoint.getSignature().getName()); 
//		
//		logger.info("Method Arguements {}", Arrays.toString(joinPoint.getArgs()));
//	}
//	
//	@Before("execution(* com.itp.amazon.service.*.*(..))")
//	public void loggingBeforeServiceMethods(JoinPoint joinPoint)
//	{
//		logger.info("Method Started {}",joinPoint.getSignature().getName()); 
//		
//		logger.info("Method Arguements {}", Arrays.toString(joinPoint.getArgs()));
//	}
	
	
	@Before("execution(* com.itp.amazon.controller.*.*(..)) ||" + 
	        "execution(* com.itp.amazon.service.*.*(..))")   
	public void loggingBeforeControllerMethods(JoinPoint joinPoint)
	{
		logger.info("Method Started {}",joinPoint.getSignature().getName()); 
		
		logger.info("Method Arguements {}", Arrays.toString(joinPoint.getArgs()));
	}
	
	
//	@AfterReturning("execution(* com.itp.amazon.controller.*.*(..))")
//	public void loggingAfterReturningControllerMethods(JoinPoint joinPoint)
//	{
//		logger.info("Method Completed {}",joinPoint.getSignature().getName()); 
//	}
//	
//	@AfterReturning("execution(* com.itp.amazon.service.*.*(..))")
//	public void loggingAfterReturningServiceMethods(JoinPoint joinPoint)
//	{
//		logger.info("Method Completed {}",joinPoint.getSignature().getName()); 
//	}
	
	
	@AfterReturning(pointcut="execution(* com.itp.amazon.controller.*.*(..)) || "+ 
	                "execution(* com.itp.amazon.service.*.*(..))")
	public void loggingAfterReturningControllerMethods(JoinPoint joinPoint)
	{
		logger.info("Method Completed {}",joinPoint.getSignature().getName()); 
	}
}
