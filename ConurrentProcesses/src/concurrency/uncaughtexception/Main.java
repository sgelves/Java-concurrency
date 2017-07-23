package concurrency.uncaughtexception;

public class Main {

	public static void main(String[] args) {
		Task task = new Task();
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
		// task.setUncaughtExceptionHandler(new ExceptionHandler());
		task.start();
	}
}
