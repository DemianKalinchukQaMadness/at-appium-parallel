package signIn.android;

import base.BaseTest;
import core.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTest2 extends BaseTest {

    @Test
    public void testLoginAndLogout() throws InterruptedException {
        var driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("from logout");
        String input = "380999999999";

        for (int i = 0; i < input.length(); i++) {
            driver.findElement(By.id("et_phone_number")).sendKeys(String.valueOf(input.charAt(i)));
        }

        //driver.findElement(By.id("et_phone_number")).sendKeys(input);
        driver.findElement(By.id("b_next")).click();
        Assert.assertTrue(true);
        System.out.println("test: " + Thread.currentThread().getId());
    }

    @Test
    public void testLogin() {
        System.out.println("from login");
        System.out.println("test: " + Thread.currentThread().getId());
    }
}
