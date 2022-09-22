package cardControlAndroid;

import java.io.IOException;
import java.sql.ResultSet;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCardClasses.CardDirectLoginPass;
import androidCardClasses.CreatePasscode;
import androidCardClasses.CreateProfile;
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

public class UnitTestMultiCard {
	static AppiumDriver<WebElement> driver;
	private String accountNum;
	private String accountType;
	

	//GIVE YOUR TEST THE MANUAL DEFAULT DETAILS IT NEEDS TO RUN ENV IS VITAL TO RUN TEST
	// env IS THE SERVER YOU ARE RUNNING THE TEST ON
	//TestName IS THE NAME OF HTE TEST YOU WANT TO GOVE IT
	// build IS THE BUILD NUMBER ARE USING FROM TESTFLIGHT OR APP TEST
	// appName NAME OF APP BEING TESTED
		
	String TestName = "Unit Test MultiCard ";
	String build = "Build #:  ";
	String appName = "Card Control ";
	String env = "Partner ";


	public void cardControlTestAndroid(String testName, String buildNum, String app, String serverEnv) throws Exception {
		TestName = testName;
		 build = buildNum;
		 appName = app;
		 env = serverEnv;
		 
		cardControlTestAndroid();
	}

	
	

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
		CreateProfile createProfile = new CreateProfile();

//		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

