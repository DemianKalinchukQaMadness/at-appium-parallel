package core;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

@NoArgsConstructor
public class URLConfig implements Serializable {

    private final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    public URL getAppiumURL() {
        try {
            return new URL(APPIUM_URL);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public URL getAppiumURL(String port) {
        try {
            return new URL("http://127.0.0.1:" + port + "/wd/hub");
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }

        return null;
    }
}
