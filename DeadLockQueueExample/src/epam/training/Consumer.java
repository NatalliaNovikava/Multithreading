package epam.training;

import java.util.LinkedList;

//the consumer removes strings from the queue
public class Consumer implements Runnable {
		 
   private LinkedList<String> queue;
   public String name;
  
   public Consumer(LinkedList<String> queue, String name) {
      this.queue = queue;
      this.name= name;
   }
   
   public void run() {
	  String str;
	  System.out.println("Consumer " + name + " started");
	  for (int x = 0; x < 10; x++) {   
		 
		  System.out.println("try to remove "+ x);
		  synchronized (queue) { 
			 while ((str = queue.poll()) == null) {
			//	 System.out.println("Consumer " + name+ " attemp to remove  is failed" + x +" and sleep");
			  }
			  System.out.println("Consumer " + name + " removed: " + str);
			  try { 
				  Thread.currentThread().sleep(200);
			  } catch (InterruptedException e) {
				  e.printStackTrace();
			  }
		 }
	  }
	  System.out.println("Consumer " + name + " completed");
	}	  
}
