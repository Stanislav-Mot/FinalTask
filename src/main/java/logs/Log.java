package logs;

import org.apache.log4j.Logger;

public class Log {
    private static final Logger log = Logger.getLogger(Log.class);

    public static void info(String message) {
        log.info(message);
    }

    public static void info(String message, Throwable exception) {
        log.info(message, exception);
    }

    public static void error(Exception error) {
        log.error(" --- Exception occurs --- ", error);
        throw new AssertionError(error);
    }
}
