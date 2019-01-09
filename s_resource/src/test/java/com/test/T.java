package com.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class T {
  ClassPathXmlApplicationContext app=null;
	@Before
	public void before(){
		app=new ClassPathXmlApplicationContext("application.xml");
	}
	@Test
	public void test(){}
	//查询所有用户
	
}
