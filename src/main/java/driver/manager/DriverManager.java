package driver.manager;

import lombok.Getter;

@Getter
public class DriverManager {

    private final static ThreadLocal<AppiumDriverManager> webDriver = new ThreadLocal<>();

    public static void setDriver(AppiumDriverManager driver) {
        webDriver.set(driver);
    }

    public static AppiumDriverManager getDriver() {
        return webDriver.get();
    }
}
