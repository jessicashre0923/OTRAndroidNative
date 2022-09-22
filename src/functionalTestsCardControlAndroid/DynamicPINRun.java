package functionalTestsCardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.CardLoginPassSecureFuel;
import androidCardClasses.CardLoginPasscode;
import androidCardClasses.CreatePasscode;
import androidCardClasses.CreateProfile;
import androidCardClasses.DynamicPIN;
import androidCardClasses.GetACard;
import androidCardClasses.HomeLandingPageTestAll;
import androidCardClasses.LogOutCardControl;
import androidCardClasses.MultiCardLoginCheck;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ConnectionHandler;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class DynamicPINRun {
	static AppiumDriver<WebElement> driver;
	private String cardNum;	
	private String accountType;
	private String env;
	
	@Test
	public void cardControlTestAndroid() throws Exception {
		AndroidLogs androidLogs = new AndroidLogs();
		LogOutCardControl logout = new LogOutCardControl();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker=new EnvironmentPicker();
		CardDirectLoginPass card6344 = new CardDirectLoginPass();
		CardLoginPassSecureFuel card0561 = new CardLoginPassSecureFuel();
		CardLoginPasscode card5542 = new CardLoginPasscode();
		CreateProfile createProfile = new CreateProfile();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		CreatePasscode createPasscode = new CreatePasscode();
		HomeLandingPageTestAll homePageTests = new HomeLandingPageTestAll();
		
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		String storedAccount;
		String storedPinOrPassword;
		String appName = "Card Control";
		
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
			
		LogOutCardControl Logout = new LogOutCardControl();
		DynamicPIN dynamicPIN = new DynamicPIN();
		ConnectionHandler dbACPTCheck = new ConnectionHandler(environmentPicker.getEnviroment());
		
		try {
			//PASSCODE Card (this comes from turning on dynamic pin)
			androidLogs.setupTest("DYNAMIC PIN");
			getAccount.setEnv(env);
			accountType = "PASSCODE";
			androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
			getAccount.CardPassExpected(accountType);
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();
		
			
			//Delete passcode in database 
			System.out.println("Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
			dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='"+ getAccount.getAccountNum()+"'");
			//login with temp passcode 
			System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());
			
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Biometrics.BiometricsAndroid();
			Login.CardPassExpected(env, storedAccount, getAccount.getPasswordOrPin(),accountType);
			createPasscode.NewPasscode(env);
			
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			dynamicPIN.dynamicPIN();
			Logout.logoutCardControl();
			
			androidLogs.CapturedLogs(info, "Logged out");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
			androidLogs.CapturedLogs(info, "DynamicPIN functional test completed");
			
			
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
	}
	public void setCardNum(String cardNumNow) {
		this.cardNum = cardNumNow;
		System.out.println("SET Card Number: "+ cardNum);
	}


	public String getCardNum() {
		System.out.println("GET Card number: "+ cardNum);
		return cardNum;
	}
}