		int timesToRun = 2;
		int runsPerAccount = 5;
		int smashLogin = 0;
		int perAccountLogin = 0;
		String storedAccount;
		String storedPinOrPassword;
		String cardID;
		String env;
		String accountNumber = "1";
		String passwordOrPin = "1";

		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);

	
		try {
			while (smashLogin < timesToRun) {
				
				androidLogs.setupTest(TestName + build + appName +env);
				System.out.println("Times test has run: " + smashLogin);
				androidLogs.setupTest("LOGIN VERIFICATION TEST");

				// FLEET ONE
				perAccountLogin = 0;
				getAccount.setEnv(env);
				accountType = "FLEET ONE CARD";
				// TODO Add database login
				androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				androidLogs.CapturedLogs(info, "Some SQL Statements take a minute to load");
				System.out.println("Some SQL Statements take a minute to load Please Wait");
				ResultSet fleetOneCard = dbACPTCheck.query("infx", String.format(
						"Select * from card_pins where card_num like '501%%' and status = 'A' and valid = 'A' order by set DESC"));

				int fleetOneCardloops = 0;
				while (fleetOneCard.next() && fleetOneCardloops <= smashLogin) {

					// fleetOne.next();
					accountNumber = fleetOneCard.getString("card_num");
					passwordOrPin = fleetOneCard.getString("pin");
					accountNumber = accountNumber.trim();
					cardID = getAccount.getCardID(accountNumber, env);
					androidLogs.CapturedLogs(info, "Card ID located: " + cardID);
					fleetOneCardloops++;

					androidLogs.CapturedLogs(info,
							" #:" + fleetOneCardloops + " Card ID found: " + getAccount.getCardID(accountNumber, env));
					System.out.println(accountType + " #:" + fleetOneCardloops + " Card ID found: " + accountNumber
							+ " Password or Pins found: " + passwordOrPin);
					System.out.println("Smash: " + smashLogin);
				}

				storedAccount = accountNumber;
				storedPinOrPassword = passwordOrPin;
				getAccount.getAndFixCardStatus(accountNumber, env, accountType);
				System.out.println("Active account: " + accountNumber + " Password found: " + passwordOrPin);
				cardID = getAccount.getCardID(accountNumber, env);

				while (perAccountLogin < runsPerAccount) {
					androidLogs.setupTestYellow(accountType + " " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.accountType);
					Biometrics.BiometricsAndroid();
					createProfile.ProfileSetup(env);
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.accountType);
					Thread.sleep(3000);
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);

					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				// COMPANY CARD
				perAccountLogin = 0;
				getAccount.setEnv(env);
				accountType = "COMPANY CARD";
				androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				androidLogs.CapturedLogs(info, "Some SQL Statements take a minute to load");
				System.out.println("Some SQL Statements take a minute to load Please Wait");
				ResultSet companyCard = dbACPTCheck.query("infx", String.format(
						"select cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'N' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' and c.dynamic_pin_flag = 'N' order by c.lastupdated desc"));

				int companyCardloops = 0;
				while (companyCard.next() && companyCardloops <= smashLogin) {
					accountNumber = companyCard.getString("card_num");
					passwordOrPin = companyCard.getString("pin");
					accountNumber = accountNumber.trim();
					cardID = getAccount.getCardID(accountNumber, env);
					androidLogs.CapturedLogs(info, "Card ID located: " + cardID);
					companyCardloops++;

					androidLogs.CapturedLogs(info,
							" #:" + companyCardloops + " Card ID found: " + getAccount.getCardID(accountNumber, env));
					System.out.println(accountType + " #:" + companyCardloops + " Account found: " + accountNumber
							+ " Password or Pins found: " + passwordOrPin);
					System.out.println("Smash: " + smashLogin);
				}

				storedAccount = accountNumber;
				storedPinOrPassword = passwordOrPin;
				getAccount.getAndFixCardStatus(accountNumber, env, accountType);
				System.out.println("Active account: " + accountNumber + " Password found: " + passwordOrPin);
				cardID = getAccount.getCardID(accountNumber, env);

				while (perAccountLogin < runsPerAccount) {
					androidLogs.setupTestYellow(accountType + " " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.accountType);
					Biometrics.BiometricsAndroid();
					createProfile.ProfileSetup(env);
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.accountType);
					Thread.sleep(3000);
					Capabilities.driver.closeApp();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					perAccountLogin++;
					androidLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
				}

				// SMARTFUNDS CARD
				perAccountLogin = 0;
				getAccount.setEnv(env);
				accountType = "SMARTFUNDS CARD";
				androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				androidLogs.CapturedLogs(info, "Some SQL Statements take a minute to load");
				System.out.println("Some SQL Statements take a minute to load Please Wait");
				ResultSet smartFundsCard = dbACPTCheck.query("infx", String.format(
						"select cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'P' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' and cp.pin <> 'NULL' and c.card_type <> 'MCFL' order by c.lastupdated desc"));

				int smartFundsCardloops = 0;
				while (smartFundsCard.next() && smartFundsCardloops <= smashLogin) {
					accountNumber = smartFundsCard.getString("card_num");
					passwordOrPin = smartFundsCard.getString("pin");
					accountNumber = accountNumber.trim();
					cardID = getAccount.getCardID(accountNumber, env);
					androidLogs.CapturedLogs(info, "Card ID located: " + cardID);
					smartFundsCardloops++;

					androidLogs.CapturedLogs(info, " #:" + smartFundsCardloops + " Card ID found: "
							+ getAccount.getCardID(accountNumber, env));
					System.out.println(accountType + " #:" + smartFundsCardloops + " Account found: " + accountNumber
							+ " Password or Pins found: " + passwordOrPin);
					System.out.println("Smash: " + smashLogin);
				}

				storedAccount = accountNumber;
				storedPinOrPassword = passwordOrPin;
				getAccount.getAndFixCardStatus(accountNumber, env, accountType);
				System.out.println("Active account: " + accountNumber + " Password found: " + passwordOrPin);
				cardID = getAccount.getCardID(accountNumber, env);

				while (perAccountLogin < runsPerAccount) {
					androidLogs.setupTestYellow(accountType + " " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.accountType);
					Biometrics.BiometricsAndroid();
					createProfile.ProfileSetup(env);
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.accountType);
					perAccountLogin++;
					Thread.sleep(3000);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					androidLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);
				}

				// UNIVERSAL CARD
				perAccountLogin = 0;
				getAccount.setEnv(env);
				accountType = "UNIVERSAL CARD";
				androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				androidLogs.CapturedLogs(info, "Some SQL Statements take a minute to load");
				ResultSet universalCard = dbACPTCheck.query("infx", String.format(
						"select cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'B' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A'order by c.lastupdated desc"));

				int universalCardLoops = 0;
				while (universalCard.next() && universalCardLoops <= smashLogin) {
					accountNumber = universalCard.getString("card_num");
					passwordOrPin = universalCard.getString("pin");
					accountNumber = accountNumber.trim();
					cardID = getAccount.getCardID(accountNumber, env);
					androidLogs.CapturedLogs(info, "Card ID located: " + cardID);
					universalCardLoops++;

					androidLogs.CapturedLogs(info,
							" #:" + universalCardLoops + " Card ID found: " + getAccount.getCardID(accountNumber, env));
					System.out.println(accountType + " #:" + universalCardLoops + " Account found: " + accountNumber
							+ " Password or Pins found: " + passwordOrPin);
					System.out.println("Smash: " + smashLogin);
				}

				storedAccount = accountNumber;
				storedPinOrPassword = passwordOrPin;
				getAccount.getAndFixCardStatus(accountNumber, env, accountType);
				System.out.println("Active account: " + accountNumber + " Password found: " + passwordOrPin);
				cardID = getAccount.getCardID(accountNumber, env);

				while (perAccountLogin < runsPerAccount) {
					androidLogs.setupTestYellow(accountType + " " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.accountType);
					Biometrics.BiometricsAndroid();
					createProfile.ProfileSetup(env);
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.accountType);
					perAccountLogin++;
					Thread.sleep(3000);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					androidLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);
				}

				// PASSCODE Card (this comes from turning on dynamic pin)
				perAccountLogin = 0;
				Thread.sleep(3000);
				androidLogs.setupTestYellow("PASSCODE CARD");
				getAccount.setEnv(env);
				accountType = "PASSCODE CARD";
				androidLogs.setupTestYellow("LOCATING " + accountType + " ON: " + env);
				androidLogs.CapturedLogs(info, "Some SQL Statements take a minute to load");
				ResultSet passcodeCard = dbACPTCheck.query("infx", String.format(
						"select cp.card_num, cp.pin, cp.* from cards c, card_pins cp where c.card_num = cp.card_num and cp.status = 'A'and cp.valid in ('A','Y') and c.status = 'A'and cp.passcode_enabled_flag = 'Y'and c.dynamic_pin_flag = 'Y' order by cp.passcode_set_date desc"));

				int passcodeCardLoops = 0;
				while (passcodeCard.next() && passcodeCardLoops <= smashLogin) {
					accountNumber = passcodeCard.getString("card_num");
					accountNumber = accountNumber.trim();
					cardID = getAccount.getCardID(accountNumber, env);
					androidLogs.CapturedLogs(info, "Card ID located: " + cardID);
					passcodeCardLoops++;

					String newPasscodeCardPasscode = accountNumber.substring(accountNumber.length() - 6);
					passwordOrPin = newPasscodeCardPasscode;

					androidLogs.CapturedLogs(info,
							" #:" + passcodeCardLoops + " Card ID found: " + getAccount.getCardID(accountNumber, env));
					System.out.println(accountType + " #:" + passcodeCardLoops + " Account found: " + accountNumber
							+ " Password or Pins found: " + passwordOrPin);
					System.out.println("Smash: " + smashLogin);
				}

				storedAccount = accountNumber;
				storedPinOrPassword = passwordOrPin;
				System.out.println("Active account: " + accountNumber + " Password found: " + passwordOrPin);
				cardID = getAccount.getCardID(accountNumber, env);

				// Delete passcode in database
				System.out.println("Deleteing CardPin Record from " + getAccount.getCardID(accountNumber, env)
						+ " from databse prior to login");
				dbACPTCheck.execute("infx", "Delete from card_pins where card_num ='" + accountNumber + "'");
				// login with temp passcode
				System.out.println("Pin is set to: " + storedPinOrPassword);
				System.out.println(phone.autoPhonePickerCard(appName));
				environmentPicker.EnvironmentPickerButton();
				multiCard.MultiCardLoginCheck();
				Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.accountType);
				createPasscode.NewPasscode(env);
				Biometrics.BiometricsAndroid();
				createProfile.ProfileSetup(env);
				helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.accountType);
				Thread.sleep(3000);
				storedPinOrPassword = androidText.MANUAL_PASSCODE;
				Capabilities.driver.closeApp();
				androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");

				while (perAccountLogin < runsPerAccount) {
					androidLogs.setupTestYellow(accountType + " " + cardID + " LOGIN CYCLE #: " + perAccountLogin);
					System.out.println(phone.autoPhonePickerCard(appName));
					environmentPicker.EnvironmentPickerButton();
					multiCard.MultiCardLoginCheck();
					Login.CardPassExpected(env, storedAccount, storedPinOrPassword, this.accountType);
					Biometrics.BiometricsAndroid();
					createProfile.ProfileSetup(env);
					helpScreen.HelpScreenContinueRequired(env, storedAccount, storedPinOrPassword, this.accountType);
					perAccountLogin++;
					Thread.sleep(3000);
					Capabilities.driver.closeApp();
					Capabilities.driver.quit();
					androidLogs.CapturedLogs(info, "APP KILLED FOR NEXT LOGIN");
					androidLogs.setupTestYellow("LOGIN " + accountType + " COMPLETED COUNT #: " + perAccountLogin);
				}

				smashLogin++;
				androidLogs.CapturedLogs(info, "ALL LOGIN COUNT #: " + smashLogin);

			}
			androidLogs.CapturedLogs(info, "LOGIN TESTS COMPLETED WITH: " + smashLogin + " CYCLES");
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
		this.accountNum = cardNumNow;
		System.out.println("SET Card Number: " + accountNum);
	}

	public String getCardNum() {
		System.out.println("GET Card number: " + accountNum);
		return accountNum;
	}
}