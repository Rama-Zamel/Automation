package pages;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

public class ServicesPage extends BasePage {

    private By serviceBtn = By.xpath("//android.widget.TextView[@text='Services']");
    private By vlBtn = By.xpath("//android.widget.TextView[@text='Vehicle Licensing']");
    private By vehicleTSReportBtn = By.xpath("//android.widget.TextView[@text='Vehicle Technical Status Report']");
    private By VehicleInstAppointmentBtn = By.xpath("//android.widget.TextView[@text=\"Vehicle Inspection Appointment\"]");
    private By BookAppointmentBtn = By.xpath("//android.widget.TextView[@text=\"Book Appointment\"]");
    private By VehicleLicenseRenewBtn =By.xpath("//android.widget.TextView[@text=\"Vehicle License Renewal\"]");
    private By NOLBtn = By.xpath("//android.widget.TextView[@text=\"nol\"]");
    private By NolBalanceBtn = By.xpath("//android.widget.TextView[@text=\"Check your nol balance\"]");
    private By NolTopUpBtn = By.xpath("//android.widget.TextView[@text=\"Top up nol card\"]");
    private By ParkingBtn = By.xpath("//android.widget.TextView[@text=\"Parking\"] ");
    private By TopUpParkingBtn = By.xpath(" //android.widget.TextView[@text=\"Top up parking account\"]");


    public ServicesPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickService() {
        click(serviceBtn);
        System.out.println("Services Button clicked");
    }

    public void clickVehicleLicensing() {
        click(vlBtn);
        System.out.println("VL Service clicked");
    }

    public void clickVehicleTSReport() {
        click(vehicleTSReportBtn);
        System.out.println("Vehicle technical status report service clicked");
    }

    public void clickVehicleInstAppointment() {
        click(VehicleInstAppointmentBtn);
        System.out.println("Vehicle Inspection Appointment service clicked");
    }

    public void clickBookAppointment() {
        click(BookAppointmentBtn);
        System.out.println("Book Appointment button clicked");
    }

    public void clickVehicleLicenseRenew() {
        click(VehicleLicenseRenewBtn);
        System.out.println("Vehicle License Renew service clicked");
    }
    public void clickNOL() {
        click(NOLBtn);
        System.out.println("NOL Service clicked");
    }

    public void clickNolBalance() {
        click(NolBalanceBtn);
        System.out.println("NOL Balance clicked");
    }

    public void clickNolTopUp() {
        click(NolTopUpBtn);
        System.out.println("NOL TopUp clicked");
    }

    public void clickParking() {
        click(ParkingBtn);
        System.out.println("Parking Service clicked");
    }

    public void clickTopUpParking() {
        click(TopUpParkingBtn);
        System.out.println("Top Up Parking Account service clicked");
    }



}