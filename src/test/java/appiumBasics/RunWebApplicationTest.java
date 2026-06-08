package appiumBasics;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
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
    private NolTagIDPage nolTagIDPage;
    private MadinatiServicePage madinatiServicePage;
    private MorePage morePage;
    private RTALocationsPage rtalocationsPage;
    private RechargeSalikPage rechargeSalikPage;

    @BeforeSuite
    public void clearScreenshots() {
        File folder = new File("screenshots");
        if (folder.exists()) {
            for (File file : folder.listFiles()) {
                file.delete();
            }
        }

        System.out.println("Old screenshots deleted");
    }

    public void takeScreenshot(String fileName) throws Exception {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File screen = new File("screenshots/" + fileName + ".png");

        FileHandler.copy(src, screen);

        System.out.println("Screenshot taken: " + screen.getAbsolutePath());
    }

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.rta.rtadubai")
                .setAppActivity("com.rta.rtadubai.MainActivity")
                .setEnsureWebviewsHavePages(true)
                .setNoReset(false)
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
        nolTagIDPage = new NolTagIDPage(driver);
        madinatiServicePage = new MadinatiServicePage(driver);
        morePage = new MorePage(driver);
        rtalocationsPage = new RTALocationsPage(driver);
        rechargeSalikPage = new RechargeSalikPage(driver);
    }

    @Test
    public void LoginFlow() {
        try {
            loginPage.clickAllowBtn();
        } catch (Exception ignored) {}

        try {
            loginPage.clickSkip();
        } catch (Exception ignored) {}

        try {
            loginPage.selectUAEResident();
        } catch (Exception ignored) {}

        try {
            loginPage.clickProceed();
        } catch (Exception ignored) {}

        loginPage.clickLogin();
        loginPage.enterUsername("Tariqj86");
        loginPage.enterPassword("Test@1986");
        loginPage.clickLoginButton();
    }

    @Test(priority = 1)
    public void GuestFlow() {
        try {
            loginPage.clickAllowBtn();
        } catch (Exception ignored) {}

        try {
            loginPage.clickSkip();
        } catch (Exception ignored) {}

        try {
            loginPage.selectUAEResident();
        } catch (Exception ignored) {}

        try {
            loginPage.clickProceed();
        } catch (Exception ignored) {}

        loginPage.clickLogin();
        loginPage.clickGuestButton();
    }

    @Test
    public void VehicleTSReportFlow() {
        servicesPage.clickService();
        servicesPage.clickVehicleLicensing();
        servicesPage.clickVehicleTSReport();
        vehicleSelectionPage.selectRegisteredVehicle();
        vehicleSelectionPage.clickContinue();
        detailsPage.clickSelectLanguage();
        detailsPage.chooseEnglishLanguage();
        detailsPage.clickContinue2();
    }

    @Test
    public void VehicleInspectionFlow() {
        servicesPage.clickService();
        servicesPage.clickVehicleLicensing();
        servicesPage.clickVehicleInstAppointment();
        servicesPage.clickBookAppointment();

        vehicleSelectionPage.selectRegisteredVehicle();
        vehicleSelectionPage.clickContinue();

        inspectionTypePage.serviceTypeInstDropDown();
        inspectionTypePage.chooseServiceTypeInstDropDown("Registration Test");
        inspectionTypePage.clickContinue();

        inspectionCenterPage.searchInspectionCenter("Wasel Al Jaddaf");
        inspectionCenterPage.selectInspectionCenter();

        inspectionSchedulePage.inspectionDateDropDown();
        inspectionSchedulePage.chooseInspectionDateDropDown("02-03-2026");
        inspectionSchedulePage.inspectionTimeDropDown();
        inspectionSchedulePage.chooseInspectionTimeDropDown("07:00 AM - 07:10 AM");
        inspectionSchedulePage.clickContinue();

        detailsPage.clickContinue2();
    }

    @Test
    public void TopUpParkingAccountFlow() {
        servicesPage.clickService();
        servicesPage.clickParking();
        servicesPage.clickTopUpParking();
        nolTagIDPage.selectAmount();
    }

    @Test
    public void NolTopUpFlow() {
        servicesPage.clickService();
        servicesPage.clickNOL();
        servicesPage.clickNolTopUp();
        nolTagIDPage.nolTagID("0361532922");
        nolTagIDPage.selectAmount();

        try {
            nolTagIDPage.emailAddress("e@gmail.com");  // just as Guest
        } catch (Exception ignored) {}

        nolTagIDPage.topUp();
    }

    @Test
    public void NolBalanceFlow() {
        servicesPage.clickService();
        servicesPage.clickNOL();
        servicesPage.clickNolBalance();
        nolTagIDPage.nolTagID("0361532922");
        nolTagIDPage.cardInfo();
        nolTagIDPage.topUp();
        nolTagIDPage.selectAmount();
        nolTagIDPage.topUp();
    }

    @Test
    public void MadinatiFlow() {
        madinatiServicePage.madinatiService();
        madinatiServicePage.MadinatiMap();
    }

    @Test
    public void RTALocationsFlow() {
        morePage.ClickMore();
        morePage.ClickRTALocations();
        rtalocationsPage.RTALocationsWithScroll();
    }

    @Test
    public void LogoutFlow() {
        morePage.ClickMore();
        morePage.ClickLogout();
    }

    @Test(priority = 2)
    public void RechargeMySalikFlow() {
        servicesPage.clickService();
        servicesPage.clickSalik();
        servicesPage.clickRechargeMySalik();
        rechargeSalikPage.ClickMobileNumber("525285659");
        rechargeSalikPage.ClickCountry();
        rechargeSalikPage.SelectCountryDropDown("United Arab Emirates");
        rechargeSalikPage.ClickEmirate();
        rechargeSalikPage.SelectEmirateDropDown("Dubai");
        rechargeSalikPage.ClickCategory();
        rechargeSalikPage.SelectCategoryDropDown("Private");
        rechargeSalikPage.ClickPlateCode();
        rechargeSalikPage.SelectPlateDropDown("J");
        rechargeSalikPage.ClickPlateNumber("96407");
        rechargeSalikPage.SelectAmount();
        rechargeSalikPage.RechargeNow();
    }

    @Test
    public void RechargeAnotherSalikFlow() {
        servicesPage.clickService();
        servicesPage.clickSalik();
        servicesPage.clickRechargeAnotherSalik();
        rechargeSalikPage.SelectAmount();
        rechargeSalikPage.RechargeNow();
    }

    @Test
    public void WithoutPaymentFlow() {
        confirmationPage.clickDone();
    }

    @Test(priority = 3)
    public void WithPaymentFlow() {
        try {
            paymentPage.acceptTerms();
        } catch (Exception ignored) {}

        paymentPage.clickPaySummary();
        paymentPage.clickPayMethod();
        paymentPage.selectMethod();
        paymentPage.enterCardDetails("4111111111111111", "12", "27", "123");
        paymentPage.confirmPay();
        confirmationPage.clickDone();
    }







   /* 1- @Test
    public void loginPage() throws Exception {
        loginPage.clickAllowBtn();
        takeScreenshot("AllowBtn");
        loginPage.clickSkip();
        takeScreenshot("SkipBtn");
        loginPage.selectUAEResident();
        takeScreenshot("UAEResident");
        loginPage.clickProceed();
        takeScreenshot("ProceedBtn");
        loginPage.clickLogin();
        takeScreenshot( "LoginBtn");
        loginPage.enterUsername("Tariqj86");
        takeScreenshot("Username");
        loginPage.enterPassword("Test@1986");
        takeScreenshot("Password");
        loginPage.clickLoginButton();
        takeScreenshot( "LoginBtn");
        // loginPage.clickGuestButton();
        // takeScreenshot( "GuestBtn");
        // loginPage.clickUAEPASSButton();
        // loginPage.UAEPASSUserName("");
    }

    @Test(dependsOnMethods = "loginPage")
    public void servicePage() throws Exception {
        servicesPage.clickService();
        takeScreenshot("ServiceBtn");
        // servicesPage.clickVehicleLicensing();
        // servicesPage.clickVehicleTSReport();
        // servicesPage.clickVehicleInstAppointment();
        // servicesPage.clickBookAppointment();
        //servicesPage.clickNOL();
        // servicesPage.clickNolBalance();
        // servicesPage.clickNolTopUp();
        // servicesPage.clickParking();
        // servicesPage.clickTopUpParking();
        servicesPage.clickSalik();;
        takeScreenshot("Salik");
        //  servicesPage.clickRechargeMySalik();
        //  takeScreenshot("RechargeMySalik");
        servicesPage.clickRechargeAnotherSalik();
        takeScreenshot("RechargeAnotherSalik");
    }

    @Test(dependsOnMethods = "servicePage")
    public void RechargeSalikPage() throws Exception {

        rechargeSalikPage.ClickMobileNumber("525285659");
        rechargeSalikPage.ClickCountry();
        rechargeSalikPage.SelectCountryDropDown("United Arab Emirates");
        rechargeSalikPage.ClickEmirate();
        rechargeSalikPage.SelectEmirateDropDown("Dubai");
        rechargeSalikPage.ClickCategory();
        rechargeSalikPage.SelectCategoryDropDown("Private");
        rechargeSalikPage.ClickPlateCode();
        rechargeSalikPage.SelectPlateDropDown("J");
        rechargeSalikPage.ClickPlateNumber("96407");
        rechargeSalikPage.SelectAmount();
        takeScreenshot("RechargeSalikPage");
        rechargeSalikPage.RechargeNow();
        takeScreenshot("RechargeNow");
    }


    @Test(dependsOnMethods = "RechargeSalikPage")
    public void paymentPage() throws Exception {
        // paymentPage.acceptTerms();
        //  paymentPage.clickPaySummary();
        paymentPage.clickPayMethod();
        takeScreenshot("PaymentPage");
        // paymentPage.selectMethod();
        // paymentPage.enterCardDetails("4111111111111111", "12", "27", "123");
        // paymentPage.confirmPay();
    }


    */

   /*  @Test(dependsOnMethods = "loginPage")
    public void madinatiServicePage() {
        // madinatiServicePage.madinatiService();
        // madinatiServicePage.MadinatiMap();
    }

    */

   /* @Test(dependsOnMethods = "loginPage")
    public void MorePage() throws Exception {
       morePage.ClickMore();
        takeScreenshot( "MoreBtn");

        morePage.ClickRTALocations();
        takeScreenshot( "RTALocations");

        morePage.ClickLogout();
        takeScreenshot("LogoutBtn");
    }
    */

    /* @Test(dependsOnMethods = "MorePage")
    public void RTALocationsPage() throws Exception {
         rtalocationsPage.RTALocationsWithScroll();
        takeScreenshot( "RTALocationsWithScroll");


    }
     */

    /*  @Test(dependsOnMethods = "servicePage")
     public void nolTagIDPage() {
         // nolTagIDPage.nolTagID("0361532922");
         // nolTagIDPage.cardInfo();
         // nolTagIDPage.selectAmount();
         // nolTagIDPage.emailAddress("e@gmail.com");  // just as Guest
         // nolTagIDPage.topUp();
     */

    }

    /* @Test(dependsOnMethods = "servicePage")
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
           // detailsPage.clickSelectLanguage();';
            // detailsPage.chooseEnglishLanguage();
            detailsPage.clickContinue2();
        }

    @Test(dependsOnMethods = "detailsPage")
    public void confirmationWithoutPayment() {
        confirmationPage.clickDone();
    }
detailsPage
     */



  /*  @Test(dependsOnMethods = "nolTagIDPage")
    public void paymentPage() {
       // paymentPage.acceptTerms();
       // paymentPage.clickPaySummary();
       // paymentPage.clickPayMethod();
       // paymentPage.selectMethod();
       // paymentPage.enterCardDetails("4111111111111111", "12", "27", "123");
       // paymentPage.confirmPay();
    }

   */


   /*  @Test(dependsOnMethods = "paymentPage")
    public void confirmationAfterPayment() {
        confirmationPage.clickDone();
    }
    */























