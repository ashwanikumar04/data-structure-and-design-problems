package in.ashwanik.programming.design.loggers.Observer;

public class ConsoleLogger implements ILogger {

	@Override
	public void log(String message) {
		System.out.println("Writing to console: " + message);
	}

}
