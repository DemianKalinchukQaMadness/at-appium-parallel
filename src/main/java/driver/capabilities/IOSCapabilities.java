package driver.capabilities;

import config.yml.ios.IOSDeviceConfig;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.appium.java_client.remote.IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS;
import static io.appium.java_client.remote.IOSMobileCapabilityType.WDA_LOCAL_PORT;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class IOSCapabilities extends DesiredCapabilities {

    public IOSCapabilities() {
        super();
    }

    public IOSCapabilities(IOSDeviceConfig config) {
        this();
        this.setCapability(AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        this.setCapability(PLATFORM_NAME, Platform.IOS);
        this.setCapability(PLATFORM_VERSION, config.getVersion());
        this.setCapability(DEVICE_NAME, config.getDeviceName());
        this.setCapability(UDID, config.getUdid());
        this.setCapability(APP, config.getAppPath());
        this.setCapability(AUTO_ACCEPT_ALERTS, true);
    }
}
