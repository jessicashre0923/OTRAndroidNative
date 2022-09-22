package functionalTestsCardControlAndroid;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidSharedClasses.Capabilities;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;


public class ForceQuitRun {

	
	static AppiumDriver<WebElement> driver;
	
	@Test
	public static void carrierControlTestAndroid() {
		PhonePicker phone = new PhonePicker();
		String appName = "Card Control";
		
		try {
			System.out.println(phone.autoPhonePickerCard(appName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Capabilities.driver.closeApp();
		Capabilities.driver.quit();
	}
}