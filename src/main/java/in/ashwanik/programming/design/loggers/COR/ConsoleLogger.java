package in.ashwanik.programming.design.loggers.COR;


public class ConsoleLogger extends AbstractLogger {

	public ConsoleLogger(int level) {
		this.level = level;
	}

	@Override
	public void write(String message) {
		System.out.println("Writing to console: " + message);
	}
}
