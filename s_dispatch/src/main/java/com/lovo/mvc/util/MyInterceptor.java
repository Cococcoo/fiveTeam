package com.lovo.mvc.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{

   private Logger log=Logger.getLogger(this.getClass());
   
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	//获取请求路径
	String ServletPath=	request.getServletPath();
   //判断是否登录成功
   Object obj=	request.getSession().getAttribute("user");
   boolean bl=false;
   if(null!=obj){
   }
   
   return false;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
        
		System.out.println("渲染之前");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("处理完毕");
		
	}

}
