package androidSharedClasses;

import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import androidCarrierClasses.LocalConfiguration;
import io.appium.java_client.AppiumDriver;

public class Capabilities {
	public static AppiumDriver<WebElement> driver;
	// static AppiumDriver<WebElement> iphone7;
	// static RemoteWebDriver driver = null;

	public static String phoneID = "No Phone";
	public static String appName = "No App";
	public static AndroidLogs androidLogs = new AndroidLogs();
	public static AppStringsAndroid androidText = new AppStringsAndroid();
	public static String pass = androidText.PASS;
	public static String fail = androidText.FAIL;
	public static String info = androidText.INFO;

	// public int multiPhone = 0;

	public static String AppName() {

		return appName;
	}

	public static String phoneID() {

		return phoneID;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	// Carrier Control Phone Capabilities

	public static void capabilitiesCarrierControlPixel2(String appName) throws Exception {
		try {
			phoneID = "Android Pixel2";
			androidLogs.CapturedLogs(info, "Finding Device capabilities");
			DesiredCapabilities cap = new DesiredCapabilities();
			LocalConfiguration Pixel2Config = new LocalConfiguration("Pixel2.properties");

			cap.setCapability("deviceName", Pixel2Config.getConfigurationValue("deviceName"));
			// cap.setCapability("udid", Pixel2Config.getConfigurationValue("udid"));
			cap.setCapability("udid", "HT78P1A00130");
			cap.setCapability("platformName", Pixel2Config.getConfigurationValue("platformName"));
			cap.setCapability("platformVersion", Pixel2Config.getConfigurationValue("platformVersion"));
			cap.setCapability("noReset", Pixel2Config.getConfigurationValue("noReset"));
			// App capabilities
			cap.setCapability("noReset", false);
			cap.setCapability("usePrebuiltWDA", Pixel2Config.getConfigurationValue("usePrebuiltWDA"));
			// Device capabilities
			// App capabilities

			LocalConfiguration AndroidCarrierControlConfig = new LocalConfiguration(
					"Android_CarrierControl_Capabilities.properties");
			cap.setCapability("appPackage", AndroidCarrierControlConfig.getConfigurationValue("appPackage"));
			cap.setCapability("appActivity", AndroidCarrierControlConfig.getConfigurationValue("appActivity"));
			cap.setCapability("appWaitDuration", AndroidCarrierControlConfig.getConfigurationValue("appWaitDuration"));
			cap.setCapability("newCommandTimeout", 60 * 5);
			// app open in appium

			androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
			driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

			// shows it ran through here

			System.out.println("Ran through PhoneCap");

			// App sleep and display

			Thread.sleep(1); // put to sleep to load next automation.
			System.out.println("Sleep succesfull");
			androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);

		} catch (InterruptedException e) {
			System.out.println("Phone not found");
		}
	}

	public static void capabilitiesCarrierControlEM7(String appName) throws Exception {
		phoneID = "Galaxy Note 20 Ultra";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("BROWSER_NAME", "chrome");
		// cap.setCapability("autoWebview", false);
		// cap.setCapability("avd", "AndroidTestDevice");
		cap.setCapability("chromedriverDisableBuildCheck", false);
		cap.setCapability("deviceName", "Galaxy Note 20 Ultra");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "11.0");
		cap.setCapability("autoGrantPermission", true);
		cap.setCapability("automationName", "appium");
	
		cap.setCapability("noReset", false);
		cap.setCapability("usePrebuiltWDA", true);
		// App capabilities

