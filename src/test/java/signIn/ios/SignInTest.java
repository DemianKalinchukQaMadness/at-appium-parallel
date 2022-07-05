package signIn.ios;

import base.IOSBaseTest;
import org.testng.annotations.Test;

public class SignInTest extends IOSBaseTest {

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
