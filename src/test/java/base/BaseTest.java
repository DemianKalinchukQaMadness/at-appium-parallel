package base;

import config.ResourcesConfig;
import service.AppiumServer;
import service.AppiumServerManager;
import driver.manager.DriverManager;
import driver.DriverFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
    protected AppiumServer appiumServer = null;
    @BeforeTest(alwaysRun = true)
    @Parameters(value = {"platform", "properties"})
    public void beforeSuite(@Optional("ios") String platform, @Optional("iPhone_11.properties") String properties) {
        appiumServer = new AppiumServer();

        System.out.println("Appium server started " + appiumServer.getServerUrl());
        System.out.println(platform);
        System.out.println(properties);

        ResourcesConfig resourcesConfig = new ResourcesConfig(properties, platform);
        DriverFactory.createInstance(platform,resourcesConfig);
        System.out.println("Driver created");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        DriverManager.getDriver().resetApp();
        System.out.println("App reset!");
    }


    @AfterTest(alwaysRun = true)
    public void teardown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            AppiumServerManager.getService().stop();
            System.out.println("Appium server stopped!");
        }
    }
}