		cap.setCapability("appPackage", "com.efsllc.efscarriercontrol.stage");
		cap.setCapability("appActivity", "com.wex.carriercontrol.view.MainActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);
		// app open in appium

		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efsllc.efscarriercontrol.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");
		// scrcpy does not work with emulators
		// record.StartGalaxyS7Recorder(null);
		// App sleep and display

		Thread.sleep(1); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

	public static void capabilitiesCarrierControlEM10(String appName) throws Exception {
		phoneID = "Android EM10";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();
		// AndroidRecorder record = new AndroidRecorder();
		// Device capabilities

		// cap.setCapability("BROWSER_NAME", "chrome");
		// cap.setCapability("autoWebview", false);
		// cap.setCapability("avd", "AndroidTestDevice");
		// cap.setCapability("chromedriverDisableBuildCheck", false);
		cap.setCapability("deviceName", "Emulator Android 10.0");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "10.0");
		cap.setCapability("autoGrantPermission", true);
		cap.setCapability("automationName", "appium");
		cap.setCapability("noReset", false);
		// App capabilities

		cap.setCapability("appPackage", "com.efsllc.efscarriercontrol.stage");
		cap.setCapability("appActivity", "com.wex.carriercontrol.view.MainActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);
		// app open in appium

		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efsllc.efscarriercontrol.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");
		// scrcpy does not work with emulators
		// record.StartGalaxyS7Recorder(null);
		// App sleep and display

		Thread.sleep(1); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

	public static void capabilitiesCarrierControlEM11(String appName) throws Exception {
		phoneID = "Android EM11";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();
		// AndroidRecorder record = new AndroidRecorder();
		// Device capabilities

		// cap.setCapability("BROWSER_NAME", "chrome");
		// cap.setCapability("autoWebview", false);
		// cap.setCapability("avd", "AndroidTestDevice");
		// cap.setCapability("chromedriverDisableBuildCheck", false);
		cap.setCapability("deviceName", "Emulator Android 11.0");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "11.0");
		cap.setCapability("autoGrantPermission", true);
		cap.setCapability("automationName", "appium");
		cap.setCapability("noReset", false);
		// App capabilities

		cap.setCapability("appPackage", "com.efsllc.efscarriercontrol.stage");
		cap.setCapability("appActivity", "com.wex.carriercontrol.view.MainActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);
		// app open in appium

		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efsllc.efscarriercontrol.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");
		// scrcpy does not work with emulators
		// record.StartGalaxyS7Recorder(null);
		// App sleep and display

		Thread.sleep(1); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	// Card Control Phone Capabilities

	public static void capabilitiesCardControlPixel2(String appName) throws Exception {
		phoneID = "Pixel 2";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();

		// Device capabilities
		// cap.setCapability("BROWSER_NAME", "chrome");
		cap.setCapability("deviceName", "Pixel 2");
		cap.setCapability("udid", "HT78P1A00130");
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "9.0");
		cap.setCapability("automationName", "appium");

		// App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.efsllc.efsmobileapp.stage");
		cap.setCapability("appActivity", "com.efsllc.efsmobileapp.view.splash.SplashActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);

		// app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efsllc.efsmobileapp.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");

		// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

	public static void capabilitiesCardControlGN20(String appName) throws Exception {
		phoneID = "Galaxy Note 20 Ultra";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("BROWSER_NAME", "chrome");
		// cap.setCapability("autoWebview", false);
		// cap.setCapability("avd", "AndroidTestDevice");
		cap.setCapability("chromedriverDisableBuildCheck", false);
		cap.setCapability("deviceName", "GalaxyNote20Ultra");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "11.0");
		cap.setCapability("autoGrantPermission", true);
		cap.setCapability("automationName", "appium");

		// App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.efsllc.efsmobileapp.stage");
		cap.setCapability("appActivity", "com.efsllc.efsmobileapp.view.splash.SplashActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);

		// app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efs.EFS-MWA-Driver.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");

		// appName = "Card Control";
		// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);

	}

	public static void capabilitiesCardControlEM10(String appName) throws Exception {
		phoneID = "Android EM10";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("BROWSER_NAME", "chrome");
		// cap.setCapability("autoWebview", false);
		// cap.setCapability("avd", "AndroidTestDevice");
		cap.setCapability("chromedriverDisableBuildCheck", false);
		cap.setCapability("deviceName", "Emulator Android 10.0");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "10.0");
		cap.setCapability("autoGrantPermission", true);
		cap.setCapability("automationName", "Appium");

		// App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.efsllc.efsmobileapp.stage");
		cap.setCapability("appActivity", "com.efsllc.efsmobileapp.view.splash.SplashActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);

		// app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efs.EFS-MWA-Driver.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");

		// appName = "Card Control";

		// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);

	}

	public static void capabilitiesCardControlEM11(String appName) throws Exception {
		phoneID = "Android EM11";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("BROWSER_NAME", "chrome");
		// cap.setCapability("autoWebview", false);
		// cap.setCapability("avd", "AndroidTestDevice");
		cap.setCapability("chromedriverDisableBuildCheck", false);
		cap.setCapability("deviceName", "Emulator Android 11.0");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "11.0");
		cap.setCapability("autoGrantPermission", true);
		cap.setCapability("automationName", "Appium");

		// App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.efsllc.efsmobileapp.stage");
		cap.setCapability("appActivity", "com.efsllc.efsmobileapp.view.splash.SplashActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);

		// app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efs.EFS-MWA-Driver.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");

		// appName = "Card Control";

		// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	// Wex Connect Phone Capabilities

	public static void capabilitiesWexConnectPixel2(String appName) throws Exception {
		phoneID = "Pixel 2";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();

		// Device capabilities
		// cap.setCapability("BROWSER_NAME", "chrome");
		cap.setCapability("deviceName", "Pixel 2");
		cap.setCapability("udid", "HT78P1A00130");
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "9.0");
		cap.setCapability("automationName", "appium");

		// App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.wex.octane.stage");
		cap.setCapability("appActivity", "com.wex.octane.main.spash.SplashActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);

		// app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efsllc.efsmobileapp.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");
		// appName = "Wex Connect";

		// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

	public static void capabilitiesWexConnectEM7(String appName) throws Exception {
		phoneID = "Android EM7";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("BROWSER_NAME", "chrome");
		// cap.setCapability("autoWebview", false);
		// cap.setCapability("avd", "AndroidTestDevice");
		cap.setCapability("chromedriverDisableBuildCheck", false);
		cap.setCapability("deviceName", "Emulator Android 7.1.1");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "7.1.1");
		cap.setCapability("autoGrantPermission", true);
		cap.setCapability("automationName", "appium");

		// App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.wex.octane.stage");
		cap.setCapability("appActivity", "com.wex.octane.main.spash.SplashActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);

		// app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efs.EFS-MWA-Driver.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");

		// appName = "Wex Connect";

		// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

	public static void capabilitiesWexConnectEM10(String appName) throws Exception {
		phoneID = "Android EM10";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("BROWSER_NAME", "chrome");
		// cap.setCapability("autoWebview", false);
		// cap.setCapability("avd", "AndroidTestDevice");
		cap.setCapability("chromedriverDisableBuildCheck", false);
		cap.setCapability("deviceName", "Emulator Android 10.0");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "10.0");
		cap.setCapability("autoGrantPermission", true);
		cap.setCapability("automationName", "Appium");

		// App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.wex.octane.stage");
		cap.setCapability("appActivity", "com.wex.octane.main.spash.SplashActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);

		// app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efs.EFS-MWA-Driver.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");

		// appName = "Wex Connect";

		// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

	public static void capabilitiesWexConnectEM11(String appName) throws Exception {
		phoneID = "Android EM11";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("BROWSER_NAME", "chrome");
//cap.setCapability("autoWebview", false);
//cap.setCapability("avd", "AndroidTestDevice");
		cap.setCapability("chromedriverDisableBuildCheck", false);
		cap.setCapability("deviceName", "Emulator Android 11.0");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "11.0");
		cap.setCapability("autoGrantPermission", true);
		cap.setCapability("automationName", "Appium");

// App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.wex.octane.stage");
		cap.setCapability("appActivity", "com.wex.octane.main.spash.SplashActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);

// app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

//driver.context("WEBVIEW_com.efs.EFS-MWA-Driver.test");

// shows it ran through here
		System.out.println("Ran through PhoneCap");

//appName = "Wex Connect";

// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	// SMART HUB Phone Capabilities

	public static void capabilitiesSmartHubPixel2(String appName) throws Exception {
		phoneID = "Pixel 2";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");

		DesiredCapabilities cap = new DesiredCapabilities();
		// Device capabilities
		// cap.setCapability("BROWSER_NAME", "chrome");
		cap.setCapability("deviceName", "Pixel 2");
		cap.setCapability("udid", "HT78P1A00130");
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "9.0");
		cap.setCapability("automationName", "appium");
		// App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.wex.fleetsmarthub.stage");
		cap.setCapability("appActivity", "com.wex.fleetsmarthub.ui.login.LoginActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);

		// app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);

		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efsllc.efsmobileapp.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");
		// appName = "SmartHub";
		phoneID = "Pixel 2";

		// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

	public static void capabilitiesSmartHubEM7(String appName) throws Exception {
		phoneID = "Android EM7";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("BROWSER_NAME", "chrome");
		// cap.setCapability("autoWebview", false);
		// cap.setCapability("avd", "AndroidTestDevice");
		cap.setCapability("chromedriverDisableBuildCheck", false);
		cap.setCapability("deviceName", "Emulator Android 7.1.1");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "7.1.1");
		cap.setCapability("autoGrantPermission", true);
		cap.setCapability("automationName", "appium");

		// App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.wex.fleetsmarthub.stage");
		cap.setCapability("appActivity", "com.wex.fleetsmarthub.ui.login.LoginActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);

		// app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efs.EFS-MWA-Driver.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");

		appName = "SmartHub";
		phoneID = "Virtual Nexus 6";
		// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

	public static void capabilitiesSmartHubEM10(String appName) throws Exception {
		phoneID = "Android EM10";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("BROWSER_NAME", "chrome");
		// cap.setCapability("autoWebview", false);
		// cap.setCapability("avd", "AndroidTestDevice");
		cap.setCapability("chromedriverDisableBuildCheck", false);
		cap.setCapability("deviceName", "Emulator Android 10.0");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "10.0");
		cap.setCapability("autoGrantPermission", true);
		cap.setCapability("automationName", "Appium");

		// App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.wex.fleetsmarthub.stage");
		cap.setCapability("appActivity", "com.wex.fleetsmarthub.ui.login.LoginActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);

		// app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efs.EFS-MWA-Driver.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");

		// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

	public static void capabilitiesSmartHubEM11(String appName) throws Exception {
		phoneID = "Android EM11";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("BROWSER_NAME", "chrome");
//cap.setCapability("autoWebview", false);
//cap.setCapability("avd", "AndroidTestDevice");
		cap.setCapability("chromedriverDisableBuildCheck", false);
		cap.setCapability("deviceName", "Emulator Android 11.0");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "11.0");
		cap.setCapability("autoGrantPermission", true);
		cap.setCapability("automationName", "Appium");

//App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.wex.fleetsmarthub.stage");
		cap.setCapability("appActivity", "com.wex.fleetsmarthub.ui.login.LoginActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);

//app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

//driver.context("WEBVIEW_com.efs.EFS-MWA-Driver.test");

//shows it ran through here
		System.out.println("Ran through PhoneCap");

//App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	// SHELL FLEET NAVIGATOR HUB Phone Capabilities

	public static void capabilitiesSFNPixel2(String appName) throws Exception {
		phoneID = "Pixel 2";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();

		// Device capabilities
		// cap.setCapability("BROWSER_NAME", "chrome");
		cap.setCapability("deviceName", "Pixel 2");
		cap.setCapability("udid", "HT78P1A00130");
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "9.0");
		cap.setCapability("automationName", "appium");

		// App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.wex.shellfleetnavigator.stage");
		cap.setCapability("appActivity", "com.wex.shellfleetnavigator.ui.login.LoginActivity");
		cap.setCapability("appWaitDuration", "20000");
		cap.setCapability("newCommandTimeout", 60 * 5);

		// app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efsllc.efsmobileapp.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");

		// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

	public static void capabilitiesSFNEM7(String appName) throws Exception {
		phoneID = "Android EM7";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("BROWSER_NAME", "chrome");
		// cap.setCapability("autoWebview", false);
		// cap.setCapability("avd", "AndroidTestDevice");
		cap.setCapability("chromedriverDisableBuildCheck", false);
		cap.setCapability("deviceName", "Emulator Android 7.1.1");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "7.1.1");
		cap.setCapability("autoGrantPermission", true);
		cap.setCapability("automationName", "appium");

		// App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.wex.shellfleetnavigator.stage");
		cap.setCapability("appActivity", "com.wex.shellfleetnavigator.ui.login.LoginActivity");
		cap.setCapability("appWaitDuration", "3000");
		cap.setCapability("newCommandTimeout", 60 * 5);

		// app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efs.EFS-MWA-Driver.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");

		// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

	public static void capabilitiesSFNEM10(String appName) throws Exception {
		phoneID = "Android EM10";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("BROWSER_NAME", "chrome");
		// cap.setCapability("autoWebview", false);
		// cap.setCapability("avd", "AndroidTestDevice");
		cap.setCapability("chromedriverDisableBuildCheck", false);
		cap.setCapability("deviceName", "Emulator Android 10.0");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "10.0");
		cap.setCapability("autoGrantPermission", true);
		cap.setCapability("automationName", "Appium");

		// App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.wex.shellfleetnavigator.stage");
		cap.setCapability("appActivity", "com.wex.shellfleetnavigator.ui.login.LoginActivity");
		cap.setCapability("appWaitDuration", "3000");
		cap.setCapability("newCommandTimeout", 60 * 5);

		// app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

		// driver.context("WEBVIEW_com.efs.EFS-MWA-Driver.test");

		// shows it ran through here
		System.out.println("Ran through PhoneCap");

		// App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

	public static void capabilitiesSFNEM11(String appName) throws Exception {
		phoneID = "Android EM11";
		androidLogs.CapturedLogs(info, "Finding Device capabilities");
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("BROWSER_NAME", "chrome");
//cap.setCapability("autoWebview", false);
//cap.setCapability("avd", "AndroidTestDevice");
		cap.setCapability("chromedriverDisableBuildCheck", false);
		cap.setCapability("deviceName", "Emulator Android 11.0");
		cap.setCapability("platformName", "Android");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformVersion", "11.0");
		cap.setCapability("autoGrantPermission", true);
		cap.setCapability("automationName", "Appium");

//App capabilities
		cap.setCapability("noReset", false);
		cap.setCapability("appPackage", "com.wex.shellfleetnavigator.stage");
		cap.setCapability("appActivity", "com.wex.shellfleetnavigator.ui.login.LoginActivity");
		cap.setCapability("appWaitDuration", "3000");
		cap.setCapability("newCommandTimeout", 60 * 5);

//app open in appium
		androidLogs.CapturedLogs(info, "Trying to open " + appName + " on " + phoneID);
		driver = new AppiumDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);

//driver.context("WEBVIEW_com.efs.EFS-MWA-Driver.test");

//shows it ran through here
		System.out.println("Ran through PhoneCap");

//App sleep and display
		cap.setCapability("appWaitDuration", "3000");
		Thread.sleep(3000); // put to sleep to load next automation.
		System.out.println("Sleep succesfull");
		androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
	}

}
