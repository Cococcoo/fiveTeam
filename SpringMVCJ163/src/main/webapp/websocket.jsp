<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    String path=request.getContextPath();
    String basePath=request.getServerName()+":"+request.getServerPort()+path+"/";
    String basePath2=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript"  src="<%=basePath2%>js/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
     var path='<%=basePath%>';
     
</script>
</head>
<body>
   <form action="/ws.lovo" method="get">
      账号：<input type="text" name="userName">
       <input type="submit" value="login">
   </form>
</body>
</html>