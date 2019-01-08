 package com.lovo.mvc.queue;


import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class PopThread  extends Thread{
	BlockingQueue<String> queue =null;
    public PopThread(BlockingQueue<String>  queue) {
    	this.queue=queue;
    }
    public void run() {
	    while(true) {
	   	 String str;
		try {
			str = queue.take();
			System.out.println(Thread.currentThread().getName()+":"+str);
			Thread.sleep(1000*2);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   	
	    }
    }
}
