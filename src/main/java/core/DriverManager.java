package core;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class DriverManager {

    private final static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public synchronized static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public synchronized static WebDriver getDriver() {
        return driver.get();
    }
}
