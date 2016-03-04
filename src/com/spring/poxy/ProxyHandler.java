package com.spring.poxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ProxyHandler implements InvocationHandler {
	private Object arithmeticT;

	public ProxyHandler(Object arithmeticT) {
		this.arithmeticT = arithmeticT;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("����"+method.getName()+"����֮ǰ");
		int result=(int) method.invoke(arithmeticT, args);
		System.out.println("���"+Arrays.asList(args)+method.getName()+result);
		System.out.println("����"+method.getName()+"����֮��");
		return result;
		
	}

}
