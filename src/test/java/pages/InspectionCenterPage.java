package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class InspectionCenterPage extends BasePage {

    private By SearchInspectionCenter = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");
    private By SelectInspectionCenter = By.xpath("//android.widget.TextView[@text=\"Wasel Al Jaddaf\"]");

    public InspectionCenterPage(AndroidDriver driver) {
        super(driver);
    }

    public void searchInspectionCenter(String inspectioncenter) {
        sendKeys(SearchInspectionCenter, inspectioncenter);
        System.out.println("search inspection center");
    }

    public void selectInspectionCenter() {
        click(SelectInspectionCenter);
        System.out.println("Inside selectInspectionCenter");
    }
}