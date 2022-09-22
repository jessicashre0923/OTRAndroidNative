package androidCardClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.Capabilities;

//import io.appium.java_client.AppiumDriver;

public class MultiCardsRemoveCard {
	public MultiCardsRemoveCard() {
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
		System.out.println("I am in login Pass environment is:" + environment);
				
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
			
				 
			WebElement EditPencilButton = elements.EditPencilButton();
			if (EditPencilButton != null && EditPencilButton.isEnabled()) {
				EditPencilButton.click();
				AndroidLogs.CapturedLogs(pass, "Edit Pencil Pressed");
				Thread.sleep(3000);
			} else {
				AndroidLogs.CapturedLogs(fail, "Edit Pencil not found");
			}
			
			
			WebElement XCloseButton = elements.XCloseButton();
			if (XCloseButton != null && XCloseButton.isEnabled()) {
				XCloseButton.click();
				AndroidLogs.CapturedLogs(pass, "X close Button Pressed");
				Thread.sleep(3000);
			} else {
				AndroidLogs.CapturedLogs(fail, "X close Button not found");
			}
			
		
			if (EditPencilButton != null && EditPencilButton.isEnabled()) {
				EditPencilButton.click();
				AndroidLogs.CapturedLogs(pass, "Edit Pencil Pressed");
				Thread.sleep(3000);
			} else {
				AndroidLogs.CapturedLogs(fail, "Edit Pencil not found");
			}
		
			
			WebElement MultiCardSelector = elements.MultiCardSelector(cardNum);
			if (MultiCardSelector != null && MultiCardSelector.isEnabled()) {
				MultiCardSelector.click();
				AndroidLogs.CapturedLogs(pass, "MultiCard Login for: "+ cardNum+ " Selected");
				Thread.sleep(3000);
			} else {
				AndroidLogs.CapturedLogs(fail, "MultiCard Login for: "+ cardNum+ " not found");
			}
			
			WebElement RemoveCardButton = elements.RemoveCardButton();
			if (RemoveCardButton != null && RemoveCardButton.isEnabled()) {
				RemoveCardButton.click();
				AndroidLogs.CapturedLogs(pass, "Edit Pencil Pressed");
				Thread.sleep(3000);
			} else {
				AndroidLogs.CapturedLogs(fail, "Edit Pencil not found");
			}
		
		
		
	} else {
		AndroidLogs.CapturedLogs(info, "Multi Card Login page not found.");
		}
	}
}
