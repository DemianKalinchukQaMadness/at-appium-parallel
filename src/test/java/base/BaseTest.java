package base;

import config.ResourcesYaml;
import driver.DriverFactory;
import driver.manager.DriverManager;
import org.testng.ITestResult;
import org.testng.annotations.*;
import service.AppiumServer;
import service.AppiumServerManager;

public class BaseTest {

    @BeforeTest(alwaysRun = true)
    @Parameters(value = {"deviceId"})
    public void beforeTest(@Optional("ios_1") String deviceId) {

        AppiumServerManager.setService(new AppiumServer().build());
        AppiumServerManager.getService().start();

        DriverFactory.createDriverInstance(deviceId, new ResourcesYaml());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        DriverManager.getDriver().resetApp();
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        if (DriverManager.getDriver() != null)
            DriverManager.getDriver().quit();

        if (AppiumServerManager.getService().isRunning())
            AppiumServerManager.getService().stop();
    }
}
