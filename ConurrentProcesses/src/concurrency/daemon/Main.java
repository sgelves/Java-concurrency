package concurrency.daemon;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	private static Deque<Event> deque = new ArrayDeque<Event>();

	public static void main(String[] args) {
		WriterTask writer = new WriterTask(deque);
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(writer);
			thread.start();
		}
		Cleaner cleaner = new Cleaner(deque);
		cleaner.start();
	}

}
