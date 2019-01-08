package com.lovo.mvc.queue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainThread {
    public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(50);
		 PopThread pop1= new PopThread(queue);
		 PopThread pop2= new PopThread(queue);
		 PopThread pop3= new PopThread(queue);
		  Thread push1 = new Thread(new PushThread(queue));
		  Thread push2= new Thread(new PushThread(queue));
		  pop1.start();
		  pop2.start();
		  pop3.start();
		  push1.start();
		  push2.start();
	}
}
