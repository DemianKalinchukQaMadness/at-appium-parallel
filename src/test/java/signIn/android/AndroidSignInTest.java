package signIn.android;

import base.BaseTest;
import driver.manager.DriverManager;
import org.testng.annotations.Test;
import service.appium.AppiumServerManager;

public class AndroidSignInTest extends BaseTest {

    @Test
    public void testLoginAndLogout(){
        System.out.println("from testLoginAndLogout");
        System.out.println("test: " + Thread.currentThread().getId());
        System.out.println("appium: " + AppiumServerManager.getService().getUrl());
    }

    @Test
    public void testLogin() {
        System.out.println("from testLogin");
        System.out.println("test: " + Thread.currentThread().getId());
        System.out.println("appium: " + AppiumServerManager.getService().getUrl());
    }
}
