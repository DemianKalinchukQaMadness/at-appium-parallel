package base;

import appConfig.AndroidApk;
import capabilities.AndroidCapabilities;
import core.DriverManager;
import core.URLConfig;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.URL;

public class AndroidBaseTest extends BaseTest {

//    @BeforeTest(alwaysRun = true)
    @Parameters({"platform", "systemPort", "deviceName"})
    public void setup(String platform,
                      String systemPort,
                      String deviceName) {

        URL url = new URLConfig().getAppiumURL();
        String platformInfo = platform.split(" ")[1];

        AndroidCapabilities capabilities = new AndroidCapabilities(
                platformInfo,
                deviceName,
                systemPort,
                new AndroidApk().getApkPath());

        DriverManager.setDriver(new AndroidDriver(url, capabilities.getCapabilities()));
    }
}
