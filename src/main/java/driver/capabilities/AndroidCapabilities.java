package driver.capabilities;

import config.yml.android.AndroidDeviceConfig;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.AVD;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.SYSTEM_PORT;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class AndroidCapabilities extends DesiredCapabilities {

    public AndroidCapabilities() {
        super();
    }

    public AndroidCapabilities(AndroidDeviceConfig config) {
        this();
        this.setCapability(PLATFORM_NAME, Platform.ANDROID);
        this.setCapability(PLATFORM_VERSION, config.getVersion());
        this.setCapability(AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        this.setCapability(DEVICE_NAME, config.getDeviceName());
        this.setCapability(APP, config.getAppPath());
        this.setCapability(SYSTEM_PORT, config.getDevicePort());
        this.setCapability(AVD, config.getDeviceName());
    }
}
