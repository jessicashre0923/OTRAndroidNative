package androidCardClasses;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import io.appium.java_client.AppiumDriver;

public class NewAccountPinOrPasscode {

	static AppiumDriver<WebElement> driver;
	RepoCardAndroid elements = new RepoCardAndroid();
	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new AppStringsAndroid();
	CardDirectLoginPass CardLogin = new CardDirectLoginPass();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	String cardNum;
	String oldPin;
	String env;
	
	public NewAccountPinOrPasscode NewPasscodeOrPin(String enviroment, String cardNumber, String passOrPin) throws Exception {
		this.env = enviroment;
		this.cardNum = cardNumber;
		this.oldPin = passOrPin;
		
		try { 
		Thread.sleep(3000);
		WebElement CreateAPasscodePage = elements.CreateAPasscodePage();
		Thread.sleep(3000);
		if (CreateAPasscodePage != null && CreateAPasscodePage.isEnabled()) {
			androidLogs.CapturedLogs(info, "Create passcode page found and opened");	
			
		
		WebElement NewPasscodeTextbox = elements.NewPasscodeTextbox();
		 Thread.sleep(2000);
		if (NewPasscodeTextbox != null && NewPasscodeTextbox.isEnabled()) {
			NewPasscodeTextbox.click();
			NewPasscodeTextbox.sendKeys(oldPin);
			androidLogs.CapturedLogs(pass, "New passcocde textbox found and filled in");
		} else {
			androidLogs.CapturedLogs(fail, "New passcocde textbox not found");
		}
		
		
		WebElement ConfirmPasscodeTextbox = elements.ConfirmPasscodeTextbox();
		 Thread.sleep(2000);
		if (ConfirmPasscodeTextbox != null && ConfirmPasscodeTextbox.isEnabled()) {
			ConfirmPasscodeTextbox.click();
			ConfirmPasscodeTextbox.sendKeys(oldPin);
			androidLogs.CapturedLogs(pass, "Confirm passcocde textbox found and filled in");
		} else {
			androidLogs.CapturedLogs(fail, "Confirm passcocde textbox not found");
		}
		
		WebElement NextButton = elements.NextButton();
		 Thread.sleep(2000);
		if (NextButton != null && NextButton.isEnabled()) {
			NextButton.click();
			androidLogs.CapturedLogs(pass, "Next Button found and selected");
		} else {
			androidLogs.CapturedLogs(fail, "Next Button not found");
		}
		
	
		} else {
			androidLogs.CapturedLogs(info, "Create passcode page not seen might already be setup");
	}
		
		
		Thread.sleep(3000);
		WebElement CreateAPinPage = elements.CreateAPinPage();
		Thread.sleep(3000);
		if (CreateAPinPage != null && CreateAPinPage.isEnabled()) {
			androidLogs.CapturedLogs(info, "Create PIN page found and opened");	
			
		
		WebElement NewPinTextbox = elements.NewPinTextbox();
		 Thread.sleep(2000);
		if (NewPinTextbox != null && NewPinTextbox.isEnabled()) {
			NewPinTextbox.click();
			NewPinTextbox.sendKeys(oldPin);
			androidLogs.CapturedLogs(pass, "New PIN textbox found and filled in");
		} else {
			androidLogs.CapturedLogs(fail, "New PIN textbox not found");
		}
		
		
		WebElement ConfirmPinTextbox = elements.ConfirmPinTextbox();
		 Thread.sleep(2000);
		if (ConfirmPinTextbox != null && ConfirmPinTextbox.isEnabled()) {
			ConfirmPinTextbox.click();
			ConfirmPinTextbox.sendKeys(oldPin);
			androidLogs.CapturedLogs(pass, "Confirm PIN textbox found and filled in");
		} else {
			androidLogs.CapturedLogs(fail, "Confirm PIN textbox not found");
		}
		
		WebElement NextButton = elements.NextButton();
		 Thread.sleep(2000);
		if (NextButton != null && NextButton.isEnabled()) {
			NextButton.click();
			androidLogs.CapturedLogs(pass, "Next Button found and selected");
		} else {
			androidLogs.CapturedLogs(fail, "Next Button not found");
		}
		
	
		} else {
			androidLogs.CapturedLogs(info, "Create PIN page not seen might already be setup");
		}
		
		
		
		} catch (Exception exp) {String errorMessage = exp.getMessage();
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
		
		
		

		return this;
	}
}
