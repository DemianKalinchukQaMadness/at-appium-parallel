/*
 * MIT License
 *
 * Copyright (c) 2018 Elias Nogueira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package driver.manager;

import com.google.common.io.Resources;
import core.AppiumServerManager;
import driver.IDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.*;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class AndroidDriverManager implements IDriver {

    private AppiumDriver<MobileElement> driver;

    @Override
    public AppiumDriver<MobileElement> createInstance(Properties props) {
//        try {

            DesiredCapabilities caps = new DesiredCapabilities();
            String appPath = Resources.getResource("apps/"+props.getProperty("appName")).getPath();

            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, props.getProperty("platformVersion"));
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("deviceName"));
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, props.getProperty("newCommandTimeout"));
            caps.setCapability(MobileCapabilityType.APP, appPath);
            caps.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, props.getProperty("systemPort"));

            caps.setCapability(AndroidMobileCapabilityType.AVD, props.getProperty("avd"));
            caps.setCapability(AndroidMobileCapabilityType.ADB_EXEC_TIMEOUT, props.getProperty("adbExecTimeout"));
            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, props.getProperty("appPackage"));
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, props.getProperty("appActivity"));

            driver = new AndroidDriver<>(AppiumServerManager.getServerUrl(), caps);
//        } catch (Exception e) {
//            System.out.println("Failed to initiate the tests for the Android device");
//        }
        return driver;
    }
}
