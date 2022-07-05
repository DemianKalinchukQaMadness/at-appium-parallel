package signIn.android;

import base.AndroidBaseTest;
import org.testng.annotations.Test;

public class SignInTest extends AndroidBaseTest {

    @Test
    public void testLoginAndLogout() {
        System.out.println("from logout");
        System.out.println("test: " + Thread.currentThread().getId());
    }

    @Test
    public void testLogin() {
        System.out.println("from login");
        System.out.println("test: " + Thread.currentThread().getId());
    }
}
