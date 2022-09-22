package androidCardClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.Capabilities;

//import io.appium.java_client.AppiumDriver;

public class MultiCardsLogin {
	public MultiCardsLogin() {
	}

private String env;
private String cardNum;
private String passwordOrPin;

	public void multiCardPassExpected(String environment, String cardNumber, String passwordOrPin) throws Exception {
		this.env = environment;
		//this.cardNum = cardNumber;
		System.out.println("The card number before trim is " +cardNumber);
		this.cardNum = cardNumber.substring(cardNumber.length()-4);
		
		

		
		System.out.println("The card number after trim is " +cardNum);
		this.passwordOrPin = passwordOrPin;
		System.out.println("I am in login Pass invoirment is:" + environment);
				
		multiCardPassExpected();
	}
	
	
		
	public void multiCardPassExpected() throws Exception {
		AndroidLogs AndroidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		RepoCardAndroid elements = new RepoCardAndroid();

		
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
	
		
		AndroidLogs.setupTest("Multi card Login Testing started");
		AndroidLogs.CapturedLogs(info, "Login Pass Expected Testing started.");
		
		Thread.sleep(3000);
		WebElement CheckForMuliCardLogin = elements.CheckForMuliCardLogin();
		if (CheckForMuliCardLogin != null && CheckForMuliCardLogin.isDisplayed()) {
			
			AndroidLogs.CapturedLogs(pass, "Multi Card Login page found.");
			Thread.sleep(3000);
			
				 
			WebElement MultiCardSelector = elements.MultiCardSelector(cardNum);
			if (MultiCardSelector != null && MultiCardSelector.isEnabled()) {
				MultiCardSelector.click();
				AndroidLogs.CapturedLogs(pass, "MultiCard Login for: "+ cardNum+ " Pressed");
				Thread.sleep(3000);
			} else {
				AndroidLogs.CapturedLogs(fail, "MultiCard Login for: "+ cardNum+ " not found");
			}
			
			
			Thread.sleep(3000);
//used if you need to close the keyboard
		Capabilities.driver.hideKeyboard(); 
			
		WebElement CardLoginButton = elements.CardLoginButton();
		if (CardLoginButton != null && CardLoginButton.isEnabled()) {
			CardLoginButton.click();
			AndroidLogs.CapturedLogs(pass, "Login Button Pressed.");
			Thread.sleep(3000);
		} else {
			AndroidLogs.CapturedLogs(fail, "Login Button was not found");
		}
		
		Thread.sleep(3000);
		
		// Find the login Password text box tell if find or Test Fail.
		WebElement MultiCardPinPassTextBox = elements.MultiCardPinPassTextBox();

		if (MultiCardPinPassTextBox != null && MultiCardPinPassTextBox.isDisplayed()) {
			MultiCardPinPassTextBox.sendKeys(passwordOrPin);
			Thread.sleep(3000);
			AndroidLogs.CapturedLogs(pass, "MultiCard Pin/passcode entered");
// TODO				add	select hide show password button

		} else {
			AndroidLogs.CapturedLogs(fail, "MultiCard Pin/passcode was not found");
		}

// TODO				add	some options for Forgot Pin or passcode maybe go into and close. 

//used if you need to close the keyboard
		Capabilities.driver.hideKeyboard(); 
		
		WebElement MultiCardLoginButton = elements.MultiCardLoginButton();
		if (MultiCardLoginButton != null && MultiCardLoginButton.isEnabled()) {
			MultiCardLoginButton.click();
			AndroidLogs.CapturedLogs(pass, "Login Button Pressed.");
			Thread.sleep(3000);
		} else {
			AndroidLogs.CapturedLogs(fail, "Login Button was not found");
		}

	} else {
		AndroidLogs.CapturedLogs(info, "Multi Card Login page not found.");
		}
	}
}
