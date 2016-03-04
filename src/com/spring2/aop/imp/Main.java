package com.spring2.aop.imp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		ArithmeticCalculatorIn arithmetic = (ArithmeticCalculatorIn) act.getBean("arithmeticCalculatorImp");
		System.out.println(arithmetic.add(1, 2));
		System.out.println(arithmetic.div(1, 0));
	}

}
