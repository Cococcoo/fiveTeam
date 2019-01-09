<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 在所有的链接前面加上动态获取的绝对全路径 -->
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<title>用户详情</title>
 
</head>
<body>
  <!-- 用户ID -->
 <input type="hidden" id="userId" value="${userId}">
  <div align="center" id="userInfoDivId">
  
     
          
            
             

    
  </div>
  <script type="text/javascript">
  
      
      //获得用户ID
      var userId=$("#userId").val();
   
      //AJAX获取后台数据拼接HTML
      $.post("${pageContext.request.contextPath}/user/getUserInfoListByUserId.lovo",
    		  {'userId':userId},function(date){
    			  var htmlStr="<table>"
    			      htmlStr+="<tr>"
    			      htmlStr+="<td>日期</td>"
    			      htmlStr+="<td>详情</td>"
    			      htmlStr+="</tr>"
    			  $.each(date,function(index,info){  //循环组装
    				
    				        htmlStr+="<tr>"
    				      htmlStr+="<td>"+info.createDate+"</td>"
    				      htmlStr+="<td>"+info.info+"</td>"
    				      htmlStr+="</tr>"
    			  });
    			   htmlStr+="</table>";
    			   //把组装和的HTML放入到DIV
    			   $("#userInfoDivId").html(htmlStr);
    		  });
      
   
   
     
    
  
  </script>
</body>
</html>