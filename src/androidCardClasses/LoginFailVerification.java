package androidCardClasses;

import java.sql.ResultSet;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ConnectionHandler;
import androidSharedClasses.ScrollOptions;
import androidSharedClasses.Sleep;

public class LoginFailVerification {
	public LoginFailVerification() throws Exception {
	}

private String env;
private String cardNum;
private String passwordOrPin; 


	
	public void FailExpected(String environment, String cardNumber, String passwordOrPint) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPint;
		
		System.out.println("I am in login fail environment is:" + environment);
		FailExpected();
	}
	
	ScrollOptions scroll = new ScrollOptions();
	AndroidLogs AndroidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new AppStringsAndroid();
	RepoCardAndroid elements = new RepoCardAndroid();
	Sleep appSleep = new Sleep();
	
	
	
	public void FailExpected() throws Exception {
		androidText = new AppStringsAndroid(env);
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		
		AndroidLogs.setupTest("Login Fail Expected Testing started");
		AndroidLogs.CapturedLogs(info, "Login Fail Expected Testing started.");
	
		
		Thread.sleep(3000);
		
		
		
		WebElement CardNumberTextBox = elements.CardNumberTextBox();
		if (CardNumberTextBox!=null && CardNumberTextBox.isDisplayed()) {
			CardNumberTextBox.click();
			CardNumberTextBox.clear();
			CardNumberTextBox.sendKeys(cardNum);
			AndroidLogs.CapturedLogs(pass, "Fail Card Number was entered.");
			
		} else {
			AndroidLogs.CapturedLogs(fail, "Fail Card Number text box is not found");
		}

		Thread.sleep(3000);

		WebElement PinPassTextBox = elements.PinPassTextBox();

		if (PinPassTextBox!=null && PinPassTextBox.isDisplayed()) {
			PinPassTextBox.click();
			PinPassTextBox.clear();
			PinPassTextBox.sendKeys(passwordOrPin);

			AndroidLogs.CapturedLogs(pass, "Fail Pin entered.");

		} else {
			AndroidLogs.CapturedLogs(fail, "Fail Pin text box is not found");
		}

//used if you need to close the keyboard
				Capabilities.driver.hideKeyboard(); 
		
		WebElement CardLoginButton = elements.CardLoginButton();
		if (CardLoginButton!=null && CardLoginButton.isEnabled()) {
			CardLoginButton.click();
			AndroidLogs.CapturedLogs(pass, "Login Button Pressed.");
		} else {
			AndroidLogs.CapturedLogs(fail, "Login Button was not found");
		}

//		Thread.sleep(5000);
//		WebElement BiometricDenyButton = xpath.BiometricDenyButton();
//		Thread.sleep(5000);
//		if (BiometricDenyButton != null && BiometricDenyButton.isEnabled()) {
//			BiometricDenyButton.click();
//			AndroidLogs.CapturedLogs(androidText.PASS, "Biometrics Deny Button is found and clicked.");
//		} else {
//			AndroidLogs.CapturedLogs(androidText.INFO, "Biometrics Deny Button is not found.");
//		}
		
		Thread.sleep(3000);
		WebElement invalidCardTextModalOkButton = elements.invalidCardTextModalOkButton();
		if (invalidCardTextModalOkButton != null && invalidCardTextModalOkButton.isEnabled()) {
			Thread.sleep(3000);
			invalidCardTextModalOkButton.click();
			AndroidLogs.CapturedLogs(pass, "Unable to login modal ok button clicked");
			Thread.sleep(3000);
//			CardNumberTextBox.clear();
			PinPassTextBox.clear();
		} else {
			AndroidLogs.CapturedLogs(fail, "Unable to login modal ok button not found");
		}

	}
	
	public void LockedLoginExpected(String environment, String cardNumber, String passwordOrPin) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		
		System.out.println("I am in login locked environment is:" + environment);
		LockedLoginExpected();
	}

	public void LockedLoginExpected() throws Exception {
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
		androidText = new AppStringsAndroid(env);
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		

		
		AndroidLogs.setupTest("Login Locked Expected Testing");
		AndroidLogs.CapturedLogs(info, "Checking and resetting card for this test");
		System.out.println("I am in login locked environment is:" + env);
		
		dbACPTCheck.execute("mysql","update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '7083059961002500561'");
		dbACPTCheck.execute("mysql","update sec_user set login_attempted = NULL where user_id = '7083059961002500561'");
		AndroidLogs.CapturedLogs(info, "Card is ready for testing");
		
		WebElement ClearCardNumberTextBox = elements.ClearCardNumberTextBox();
		if (ClearCardNumberTextBox!=null && ClearCardNumberTextBox.isDisplayed()) {
			ClearCardNumberTextBox.click();
			// TODO	add	select info button 
		    AndroidLogs.CapturedLogs(pass, "Clear text box button selected.");
		} else {
			AndroidLogs.CapturedLogs(fail, "Clear text box button not found");
		}

		Thread.sleep(3000);
		
		WebElement CardNumberTextBox = elements.CardNumberTextBox();

		if (CardNumberTextBox!=null && CardNumberTextBox.isDisplayed()) {
			CardNumberTextBox.click();
			CardNumberTextBox.clear();
			CardNumberTextBox.sendKeys(cardNum);
			AndroidLogs.CapturedLogs(pass, "Card Number for locked login entered");

		} else {
			AndroidLogs.CapturedLogs(androidText.FAIL, "Card Number for locked login is not found");
		}

		WebElement PinPassTextBox = elements.PinPassTextBox();
		if (PinPassTextBox!=null && PinPassTextBox.isDisplayed()) {
			PinPassTextBox.click();
			PinPassTextBox.clear();
			//DO NOT CHANGE THIS AS IT IS A FAKE LOGIN EXPECTED TO BE WRONG
			PinPassTextBox.sendKeys(androidText.getENVData("CARD_LOGIN_PIN_FAIL_EXPECTED"));

			AndroidLogs.CapturedLogs(pass, "Locked Pin entered.");

		} else {
			AndroidLogs.CapturedLogs(fail, "Locked Pin text box not found");
		}
	
		ResultSet card_info_now = dbACPTCheck.query("mysql",
				String.format("select status_id from sec_user where user_id = %s", "7083059961002500561"));

		card_info_now.next();

		if (card_info_now.getString("status_id").equals("S")) {
			AndroidLogs.CapturedLogs(pass, "Card Account Was Suspended prior to testing");

		} else if (card_info_now.getString("status_id").equals("A")) {

			int loginAttempt = 0;

			while (loginAttempt < 10) {
				Thread.sleep(3000);
				dbACPTCheck.execute("mysql",
						"update sec_user set login_attempted = NULL where user_id = '7083059961002500561'");
				AndroidLogs.CapturedLogs(info, "Login attempted field now equals Null");
				Thread.sleep(2000);

//used if you need to close the keyboard
				Capabilities.driver.hideKeyboard(); 
				
				WebElement CardLoginButton = elements.CardLoginButton();
				if (CardLoginButton != null && CardLoginButton.isDisplayed()) {
					CardLoginButton.click();
					loginAttempt++;
					AndroidLogs.CapturedLogs(pass, "Login Button Pressed.");
				} else {
					AndroidLogs.CapturedLogs(pass, "Login Button not found");
					loginAttempt++;
				}
			}

		}
		Thread.sleep(3000);
		WebElement invalidCardTextModalOkButton = elements.invalidCardTextModalOkButton();
		if (invalidCardTextModalOkButton != null && invalidCardTextModalOkButton.isEnabled()) {
			invalidCardTextModalOkButton.click();
			AndroidLogs.CapturedLogs(pass, "Suspended login model ok button clicked");
			Thread.sleep(3000);
//			CardNumberTextBox.clear();
			PinPassTextBox.clear();

			AndroidLogs.CapturedLogs(info, "Checking and resetting card for this test");
			dbACPTCheck.execute("mysql",
					"update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '7083059961002500561'");
			dbACPTCheck.execute("mysql",
					"update sec_user set login_attempted = NULL where user_id = '7083059961002500561'");
			AndroidLogs.CapturedLogs(info, "Card is ready for testing");
		
		} else {
			AndroidLogs.CapturedLogs(fail, "Suspended model ok button not found");
//			CardNumberTextBox.clear();
			PinPassTextBox.clear();
		}
	}
}