package androidCardClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.Capabilities;

//import io.appium.java_client.AppiumDriver;

public class CardDirectLoginPass {
	public CardDirectLoginPass() {
	}


private String env;
private String cardNum;
private String passwordOrPin;
private String cardType;
private String cardID;

	public void CardPassExpected(String environment, String cardNumber, String passwordOrPin, String cardType) throws Exception {
		AutoAccountSelector getAccount = new AutoAccountSelector();
		
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		this.cardType = cardType;
		this.cardID = getAccount.getCardID(cardNumber, env);
		
		//System.out.println("I am in Card Pass expected environment is:" + environment);
		CardPassExpected();
	}
	
	public void CardPassExpected() throws Exception {
		AndroidLogs AndroidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		RepoCardAndroid elements = new RepoCardAndroid();
		
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		
				
		AndroidLogs.setupTest("LOGIN testing for " + cardType);
		AndroidLogs.setupTest("Login Pass Expected");
		
		AndroidLogs.CapturedLogs(info, "Login Pass Expected Testing started.");
		AndroidLogs.CapturedLogs(info, "Testing with Card ID: " + cardID);
				
		Thread.sleep(3000);
		WebElement ClearCardNumberTextBox = elements.ClearCardNumberTextBox();
	//	Thread.sleep(3000);
		if (ClearCardNumberTextBox != null && ClearCardNumberTextBox.isDisplayed()) {
			ClearCardNumberTextBox.click();
			// TODO add select info button
			AndroidLogs.CapturedLogs(pass, "Clear text box button selected.");
		} else {
			AndroidLogs.CapturedLogs(info, "Clear text box button not found");
		}

		
		Thread.sleep(3000);
		WebElement CardNumberTextBox = elements.CardNumberTextBox();
	//	Thread.sleep(3000);
		if (CardNumberTextBox != null && CardNumberTextBox.isDisplayed()) {
			CardNumberTextBox.click();
			// TODO add select info button
			
			CardNumberTextBox.sendKeys(cardNum);
			AndroidLogs.CapturedLogs(pass, "Card Number was entered.");
		} else {
			AndroidLogs.CapturedLogs(fail, "Card Number text box is not found");
		}

				Thread.sleep(3000);
				WebElement PinPassTextBoxFilledIN = elements.PinPassTextBoxFilledIN();
	//			Thread.sleep(3000);
				if (PinPassTextBoxFilledIN != null && PinPassTextBoxFilledIN.isDisplayed()) {
					AndroidLogs.CapturedLogs(pass, "Filled in Pin/passcode box is seen");
					PinPassTextBoxFilledIN.sendKeys(passwordOrPin);
//					Thread.sleep(3000);
					AndroidLogs.CapturedLogs(pass, "Pin/passcode entered");
		

				} else {
					AndroidLogs.CapturedLogs(info, "PIN or Passcode pre filled text box was not found");
					AndroidLogs.CapturedLogs(info, "Testing empty PIN or Passcode textbox");
					// Find the login Password text box tell if find or Test Fail.
					Thread.sleep(3000);
					WebElement PinPassTextBox = elements.PinPassTextBox();
//					Thread.sleep(3000);
					if (PinPassTextBox != null && PinPassTextBox.isDisplayed()) {
						PinPassTextBox.sendKeys(passwordOrPin);
//						Thread.sleep(3000);
						AndroidLogs.CapturedLogs(pass, "Pin/passcode entered");
			// TODO				add	select hide show password button
			
					} else {
						AndroidLogs.CapturedLogs(fail, "PIN or Passcode empty textbox was not found");
					}
			
			// TODO				add	some options for Forgot Pin or passcode maybe go into and close. 
				}


//used if you need to close the keyboard
	//	Thread.sleep(3000);
	//	Capabilities.driver.hideKeyboard(); 
		
		Thread.sleep(3000);
		WebElement CardLoginButton = elements.CardLoginButton();
//		Thread.sleep(3000);
		if (CardLoginButton != null && CardLoginButton.isEnabled()) {
			CardLoginButton.click();
			AndroidLogs.CapturedLogs(pass, "Login Button Pressed.");
			//Thread.sleep(3000);
		} else {
			AndroidLogs.CapturedLogs(fail, "Login Button was not found");
		}
	}

}
