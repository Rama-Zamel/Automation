package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage {

    private By termsCheckbox = By.xpath("//android.widget.CheckBox");
    private By paySummary = By.xpath("//android.widget.TextView[@text='Pay']");
    private By payMethod = By.xpath("//android.widget.TextView[@text='Pay']");
    private By sMethodBtn = By.xpath("//android.widget.Button[@resource-id='btnPay']");
    private By ibanTxt = By.xpath("//android.widget.EditText[@resource-id='txtCardNo']");
    private By monthTxt = By.xpath("//android.widget.EditText[@resource-id='ddlMonth']");
    private By yearTxt = By.xpath("//android.widget.EditText[@resource-id='ddlYear']");
    private By cvvTxt = By.xpath("//android.widget.EditText[@resource-id='txtCvvNo']");
    private By payConfirmBtn = By.xpath("//android.widget.Button[@resource-id='payButton']");

    public PaymentPage(AndroidDriver driver) {
        super(driver);
    }

    public void acceptTerms() {
        click(termsCheckbox);
        System.out.println("Terms & Conditions accepted");
    }

    public void clickPaySummary() {
        click(paySummary);
        System.out.println("Pay Button clicked From Payment Summary");
    }

    public void clickPayMethod() {
        click(payMethod);
        System.out.println("Pay Button clicked From Payment Methods");
    }

    public void selectMethod() {
        click(sMethodBtn);
        System.out.println("Select Method Button clicked");
    }

    public void enterCardDetails(String iban, String month, String year, String cvv) {
        sendKeys(ibanTxt, iban);
        sendKeys(monthTxt, month);
        sendKeys(yearTxt, year);
        sendKeys(cvvTxt, cvv);
        System.out.println("Card details entered");
    }

    public void confirmPay() {
        click(payConfirmBtn);
        System.out.println("Pay3 Button clicked");
    }
}