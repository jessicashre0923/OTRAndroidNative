package functionalTestsCardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.CardLoginPassSecureFuel;
import androidCardClasses.CardLoginPasscode;
import androidCardClasses.CreateProfile;
import androidCardClasses.HomeLandingPage;
import androidCardClasses.LogOutCardControl;
import androidCardClasses.MultiCardLoginCheck;
import androidCardClasses.MultiCardsLogin;
import androidCardClasses.MultiCardsRemoveCard;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class AddDeleteMultiCard {
	static AppiumDriver<WebElement> driver;
	private String accountNum;	
	private String accountType;
	String env;
	
	@Test
	public void cardControlTestAndroid() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		LogOutCardControl logout = new LogOutCardControl();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		CardDirectLoginPass card6344 = new CardDirectLoginPass();
		CardLoginPassSecureFuel card0561 = new CardLoginPassSecureFuel();
		CardLoginPasscode card5542 = new CardLoginPasscode();
		CreateProfile createProfile = new CreateProfile();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		MultiCardsLogin multiCardsLogin = new MultiCardsLogin();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		MultiCardsRemoveCard removeCard = new MultiCardsRemoveCard();
		HomeLandingPage homePage = new HomeLandingPage();
			
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		String storedAccount;
		String storedPinOrPassword;
		String appName = "Card Control";
		
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		
		
		try {
			androidLogs.setupTest("MULTI CARD ADDED AND DELETED");
			//UNIVERSAL
			getAccount.setEnv(env);
			accountType = "UNIVERSAL";
			androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
			getAccount.CardPassExpected(accountType);
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();
			
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			getAccount.setEnv(environmentPicker.getEnviroment());
			Login.CardPassExpected(env, storedAccount, storedPinOrPassword,accountType);
			Biometrics.BiometricsAndroid();
			homePage.HomeLandingPage(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(),accountType);
			createProfile.ProfileSetup(env);
			logout.logoutCardControl();
			androidLogs.CapturedLogs(androidText.PASS, "Logged out of "+accountType+" Card");
	
			
			//UNIVERSAL MultiCard page login
			androidLogs.setupTestYellow("Testing "+accountType+" login via list");
			environmentPicker.EnvironmentPickerButton();
			getAccount.setEnv(env);
			removeCard.multiCardPassExpected(env, storedAccount, storedPinOrPassword);
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
			
			
			
//TODO add a fleet one card also...
			

			
			androidLogs.CapturedLogs(androidText.INFO, "MultiCard Login Logout functional test completed");
		
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
				androidLogs.CapturedLogs(androidText.FAIL, errorMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	public void setCardNum(String cardNumNow) {
		this.accountNum = cardNumNow;
		System.out.println("SET Card Number: "+ accountNum);
	}


	public String getCardNum() {
		System.out.println("GET Card number: "+ accountNum);
		return accountNum;
	}
}