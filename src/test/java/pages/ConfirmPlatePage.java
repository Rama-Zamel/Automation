package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

   public class ConfirmPlatePage extends BasePage {

        private By ProceedBtn1 = By.xpath("");

        public ConfirmPlatePage(AndroidDriver driver) {
            super(driver);
        }

        public void clickProceed() {
            click(ProceedBtn1);
            System.out.println("Proceed Button clicked,Confirm Plate");
        }
    }
