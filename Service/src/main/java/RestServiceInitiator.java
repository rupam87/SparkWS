import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class RestServiceInitiator {
    public static void main(String[] args) {

        // Start embedded server at this port
        port(8081);

        // Set Threadpool size, timeouts
        int maxThreads = 8;
        int minThreads = 2;
        int timeOutMillis = 30000;
        threadPool(maxThreads, minThreads, timeOutMillis);

        // Start the User Controller Service with the defined Routes
        new UserController();

        enableDebugScreen();

    }
}
