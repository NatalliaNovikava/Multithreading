package epam.training;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	  ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
      Thread producer = new Thread(new Producer(queue));
      Thread consumerA = new Thread(new Consumer(queue,"A" ), "consumerA");
      Thread consumerB = new Thread(new Consumer(queue,"B"), "consumerB");
      consumerA.start();
      consumerB.start();
      producer.start();
     }
}