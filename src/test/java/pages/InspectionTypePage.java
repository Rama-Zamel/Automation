package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class InspectionTypePage extends BasePage {

    private By ServiceTypeInstDropDown = AppiumBy.androidUIAutomator("new UiSelector().text(\"Please select\")");
    private By ChooseServiceTypeInstDropDown = By.xpath("//android.widget.TextView[@text=\"Registration Test\"]");
    private By continueBtn = By.xpath("//android.widget.TextView[@text='Continue']");

    public InspectionTypePage(AndroidDriver driver) {
        super(driver);
    }

    public void serviceTypeInstDropDown() {
        click(ServiceTypeInstDropDown);
        System.out.println("Please select Drop Down (Type Inspection) clicked");
    }

    public void chooseServiceTypeInstDropDown(String serviceType) {
        click(ChooseServiceTypeInstDropDown);
        System.out.println("Inside chooseServiceTypeInstDropDown" + serviceType);
    }

    public void clickContinue() {
        click(continueBtn);
        System.out.println("Continue Button clicked");
    }

}