/*   2- public void completeFlowLoginService() {

        loginPage.clickAllowBtn();
        loginPage.clickSkip();
        loginPage.selectUAEResident();
        loginPage.clickProceed();
        loginPage.clickLogin();
        loginPage.enterUsername("permit004");
        loginPage.enterPassword("Test@1234");
        loginPage.clickLoginButton();

    }

    public void completeGuestService() {

        loginPage.clickAllowBtn();
        loginPage.clickSkip();
        loginPage.selectUAEResident();
        loginPage.clickProceed();
        loginPage.clickLogin();
        loginPage.clickGuestButton();

    }

    public void completeFlowVehicleTSReportService() {
        servicesPage.clickService();
        servicesPage.clickVehicleLicensing();
        servicesPage.clickVehicleTSReport();
        vehicleSelectionPage.selectRegisteredVehicle();
        vehicleSelectionPage.clickContinue();
        detailsPage.clickSelectLanguage();';
        detailsPage.chooseEnglishLanguage();
        detailsPage.clickContinue2();
    }

    public void completeFlowInspectionService() {

        servicesPage.clickService();
        servicesPage.clickVehicleLicensing();
        servicesPage.clickVehicleInstAppointment();
        servicesPage.clickBookAppointment();

        vehicleSelectionPage.selectRegisteredVehicle();
        vehicleSelectionPage.clickContinue();

        inspectionTypePage.serviceTypeInstDropDown();
        inspectionTypePage.chooseServiceTypeInstDropDown("Registration Test");
        inspectionTypePage.clickContinue();

        inspectionCenterPage.searchInspectionCenter("Wasel Al Jaddaf");
        inspectionCenterPage.selectInspectionCenter();

        inspectionSchedulePage.inspectionDateDropDown();
        inspectionSchedulePage.chooseInspectionDateDropDown("02-03-2026");
        inspectionSchedulePage.inspectionTimeDropDown();
        inspectionSchedulePage.chooseInspectionTimeDropDown("07:00 AM - 07:10 AM");
        inspectionSchedulePage.clickContinue();

        detailsPage.clickContinue2();
    }

    public void completeFlowTopUpParkingAccountService() {

        servicesPage.clickService();
        servicesPage.clickParking();
        servicesPage.clickTopUpParking();
        nolTagIDPage.selectAmount();
    }

    public void completeFlowNolTopUpService() {
        servicesPage.clickService();
        servicesPage.clickNOL();
        servicesPage.clickNolTopUp();
        nolTagIDPage.nolTagID("0361532922");
        nolTagIDPage.selectAmount();
        nolTagIDPage.emailAddress("e@gmail.com");  // just as Guest
        nolTagIDPage.topUp();
    }

    public void completeFlowNolBalanceService() {
        servicesPage.clickService();
        servicesPage.clickNOL();
        servicesPage.clickNolBalance();
        nolTagIDPage.nolTagID("0361532922");
        nolTagIDPage.cardInfo();
        nolTagIDPage.topUp();
        nolTagIDPage.selectAmount();
        nolTagIDPage.topUp();
    }

    public void completeFlowMadinatiService() {
       madinatiServicePage.madinatiService();
       madinatiServicePage.MadinatiMap();
    }



    @Test
    public void withoutPayment() {

        completeFlowLoginService();
        completeFlowInspectionService();
        confirmationPage.clickDone();
        completeFlowNolBalanceService();
        completeFlowMadinatiService();
    }

    @Test
    public void withPayment() {

        completeFlowLoginService();
        completeFlowVehicleTSReportService();
        completeFlowTopUpParkingAccountService();
        completeFlowNolTopUpService();
        paymentPage.acceptTerms();
        paymentPage.clickPaySummary();
        paymentPage.clickPayMethod();
        paymentPage.selectMethod();
        paymentPage.enterCardDetails("4111111111111111", "12", "27", "123");
        paymentPage.confirmPay();
        confirmationPage.clickDone();
    }

 */








// //  صفحه الكولات

//  adb pair 172.20.10.3:43199 adb connect 172.20.10.3:38483    //


// CI/CD with maven  = نظام بيشتغل عنك التست أوتوماتيك عن طريق استخدام ال جيت هب   // =>
// selenium web need (CI/CD)
// appium need (cloud)


//  Maven + POM + TestNG best practice لمشروع Appium with Selenium  //
//  We are using Appium with TestNG and Page Object Model framework //

// 1- Technical vehicle statues report service // As A Login
// 2- Book inspection appointment service // As A Login
// 3- Vehicle License Renew // As A Login *
// 4- Profile ( Login , Guest , UAE Pass ) //
// 5- Nol Section // As A Login & As A Guest
// 6- Madinati Service// As A Login & As A Guest
// 7- Top Up Parking Account Service// As A Login
// 8- RTA Location Service// As A Login & As A Guest
// 9- Recharge Salik Service// As A Login & As A Guest



// Selenium (كل الكود) + Appium (الجزء من الكود ربط الموبايل بالاب) + TestNG (@BEFORE).+ POM (تقسيم وترتيب المشروع)








