package SheelFleetNavigatorAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import androidCardClasses.ProgressSpinner;
import androidCardClasses.RepoCardAndroid;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.PhonePicker;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class ShellFleetNavigatorLoginTest {
	static AppiumDriver<WebElement> driver;

	@Test
	public void ShellFleetNavigatorLoginTest() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid();
		PhonePicker phone = new PhonePicker();
		RepoCardAndroid elements = new RepoCardAndroid();
		ScrollOptions scroll = new ScrollOptions();
		ProgressSpinner loading = new ProgressSpinner();

		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;
		String tab;
		String sanFran = "San Francisco, CA, USA";
		String newYork = "New York, NY, USA";
		String ogdenUtah = "Ogden, UT, USA";
		String dallasTexas = "Dallas, TX, USA";
		String pickedLocation;
		String ev22 = "EV22";
		String edge20 = "edge20";
		String carWashOnly = "FIND A LOCTATION FOR THIS";
		String userName = "xomu003";
		String password = "Tester22";
		

		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "Login Test ";
		String build = "Build #:  ";
		String appName = "SHELL FLEET NAVIGATOR ";
		String server = "Stage ";

		try {
			androidLogs.setupTest(TestName + build + appName + server);

			System.out.println(phone.autoPhonePickerSFN(appName));

			Thread.sleep(3000);
			WebElement SmartHubUsernameTextBox = elements.SmartHubUsernameTextBox();
			Thread.sleep(3000);
			if (SmartHubUsernameTextBox != null && SmartHubUsernameTextBox.isEnabled()) {
				SmartHubUsernameTextBox.click();
				SmartHubUsernameTextBox.sendKeys(userName);
				androidLogs.CapturedLogs(pass, "Username Found and addded");
			} else {
				androidLogs.CapturedLogs(info, "Username is not found");
			}

			Thread.sleep(3000);
			WebElement SmartHubPasswordTextBox = elements.SmartHubPasswordTextBox();
			Thread.sleep(3000);
			if (SmartHubPasswordTextBox != null && SmartHubPasswordTextBox.isEnabled()) {
				SmartHubPasswordTextBox.click();
				SmartHubPasswordTextBox.sendKeys(password);
				androidLogs.CapturedLogs(pass, "Password Found and addded");
			} else {
				androidLogs.CapturedLogs(info, "Password is not found");
			}

			Thread.sleep(3000);
			WebElement SmartHubLoginButton = elements.SmartHubLoginButton();
			Thread.sleep(3000);
			if (SmartHubLoginButton != null && SmartHubLoginButton.isEnabled()) {
				SmartHubLoginButton.click();
				androidLogs.CapturedLogs(pass, "Login Button is found and pressed");
			} else {
				androidLogs.CapturedLogs(info, "Login button is not found");
			}

			androidLogs.CapturedLogs(info, " Testing completed");

			Thread.sleep(5000);

			Capabilities.driver.closeApp();
			Capabilities.driver.quit();

			androidLogs.CapturedLogs(info, "Wex Connect open and close app Completed");

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
}