package com.spring2.aop.imp;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

public class LogCatXml {
	// 前置通知
	public void beforeMethod(JoinPoint joinPoint) {
		System.out.println(
				"The method begins  " + joinPoint.getSignature().getName() + Arrays.asList(joinPoint.getArgs()));
	}

	// 后置通知，无论正常返回或者发生异常，都会执行
	public void after(JoinPoint joinPoint) {
		System.out
				.println("The Method after " + joinPoint.getSignature().getName() + Arrays.asList(joinPoint.getArgs()));
	}

	// 正常返回后通知
	// 所以可以访问到方法的返回值
	public void afterResult(JoinPoint joinPoint, Object result) {
		System.err.println("正常返回通知" + result);
	}

	// @Pointcut("execution(*
	// com.spring2.aop.imp.ArithmeticCalculatorIn.*(int,int))")
	// public void informRule() {
	// }
	// 异常通知
	public void errorResult(JoinPoint joinPoint, Throwable e) {
		System.out.println("发生异常" + e + joinPoint.getSignature().getName());
	}
}
