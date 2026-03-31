package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class VehicleSelectionPage extends BasePage {

    private By registeredVehicleBtn = By.xpath("//android.widget.TextView[@text='4038']");
    private By continueBtn = By.xpath("//android.widget.TextView[@text='Continue']");

    public VehicleSelectionPage(AndroidDriver driver) {
        super(driver);
    }

    public void selectRegisteredVehicle() {
        click(registeredVehicleBtn);
        System.out.println("Registered Vehicle 9555 clicked");
    }

    public void clickContinue() {
        click(continueBtn);
        System.out.println("Continue Button clicked");
    }
}

// final or private what is deffer-net between this?


