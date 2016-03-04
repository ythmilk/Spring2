package com.spring.poxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {
		ArithmeticCalculatorImp aImp = new ArithmeticCalculatorImp();
		// �����ô������ķ���ʱ����ִ�еĴ���
		InvocationHandler ih = new ProxyHandler(aImp);

		// ClassLoader �����������һ����������������
		// interFace�����������ͣ�����������Щ����
		ArithmeticCalculatorIn aIn = (ArithmeticCalculatorIn) Proxy.newProxyInstance(
				ArithmeticCalculatorIn.class.getClassLoader(), new Class[] { ArithmeticCalculatorIn.class }, ih);
		int a = aIn.add(1, 2);
		System.out.println(a);
	}

}
