package com.cain.c_aop_all;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;



public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		// TODO Auto-generated method stub

		System.out.println("ǰ3");
		
		//�ֶ�ִ��Ŀ�귽��
		Object obj = mi.proceed();
		
		System.out.println("��3");
		return obj;
	}

	

}
