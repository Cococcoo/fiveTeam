<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>添加权限</title>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css"
	type="text/css">
<script src="jquery-2.1.4.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<form class="form-horizontal col-md-offset-4" role="form"
				action="addPower.lovo" method="post">
				<div class="form-group">
					<label for="powerName" class="col-sm-2 control-label">权限名</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="powerName"
							name="powerName" placeholder="请输入权限名">
					</div>
				</div>
				<div class="form-group">
					<label for="resourceName" class="col-sm-2 control-label">资源名</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="resourceName"
							name="resourceName" placeholder="请输入资源名">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-4">
						<button type="submit" class="btn btn-primary">添加权限</button>
					</div>
				</div>
			</form>
		</div>
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<table class="table table-hover table-bordered">
					<tr>
						<th class="col-sm-2">权限名</th>
						<th class="col-sm-2">资源名</th>
						<th class="col-sm-2">删除权限</th>
					</tr>
					<c:forEach var="power" items="${powerList}">
						<tr>
							<th class="col-sm-2">${power.powerName}</th>
							<th class="col-sm-2">${power.resourceName}</th>
							<th class="col-sm-2"><a href="/${ power.powerId}/deletePower.lovo" class="btn btn-danger active" role="button">删除角色</a></th>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>