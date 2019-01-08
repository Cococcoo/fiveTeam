<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 在所有的链接前面加上动态获取的绝对全路径 -->
<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css" type="text/css">
    <script src="jquery-2.1.4.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body>

    <div class="container">
        <div class="row">
            <form class="form-horizontal col-md-offset-4" role="form" action="user/login.lovo" method="post">
                <div class="form-group">
                    <label for="userName" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-4">
                        <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-4">
                        <button type="submit" class="btn btn-primary">登录</button>
                        <a href="register.jsp">注册</a>
                        <span style="color: red;">${loginMis }</span>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>