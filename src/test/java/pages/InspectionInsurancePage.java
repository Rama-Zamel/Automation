package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class InspectionInsurancePage extends BasePage {

    private By ProceedBtn = By.xpath("");

    public InspectionInsurancePage(AndroidDriver driver) {
        super(driver);
    }

    public void clickProceed() {
        click(ProceedBtn);
        System.out.println("Proceed Button clicked,Inspection & Insurance Done");
    }
}


