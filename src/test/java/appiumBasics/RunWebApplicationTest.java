package appiumBasics;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.net.URL;
import java.util.Set;

public class RunWebApplicationTest {

    private AndroidDriver driver;
    private LoginPage loginPage;
    private ServicesPage servicesPage;
    private PaymentPage paymentPage;
    private VehicleSelectionPage vehicleSelectionPage;
    private InspectionTypePage inspectionTypePage;
    private InspectionCenterPage inspectionCenterPage;
    private InspectionSchedulePage inspectionSchedulePage;
    private DetailsPage detailsPage;
    private ConfirmationPage confirmationPage;

    @BeforeClass
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("R58Y504S1HP")
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.rta.rtadubai")
                .setAppActivity("com.rta.rtadubai.MainActivity")
                .setEnsureWebviewsHavePages(true)
                .setNoReset(true)
                .setFullReset(false);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        Set<String> contexts = driver.getContextHandles();
        System.out.println("Contexts: " + contexts);

        loginPage = new LoginPage(driver);
        servicesPage = new ServicesPage(driver);
        paymentPage = new PaymentPage(driver);
        vehicleSelectionPage = new VehicleSelectionPage(driver);
        inspectionTypePage = new InspectionTypePage(driver);
        inspectionCenterPage = new InspectionCenterPage(driver);
        inspectionSchedulePage = new InspectionSchedulePage(driver);
        detailsPage = new DetailsPage(driver);
        confirmationPage = new ConfirmationPage(driver);
    }

    @Test
    public void loginPage() {
        loginPage.clickAllowBtn();
        loginPage.clickSkip();
        loginPage.selectUAEResident();
        loginPage.clickProceed();
        loginPage.clickLogin();
        loginPage.enterUsername("permit004");
        loginPage.enterPassword("Test@1234");
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "loginPage")
    public void servicePage() {
        servicesPage.clickService();
        servicesPage.clickVehicleLicensing();
      // servicesPage.clickVehicleTSReport();
        servicesPage.clickVehicleInstAppointment();
        servicesPage.clickBookAppointment();
    }

    @Test(dependsOnMethods = "servicePage")
    public void vehicleSelectionPage() {
        vehicleSelectionPage.selectRegisteredVehicle();
        vehicleSelectionPage.clickContinue();
    }

    @Test(dependsOnMethods = "vehicleSelectionPage")
    public void inspectionTypePage() {
        inspectionTypePage.serviceTypeInstDropDown();
        inspectionTypePage.chooseServiceTypeInstDropDown("Registration Test");
        inspectionTypePage.clickContinue();
    }

    @Test(dependsOnMethods = "inspectionTypePage")
    public void inspectionCenterPage() {
        inspectionCenterPage.searchInspectionCenter("Wasel Al Jaddaf");
        inspectionCenterPage.selectInspectionCenter();
    }

    @Test(dependsOnMethods = "inspectionCenterPage")
    public void inspectionSchedulePage() {
        inspectionSchedulePage.inspectionDateDropDown();
        inspectionSchedulePage.chooseInspectionDateDropDown("02-03-2026");
        inspectionSchedulePage.inspectionTimeDropDown();
        inspectionSchedulePage.chooseInspectionTimeDropDown("07:00 AM - 07:10 AM");
        inspectionSchedulePage.clickContinue();
    }

    @Test(dependsOnMethods = "inspectionSchedulePage")
        public void detailsPage() {
           // detailsPage.clickSelectLanguage();
            // detailsPage.chooseEnglishLanguage();
            detailsPage.clickContinue2();
        }

    @Test(dependsOnMethods = "detailsPage")
    public void confirmationWithoutPayment() {
        confirmationPage.clickDone();
    }

  /*  @Test(dependsOnMethods = "detailsPage")
    public void paymentPage() {
        paymentPage.acceptTerms();
        paymentPage.clickPaySummary();
        paymentPage.clickPayMethod();
        paymentPage.selectMethod();
        paymentPage.enterCardDetails("4111111111111111", "12", "27", "123");
        paymentPage.confirmPay();
    }
   */

   /*  @Test(dependsOnMethods = "paymentPage")
    public void confirmationAfterPayment() {
        confirmationPage.clickDone();
    }
    */
}


// //  صفحه الكولات

//  adb pair 172.20.10.3:43199 adb connect 172.20.10.3:38483    //


// POM + TestNG best practice لمشروع Appium with Selenium //

// 1- Technical vehicle statues report service // As A Login
// 2- Book inspection appointment service // As A Login
// 3- Vehicle License Renew // As A Login
// 4- Profile ( Login , Guest , UAE Pass ) //




