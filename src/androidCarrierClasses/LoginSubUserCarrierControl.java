package androidCarrierClasses;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;

public class LoginSubUserCarrierControl {

	public LoginSubUserCarrierControl() {
	}

	
	private String env;
	private String carrierNum;
	private String passwordOrPin;
		
	public void PassExpected(String environment, String carrierNum, String passwordOrPin) throws Exception {
		this.env = environment;
		this.carrierNum = carrierNum;
		this.passwordOrPin = passwordOrPin;
		PassExpected();
	}
		

		@Test

	public void PassExpected() throws Exception {
		AndroidLogs androidLogs = new AndroidLogs();
		RepoCarrierAndroid elements = new RepoCarrierAndroid();
		AppStringsAndroid androidText = new AppStringsAndroid();
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		
		androidLogs.setupTest("Testing for SubUser login of 102698db");
		androidLogs.CapturedLogs("Test Info", "Login Pass Expected Testing started.");

		Thread.sleep(3000);
		WebElement LoginCarrierTextBox = elements.LoginCarrierTextBox();
		if (LoginCarrierTextBox != null && LoginCarrierTextBox.isEnabled()) {
			LoginCarrierTextBox.clear();
			androidLogs.CapturedLogs(info, "Carrier number textbox cleared");
			LoginCarrierTextBox.click();
			LoginCarrierTextBox.sendKeys(this.carrierNum);
			androidLogs.CapturedLogs(pass, "Carrier number entered");
		} else {
			androidLogs.CapturedLogs(fail,
					"Carrier number for " + this.carrierNum + " text box is not found");
		}

		Thread.sleep(3000);
		WebElement LoginCarrierPasswordTextBox = elements.LoginCarrierPasswordTextBox();
		if (LoginCarrierPasswordTextBox != null && LoginCarrierPasswordTextBox.isDisplayed()) {
			LoginCarrierPasswordTextBox.click();
			LoginCarrierPasswordTextBox.clear();
			androidLogs.CapturedLogs(info, "Carrier Password textbox cleared");
			LoginCarrierPasswordTextBox.sendKeys(this.passwordOrPin);
			androidLogs.CapturedLogs(pass,
					"Pin text box for " + this.carrierNum + " is entered.");
		} else {
			androidLogs.CapturedLogs(fail,
					"Pin text box for " + this.carrierNum+ " is not found");
		}

		Thread.sleep(3000);
		WebElement LoginButtonCarrierControl = elements.LoginButtonCarrierControl();
		if (LoginButtonCarrierControl != null && LoginButtonCarrierControl.isEnabled()) {
			LoginButtonCarrierControl.click();
			androidLogs.CapturedLogs(pass, "Login Button selected.");
		} else {
			androidLogs.CapturedLogs(fail, "Login Button not found");
		}
	}

}
