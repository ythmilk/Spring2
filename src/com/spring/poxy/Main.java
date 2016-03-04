package com.spring.poxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {
		ArithmeticCalculatorImp aImp = new ArithmeticCalculatorImp();
		// 当调用代理对象的方法时，该执行的代码
		InvocationHandler ih = new ProxyHandler(aImp);

		// ClassLoader 代理对象由哪一个类加载器负责加载
		// interFace代理对象的类型，即其中有哪些方法
		ArithmeticCalculatorIn aIn = (ArithmeticCalculatorIn) Proxy.newProxyInstance(
				ArithmeticCalculatorIn.class.getClassLoader(), new Class[] { ArithmeticCalculatorIn.class }, ih);
		int a = aIn.add(1, 2);
		System.out.println(a);
	}

}
