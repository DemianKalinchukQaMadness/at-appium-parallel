package base;

import appConfig.IOSApp;
import capabilities.IOSCapabilities;
import core.DriverManager;
import core.URLConfig;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.URL;

public class IOSBaseTest extends BaseTest {

//    @BeforeTest(alwaysRun = true)
    @Parameters({"platform", "udid", "deviceName", "wdaLocalPort", "appiumPort"})
    public void setup(@Optional("iOS 15.5") String platform,
                      @Optional("794A91D0-0C31-4549-BE16-BB9937DB5239") String udid,
                      @Optional("iPhone 11") String deviceName,
                      @Optional("8100") String wdaLocalPort,
                      @Optional("4723") String appiumPort) {

        URL url = new URLConfig().getAppiumURL(appiumPort);

        String[] platformInfo = platform.split(" ");

        IOSCapabilities capabilities = new IOSCapabilities(
                platformInfo[0],
                platformInfo[1],
                deviceName,
                udid,
                wdaLocalPort,
                new IOSApp().getAppPath());

        DriverManager.setDriver(new IOSDriver(url, capabilities.getCapabilities()));
    }
}
