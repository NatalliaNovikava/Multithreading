package epam.training;

import java.util.concurrent.ConcurrentLinkedQueue;
//the consumer removes strings from the queue

public class Consumer implements Runnable {
		 
   private ConcurrentLinkedQueue<String> queue;
   private String name;
   
   public Consumer(ConcurrentLinkedQueue<String> queue, String name){
      this.queue = queue;
      this.name= name;
   }
   
   public void run() {
	  String str;
	  System.out.println("Consumer " + name + " started");
	  for (int x = 0; x < 10; x++) {
	     while ((str = queue.poll()) != null)
	     {
	    	 System.out.println("Consumer " + name + " removed: " + str);
	     }
	     try {
	        Thread.currentThread().sleep(500);
	     } catch (Exception ex) {
	        ex.printStackTrace();
	     }
	  }
	  System.out.println("Consumer " + name + " completed");
   }
}
