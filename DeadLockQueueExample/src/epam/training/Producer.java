package epam.training;

import java.util.LinkedList;

// the producer puts strings on the queue 
public class Producer implements Runnable
{
 
   private LinkedList<String> queue;
  
   public Producer(LinkedList<String> queue)
   {
      this.queue = queue;
   }
   
   public void run() {
     System.out.println("Producer started");
     
     for (int i = 1; i < 10; i++) {
		  
    	 synchronized (queue) {
		   	queue.add("String" + i);
		   	System.out.println("Added: String" + i);
		    try {
		    	Thread.currentThread().sleep(500);
		    } catch (Exception ex) {
		         ex.printStackTrace();
		    }
	     }
      }
	  
     System.out.println("Producer completed");
      
   }

}