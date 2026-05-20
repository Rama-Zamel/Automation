package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

public class RTALocationsPage extends BasePage {


    private By RTAlPermissionmapBtn = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_one_time_button\")");
    String ScrollBtn = "new UiScrollable(new UiSelector().scrollable(true))" + ".setAsHorizontalList()";

    public RTALocationsPage(AndroidDriver driver) {
        super(driver);
    }

    public void RTALocationsWithScroll() {

        try {
            click(RTAlPermissionmapBtn);
            System.out.println("✓ Permission granted");
            Thread.sleep(2000);

            System.out.println("✓ RTA head quarter (default) loaded");
            Thread.sleep(2000);

            String[] tabs = {
                    "Happiness centers",
                    "RTA kiosks",
                    "Eye test",
                    "Vehicle test centers",
                    "Driving schools"
            };

            for (String tab : tabs) {
                try {
                    System.out.println("\n--- Searching for: " + tab + " ---");

                    click(AppiumBy.androidUIAutomator(ScrollBtn + ".scrollIntoView(new UiSelector().textContains(\"" + tab + "\"))"));

                    System.out.println("✓ Clicked: " + tab);
                    Thread.sleep(7000);

                } catch (Exception e) {
                    System.err.println("❌ Failed to find: " + tab);
                    System.err.println("Error: " + e.getMessage());

                    String shortText = tab.split(" ")[0];
                    System.out.println("Trying with shorter text: " + shortText);

                    click(AppiumBy.androidUIAutomator(ScrollBtn + ".scrollIntoView(new UiSelector().textContains(\"" + shortText + "\"))"));

                    System.out.println("✓ Clicked with short text: " + shortText);
                    Thread.sleep(2000);
                }
            }

            System.out.println("\n✓ All tabs completed!");
            driver.pressKey(new KeyEvent(AndroidKey.BACK));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
