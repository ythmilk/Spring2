package com.spring2.aop.imp;

import java.util.Arrays;

import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.RequestingUserName;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class LogCat {
	// @Before("execution(public int
	// com.spring2.aop.imp.ArithmeticCalculatorIn.*(int,int))")
	//@Before("execution(* *.*(..))")
	@Before("informRule()")
	public void beforeMethod(JoinPoint joinPoint) {

		System.out.println(
				"The method begins  " + joinPoint.getSignature().getName() + Arrays.asList(joinPoint.getArgs()));
	}

	// ����֪ͨ�������������ػ��߷����쳣������ִ��
	//@After("execution(public int com.spring2.aop.imp.ArithmeticCalculatorIn.*(int,int))")
	@After("informRule()")
	public void after(JoinPoint joinPoint) {
		System.out
				.println("The Method after " + joinPoint.getSignature().getName() + Arrays.asList(joinPoint.getArgs()));
	}

	// �������غ�֪ͨ
	//���Կ��Է��ʵ������ķ���ֵ
	@AfterReturning(value="execution(* com.spring2.aop.imp.ArithmeticCalculatorIn.*(int,int))",returning="result")
	//@AfterReturning("informRule()")
	public void afterResult(JoinPoint joinPoint,Object result) {
		System.err.println("��������֪ͨ"+result);
	}
	@Pointcut("execution(* com.spring2.aop.imp.ArithmeticCalculatorIn.*(int,int))")
	public void informRule(){
		
	}
	@AfterThrowing(pointcut = "execution(* com.spring2.aop.imp.ArithmeticCalculatorIn.*(int,int))", throwing = "e")
	public void errorResult(JoinPoint joinPoint, Throwable e) {
		System.out.println("�����쳣" +  joinPoint.getSignature().getName()+e);
	}
}
