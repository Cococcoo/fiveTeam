package com.lovo.mvc.mq;

public interface AmqSenderService {
	/**
	 *发送消息点对点
	 * @param message
	 */
	 public void sendMsgQueue(String message);
	 /**
		 *发送消息订阅发布
		 * @param message
		 */
	 public void sendMsgTopic(String message);
	 /**
	  * 发送事件信息给调度系统
	  * @param obj 事件实体
	  */
	 public void sendModel(final Object obj);
}
