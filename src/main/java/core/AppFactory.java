package core;

import capabilities.AndroidCapabilities;
import capabilities.IOSCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.util.Properties;

public class AppFactory {

    public static void androidLaunch(Properties properties,
                                     AppiumDriverLocalService appiumService) {
        AndroidCapabilities capabilities = new AndroidCapabilities(
                properties.getProperty("platformVersion"),
                properties.getProperty("deviceName"),
                properties.getProperty("localPort"),
                properties.getProperty("apkPath"));

        DriverManager.setDriver(
                new AndroidDriver<>(
                        appiumService.getUrl(),
                        capabilities.getCapabilities()));
    }

    public static void iosLaunch(Properties properties,
                                 AppiumDriverLocalService appiumService) {
        IOSCapabilities capabilities = new IOSCapabilities(
                properties.getProperty("platformName"),
                properties.getProperty("platformVersion"),
                properties.getProperty("deviceName"),
                properties.getProperty("udid"),
                properties.getProperty("localPort"),
                properties.getProperty("appPath"));

        DriverManager.setDriver(
                new IOSDriver<>(
                        appiumService.getUrl(),
                        capabilities.getCapabilities()));
    }
}
