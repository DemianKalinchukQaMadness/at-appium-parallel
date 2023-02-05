package driver.manager;

import config.yml.android.AndroidDeviceConfig;
import config.yml.ios.IOSDeviceConfig;
import driver.capabilities.AndroidCapabilities;
import driver.capabilities.IOSCapabilities;
import io.appium.java_client.AppiumDriver;
import service.appium.AppiumServerManager;

public class AppiumDriverManager extends AppiumDriver {

    public AppiumDriverManager(IOSDeviceConfig config) {
        super(AppiumServerManager.getServerUrl(), new IOSCapabilities(config));
    }

    public AppiumDriverManager(AndroidDeviceConfig config) {
        super(AppiumServerManager.getServerUrl(), new AndroidCapabilities(config));
    }
}
