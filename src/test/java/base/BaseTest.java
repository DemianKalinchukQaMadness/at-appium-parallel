package base;

import core.DriverManager;
import org.testng.annotations.AfterTest;

public class BaseTest {

    @AfterTest(alwaysRun = true)
    public void teardown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }
}
