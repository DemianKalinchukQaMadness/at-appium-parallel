package core;

import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.URL;

public class AppiumServerManager {

    private static ThreadLocal<AppiumDriverLocalService> service = new ThreadLocal<>();

    public static AppiumDriverLocalService getService() {
        return service.get();
    }

    public static void setService(AppiumDriverLocalService appiumDriverLocalService) {
        service.set(appiumDriverLocalService);
    }

    public static URL getServerUrl() {
        return getService().getUrl();
    }
}
