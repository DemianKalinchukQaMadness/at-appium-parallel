package core;

import capabilities.AndroidCapabilities;
import capabilities.IOSCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.util.Properties;

public class AppFactory {

    private static final String LOCAL_PORT = "localPort";
    private static final String ARTIFACT_PATH = "artifactPath";

    public static void androidLaunch(Properties properties,
                                     AppiumServer appiumServer) {
        AndroidCapabilities capabilities = new AndroidCapabilities(
                properties.getProperty(MobileCapabilityType.PLATFORM_VERSION),
                properties.getProperty(MobileCapabilityType.DEVICE_NAME),
                properties.getProperty(LOCAL_PORT),
                properties.getProperty(ARTIFACT_PATH));

        DriverManager.setDriver(
                new AndroidDriver<>(
                        appiumServer.getServerUrl(),
                        capabilities.getCapabilities()));
    }

    public static void iosLaunch(Properties properties,
                                 AppiumServer appiumServer) {
        IOSCapabilities capabilities = new IOSCapabilities(
                properties.getProperty(MobileCapabilityType.PLATFORM_NAME),
                properties.getProperty(MobileCapabilityType.PLATFORM_VERSION),
                properties.getProperty(MobileCapabilityType.DEVICE_NAME),
                properties.getProperty(MobileCapabilityType.UDID),
                properties.getProperty(LOCAL_PORT),
                properties.getProperty(ARTIFACT_PATH));

        DriverManager.setDriver(
                new IOSDriver<>(
                        appiumServer.getServerUrl(),
                        capabilities.getCapabilities()));
    }
}
