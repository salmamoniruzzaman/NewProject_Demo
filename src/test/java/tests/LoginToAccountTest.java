package tests;

import common.LoginToAccount;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BrowserTest;

import java.io.IOException;

public class LoginToAccountTest extends BrowserTest {
    LoginToAccount lg;

    @Test
    public void verifyLoginTest() throws InterruptedException, IOException {
        lg = new LoginToAccount(driver);
        lg.verifySelectMyAccount();
        Thread.sleep(3000);
        lg.verifyLogin();
        Thread.sleep(3000);
        String actualText = lg.verifyLoginErrorMessage();
        Assert.assertEquals(actualText, "Warning: No match for E-Mail Address and/or Password.");
        System.out.println("This is practice test");

    }
    @Test
    public void verifyLoginTest1() throws InterruptedException, IOException {
        lg = new LoginToAccount(driver);
        lg.verifySelectMyAccount();
        Thread.sleep(3000);
        lg.verifyLogin();
        Thread.sleep(3000);
        String actualText = lg.verifyLoginErrorMessage();
        Assert.assertEquals(actualText, "Warning: No match for E-Mail Address and/or Password.");
        System.out.println("This is practice test");

    }

}
