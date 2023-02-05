package driver;

import config.ResourcesYaml;
import driver.manager.DriverManager;
import driver.manager.AppiumDriverManager;

public class SimpleDriverFactory {

    public static void createDriverInstance(String deviceId,
                                            ResourcesYaml resourcesYaml) {
        if (deviceId.contains("ios"))
            DriverManager.setDriver(new AppiumDriverManager(resourcesYaml.getIosConfig().getDeviceById(deviceId)));
        else
            DriverManager.setDriver(new AppiumDriverManager(resourcesYaml.getAndroidConfig().getDeviceById(deviceId)));
    }
}