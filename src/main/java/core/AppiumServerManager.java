package core;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumServerManager {

    private static ThreadLocal<AppiumDriverLocalService> service = new ThreadLocal<>();

    public static AppiumDriverLocalService getService() {
        return service.get();
    }

    public static void setService(AppiumDriverLocalService appiumDriverLocalService) {
        service.set(appiumDriverLocalService);
    }
}
