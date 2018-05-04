package com.blomni.o2o.eureka.test;

public class ProxyTest implements Animor{

	private Animor a;
	
	public ProxyTest(Animor a){
		this.a=a;
	}

	public void check(){
		System.out.println("输出瓣。。");
	}
	
	@Override
	public void say() {
		this.check();
		this.a.say();
	}
}
