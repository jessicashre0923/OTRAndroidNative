package androidCarrierClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.Sleep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class WelcomeScreen{
	AndroidLogs androidLogs = new AndroidLogs();
	Sleep appSleep = new Sleep();
	RepoCarrierAndroid elements = new RepoCarrierAndroid();
	AppStringsAndroid androidText = new AppStringsAndroid();

	static AppiumDriver<WebElement> driver;
	// static WebDriver driverWeb;
	OpenAndLoginCarrierControl reopenApp = new OpenAndLoginCarrierControl();

	public WelcomeScreen welomeScreen() throws Exception {
		androidLogs.setupTest("WELCOME SCREEN");
		try {
			
			Thread.sleep(2000);
			if (elements.WelcomeScreen().isEnabled()) {
				int welcomeScreen = 0;
				while (welcomeScreen < 3) {
					androidLogs.CapturedLogs(androidText.PASS, "Welcome screen is seen.");
					// this is the long press move to new location on screen needed for screen
					new TouchAction<>(Capabilities.driver).longPress(PointOption.point(1000, 1390)).moveTo(PointOption.point(60, 1390)).release().perform();
					androidLogs.CapturedLogs(androidText.PASS, "Welcome screen swiped through");
					appSleep.ThreadSleep1();
					welcomeScreen++;
				}
				
				Thread.sleep(2000);
				WebElement getStarted = elements.getStarted();

				if (getStarted!=null && getStarted.isDisplayed()) {
					getStarted.click();
					androidLogs.CapturedLogs(androidText.PASS, "Get started clicked");
				}
			} else {
				androidLogs.CapturedLogs(androidText.INFO,"Welcome screen is not seen or has been closed on prior run");
				System.out.println("Welcome screen is not seen or has been closed on prior run");
			}
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println(e.getMessage());
			androidLogs.CapturedLogs(androidText.INFO, "Welcome screen is not seen or has been closed on prior run");
			System.out.println("Welcome screen is not seen or has been closed on prior run");

		}

		return this;
	}
}
