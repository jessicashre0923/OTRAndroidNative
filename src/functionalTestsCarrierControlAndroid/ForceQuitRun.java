package functionalTestsCarrierControlAndroid;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidSharedClasses.Capabilities;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;


public class ForceQuitRun {

	
	static AppiumDriver<WebElement> driver;

	@Test
	public static void carrierControlTestAndroid() {
		String appName = "Carrier Control";
		PhonePicker phone = new PhonePicker();
		
		try {
			System.out.println(phone.autoPhonePickerCarrier(appName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
	}
}