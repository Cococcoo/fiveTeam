<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>springMVC</title>
 
</head>
<body>
  <div align="center">
  <ul>
        <c:forEach var="u" items="${listUser}">
           <li>${u.userName }/${u.userPassword }</li>    
        </c:forEach>
     </ul>
  </div>
</body>
</html>