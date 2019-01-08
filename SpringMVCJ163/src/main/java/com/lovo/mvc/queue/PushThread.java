package com.lovo.mvc.queue;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class PushThread implements Runnable{
	BlockingQueue<String> queue =null;
	public PushThread(BlockingQueue<String> queue ) {
		this.queue=queue;
	}
	@Override
	public void run() {
	       for (int i = 0; i < 20; i++) {
			   
                       try {
                    	   queue.put(Thread.currentThread().getName()+":"+"hello"+i);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			   
		}
	}
	

}
