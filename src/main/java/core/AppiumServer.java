package core;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.Getter;

import java.io.File;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.HashMap;

@Getter
public class AppiumServer {

    public AppiumDriverLocalService service;

    private AppiumDriverLocalService getInstance() {
        if (service == null) {
            setInstance(); // Setting the instance of the AppiumDriverLocalService.
            service.clearOutPutStreams(); //stop printing appium logs to console
        }

        return service;
    }

    private AppiumDriverLocalService getInstance(int port) {
        if (service == null) {
            setInstance(port); // Setting the instance of the AppiumDriverLocalService.
            service.clearOutPutStreams(); //stop printing appium logs to console
        }

        return service;
    }

    private void setInstance() {
        HashMap<String, String> environment = new HashMap<>();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH")); //path to carthage bin folder

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .usingAnyFreePort()
                .withEnvironment(environment)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error:debug") //log level for appium
                .withLogFile(new File("AppiumLog.txt"));

        service = AppiumDriverLocalService.buildService(builder);
    }

    private void setInstance(int port) {
        HashMap<String, String> environment = new HashMap<>();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH")); //path to carthage bin folder

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .usingPort(port)
                .withEnvironment(environment)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error:debug") //log level for appium
                .withLogFile(new File("AppiumLog.txt"));

        service = AppiumDriverLocalService.buildService(builder);
    }

    public void startServer() {
            getInstance().start(); //start appium server
//        if (isPortAvailable(4723)) {
//        }
    }

    public void startServer(int port) {
        if (isPortAvailable(port)) {
            getInstance(port).start(); //start appium server
        }
    }

    public void stopServer() {
        if (service != null) {
            getInstance().stop();
        }
    }

    public void stopServer(int port) {
        if (service != null) {
            getInstance(port).stop();
        }
    }

    public boolean isPortAvailable(int port) {
        //applicable for tcp ports
        try (ServerSocket serverSocket = new ServerSocket()) {
            // setReuseAddress(false) is required only on OSX,
            // otherwise the code will not work correctly on that platform
            serverSocket.setReuseAddress(false);
            serverSocket.bind(new InetSocketAddress(InetAddress.getByName("localhost"), port), 1);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
