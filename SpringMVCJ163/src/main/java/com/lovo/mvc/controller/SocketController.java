package com.lovo.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import com.lovo.mvc.websocket.MyWebSocketHandler;
  
@Controller
public class SocketController {
	
	@RequestMapping(value="/ws.lovo")
      public String login(String userName) {
		   
    	  try {
			MyWebSocketHandler.session.sendMessage(new TextMessage("{'userName:''"+userName+"'}") );
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	  return "socket";   
      }
	  
}
