package service.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.time.Instant;
import java.util.HashMap;

public class AppiumServer {

    private final AppiumServiceBuilder appiumServiceBuilder;

    public AppiumServer() {
        HashMap<String, String> environment = new HashMap<>();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH")); //path to carthage bin folder

        this.appiumServiceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .usingAnyFreePort()
                .withEnvironment(environment)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error:debug") //log level for appium
                .withLogFile(new File("AppiumLog_" + Instant.now().toEpochMilli() + ".txt"));
    }

    public AppiumDriverLocalService build() {
        return AppiumDriverLocalService.buildService(this.appiumServiceBuilder);
    }
}
