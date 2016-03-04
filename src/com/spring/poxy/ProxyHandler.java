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
		
		System.out.println("调用"+method.getName()+"方法之前");
		int result=(int) method.invoke(arithmeticT, args);
		System.out.println("结果"+Arrays.asList(args)+method.getName()+result);
		System.out.println("调用"+method.getName()+"方法之后");
		return result;
		
	}

}
