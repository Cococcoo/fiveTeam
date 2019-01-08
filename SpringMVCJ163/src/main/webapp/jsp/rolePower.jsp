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
<title>角色-权限维护</title>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css"
	type="text/css">
<script src="jquery-2.1.4.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body >

	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-4">
				<h1>${roleName}-权限维护</h1>
			</div>
		</div>
		<div class="row">


			<div class="form-group">
				<div class="checkbox">
					<span style="color: blue;"><b>${roleName}-角色拥有的权限</b></span>
					<div class="row">
					
                        <c:forEach var="p" items="${rolePowerList}">
							<label class="col-sm-3 control-label h3"> <input
								type="checkbox" name="checkedName" checked="checked"
								value="${p.powerId}"> ${p.powerName }
							</label>
                    </c:forEach>
						
					</div>
					<hr />
					<span style="color: blue;"><b>${roleName}-角色没有拥有的权限</b></span>
					<div class="row">              
						 <c:forEach var="p" items="${unRolePowerList}">

							<label class="col-sm-3 control-label h3"> <input
								type="checkbox" name="noCheckedName" value="${p.powerId}">
							${p.powerName }
							</label>
                </c:forEach>
						
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-5">
					<button type="button" class="btn btn-primary"
						onclick="submitPowerId()">提交</button>
				</div>
			</div>

		</div>
	</div>

	<form action="updateRolePower.lovo" method="post" id="addordelformId" >
		<input type="text" id="addId" name="addName" /> <input type="text"
			id="delId" name="delName" /> <input type="text" value="${roleId}"
			name="roleId"> <input type="text" value="${roleName}"
			name="roleName">
	</form>
	
	  <script type="text/javascript">
	  
	  function submitPowerId(){
		  var delPowerId="";
		  var addpowerId="";
		  //获取需要删除的权限ID字符串
		  $("input[name=checkedName]").each(function(){
			  //获取没有被选中的权限ID
			  if(!$(this).prop("checked")){
				  delPowerId= delPowerId+ $(this).val()+",";
			  }
		  });
		  
		  //获取需要添加的权限ID字符串
		  $("input[name=noCheckedName]").each(function(){
			  //获取被选中的权限ID
			  if($(this).prop("checked")){
				  addpowerId= addpowerId+ $(this).val()+",";
			  }
		  });
		  //把它们放入到隐藏表单
		  $("#addId").val(addpowerId);
		  $("#delId").val(delPowerId);
		  
		  //提交表单
		  $("#addordelformId").submit();
	  }
	  
	  </script>
	
</body>
</html>