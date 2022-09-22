package cardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Encrypt;
import io.appium.java_client.AppiumDriver;

public class EncryptRunner {
	static AppiumDriver<WebElement> driver;

	
	

	@Test
	public void cardControlTestAndroid() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid();
		Encrypt encrypt = new Encrypt(); 
		
//		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

	

		try {
			androidLogs.setupTest("Encrypt Runner TESTS");
			
			encrypt.Encode("ADD THE STRINGS YOU WANT TO Encode");
		
			
			androidLogs.CapturedLogs(info, "Encrypt Runner finished");
			
			
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
				androidLogs.CapturedLogs(fail, errorMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}