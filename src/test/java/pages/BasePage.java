package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    // attributes //
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    // constructor //
    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // method //
    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();          // لتفعيل focus
        element.clear();          // لتنظيف أي نص موجود
        element.sendKeys(text);   // أدخل النص
        // أو ممكن تجرب setValue لو sendKeys ما اشتغل:
        // ((AndroidElement) element).setValue(text);
    }

    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}


// //  صفحه الميثودات الاساسيه لل ايليمنت ل تنفيد الاكشن
