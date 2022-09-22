package functionalTestsCarrierControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCarrierClasses.LogoutCarrierControl;
import androidCarrierClasses.OpenAndLoginCarrierControl;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import io.appium.java_client.AppiumDriver;

public class LoginScenariosRun{
	static AppiumDriver<WebElement> driver;

	@Test
	public void carrierControlTestAndroidLoginLogout() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		LogoutCarrierControl logoutApp = new LogoutCarrierControl();
		AppStringsAndroid androidText = new AppStringsAndroid();
		OpenAndLoginCarrierControl OpenAndLoginCarrierControl = new OpenAndLoginCarrierControl();
	
		try {
			androidLogs.setupTest("LOGIN SCENARIOS");
			androidLogs.CapturedLogs(androidText.INFO, "--Carrier Control--App testing Logs started--");
			Thread.sleep(3000);

			OpenAndLoginCarrierControl.openCarrierControl();
			logoutApp.logOutCarrierControll();
			androidLogs.CapturedLogs(androidText.INFO, "Logged out");
			
			

		} catch (Exception exp) {

			String errorMessage = exp.getMessage();

			if (errorMessage == null) {
				errorMessage = exp.toString();
				System.out.println("Error is: " + errorMessage);

			} else {
				System.out.println("Error is: " + errorMessage);
			}

			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
			try {
				androidLogs.CapturedLogs(androidText.FAIL, errorMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}