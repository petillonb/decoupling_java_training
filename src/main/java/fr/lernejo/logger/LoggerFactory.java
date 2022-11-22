package fr.lernejo.logger;

import java.io.File;

public class LoggerFactory {


    public static Logger getLogger(String name) {
        new File("./log");
        Logger logger = new FileLogger("./log/log");
        return new ContextualLogger(name, logger);

    }
}
