package in.ashwanik.programming.design.loggers;


import in.ashwanik.programming.design.loggers.COR.AbstractLogger;
import in.ashwanik.programming.design.loggers.COR.ConsoleLogger;
import in.ashwanik.programming.design.loggers.COR.FileLogger;
import in.ashwanik.programming.design.loggers.Observer.Logger;

public class LoggerDemo {

    private static AbstractLogger getLoggerChain() {
        FileLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        ConsoleLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        fileLogger.setNextLogger(consoleLogger);
        return fileLogger;
    }

    private static void setObserverLoggers() {
        in.ashwanik.programming.design.loggers.Observer.FileLogger fileLogger = new in.ashwanik.programming.design.loggers.Observer.FileLogger();
        Logger.getInstace().register(fileLogger);
    }

    public static void main(String[] args) {

        AbstractLogger logger = getLoggerChain();
        logger.logMessage(AbstractLogger.INFO, "This is info");
        logger.logMessage(AbstractLogger.DEBUG, "This is debug");

        System.out.println("Observer pattern");

        setObserverLoggers();
        Logger.getInstace().log("This is observer logger");

    }
}
