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
	  * 发送结束事件给上报系统
	  * @param obj  事件实体
	  */
	 public void sendOverMessage1(final Object obj);
	 /**
	  * 发送结束事件给资源系统
	  * @param obj  事件实体
	  */
	 public void sendOverMessage2(final Object obj);
}
