package concurrency.threadvariable;

import java.util.concurrent.TimeUnit;

public class Main {

	public static Thread[] threads;

	public static void main(String[] args) {
		UnsafeTask ut = new UnsafeTask();
		threads = new Thread[3];
		for (int i = 0; i < 3; i++) {
			threads[i] = new Thread(ut);
			threads[i].start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
