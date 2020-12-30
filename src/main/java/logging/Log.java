package logging;


import org.apache.log4j.Logger;

public class Log {


    public static Logger getLogger() {
        final Throwable t = new Throwable();
        final StackTraceElement methodCaller = t.getStackTrace()[2];
        final Logger logger = Logger.getLogger(methodCaller.getClassName());
        return logger;
    }

    public static int numberOfline() {
        final Throwable t = new Throwable();
        final StackTraceElement methodCaller = t.getStackTrace()[2];
        final int numberOfLine = methodCaller.getLineNumber();
        return numberOfLine;
    }


    public static void TEST_MESSAGE_CHECK(String text) {
        getLogger().info(numberOfline() + " " + text);
    }

    public static void TEST_MESSAGE_SUCESS(String text) {
        getLogger().warn(numberOfline() + " " + text);
    }

    public static void TEST_MESSAGE_FAIL(String text) {
        getLogger().error(numberOfline() + " " + text);
    }

    public static void DEBUG_MESSAGE_CHECK(String text) {
        getLogger().debug(numberOfline() + " " + text);
    }
}
