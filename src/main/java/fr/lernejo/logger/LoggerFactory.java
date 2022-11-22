package fr.lernejo.logger;

import java.io.File;

public class LoggerFactory {


    public static Logger getLogger(String name) {
        new File("./log");
        Logger fileLogger = new FileLogger("./log/log");
        Logger contextualFileLogger = new ContextualLogger(name, fileLogger);
        Logger consoleLogger = new ConsoleLogger();
        Logger contextualConsoleLogger = new ContextualLogger(name, consoleLogger);

        return new CompositeLogger(contextualConsoleLogger, contextualFileLogger);

    }
}
