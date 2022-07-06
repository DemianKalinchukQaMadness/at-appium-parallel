package base;

import appConfig.Platform;
import appConfig.ResourcesConfig;
import core.AppFactory;
import core.AppiumServer;
import core.AppiumServerManager;
import core.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeTest(alwaysRun = true)
    @Parameters(value = {"platform", "properties"})
    public void beforeSuite(String platform,
                            String properties) {
        ResourcesConfig resourcesConfig = new ResourcesConfig(properties, platform);

        if (Platform.isAndroid(platform)) {
            AppFactory.androidLaunch(resourcesConfig, new AppiumServer());

        } else {
            AppFactory.iosLaunch(resourcesConfig, new AppiumServer());
        }
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            AppiumServerManager.getService().stop();
        }
    }
}
