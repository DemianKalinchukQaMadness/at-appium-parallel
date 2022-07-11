package base;

import driver.DriverFactory;
import driver.manager.DriverManager;
import org.testng.ITestResult;
import org.testng.annotations.*;
import service.AppiumServer;
import service.AppiumServerManager;

public class BaseTest extends BaseSuite {

    @BeforeTest(alwaysRun = true)
    @Parameters(value = {"deviceId"})
    public void beforeTest(@Optional("ios_1") String deviceId) {
        new AppiumServer();
        DriverFactory.createInstance(deviceId, resourcesYaml);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        DriverManager.getDriver().resetApp();
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            AppiumServerManager.getService().stop();
        }
    }
}
