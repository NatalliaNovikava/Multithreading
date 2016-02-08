package epam.training;

import java.util.LinkedList;


public class LinkedListExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	  LinkedList<String> queue = new LinkedList<String>();
      Thread producer = new Thread(new Producer(queue), "producer");
      Thread consumerA = new Thread(new Consumer(queue,"A" ), "consumerA");
      Thread consumerB = new Thread(new Consumer(queue,"B"), "consumerB");
      producer.start();
      consumerA.start();
      consumerB.start();

	}
}