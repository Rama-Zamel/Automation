package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MorePage extends BasePage {

    private By MoreBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"More\")");
    private By RTAlocationsBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"RTA locations\")");

        public MorePage(AndroidDriver driver) {
            super(driver);

        }

    public void ClickMore() {
            click(MoreBtn);
            System.out.println("✓ More Button clicked");
            }


    public void ClickRTALocations() {
        click(RTAlocationsBtn);
        System.out.println("✓ RTA locations Button clicked");
    }
}
