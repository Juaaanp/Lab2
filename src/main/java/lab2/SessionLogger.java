package lab2;
import java.io.IOException;
import java.util.logging.*;

public class SessionLogger {

    private static Logger logger = Logger.getLogger(SessionLogger.class.getName());
    private static FileHandler fileHandler;

    static {
        try {
            fileHandler = new FileHandler("application.log", true); 
            fileHandler.setFormatter(new SimpleFormatter()); 

            logger.addHandler(fileHandler);

            logger.setLevel(Level.ALL); 

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize log file handler", e);
        }
    }

    @SuppressWarnings("exports")
    public static Logger getLogger() {
        return logger;
    }
}
