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
<title>角色-用户维护</title>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css"
	type="text/css">
<script src="jquery-2.1.4.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body >

	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-4">
				<h1>${roleName}-用户维护</h1>
			</div>
		</div>
		<div class="row">


			<div class="form-group">
				<div class="checkbox">
					<span style="color: blue;"><b>${roleName}角色-拥有的用户</b></span>
					<div class="row">
					
                   <c:forEach var="u" items="${listRoleUser}">
							<label class="col-sm-3 control-label h3"> <input
								type="checkbox" name="checkedName" checked="checked"
								value="${u.userId}"> ${u.userName}
							</label>
              </c:forEach>
						
					</div>
					<hr />
					<span style="color: blue;"><b>${roleName}角色-没有拥有的用户</b></span>
					<div class="row">
						
                    <c:forEach var="u" items="${unRoleUser}">
							<label class="col-sm-3 control-label h3"> <input
								type="checkbox" name="checkedName" value="${u.userId}">
							${u.userName}
							</label>
                </c:forEach>
						
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-5">
					<button type="button" class="btn btn-primary"
						onclick="submitUserId()">修改保存</button>
				</div>
			</div>

		</div>
	</div>

	<form action="updateRoleUser.lovo" method="post" id="addordelformId" >
		<input type="text" id="userListId" name="userListId" />
		  <input type="text" value="${roleId}" name="roleId"> 
		  <input type="text" value="${roleName}" name="roleName">
	</form>
	
	<script type="text/javascript">
	//获取选中用户并提交到后台
	function submitUserId(){
		var userid="";
	   $("input[name=checkedName]:checked").each(function(){
		  var v= $(this).val();
		  userid=userid+v+","
	   });
	   //把用户字符串id放入到表单
	   $("#userListId").val(userid);
	   //提交表单
	   $("#addordelformId").submit();
	   
	}
	</script>
	
	
</body>
</html>