package com.yedam.app.ioc;

import javax.annotation.Resource;
import javax.inject.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class SamsungTV implements TV {

	//@Autowired //주입  -> factory.getBean("speaker")와 같음
	//@Qualifier("sonySpeaker")  //식별자 스피커들의 이름을 지정해주지 않았을때 사용
	//@Resource(name="sonySpeaker") //위에 두개를 합쳐놓은게 이거임 
	private Speaker speaker;	
	private int price;
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSonySpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//생성자 방식으로 의존관계 객체 주입
	public SamsungTV(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
	}
	public SamsungTV() {}
	
	public void initMethod() {
		System.out.println("SamsungTV 초기화");
	}
	@Override
	public void powerOn() {
		System.out.println("SamsungTV powerOn 가격:");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV powerDown");
	}
	@Override
	public void volumeUp() {
		//speaker = new SonySpeaker();
		speaker.volumeUp();
		//System.out.println("SamsungTV volumeUp");
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
		//System.out.println("SamsungTV volumeDown");
	}	
}
