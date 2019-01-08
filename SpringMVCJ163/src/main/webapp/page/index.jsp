<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>springMVC</title>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<% String imgpath= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+"/";
			%>
<!-- 在所有的链接前面加上动态获取的绝对全路径 -->
<base href="<%=basePath%>">
</head>
<body>
  <div align="center">
  <img src="<%=imgpath%>img/xx.jpg" style="width: 100px;height: 200px"/>
       <form action="user/savaUser.lovo" method="post" >
         <span>用户：</span><input type="text" name="userName"><p/>
         <span>密码：</span><input type="text" name="password"><p/>
         <input type="submit" value="保存">
          
       </form>
  </div>
</body>
</html>