package com.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lovo.mvc.entity.UserEntity;
import com.lovo.mvc.service.IUserService;

public class T {
  ClassPathXmlApplicationContext app=null;
	@Before
	public void before(){
		app=new ClassPathXmlApplicationContext("application.xml");
	}
	@Test
	public void test(){}
	//查询所有用户
	@Test
	public void getListUser(){
	IUserService us=	(IUserService) app.getBean("userService");
	List list=us.getListUser();
	System.out.println(list.size());
	}
	//根据用户ID查询用户信息
	@Test
	public void getListUserInfoByUserId(){
		IUserService us=	(IUserService) app.getBean("userService");
	List list=	us.getListUserInfoByUserId("1");
	System.out.println(list.size());
	}
	@Test
	public void getUNListUserByRoleT(){
		IUserService us=	(IUserService) app.getBean("userService");
 List<UserEntity> list=		us.getUNListUserByRole(us.getListUser(),us.getListUserByRoleId("1"));
	System.out.println(list.size());
	}
}
