package androidCarrierClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;

public class LoginUniversalCC {

	public LoginUniversalCC() {
	}
	
	private String env;
	private String accountNumber;
	private String passwordOrPin;
	
	public void LoginUniversalCC(String environment, String carrierNum, String passwordOrPin) throws Exception {
		this.env = environment;
		this.accountNumber = carrierNum;
		this.passwordOrPin = passwordOrPin;
		PassExpected();
	}

	public void PassExpected() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid();
		RepoCarrierAndroid elements = new RepoCarrierAndroid();
		androidLogs.setupTest("Login testing for universal 129698");

		Thread.sleep(3000);
		WebElement LoginCarrierTextBox = elements.LoginCarrierTextBox();
		Thread.sleep(3000);
		if (LoginCarrierTextBox != null && LoginCarrierTextBox.isEnabled()) {
			LoginCarrierTextBox.clear();
			androidLogs.CapturedLogs(androidText.INFO, "Carrier number textbox cleared");
			LoginCarrierTextBox.click();
			LoginCarrierTextBox.sendKeys(accountNumber);
			androidLogs.CapturedLogs(androidText.PASS, "Carrier number entered");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL,
					"Carrier number for " + accountNumber + " text box is not found");
		}

		Thread.sleep(3000);
		WebElement LoginCarrierPasswordTextBox = elements.LoginCarrierPasswordTextBox();
		Thread.sleep(3000);
		if (LoginCarrierPasswordTextBox != null && LoginCarrierPasswordTextBox.isDisplayed()) {
			LoginCarrierPasswordTextBox.click();
			LoginCarrierPasswordTextBox.clear();
			androidLogs.CapturedLogs(androidText.INFO, "Carrier Password textbox cleared");
			LoginCarrierPasswordTextBox.sendKeys(passwordOrPin);
			androidLogs.CapturedLogs(androidText.PASS,
					"Pin text box for " + accountNumber + " is entered.");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL,
					"Pin text box for " + accountNumber + " is not found");
		}

		Thread.sleep(3000);
		WebElement LoginButtonCarrierControl = elements.LoginButtonCarrierControl();
		Thread.sleep(3000);
		if (LoginButtonCarrierControl != null && LoginButtonCarrierControl.isEnabled()) {
			LoginButtonCarrierControl.click();
			androidLogs.CapturedLogs(androidText.PASS, "Login Button selected.");
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Login Button not found");
		}
	}

}
