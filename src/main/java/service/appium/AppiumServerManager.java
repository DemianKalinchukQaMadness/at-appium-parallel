package service.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.URL;

public class AppiumServerManager {

    private static ThreadLocal<AppiumDriverLocalService> service = new ThreadLocal<>();

    public synchronized static AppiumDriverLocalService getService() {
        return service.get();
    }

    public synchronized static void setService(AppiumDriverLocalService appiumDriverLocalService) {
        service.set(appiumDriverLocalService);
    }

    public synchronized static URL getServerUrl() {
        return getService().getUrl();
    }
}
