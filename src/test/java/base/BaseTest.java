package base;

import appConfig.Platform;
import appConfig.ResourcesConfig;
import core.AppFactory;
import core.AppiumServer;
import core.AppiumServerManager;
import core.DriverManager;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected AppiumServer appiumServer = null;
    @BeforeTest(alwaysRun = true)
    @Parameters(value = {"platform", "properties"})
    public void beforeSuite(@Optional("ios") String platform, @Optional("iPhone_11.properties") String properties) {

        appiumServer = new AppiumServer();
        System.out.println(platform);
        System.out.println(properties);
        ResourcesConfig resourcesConfig = new ResourcesConfig(properties, platform);
        DriverFactory.createInstance(platform,resourcesConfig);
    }
    @AfterTest(alwaysRun = true)
    public void teardown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            AppiumServerManager.getService().stop();
        }
    }
}
