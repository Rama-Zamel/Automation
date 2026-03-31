package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ConfirmationPage extends BasePage {

    private By doneBtn = By.xpath("//android.widget.TextView[@text='Done']");

    public ConfirmationPage(AndroidDriver driver) {
        super(driver);
    }

   public void clickDone() {
        click(doneBtn);
        System.out.println("Done Button clicked");
    }
}