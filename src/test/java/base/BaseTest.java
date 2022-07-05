package base;

import com.google.common.io.Resources;
import core.AppFactory;
import core.AppiumServer;
import core.DriverManager;
import org.openqa.selenium.Platform;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseTest {

    @BeforeTest(alwaysRun = true)
    @Parameters(value = {"platform", "properties"})
    public void beforeSuite(String platform,
                            String properties) throws IOException {
        String propertiesFilePath = Resources.getResource(properties).getPath();
        Properties appProperties = new Properties();
        appProperties.load(Files.newInputStream(Paths.get(propertiesFilePath)));

        AppiumServer appiumServer = new AppiumServer();
        appiumServer.startServer(Integer.parseInt(appProperties.getProperty("appiumPort")));

        if (Platform.ANDROID.name().equalsIgnoreCase(platform)) {
            AppFactory.androidLaunch(appProperties, appiumServer.getService());
        } else {
            AppFactory.iosLaunch(appProperties, appiumServer.getService());
        }
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }
}
