package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;

import screens.FindCarScreen;
import screens.SplashScreen;

public class LoginTest extends AppiumConfig {
    @BeforeClass
    public void preCondition(){

        new FindCarScreen(driver).login();
    }

    @Test
    public void loginSuccess() {
//        boolean result = new SplashScreen(driver)
//                .checkCurrentVersion("Version 1.0.0")
        boolean result = new AuthenticationScreen(driver)
                .fillEmail("niln@gmail.com")
                .fillPassword("Nn12345$")
                .submitLogin()
                .isActivityTitleDisplayed("Find your car now!");
        Assert.assertTrue(result);
    }
//    @Test
//    public void loginSuccessModel() {
//        boolean result = new AuthenticationScreen(driver)
//                .fillLoginForm(Auth.builder().email("niln@gmail.com")
//                        .password("MNn12345$").build()).submitLogin()
//                .isActivityTitleDisplayed("Find your car now!");
//        Assert.assertTrue(result);
//    }
//
//    @Test
//    public void loginSuccessModel2() {
//        Assert.assertTrue(new AuthenticationScreen(driver)
//                .fillLoginForm(Auth.builder().email("niln@gmail.com")
//                        .password("Nn12345$").build()).submitLogin()
//                .isActivityTitleDisplayed("Find your car now!"));
//    }
//    @Test
//    public void loginWrongEmail(){
//        new AuthenticationScreen(driver).fillLoginForm(Auth.builder()
//                        .email("nilngmail.com").password("Nn12345$").build())
//                .submitLoginNegative().isErrorMessageContainsText("Find your car now!");
//    }
    @AfterMethod
    public void posCondition() {
        new FindCarScreen(driver).logout();

    }
}
