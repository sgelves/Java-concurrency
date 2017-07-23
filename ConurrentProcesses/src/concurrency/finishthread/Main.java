package concurrency.finishthread;

public class Main {

	public static void main(String[] args) {
		Thread thread = new PrimeGenerator();
		thread.start();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {

		}
		thread.interrupt();
	}
}
