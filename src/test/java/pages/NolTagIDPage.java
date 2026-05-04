package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class NolTagIDPage extends BasePage {

    private By noltagidBtn = By.xpath("//android.widget.EditText");
    private By cardinfoBtn = By.xpath("//android.widget.TextView[@text=\"Check card info\"]");
    private By emailaddressBtn = AppiumBy.androidUIAutomator("");
    private By selectamountBtn = By.xpath("//android.widget.TextView[@text=\"30\"]");
    private By topupBtn = AppiumBy.androidUIAutomator( "new UiSelector().textContains(\"Top\")");

    public NolTagIDPage(AndroidDriver driver) {
        super(driver);
    }

    public void nolTagID(String TagID) {
        sendKeys(noltagidBtn, TagID);
        System.out.println("NOL Tag ID entered");
    }

    public void cardInfo() {
        click(cardinfoBtn);
        System.out.println("Card info clicked");
    }

    public void selectAmount() {
        click(selectamountBtn);
        System.out.println("Amount clicked");
    }

    public void emailAddress(String EmailAddress) {
        sendKeys(emailaddressBtn, EmailAddress);
        System.out.println("Email address entered");
    }

    public void topUp() {
        click(topupBtn);
        System.out.println("Top Up clicked");
    }
}