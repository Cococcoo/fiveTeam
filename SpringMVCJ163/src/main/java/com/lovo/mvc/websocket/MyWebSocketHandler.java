package com.lovo.mvc.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@Configuration
@EnableWebMvc
@EnableWebSocket
public class MyWebSocketHandler implements WebSocketHandler{
   public static WebSocketSession session;
	

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		  System.out.println("已建立连接");
		   session.sendMessage(new TextMessage("{'name:'已经与后台建立连接'}") );
		   this.session=session;
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		  String mstr = message.getPayload().toString();
		  System.out.println(session.isOpen());
		  if(null!=this.session&&this.session.isOpen()) {
			  this.session.sendMessage(new TextMessage("{'name:'我是服务器','message':'"+mstr+"'}") );
		  }
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		if(session.isOpen()) {
			session.close();
		}
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterConnectionClosed(WebSocketSession arg0, CloseStatus arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
