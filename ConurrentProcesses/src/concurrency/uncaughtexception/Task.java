package concurrency.uncaughtexception;

public class Task extends Thread {

	@Override
	public void run() {
		Integer i = Integer.parseInt("TT");
	}
}
