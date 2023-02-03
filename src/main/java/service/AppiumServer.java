package service;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.Getter;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

import static service.AppiumServerManager.getService;
import static service.AppiumServerManager.setService;

public class AppiumServer {

    @Getter
    private AppiumServiceBuilder appiumServiceBuilder;

    public AppiumServer() {
        HashMap<String, String> environment = new HashMap<>();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH")); //path to carthage bin folder

        this.appiumServiceBuilder = new AppiumServiceBuilder();
        this.appiumServiceBuilder
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .usingAnyFreePort()
                .withEnvironment(environment)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error:debug") //log level for appium
                .withLogFile(new File("AppiumLog.txt"));
    }

    public AppiumDriverLocalService build() {
        return AppiumDriverLocalService.buildService(this.appiumServiceBuilder);
    }
}
