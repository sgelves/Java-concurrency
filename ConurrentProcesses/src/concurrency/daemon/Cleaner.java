package concurrency.daemon;

import java.util.Date;
import java.util.Deque;

public class Cleaner extends Thread {
	private Deque<Event> deque;

	public Cleaner(Deque<Event> deque) {
		this.deque = deque;
		setDaemon(true);
	}

	@Override
	public void run() {
		while (true) {
			Date date = new Date();
			clean(date);
		}
	}

	private void clean(Date date) {
		long difference;
		boolean delete;
		if (deque.size() == 0) {
			System.out.println("Tamaño del arreglo: " + deque.size());
			return;
		} else {
			delete = false;
			do {
				Event e = deque.getLast();
				difference = date.getTime() - e.getDate().getTime();
				if (difference > 10000) {
					System.out.printf("Cleaner: %s\n", e.getEvent());
					deque.removeLast();
					delete = true;
				}
			} while (difference > 10000);
			if (delete) {
				System.out.printf("Cleaner: Size of the queue: %d\n", deque.size());
			}
			
		}
	}
}
