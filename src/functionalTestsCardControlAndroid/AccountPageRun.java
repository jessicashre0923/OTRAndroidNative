package functionalTestsCardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.AccountPage;
import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.CreatePasscode;
import androidCardClasses.CreateProfile;
import androidCardClasses.HomeLandingPage;
import androidCardClasses.MultiCardLoginCheck;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ConnectionHandler;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.HelpScreen;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class AccountPageRun {
	static AppiumDriver<WebElement> driver;
	private String cardNum;	
	private String accountType;
	String env;
	
	@Test
	public void cardControlTestAndroid() throws Exception {
		//String testType = "Account_Page_test_";
		//String buildNum = "5.0.0";
	
		AndroidLogs androidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker=new EnvironmentPicker();
		CreateProfile createProfile = new CreateProfile();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		CreatePasscode createPasscode = new CreatePasscode();
		AccountPage accountPage = new AccountPage();
		HomeLandingPage homePage = new HomeLandingPage();
		HelpScreen helpScreen = new HelpScreen();
	
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		String storedAccount;
		String storedPinOrPassword;
		String appName = "Card Control";
		
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
					
		
		try {
			androidLogs.setupTest("Account Page tests");	
			getAccount.setEnv(env);
			accountType = "COMPANY";
			androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
			getAccount.CardPassExpected(accountType);
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();
					
			
			System.out.println(phone.autoPhonePickerCard(appName));
			androidLogs.setupTestYellow("COMPANY CARD");
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env,storedAccount, storedPinOrPassword, accountType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			homePage.HomeLandingPage(env,storedAccount, storedPinOrPassword, accountType);
			accountPage.openProfileButtonFromHome(env,storedAccount, storedPinOrPassword);
			
			androidLogs.CapturedLogs(pass, "Logged out of "+ accountType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
			
			
			
			//FLEET ONE CARD
			Thread.sleep(3000);
			getAccount.setEnv(env);
			accountType = "FLEET_ONE";
			androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
			getAccount.CardPassExpected(accountType);
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();
			
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env,storedAccount, storedPinOrPassword, accountType);
			Thread.sleep(3000);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			homePage.HomeLandingPage(env,storedAccount, storedPinOrPassword, accountType);
			accountPage.openProfileButtonFromHome(env,storedAccount, storedPinOrPassword);
			androidLogs.CapturedLogs(pass, "Logged out of "+ accountType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
			
			
			//SMARTFUNDS CARD
			Thread.sleep(3000);
			getAccount.setEnv(env);
			accountType = "SMARTFUNDS";
			androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
			getAccount.CardPassExpected(accountType);	
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();
			
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env,storedAccount, storedPinOrPassword, accountType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			homePage.HomeLandingPage(env,storedAccount, storedPinOrPassword, accountType);
			accountPage.openProfileButtonFromHome(env,storedAccount, storedPinOrPassword);
		
			androidLogs.CapturedLogs(pass, "Logged out of "+ accountType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
						
			
			//UNIVERSAL CARD
			getAccount.setEnv(env);
			accountType = "UNIVERSAL";
			androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
			getAccount.CardPassExpected(accountType);
			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = getAccount.getPasswordOrPin();
			
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env,storedAccount, storedPinOrPassword, accountType);
			Biometrics.BiometricsAndroid();
			
			createProfile.ProfileSetup(env);
			homePage.HomeLandingPage(env,storedAccount, storedPinOrPassword, accountType);
			accountPage.openProfileButtonFromHome(env,storedAccount, storedPinOrPassword);
			
			androidLogs.CapturedLogs(pass, "Logged out of "+ accountType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
			
			
			//PASSCODE Card (this comes from turning on dynamic pin)
			getAccount.setEnv(env);
			accountType = "PASSCODE";
			androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
			getAccount.CardPassExpected(accountType);
			
			
			ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
			//Delete passcode in database 
			System.out.println("Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
			dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='"+ getAccount.getAccountNum()+"'");
			//login with temp passcode 
			System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());
			
			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(),accountType);
			createPasscode.NewPasscode(env);
			Biometrics.BiometricsAndroid();
			helpScreen.HelpScreenContinue(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), accountType);
			createProfile.ProfileSetup(env);
			accountPage.openProfileButtonFromHome(env, getAccount.getAccountNum(), androidText.MANUAL_PASSCODE);
		
			androidLogs.CapturedLogs(pass, "Logged out of "+ accountType+ " Card");
			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
			
//TODO add a fleet one card also...
			

			
			androidLogs.CapturedLogs(info, "Account Page test completed");
		
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