package base;

import config.ResourcesYaml;
import driver.DriverFactory;
import driver.manager.DriverManager;
import org.testng.ITestResult;
import org.testng.annotations.*;
import service.appium.AppiumServer;
import service.appium.AppiumServerManager;

public class BaseTest {

    @BeforeTest(alwaysRun = true)
    @Parameters(value = {"deviceId"})
    public void beforeTest(@Optional("ios_1") String deviceId) {

        AppiumServerManager.setService(new AppiumServer().build());
        AppiumServerManager.getService().start();

        DriverFactory.createDriverInstance(deviceId, new ResourcesYaml());
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        if (DriverManager.getDriver() != null)
            DriverManager.getDriver().quit();

        if (AppiumServerManager.getService().isRunning())
            AppiumServerManager.getService().stop();
    }
}
