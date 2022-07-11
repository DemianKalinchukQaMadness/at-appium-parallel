/*
 * MIT License
 *
 * Copyright (c) 2018 Elias Nogueira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package driver;

import config.ResourcesYaml;
import driver.manager.AndroidDriverManager;
import driver.manager.DriverManager;
import driver.manager.IOSDriverManager;

import java.util.Properties;

import static driver.Platform.ANDROID;
import static driver.Platform.IOS;

public class DriverFactory {
    public static void createInstance(String platform, Properties props) {
        Platform mobilePlatform = Platform.valueOf(platform.toUpperCase());

        switch (mobilePlatform) {
            case IOS:
                DriverManager.setDriver(new IOSDriverManager().createInstance(props));
                break;

            case ANDROID:
                DriverManager.setDriver(new AndroidDriverManager().createInstance(props));
                break;

            default:
                throw new IllegalStateException(
                    "Platform not supported! Check if you set ios or android on the parameter.");
        }
    }

    public static void createInstance(String platform,
                                      String deviceId,
                                      ResourcesYaml resourcesYaml) {
        switch (Platform.valueOf(platform.toUpperCase())) {
            case IOS:
                DriverManager.setDriver(
                        new IOSDriverManager()
                                .createInstance(deviceId, resourcesYaml.getIosConfig()));
                break;

            case ANDROID:
                DriverManager.setDriver(
                        new AndroidDriverManager()
                                .createInstance(deviceId, resourcesYaml.getAndroidConfig()));
                break;

            default:
                throw new IllegalStateException(
                    "Platform not supported! Check if you set ios or android on the parameter.");
        }
    }
}
