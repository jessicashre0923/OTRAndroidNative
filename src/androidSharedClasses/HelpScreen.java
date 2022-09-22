package androidSharedClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import androidCardClasses.RepoCardAndroid;

public class HelpScreen {

	private String env;
	private String cardNum;
	private String passwordOrPin;
	private String cardType;
	
	public HelpScreen HelpScreenContinue(String environment, String cardNumber, String passwordOrPin, String cardType) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		this.cardType = cardType;
		
		AndroidLogs androidLogs = new AndroidLogs();
		RepoCardAndroid elements = new RepoCardAndroid();
		AppStringsAndroid androidText = new AppStringsAndroid(env);

		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
			try {
			
		
			//Help screen for home page
			Thread.sleep(3000);
			WebElement HelpScreenContinue = elements.HelpScreenContinue();
			Thread.sleep(3000);
			if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
				HelpScreenContinue.click();
				androidLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
			} else {
				androidLogs.CapturedLogs(info, "Help Screen continue Button is not found");
			}

		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}

		return this;
	}
	
	
	
	public HelpScreen HelpScreenContinueRequired(String environment, String cardNumber, String passwordOrPin, String cardType) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		this.cardType = cardType;
		
		AndroidLogs androidLogs = new AndroidLogs();
		RepoCardAndroid elements = new RepoCardAndroid();
		AppStringsAndroid androidText = new AppStringsAndroid(env);

		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
			try {
			
		
			//Help screen for home page
			Thread.sleep(3000);
			WebElement HelpScreenContinue = elements.HelpScreenContinue();
			Thread.sleep(3000);
			if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
				HelpScreenContinue.click();
				androidLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
			} else {
				androidLogs.CapturedLogs(fail, "Help Screen continue Button is not found");
			}

		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}

		return this;
	}
	
	
	public HelpScreen HelpScreenContinueOld() throws Exception {
				
		AndroidLogs androidLogs = new AndroidLogs();
		RepoCardAndroid elements = new RepoCardAndroid();
		AppStringsAndroid androidText = new AppStringsAndroid(env);

		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
			try {
			
		
			//Help screen for home page
			Thread.sleep(3000);
			WebElement HelpScreenContinue = elements.HelpScreenContinue();
			Thread.sleep(3000);
			if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
				HelpScreenContinue.click();
				androidLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
			} else {
				androidLogs.CapturedLogs(info, "Help Screen continue Button is not found");
			}

		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}

		return this;
	}
	
	
	
}
