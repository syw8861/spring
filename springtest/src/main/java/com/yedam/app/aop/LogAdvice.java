package com.yedam.app.aop;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[공통 로그] 로직 수행 전 "+method +  " : " + ((args != null && args.length>0) ? args[0] : "") );
		System.out.println(jp.toLongString()); 
		System.out.println(jp.toShortString()); 
	}
}
