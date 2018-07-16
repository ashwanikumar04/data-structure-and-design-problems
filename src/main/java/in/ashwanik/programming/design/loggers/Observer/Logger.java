package in.ashwanik.programming.design.loggers.Observer;

import java.util.ArrayList;

public class Logger {

	public static Logger getInstace() {
		if (instance == null) {
			synchronized (Logger.class) {
				if (instance == null) {
					instance = new Logger();
				}
			}
		}
		return instance;
	}

	private static volatile Logger instance = null;

	private ArrayList<ILogger> loggers;

	private Logger() {
		loggers = new ArrayList<ILogger>();
	}

	public void log(String message) {
		for (ILogger logger : loggers) {
			logger.log(message);
		}
	}

	public void register(ILogger logger) {
		if (!loggers.contains(logger)) {
			loggers.add(logger);
		}
	}
}
