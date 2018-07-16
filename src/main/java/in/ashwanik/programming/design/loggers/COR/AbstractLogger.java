package in.ashwanik.programming.design.loggers.COR;

public abstract class AbstractLogger {

	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;

	protected int level;

	public AbstractLogger nextLogger;

	public void setNextLogger(AbstractLogger logger) {
		this.nextLogger = logger;
	}

	public void logMessage(int level, String message) {
		if (this.level <= level) {
			write(message);
		}
		if (nextLogger != null) {
			nextLogger.logMessage(level, message);
		}
	}

	abstract public void write(String message);

}
