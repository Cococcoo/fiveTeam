<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
	String basePath2 = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户端2</title>
<script type="text/javascript" src="<%=basePath2%>js/jquery-1.10.1.min.js"></script>

<script type="text/javascript">

		var path = '<%=basePath%>';
		//alert("ws://" + path + "ws.lovo");
		var websocket;
		
		if ('WebSocket' in window) {
			websocket = new WebSocket("ws://" + path + "ws.lovo");
		} else if ('MozWebSocket' in window) {
			websocket = new MozWebSocket("ws://" + path + "ws.lovo");
		} else {
			websocket = new SockJS("http://" + path + "ws/sockjs.lovo");
		}
		websocket.onopen = function(event) {
			//alert("WebSocket:已连接");
			  $("#xxid").html(event.data);
			  websocket.send("client2");
		};
		//接收服务器发送回来的消息
		websocket.onmessage = function(event) {
			 
		   $("#mid").html(event.data);
		
		};
		websocket.onerror = function(event) {
			alert("WebSocket:发生错误 ");
			alert(event);
		};
		/** websocket.onclose = function(event) {
			alert("WebSocket:已关闭");
			alert(event);
		} **/
		function sendMsg(){
		websocket.send("我是前台");
		}
		</script>
</head>
<body>
<div id="xxid"></div>
<div id="mid"></div>
	<input type="button" value="发送" class="send" onclick="sendMsg()" >
</body>
</html>
