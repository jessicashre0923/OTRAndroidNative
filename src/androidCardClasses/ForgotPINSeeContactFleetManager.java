package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import io.appium.java_client.AppiumDriver;

public class ForgotPINSeeContactFleetManager {
	
	private String env;
	private String cardNum;


	
	public ForgotPINSeeContactFleetManager ForgotPIN(String environment, String cardNumber) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
				
		//System.out.println("I am in login fail environment is:" + environment);
		ForgotPIN();
		return this;
	}

	static AppiumDriver<WebElement> driver;
	RepoCardAndroid elements = new RepoCardAndroid();
	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new AppStringsAndroid();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	

	public ForgotPINSeeContactFleetManager ForgotPIN() throws Exception {
		androidLogs.setupTest("FORGOT PIN FROM LOGIN TESTS");
		androidText = new AppStringsAndroid(env);
				
		Thread.sleep(5000);
		WebElement ForgotPINorPasscode = elements.ForgotPINorPasscode();
		Thread.sleep(3000);
		if (ForgotPINorPasscode != null && ForgotPINorPasscode.isEnabled()) {
			ForgotPINorPasscode.click();
			androidLogs.CapturedLogs(pass, "Forgot pin link clicked");
		

		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeCardNumberTextBox = elements.ForgotPINorPasscodeCardNumberTextBox();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeCardNumberTextBox != null && ForgotPINorPasscodeCardNumberTextBox.isEnabled()) {
			ForgotPINorPasscodeCardNumberTextBox.click();
			ForgotPINorPasscodeCardNumberTextBox.sendKeys(cardNum);
			androidLogs.CapturedLogs(pass,
					"Forgot pin card number textbox clicked and entered");
		} else {
			androidLogs.CapturedLogs(fail, "Forgot pin card number textbox not found");
		}

		Thread.sleep(3000);
		WebElement ForgotPINNextButton = elements.ForgotPINNextButton();
		Thread.sleep(3000);
		if (ForgotPINNextButton != null && ForgotPINNextButton.isEnabled()) {
			ForgotPINNextButton.click();
			androidLogs.CapturedLogs(pass, "Reset PIN Next clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Reset PIN Next not found");
		}


//enter Contact your fleet manager found and ok used to go back to login 				
		Thread.sleep(3000);
		WebElement ContactFleetManagerOkButton = elements.ContactFleetManagerOkButton();
		Thread.sleep(3000);
		if (ContactFleetManagerOkButton != null && ContactFleetManagerOkButton.isEnabled()) {
			ContactFleetManagerOkButton.click();
			androidLogs.CapturedLogs(pass, "Conttact fleet manager ok Button Pressed");
			Thread.sleep(3000);
		} else {
			androidLogs.CapturedLogs(fail, "Conttact fleet manager ok not found");
		}
		
	} else {
		androidLogs.CapturedLogs(fail, "Forgot pin link not found");
	}

		
		return this;
	}
}
