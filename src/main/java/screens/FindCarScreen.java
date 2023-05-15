package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class FindCarScreen extends BaseScreen{
    public FindCarScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/findTitle']")
    AndroidElement activityTextView;
    @FindBy(xpath = "//*[@content-desc='More options']")
    AndroidElement menuOptions;
    @FindBy(xpath = "//*[@text='Login']")
    AndroidElement loginButton;
    @FindBy(xpath = "//*[@text='Logout']")
    AndroidElement logoutButton;

    public boolean isActivityTitleDisplayed(String text){
        // return activityTextView.getText().contains("Contact List");
        return isShouldHave(activityTextView,text,8);
    }
    public AuthenticationScreen logout(){
        menuOptions.click();
        logoutButton.click();
        return new AuthenticationScreen(driver);
    }
    public AuthenticationScreen login(){
        should(activityTextView,15);
        menuOptions.click();
        loginButton.click();
        return new AuthenticationScreen(driver);
    }
}
