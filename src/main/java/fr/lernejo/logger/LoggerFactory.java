package fr.lernejo.logger;

import java.io.File;
import java.util.function.Predicate;

public class LoggerFactory {


    public static Logger getLogger(String name) {
        Predicate<String> condition = message -> !message.contains("player");
        new File("./log");
        Logger fileLogger = new FileLogger("./log/log");
        Logger filteredFileLogger = new FilteredLogger(fileLogger, condition);
        Logger contextualFileLogger = new ContextualLogger(name, filteredFileLogger);
        Logger consoleLogger = new ConsoleLogger();
        Logger contextualConsoleLogger = new ContextualLogger(name, consoleLogger);

        return new CompositeLogger(contextualConsoleLogger, contextualFileLogger);

    }
}
