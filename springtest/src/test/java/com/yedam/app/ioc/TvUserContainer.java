package com.yedam.app.ioc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUserContainer {

	public static void main(String[] args) {

		AbstractApplicationContext  factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		//new GenericXmlApplicationContext("applicationContext.xml");여기에 내가 불어올 beans를 다 넣어놓고 쓰면됨 이건 resources에 있음
		
		/*TV tv = (TV)factory.getBean("tv");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();   */
		
		Speaker speaker1 = (Speaker) factory.getBean("sony");
		Speaker speaker2 = (Speaker) factory.getBean("sony");
		System.out.println(speaker1 == speaker2 ? "yes" : "no");
		

	}
}
