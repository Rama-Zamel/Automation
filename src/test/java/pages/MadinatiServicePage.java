package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class MadinatiServicePage extends BasePage{

    private By MadinatiBtn = AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Madinati\")");
    private By ReportsuggestBtn = AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().textContains(\"Report / Suggest\"))");
    private By MadinatiPermissionmapBtn = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\")");
    private By MadinatimapBtn = AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"Select location on map\"))");
    private By ConfirmmapBtn = AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Confirm\")");


    public MadinatiServicePage(AndroidDriver driver) {
        super(driver);
    }

    public void swipeLeft() {
        Dimension size = driver.manage().window().getSize();

        int startX = (int)(size.width * 0.85);
        int endX = (int)(size.width * 0.15);
        int y = (int)(size.height * 0.80);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), startX, y));

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(200),
                PointerInput.Origin.viewport(), endX, y));

        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }

    public void madinatiService() {

        scrollToReportSuggestSection();

        for (int i = 0; i < 6; i++) {
            try {
                System.out.println("Found Madinati on swipe #" + (i + 1));
                click(MadinatiBtn);
                return;

            } catch (Exception e) {
                System.out.println("Swipe #" + (i + 1) + " - Madinati not found yet");
                swipeLeft();

                try {
                    Thread.sleep(800); // انتظر بعد كل swipe
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }

        throw new RuntimeException("Madinati not found after 6 swipes");
    }

    private void scrollToReportSuggestSection() {
        try {
            driver.findElement(ReportsuggestBtn);
            System.out.println("Scrolled to Report / Suggest section");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("Report / Suggest section already visible");
        }
    }

    public void MadinatiMap() {

        click(MadinatiPermissionmapBtn);
        System.out.println("Madinati Permission Button clicked");

        click(MadinatimapBtn);
        System.out.println("Madinati Map Button clicked");

        try {
            Thread.sleep(17000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        click(ConfirmmapBtn);
        System.out.println("Confirm Map Button clicked");
    }
    }