package signIn.android;

import base.BaseTest;
import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

public class SignInTest extends BaseTest {

    @Test
    public void testLoginAndLogout() throws InterruptedException {
        var driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("from logout");
        String input = "380967930959";

        driver.findElement(By.id("et_phone_number")).sendKeys(input);
        Assert.assertTrue(true);
        System.out.println("test: " + Thread.currentThread().getId());
    }

    @Test
    public void testLogin() {
        System.out.println("from login");
        System.out.println("test: " + Thread.currentThread().getId());
    }
}
