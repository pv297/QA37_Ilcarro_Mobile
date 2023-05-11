package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class SplashScreen extends BaseScreen{
    public SplashScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/versionText']")
    AndroidElement versionTextView;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/imageView3']")
    AndroidElement titleTextView;

    public String getCurrentVersion(){
        return versionTextView.getText();
    }
}
