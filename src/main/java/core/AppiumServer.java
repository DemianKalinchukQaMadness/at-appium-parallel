package core;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

public class AppiumServer {

    private static ThreadLocal<AppiumDriverLocalService> service = new ThreadLocal<>();

    public AppiumServer() {
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

        setService(AppiumDriverLocalService.buildService(builder));
        getService().start();
    }

    public static AppiumDriverLocalService getService() {
        return service.get();
    }

    public static void setService(AppiumDriverLocalService appiumDriverLocalService) {
        service.set(appiumDriverLocalService);
    }

    public AppiumDriverLocalService getInstance() {
        if (getService() == null) {
            getService().clearOutPutStreams(); //stop printing appium logs to console
        }

        return getService();
    }

    public void startServer() {
        getInstance().start(); //start appium server
    }

    public URL getServerUrl() {
        return getService().getUrl();
    }

    public void stopServer() {
        if (getService() != null) {
            getService().stop();
        }
    }
}
