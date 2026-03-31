package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class DetailsPage extends BasePage {

    private By selectLanguageBtn = AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\"))" + ".scrollIntoView(new UiSelector().text(\"Select Language\").instance(1))");
    private By enLanguageBtn = By.xpath("//android.widget.TextView[@text='English']");
    private By continue2Btn = By.xpath("//android.widget.TextView[@text='Continue']");

    public DetailsPage(AndroidDriver driver) {
        super(driver);
    }

     public void clickSelectLanguage() {
        click(selectLanguageBtn);
        System.out.println("Select Language clicked + Scroll");
    }

    public void chooseEnglishLanguage() {
        click(enLanguageBtn);
        System.out.println("English Language selected");
    }

    public void clickContinue2() {
        click(continue2Btn);
        System.out.println("Continue2 Button clicked");
    }
}