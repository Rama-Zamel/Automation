package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class RechargeSalikPage extends BasePage {

    private By MobileNumberBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");
    private By CountryBtn = By.xpath("//android.widget.TextView[@text=\"Please select\"]");
    private By SelectCountry = AppiumBy.androidUIAutomator("new UiSelector().text(\"United Arab Emirates\")");


    private By EmirateBtn = By.xpath("//android.widget.TextView[@text=\"eg:Dubai/Sharjah/Ajman\"]");
    private By SelectyourEmirate = AppiumBy.androidUIAutomator("new UiSelector().text(\"Dubai\")");

    private By CategoryBtn = By.xpath("//android.widget.TextView[@text=\"Select category\"]");
    private By SelectCategory = AppiumBy.androidUIAutomator("new UiSelector().text(\"Private\")");

    private By PlateCodeBtn = By.xpath("//android.widget.TextView[@text=\"eg:A, B, K, L\"]");
    String scroll1 = "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()";
    private By SelectPlate = AppiumBy.androidUIAutomator("new UiSelector().text(\"J\")");

    private By MobileNumber2Btn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");
    private By selectamount1Btn = AppiumBy.androidUIAutomator("new UiSelector().text(\"50\")");
    private By RechargeNowBtn = AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Recharge now\")");

    public RechargeSalikPage(AndroidDriver driver) {
        super(driver);
    }

    public void ClickMobileNumber(String mobileNumber) {
        sendKeys(MobileNumberBtn ,  mobileNumber);
        System.out.println("✓ Mobile Number entered");
    }

    public void ClickCountry() {
        click(CountryBtn);
        System.out.println("Please select your country clicked");
    }

    public void SelectCountryDropDown(String country) {
        click(SelectCountry);
        System.out.println("Inside chooseCountryDropDown" + country);
    }

    public void ClickEmirate() {
        click(EmirateBtn);
        System.out.println("Please select your Emirate clicked");
    }

    public void SelectEmirateDropDown(String emirate) {
        click(SelectyourEmirate);
        System.out.println("Inside chooseEmirateDropDown" + emirate);
    }

    public void ClickCategory() {
        click(CategoryBtn);
        System.out.println("Please select your Category clicked");
    }

    public void SelectCategoryDropDown(String category) {
        click(SelectCategory);
        System.out.println("Inside chooseCategoryDropDown" + category);
    }

    public void ClickPlateCode() {
        click(PlateCodeBtn);
        System.out.println("Please select your Plate code clicked");
    }

    public void SelectPlateDropDown(String plateCode) {
        driver.findElement(AppiumBy.androidUIAutomator(scroll1));
        click(SelectPlate);
        System.out.println("Inside choosePlateCodeDropDown" + plateCode);
    }

    public void ClickPlateNumber(String plateNumber) {
        driver.findElement(AppiumBy.androidUIAutomator(scroll1));
        sendKeys(MobileNumber2Btn , plateNumber);
        driver.hideKeyboard();
        System.out.println("Plate number Entered" + plateNumber);
    }

    public void SelectAmount() {
        click(selectamount1Btn);
        System.out.println("Amount clicked");
    }

    public void RechargeNow() {
        click(RechargeNowBtn);
        System.out.println("Recharge Now Button clicked");
    }
}