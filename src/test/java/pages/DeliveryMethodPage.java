package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class DeliveryMethodPage extends BasePage {

    private By KioskBtn = By.xpath("");
    private By CenterBtn = By.xpath("");
    private By continue3Btn = By.xpath("");

    public DeliveryMethodPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickKiosk() {
        click(KioskBtn);
        System.out.println("Kiosk Button clicked");
    }

    public void clickCenter() {
        click(CenterBtn);
        System.out.println("Center Button clicked");
    }

    public void clickContinue3() {
        click(continue3Btn);
        System.out.println("Continue3 Button clicked");
    }
}