package androidCardClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;

public class CardLoginPasscode {
	public CardLoginPasscode() {
	}

private String env;
private String cardNum;
private String passwordOrPin;
private String cardType;
	
	public void CardPassExpected(String environment ,String cardNumber, String passwordOrPin, String cardType ) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		this.cardType = cardType;
		System.out.println("I am in login Pass env and Card num:" + environment + " " + cardNumber + " " +passwordOrPin );
		CardPassExpected();
	}
	
	AndroidLogs AndroidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new AppStringsAndroid();
	RepoCardAndroid elements = new RepoCardAndroid();
	
	public void CardPassExpected() throws Exception {
		androidText = new AppStringsAndroid(env);
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		

		
		AndroidLogs.setupTest("Login Pass Expected on" + cardType);
		AndroidLogs.CapturedLogs(info, "Login Pass Expected Testing started on" + cardType);

		Thread.sleep(3000);

		WebElement CardNumberTextBox = elements.CardNumberTextBox();
		if (CardNumberTextBox != null && CardNumberTextBox.isDisplayed()) {
			CardNumberTextBox.click();
			CardNumberTextBox.clear();
			CardNumberTextBox.sendKeys(cardNum);
			AndroidLogs.CapturedLogs(pass, "Card Number was entered.");
		} else {
			AndroidLogs.CapturedLogs(fail, "Card Number text box is not found");
		}

		Thread.sleep(3000);
		WebElement PinPassTextBox = elements.PinPassTextBox();

		if (PinPassTextBox != null && PinPassTextBox.isDisplayed()) {
			PinPassTextBox.sendKeys(passwordOrPin);
			AndroidLogs.CapturedLogs(pass, "Pin/passcode entered");
			Thread.sleep(3000);


		} else {
			AndroidLogs.CapturedLogs(fail, "Pin/passcode was not found");
		}
		
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
	}

}
