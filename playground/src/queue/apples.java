package queue;

import java.util.PriorityQueue;

public class apples {
	public static void main(String[] args) {
		PriorityQueue<String> q = new PriorityQueue<String>();
		q.add("first");
		q.add("second");
		q.add("third");
		
		System.out.println(q);
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q);
	}
}
