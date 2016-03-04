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
	// ǰ��֪ͨ
	public void beforeMethod(JoinPoint joinPoint) {
		System.out.println(
				"The method begins  " + joinPoint.getSignature().getName() + Arrays.asList(joinPoint.getArgs()));
	}

	// ����֪ͨ�������������ػ��߷����쳣������ִ��
	public void after(JoinPoint joinPoint) {
		System.out
				.println("The Method after " + joinPoint.getSignature().getName() + Arrays.asList(joinPoint.getArgs()));
	}

	// �������غ�֪ͨ
	// ���Կ��Է��ʵ������ķ���ֵ
	public void afterResult(JoinPoint joinPoint, Object result) {
		System.err.println("��������֪ͨ" + result);
	}

	// @Pointcut("execution(*
	// com.spring2.aop.imp.ArithmeticCalculatorIn.*(int,int))")
	// public void informRule() {
	// }
	// �쳣֪ͨ
	public void errorResult(JoinPoint joinPoint, Throwable e) {
		System.out.println("�����쳣" + e + joinPoint.getSignature().getName());
	}
}
