package com.lovo.mvc.websocket;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
@Component
@EnableWebSocket
public class WebSocketConfig  extends WebMvcConfigurerAdapter implements WebSocketConfigurer{
    @Resource
	MyWebSocketHandler handler;
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
              registry.addHandler(handler, "/ws.lovo").addInterceptors(new HandShake());
              registry.addHandler(handler, "/ws/sockjs.lovo").addInterceptors(new HandShake()).withSockJS();
		
	}

}
