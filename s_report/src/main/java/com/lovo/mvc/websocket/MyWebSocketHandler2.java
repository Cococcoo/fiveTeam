package com.lovo.mvc.websocket;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;





/**
 * Socket处理器
 * 
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class MyWebSocketHandler2 implements WebSocketHandler {
	public  WebSocketSession session;
	public static  Map<String,WebSocketSession> mapSession=new HashMap<String,WebSocketSession>();
	/**
	 * 建立连接后
	 */
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	    System.out.println("已建立连接。。。XXXX。");
	     //向客服端发送信息
	     session.sendMessage(new TextMessage("已经与后台建立连接")); 
	
	    
	      this.session=session;
	    
	}

	/**
	 * 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
	 */
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
	
		//打印客户端发送回来的消息
		String mstr=message.getPayload().toString();
	
		System.out.println(session.isOpen());
		if (null!=this.session  && this.session.isOpen()) {
			mapSession.put(mstr,session);
			//回复前端消息
			 // this.session.sendMessage(new TextMessage("{'name:'我是服务器','message':'"+mstr+"'}"));
		}
	}

	/**
	 * 消息传输错误处理
	 */
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
	
	}

	/**
	 * 关闭连接后
	 */
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.out.println("Websocket:" + session.getId() + "已经关闭");
	
	}

	public boolean supportsPartialMessages() {
		return false;
	}

	

}
