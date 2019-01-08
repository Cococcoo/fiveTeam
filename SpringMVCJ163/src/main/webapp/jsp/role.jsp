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
<title>添加角色</title>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css"
	type="text/css">
<script src="jquery-2.1.4.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<form class="form-horizontal col-md-offset-4" role="form"
				action="addRole.lovo" method="post">
				<div class="form-group">
					<label for="roleName" class="col-sm-2 control-label">角色名</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="roleName"
							name="roleName" placeholder="请输入角色名">
					</div>
				</div>
				<div class="form-group">
					<label for="roleDescribe" class="col-sm-2 control-label">角色描述</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="roleDescribe"
							name="roleDescribe" placeholder="请输入角色描述">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-4">
						<button type="submit" class="btn btn-primary">添加角色</button>
					</div>
				</div>
			</form>
		</div>
		<div class="row">
			<div class="col-sm-10 col-sm-offset-1">
				<table class="table table-hover table-bordered">
					<tr>
						<th class="col-sm-2">角色名</th>
						<th class="col-sm-2">角色描述</th>
						<th class="col-sm-2">删除角色</th>
						<th class="col-sm-2">维护用户</th>
						<th class="col-sm-2">维护权限</th>
					</tr>
					<c:forEach var="role" items="${listRole}">
						<tr>
							<th class="col-sm-2">${role.roleName}</th>
							<th class="col-sm-2">${role.roleInfo}</th>
							<th class="col-sm-2"><a
								href="${role.roleId}/deleteRole.lovo"
								class="btn btn-danger active" role="button">删除角色</a></th>
							<th class="col-sm-2"><a onclick="userF('${role.roleName}','${role.roleId}')" 
								href="javascript:void(0)"
								class="btn btn-primary active" role="button">维护用户</a></th>
							<th class="col-sm-2"><a
								onclick="powerF('${role.roleName}','${role.roleId}')" 
								href="javascript:void(0)"
								class="btn btn-primary active" role="button">维护权限</a></th>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	    <form action="gotoRoleUser.lovo" method="post" id="gotoRoleUserId" >
	       <input type="text" id="roleNameId" name="roleName">
	         <input type="text" id="roleId" name="roleId">
	    </form>
	    <form action="gotoRolePower.lovo" method="post" id="gotoRolePowerId" style="display: none;">
	       <input type="text" id="rolePName" name="roleName">
	         <input type="text" id="rolePId" name="roleId">
	    </form>
	<script type="text/javascript">
     //角色用户维护
	function userF(roleName,roleId){
		//把用户名和角色ID 放入到form表单
		$("#roleNameId").val(roleName);
		$("#roleId").val(roleId);
		//提交form表单
		$("#gotoRoleUserId").submit();
	}
     //权限维护
     function powerF(roleName,roleId){
    	//把用户名和角色ID 放入到form表单
 		$("#rolePName").val(roleName);
 		$("#rolePId").val(roleId);
 		//提交form表单
 		$("#gotoRolePowerId").submit();
     }
     
	
	</script>
</body>
</html>