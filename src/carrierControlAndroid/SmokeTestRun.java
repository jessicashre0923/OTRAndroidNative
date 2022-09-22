package carrierControlAndroid;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import androidCarrierClasses.OpenAndLoginCarrierControl;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import functionalTestsCarrierControlAndroid.AccountTabRun;
import functionalTestsCarrierControlAndroid.BillingTabRun;
import functionalTestsCarrierControlAndroid.CardsTabRun;
import functionalTestsCarrierControlAndroid.CompanyCardOverviewRun;
import functionalTestsCarrierControlAndroid.ManageYourProfileRun;
import functionalTestsCarrierControlAndroid.MoneyCodesRun;
import functionalTestsCarrierControlAndroid.QuickLoginLogoutRun;
import functionalTestsCarrierControlAndroid.RejectsTabRun;
import functionalTestsCarrierControlAndroid.SmartFundsCardOverviewRun;
import functionalTestsCarrierControlAndroid.TransferToBankRun;
import functionalTestsCarrierControlAndroid.UniversalCardOverviewRun;
import io.appium.java_client.AppiumDriver;

public class SmokeTestRun {

	static AppiumDriver<WebElement> driver;

//	public static void main(String[] args) throws Exception {
//		System.out.println("Test Info " + "------Test--------Running using Java----------");
//		carrierControlTestAndroid();
//	}

	@Test
	public static void carrierControlTestAndroid() throws Exception {
		AndroidLogs androidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid();
		AccountTabRun accountTabRun = new AccountTabRun();
		BillingTabRun billingTabRun = new BillingTabRun();
		CardsTabRun cardsTabRun = new CardsTabRun();
		ManageYourProfileRun manageYourProfileRun = new ManageYourProfileRun();
		MoneyCodesRun moneyCodesRun = new MoneyCodesRun();
		QuickLoginLogoutRun quickLoginLogoutRun = new QuickLoginLogoutRun();
		RejectsTabRun rejectsTabRun = new RejectsTabRun();
		TransferToBankRun transferToBankRun = new TransferToBankRun();
		CompanyCardOverviewRun companyCardOverviewRun = new CompanyCardOverviewRun();
		SmartFundsCardOverviewRun smartFundsCardOverviewRun = new SmartFundsCardOverviewRun();
		UniversalCardOverviewRun universalCardOverviewRun = new UniversalCardOverviewRun();
		OpenAndLoginCarrierControl OpenAndLoginCarrierControl = new OpenAndLoginCarrierControl();

//		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

		// BUILD IS THE ONE YOU ARE USING FROM TESTFLIGHT OR APP TEST
		// APPNAME NAME OF APP BEING TESTED
		// SERVER IS THE SERVER YOU ARE RUNNING THE TEST ON

		String TestName = "Smoke Test ";
		String build = "Build #:  ";
		String appName = "Carrier Control ";
		String server = "AWS DIT ";

		try {
			androidLogs.setupTest(TestName + build + appName +server);
			
			
			androidLogs.setupTestYellow("*ACCOUNT TAB TESTS*");
			accountTabRun.carrierControlTestAndroidLoginLogout();

			androidLogs.setupTestYellow("*BILLING TAB TESTS*");
			billingTabRun.carrierControlTestAndroidLoginLogout();

			androidLogs.setupTestYellow("*CARDS TAB TESTS*");
			cardsTabRun.carrierControlTestAndroidLoginLogout();

			androidLogs.setupTestYellow("*LOGIN SCENARIOS TESTS*");
			OpenAndLoginCarrierControl.openCarrierControl();

			androidLogs.setupTestYellow("*MANAGE YOUR PROFILE TESTS*");
			manageYourProfileRun.carrierControlTestAndroidLoginLogout();

			androidLogs.setupTestYellow("*MONEY CODES TESTS*");
			moneyCodesRun.carrierControlTestAndroidLoginLogout();

			androidLogs.setupTestYellow("*QUICK LOGIN LOGOUT TESTS*");
			quickLoginLogoutRun.carrierControlTestAndroidLoginLogout();

			androidLogs.setupTestYellow("*REJECTS TAB TESTS*");
			rejectsTabRun.carrierControlTestAndroidLoginLogout();

			androidLogs.setupTestYellow("*COMPANY CARD OVERVIEW TESTS*");
			companyCardOverviewRun.carrierControlTestAndroidLoginLogout();

			androidLogs.setupTestYellow("*SMART FUNDS CARD OVERVIEW TESTS*");
			smartFundsCardOverviewRun.carrierControlTestAndroidLoginLogout();

			androidLogs.setupTestYellow("*UNIVERSAL CARD OVERVIEW TESTS*");
			universalCardOverviewRun.carrierControlTestAndroidLoginLogout();

			androidLogs.setupTestYellow("*TRANSFER TO BANK TESTS*");
			transferToBankRun.carrierControlTestAndroidLoginLogout();
			androidLogs.CapturedLogs(info, "SMOKE TEST Carrier Control Completed");

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