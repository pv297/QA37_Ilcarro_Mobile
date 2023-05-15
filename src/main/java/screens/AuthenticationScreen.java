package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.Auth;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AuthenticationScreen extends BaseScreen {
    public AuthenticationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id = 'com.telran.ilcarro:id/editLoginEmail']")
    AndroidElement emailEditText;

    @FindBy(id = "com.telran.ilcarro:id/editLoginPassword")
    AndroidElement passwordEditText;

    @FindBy(xpath = "//*[@resource-id ='com.telran.ilcarro:id/loginBtn']")
    AndroidElement yButton;

    public AuthenticationScreen fillEmail(String email) {
        //pause(4000);
        should(emailEditText, 2);
        type(emailEditText, email);
        return this;
    }

    public AuthenticationScreen fillLoginForm(Auth auth) {
        should(emailEditText, 20);
        type(emailEditText, auth.getEmail());
        type(passwordEditText, auth.getPassword());

        return this;
    }

    public AuthenticationScreen fillPassword(String password) {
        should(passwordEditText, 20);
        type(passwordEditText, password);
        return this;
    }

    public FindCarScreen submitLogin() {

        yButton.click();
        return new FindCarScreen(driver);
    }

    public AuthenticationScreen submitLoginNegative() {
        yButton.click();
        return this;
    }

    public AuthenticationScreen isErrorMessageContainsText(String text) {
        Alert alert = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(text));
        alert.accept();

        return this;
    }
}

