package com.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lovo.mvc.entity.RoleEntity;
import com.lovo.mvc.service.IRoleService;

public class TRoleSerice {
	ClassPathXmlApplicationContext app=null;
	IRoleService rs=null;
	@Before
	public void before(){
		app=new ClassPathXmlApplicationContext("application.xml");
		rs=(IRoleService) app.getBean("roleService");
		
	}
	/**
	 * 测试获取角色集合
	 */
	@Test
	public void getListRole(){
	List l=	rs.getListRole();
	System.out.println(l.size());
	}
}
