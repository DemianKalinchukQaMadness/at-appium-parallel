package base;

import config.ResourcesYaml;
import driver.SimpleDriverFactory;
import driver.manager.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import service.appium.AppiumServer;
import service.appium.AppiumServerManager;

public class BaseTest {

    @BeforeTest(alwaysRun = true)
    @Parameters(value = {"deviceId"})
    public void beforeTest(@Optional("ios_1") String deviceId) {

        AppiumServerManager.setService(new AppiumServer().build());
        AppiumServerManager.getService().start();

        SimpleDriverFactory.createDriverInstance(deviceId, new ResourcesYaml());
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        if (DriverManager.getDriver() != null)
            DriverManager.getDriver().quit();

        if (AppiumServerManager.getService().isRunning())
            AppiumServerManager.getService().stop();
    }
}
