package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidCarrierClasses.TextBoxXpaths;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class HomeLandingPage {

	AppiumDriver<WebElement> driver;
	TextBoxXpaths appText = new TextBoxXpaths();
	AndroidLogs androidLogs = new AndroidLogs();
	RepoCardAndroid elements = new RepoCardAndroid();
	AppStringsAndroid androidText = new AppStringsAndroid();
	ScrollOptions scroll = new ScrollOptions();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	private String env;
	private String cardNum;
	private String passwordOrPin;
	private String cardType;
	
	public void HomeLandingPage(String environment, String cardNumber, String passwordOrPin, String cardType) throws Exception {
			this.env = environment;
			this.cardNum = cardNumber;
			this.passwordOrPin = passwordOrPin;
			this.cardType = cardType;
			
			//System.out.println("I am in Card Pass expected environment is:" + environment);
			homePage();
		}
		
	public void homePage() throws Exception {
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		RepoCardAndroid elements = new RepoCardAndroid();
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		

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
		
//TODO add cardtype check for what one of these to look for.
	
//Home card header expected seen (One sided cards)
		androidLogs.setupTest("Home Landing Page Testing started.");
		androidLogs.CapturedLogs(info, "Checking for Home header");
		Thread.sleep(3000);
		WebElement HomeHeader = elements.HomeHeader();
		Thread.sleep(3000);
		if (HomeHeader != null && HomeHeader.isDisplayed()) {
			androidLogs.CapturedLogs(pass, "Company or SmartFunds only account homepage found");
					
		} else {
			androidLogs.CapturedLogs(info, "Home Header not found");
		}
		
//Company header expected for Universal (Dual sided cards)
		androidLogs.CapturedLogs(info, "Checking for Company header");
		Thread.sleep(3000);
		WebElement CompanyHeader = elements.CompanyHeader();
		Thread.sleep(3000);
		if (CompanyHeader != null && CompanyHeader.isEnabled()) {
			androidLogs.CapturedLogs(pass, "Company account homepage found");
			
//SmartFunds header expected for Universal (Dual sided cards)			
			Thread.sleep(3000);
			WebElement SmartFundsHeader = elements.SmartFundsHeader();
			Thread.sleep(3000);
			if (SmartFundsHeader != null && SmartFundsHeader.isEnabled()) {
				SmartFundsHeader.click();
				androidLogs.CapturedLogs(pass, "SmartFunds account homepage found");
				Thread.sleep(3000);
				CompanyHeader.click();
				androidLogs.CapturedLogs(pass, "Switched back to company side");
				Thread.sleep(3000);
			
		} else {
			androidLogs.CapturedLogs(info, "Company Header not found");
		}
		}
		
		

	

		
		
//TODO If you want to click the profile button latter on
//		Thread.sleep(3000);	
//		WebElement openProfileButtonFromHome = elements.ProfileButtonFromHome();
//		Thread.sleep(3000);
//		if (openProfileButtonFromHome != null && openProfileButtonFromHome.isEnabled()) {
//			openProfileButtonFromHome.click();
//			androidLogs.CapturedLogs(pass, "Open Profile Button is found and pressed.");
//		} else {
//			androidLogs.CapturedLogs(fail, "Open Profile Button is not found");
//		}
//				
//		
//		Thread.sleep(3000);
//		WebElement HelpScreenContinue = elements.HelpScreenContinue();
//		Thread.sleep(3000);
//		if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
//			HelpScreenContinue.click();
//			androidLogs.CapturedLogs(pass, "Help Screen Continue Button is found and pressed");
//		} else {
//			androidLogs.CapturedLogs(info, "Help Screen Continue Button is not found");
//		}

		

	
		
	}
}

