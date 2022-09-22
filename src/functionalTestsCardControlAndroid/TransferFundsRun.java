package functionalTestsCardControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.CreatePasscode;
import androidCardClasses.CreateProfile;
import androidCardClasses.LogOutCardControl;
import androidCardClasses.MultiCardLoginCheck;
import androidCardClasses.TransferFunds;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.AutoAccountSelector;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ConnectionHandler;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class TransferFundsRun {
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
		CreateProfile createProfile = new CreateProfile();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		AutoAccountSelector getAccount = new AutoAccountSelector();
		CreatePasscode createPasscode = new CreatePasscode();
		LogOutCardControl Logout = new LogOutCardControl();
		TransferFunds TransferFunds = new TransferFunds();

		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		String env;
		String storedAccount;
		String storedPinOrPassword;
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);

		try {
			androidLogs.setupTestYellow("TRANSFER FUNDS");
			androidLogs.setupTestYellow("PASSCODE CARD");
			getAccount.setEnv(env);
			getAccount.CardPassExpected("PASSCODE");
			cardType = "PASSCODE CARD";

			// Delete passcode in database
			System.out.println(
					"Deleteing CardPin Record from " + getAccount.getMaskedCard() + " from databse prior to login");
			dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='" + getAccount.getAccountNum() + "'");
			// login with temp passcode
			System.out.println("Pin is set to: " + getAccount.getPasswordOrPin());

			System.out.println(phone.autoPhonePickerCard(appName));
			environmentPicker.EnvironmentPickerButton();
			multiCard.MultiCardLoginCheck();
			Login.CardPassExpected(env, getAccount.getAccountNum(), getAccount.getPasswordOrPin(), this.cardType);
			createPasscode.NewPasscode(env);

			System.out.println("Pin before new manual set: " + getAccount.getPasswordOrPin());

			storedAccount = getAccount.getAccountNum();
			storedPinOrPassword = androidText.MANUAL_PASSCODE;

			// Login with newly set card passcode
			// Login.CardPassExpected(env, getAccount.getAccountNum(),
			// androidText.MANUAL_PASSCODE,this.cardType);
			Biometrics.BiometricsAndroid();
			createProfile.ProfileSetup(env);
			TransferFunds.TransferFunds(env, storedAccount, storedPinOrPassword);
			Logout.logoutCardControl();
			androidLogs.CapturedLogs(info, "Logged out");

			Capabilities.driver.closeApp();
			Capabilities.driver.quit();
			androidLogs.CapturedLogs(info, "Transfer funds functional test completed");

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