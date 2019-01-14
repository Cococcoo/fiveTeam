package com.lovo.mvc.mq;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.google.gson.Gson;
import com.lovo.mvc.entity.UserEntity;



public class MyMessageTopicListener implements MessageListener{
//
//	@Override
//	public void onMessage(Message msg) {
//		 if (msg instanceof TextMessage) {
//	            try {
//	                TextMessage txtMsg = (TextMessage) msg;
//	                String message = txtMsg.getText();
//	               
//	                System.out.println("订阅发布收到结果===" + message);
//	            } catch (JMSException e) {
//	                throw new RuntimeException(e);
//	            }
//	        } else {
//	            throw new IllegalArgumentException("Message must be of type TextMessage");
//	        }
//	}
	@Override
	public void onMessage(Message message) {
		System.out.println("[receive message]");  
		 if (message instanceof TextMessage) {
	        try {  
                TextMessage txtMsg = (TextMessage) message;
                String json = txtMsg.getText();
	        	final Gson gson= new Gson();
	            final UserEntity user = gson.fromJson(json, UserEntity.class);
	            System.out.println(user.getId()+","+user.getName());
	 
	        } catch (final JMSException e) {  
	            e.printStackTrace();  
	        }
		 }else {
	            throw new IllegalArgumentException("Message must be of type TextMessage");
	        }
			
	}
}
