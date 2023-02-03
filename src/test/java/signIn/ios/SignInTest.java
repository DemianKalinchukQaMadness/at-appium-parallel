package signIn.ios;

import base.BaseTest;
import driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTest extends BaseTest {

    @Test
    public void testLoginAndLogout() {
        System.out.println("from logout");
        System.out.println("test: " + Thread.currentThread().getId());
        var driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String input = "380967930959";

        driver.findElement(By.xpath("//XCUIElementTypeTextField")).clear();
        driver.findElement(By.xpath("//XCUIElementTypeTextField")).sendKeys(input);
        Assert.assertTrue(true);
    }

    @Test
    public void testLogin() {
        System.out.println("from login");
        System.out.println("test: " + Thread.currentThread().getId());

//        var driver = DriverManager.getDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        String input = "380967930000";
//        driver.findElement(By.xpath("//XCUIElementTypeTextField")).clear();
//        driver.findElement(By.xpath("//XCUIElementTypeTextField")).sendKeys(input);
//        driver.findElement(By.xpath("//XCUIElementTypeButton")).click();
//        Assert.assertTrue(true);
    }
}
