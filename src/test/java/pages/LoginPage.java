package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Locators
    private By allowBtn = By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]");
    private By skipBtn = By.xpath("//android.widget.TextView[@text='Skip']");
    private By uaResidentBtn = By.xpath("//android.widget.TextView[@text='UAE Resident']");
    private By proceedBtn = By.xpath("//android.widget.TextView[@text='Proceed']");
    private By loginBtn = By.xpath("//android.widget.TextView[@text='Hello guest |Login']");
    private By usernameTxt = By.xpath("//android.widget.ScrollView//android.widget.EditText[1]");
    private By passwordTxt = By.xpath("//android.widget.ScrollView//android.widget.EditText[2]");
    private By loginButton = By.xpath("//android.widget.TextView[@text='Login']");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickAllowBtn() {
        click(allowBtn);
        System.out.println("Notification Do Not Allow clicked");
    }

    public void clickSkip() {
        click(skipBtn);
        System.out.println("Skip Button clicked");
    }

    public void selectUAEResident() {
        click(uaResidentBtn);
        System.out.println("UAEResident Button clicked");
    }

    public void clickProceed() {
        click(proceedBtn);
        System.out.println("Proceed Button clicked");
    }

    public void clickLogin() {
        click(loginBtn);
        System.out.println("Clicked on Hello guest | Login");
    }

    public void enterUsername(String username) {
        sendKeys(usernameTxt, username);
        System.out.println("Username entered");
    }

    public void enterPassword(String password) {
        sendKeys(passwordTxt, password);
        System.out.println("Password entered");
    }

    public void clickLoginButton() {
        click(loginButton);
        System.out.println("Login Button clicked");
    }
}