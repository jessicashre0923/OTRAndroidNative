package functionalTestsCardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.CreatePasscode;
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

public class SmashLoginRun {
	static AppiumDriver<WebElement> driver;
	private String cardNum;
	private String cardType;
	String appName = "Card Control";
	
	@Test
	public void cardControlTestAndroid() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		PhonePicker phone = new PhonePicker();
		EnvironmentPicker environmentPicker = new EnvironmentPicker();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		CreatePasscode createPasscode = new CreatePasscode();
		HelpScreen helpScreen = new HelpScreen();

		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		int smashLogin = 0;
		int timesToRun = 3;

		try {
			while (smashLogin <= timesToRun) {
				System.out.println("Times test has run: " + smashLogin);

				androidLogs.setupTest("TEST TO VERIFY LOGIN WORKS");

				// FLEET ONE CARD
				androidLogs.setupTestYellow("FLEET ONE CARD");
				System.out.println(phone.autoPhonePickerCard(appName));
				environmentPicker.EnvironmentPickerButton();
				multiCard.MultiCardLoginCheck();
				getAccount.setEnv(environmentPicker.getEnviroment());
				getAccount.CardPassExpected("FLEET_ONE");
				cardType = "FLEET ONE CARD";
				Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
						getAccount.getPasswordOrPin(), this.cardType);
				Biometrics.BiometricsAndroid();
				helpScreen.HelpScreenContinue(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
						getAccount.getPasswordOrPin(), this.cardType);
				Capabilities.driver.closeApp();
				Capabilities.driver.quit();
				androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT CARD TYPE");

				// COMPANY CARD
				androidLogs.setupTestYellow("COMPANY CARD");
				System.out.println(phone.autoPhonePickerCard(appName));
				environmentPicker.EnvironmentPickerButton();
				multiCard.MultiCardLoginCheck();
				getAccount.setEnv(environmentPicker.getEnviroment());
				getAccount.CardPassExpected("COMPANY");
				cardType = "COMPANY CARD";
				Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
						getAccount.getPasswordOrPin(), this.cardType);
				Biometrics.BiometricsAndroid();
				helpScreen.HelpScreenContinue(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
						getAccount.getPasswordOrPin(), this.cardType);
				Capabilities.driver.closeApp();
				Capabilities.driver.quit();
				androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT CARD TYPE");

				// SMARTFUNDS CARD
				System.out.println(phone.autoPhonePickerCard(appName));
				androidLogs.setupTestYellow("SMARTFUNDS CARD");
				environmentPicker.EnvironmentPickerButton();
				multiCard.MultiCardLoginCheck();
				getAccount.setEnv(environmentPicker.getEnviroment());
				getAccount.CardPassExpected("SMARTFUNDS");
				cardType = "SMARTFUNDS CARD";
				Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
						getAccount.getPasswordOrPin(), this.cardType);
				Biometrics.BiometricsAndroid();
				helpScreen.HelpScreenContinue(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
						getAccount.getPasswordOrPin(), this.cardType);
				Capabilities.driver.closeApp();
				Capabilities.driver.quit();
				androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT CARD TYPE");

				// UNIVERSAL CARD
				System.out.println(phone.autoPhonePickerCard(appName));
				androidLogs.setupTestYellow("UNIVERSAL CARD");
				environmentPicker.EnvironmentPickerButton();
				multiCard.MultiCardLoginCheck();
				getAccount.setEnv(environmentPicker.getEnviroment());
				getAccount.CardPassExpected("UNIVERSAL");
				cardType = "UNIVERSAL CARD";
				Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
						getAccount.getPasswordOrPin(), this.cardType);
				Biometrics.BiometricsAndroid();
				helpScreen.HelpScreenContinue(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
						getAccount.getPasswordOrPin(), this.cardType);
				Capabilities.driver.closeApp();
				Capabilities.driver.quit();
				androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT CARD TYPE");

				// PASSCODE Card (this comes from turning on dynamic pin)
				Thread.sleep(3000);
				androidLogs.setupTestYellow("PASSCODE CARD");
				System.out.println(phone.autoPhonePickerCard(appName));
				environmentPicker.EnvironmentPickerButton();
				multiCard.MultiCardLoginCheck();
				getAccount.setEnv(environmentPicker.getEnviroment());
				getAccount.CardPassExpected("PASSCODE");
				cardType = "PASSCODE CARD";
				ConnectionHandler dbACPTCheck = new ConnectionHandler(environmentPicker.getEnviroment());

				// Delete passcode in database
				System.out.println(
						"Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
				dbACPTCheck.execute("infx",
						"Delete from card_pins where card_num ='" + getAccount.getAccountNum() + "'");
				// login with temp passcode
				System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());
				Login.CardPassExpected(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
						getAccount.getPasswordOrPin(), this.cardType);
				createPasscode.NewPasscode(environmentPicker.getEnviroment());
				Biometrics.BiometricsAndroid();
				helpScreen.HelpScreenContinue(environmentPicker.getEnviroment(), getAccount.getAccountNum(),
						getAccount.getPasswordOrPin(), this.cardType);
				Capabilities.driver.closeApp();
				Capabilities.driver.quit();
				androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT CARD TYPE");

				smashLogin++;
				androidLogs.CapturedLogs(info, "LOGIN TESTS COMPLETED CYCLE #: " + smashLogin);
			}
			androidLogs.setupTestYellow("LOGIN TESTS COMPLETED WITH: " + smashLogin + " CYCLES");

		} catch (Exception exp) {
			String errorMessage = exp.getMessage();
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
		System.out.println("SET Card Number: " + cardNum);
	}

	public String getCardNum() {
		System.out.println("GET Card number: " + cardNum);
		return cardNum;
	}
}