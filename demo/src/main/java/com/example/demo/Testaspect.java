package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Testaspect {

	
	
	@AfterReturning(pointcut ="execution(String com.example.demo.Test.two*(..))" ,returning = "result" )
	public void ftrreturn(JoinPoint jp ,Object result)  {
		System.out.println("after proceed :"+result.toString());
	}
	
	@Around("execution(* com.example.demo.Test.one*(..))") 
	public void bfr(ProceedingJoinPoint pjp ) throws Throwable { 
	System.out.println("around"); 
	pjp.proceed();
	System.out.println("after around proceed :");
	
	}
	
	
	  @Before("execution(* com.example.demo.Test.one*(..))")
	  public void bfr() { System.out.println("bfr()"); }
	  
	  @After("execution(* com.example.demo.Test.one*(..))") 
	  public void Aftr() { System.out.println("Aftr()"); }
	 
}
