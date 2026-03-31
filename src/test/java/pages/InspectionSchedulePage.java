package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class InspectionSchedulePage extends BasePage {

    private By InspectionDateDropDown = AppiumBy.androidUIAutomator("new UiSelector().text(\"Please select\")");
    private By ChooseInspectionDateDropDown = By.xpath("//android.widget.TextView[@text=\"02-03-2026\"]");
    private By InspectionTimeDropDown = AppiumBy.androidUIAutomator("new UiSelector().text(\"Choose Time\")");
    private By ChooseInspectionTimeDropDown = By.xpath("//android.widget.TextView[@text=\"07:00 AM - 07:10 AM\"]");
    private By continueBtn = By.xpath("//android.widget.TextView[@text='Continue']");

    public InspectionSchedulePage(AndroidDriver driver) {
        super(driver);
    }

    public void inspectionDateDropDown() {
        click(InspectionDateDropDown );
        System.out.println("Please select Drop Down (Date) clicked");
    }

    public void chooseInspectionDateDropDown(String date) {
        click(ChooseInspectionDateDropDown);
        System.out.println("Inside chooseInspectionDateDropDown" + date);
    }

    public void inspectionTimeDropDown() {
        click(InspectionTimeDropDown);
        System.out.println("Please select Drop Down (Time) clicked");
    }

    public void chooseInspectionTimeDropDown(String time) {
        click(ChooseInspectionTimeDropDown);
        System.out.println("chooseInspectionTimeDropDown" + time );
    }

    public void clickContinue() {
        click(continueBtn);
        System.out.println("Continue Button clicked");
    }
}