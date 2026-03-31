package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ServicesPage extends BasePage {

    private By serviceBtn = By.xpath("//android.widget.TextView[@text='Services']");
    private By vlBtn = By.xpath("//android.widget.TextView[@text='Vehicle Licensing']");
    private By vehicleTSReportBtn = By.xpath("//android.widget.TextView[@text='Vehicle Technical Status Report']");
    private By VehicleInstAppointmentBtn = By.xpath("//android.widget.TextView[@text=\"Vehicle Inspection Appointment\"]");
    private By BookAppointmentBtn = By.xpath("//android.widget.TextView[@text=\"Book Appointment\"]");

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
}