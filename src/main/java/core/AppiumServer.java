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

    public ThreadLocal<AppiumDriverLocalService> service = new ThreadLocal<>();

    public synchronized void setService(AppiumDriverLocalService localService) {
        service.set(localService);
    }

    public synchronized AppiumDriverLocalService getService() {
        return service.get();
    }

    private AppiumDriverLocalService getInstance(int port) {
        if (getService() == null) {
            setInstance(port); // Setting the instance of the AppiumDriverLocalService.
            getService().clearOutPutStreams(); //stop printing appium logs to console
        }

        return getService();
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

        setService(AppiumDriverLocalService.buildService(builder));
    }

    public void startServer(int port) {
            getInstance(port).start(); //start appium server
    }

    public void stopServer(int port) {
        if (getService() != null) {
            getInstance(port).stop();
        }
    }
}
