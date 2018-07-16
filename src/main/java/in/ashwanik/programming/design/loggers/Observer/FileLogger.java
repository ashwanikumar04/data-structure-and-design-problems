package in.ashwanik.programming.design.loggers.Observer;

public class FileLogger implements ILogger {

	@Override
	public void log(String message) {
		System.out.println("Writing to file: " + message);
	}

}
