package concurrency.threadvariable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {

	private Date startDate;

	@Override
	public void run() {
		startDate = new Date();
		System.out.printf("Thread %s, at time: %s \n", Thread.currentThread().getId(), startDate);
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s : %s \n", Thread.currentThread().getId(), startDate);
	}
}
