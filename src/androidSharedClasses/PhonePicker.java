package androidSharedClasses;

import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;

public class PhonePicker {
	Sleep appSleep = new Sleep();
	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new AppStringsAndroid();
	static AppiumDriver<WebElement> driver;

	public static String phoneID = "No Phone";
	public static String appName = "No App";
	// public int multiPhone = 0;

	public static String AppName() {

		return appName;
	}

	public static String PhoneID() {

		return phoneID;
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	// Carrier Control Phone Capabilities
	public String autoPhonePickerCarrier(String appName) throws Exception {
		androidLogs.setupTestYellow("Phone Picker");
		AppStringsAndroid androidText = new AppStringsAndroid();
		try {
			Capabilities.capabilitiesCarrierControlPixel2(appName);
//			appName = "Carrier_Control";
			phoneID = "Pixel 2";
			
//			androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
			return appName +" started on " + phoneID;
			

		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Checking Phone: Pixel 2 Not Plugged in.");

		}

		try {

			Capabilities.capabilitiesCarrierControlEM7(appName);
//			appName = "Carrier Control";
			phoneID = "Emulator Device Android";
//			androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
			return appName +" started on " + phoneID;

		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Checking Phone: Virtual Nexus 6 Not Plugged in.");

		}

		try {

			Capabilities.capabilitiesCarrierControlEM10(appName);
//			appName = "Carrier Control";
			phoneID = "Emulator Device Android";
//			androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
			return appName +" started on " + phoneID;

		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Checking Phone: Virtual Nexus 6 Not Plugged in.");

		}

		try {

			Capabilities.capabilitiesCarrierControlEM11(appName);
//			appName = "Carrier Control";
			phoneID = "Emulator Device Android";
//			androidLogs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
			return appName +" started on " + phoneID;

		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Checking Phone: Virtual Nexus 6 Not Plugged in.");

		}

		return "Carrier Control no devices found";
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	// Card Control Phone Capabilities

	public String autoPhonePickerCard(String appName) throws Exception {
		androidLogs.setupTestYellow("Phone Picker");
		AppStringsAndroid androidText = new AppStringsAndroid();
		AndroidLogs logs = new AndroidLogs();
		// find first device found connected as uses it for automation.

		try {

			Capabilities.capabilitiesCardControlPixel2(appName);
//			appName = "Card Control";
			phoneID = "Pixel 2";

//			logs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
			return appName +" started on " + phoneID;

		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Checking Phone: Pixel 2 Not Plugged in.");

		}
		try {

			Capabilities.capabilitiesCardControlGN20(appName);
//			appName = "Card Control";
			phoneID = "Galaxy Note 20 Emulator";
//			logs.CapturedLogs(androidText.INFO, appName+ " running on " + PhoneID().toString());
			return appName +" started on " + phoneID;

		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Checking Phone: Virtual Galaxy Note 20 Plugged in.");

		}

		try {

			Capabilities.capabilitiesCardControlEM10(appName);
//			appName = "Card Control";
			phoneID = "Emulator Device Android";
//			logs.CapturedLogs(androidText.INFO, appName + " running on " + phoneID);
			return appName +" started on " + phoneID;

		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Checking Phone: Virtual Nexus 6 Not Plugged in.");

		}

		try {

			Capabilities.capabilitiesCardControlEM11(appName);
//			appName = "Card Control";
			phoneID = "Emulator Device Android 11.0";
//			logs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
			return appName +" started on " + phoneID;

		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println("Checking Phone: Virtual Nexus 6 Not Plugged in.");

		}

		return "Card Control no devices found.";

	}
	
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		// WEX Connect Phone Capabilities

		public String autoPhonePickerWexConnect(String appName) throws Exception {
			androidLogs.setupTestYellow("Phone Picker");
			AppStringsAndroid androidText = new AppStringsAndroid();
			AndroidLogs logs = new AndroidLogs();
			// find first device found connected as uses it for automation.

			try {

				Capabilities.capabilitiesWexConnectPixel2(appName);
//				appName = "Wex Connect";
				phoneID = "Pixel 2";

//				logs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
				return appName +" started on " + phoneID;

			} catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("Checking Phone: Pixel 2 Not Plugged in.");

			}
			try {

				Capabilities.capabilitiesWexConnectEM7(appName);
//				appName = "Wex Connect";
				phoneID = "Emulator Device Android";
				logs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
				return appName +" started on " + phoneID;

			} catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("Checking Phone: Virtual Nexus 6 Not Plugged in.");

			}

			try {

				Capabilities.capabilitiesWexConnectEM10(appName);
//				appName = "Wex Connect";
				phoneID = "Emulator Device Android 10.0";
//				logs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
				return appName +" started on " + phoneID;

			} catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("Checking Phone: Virtual Nexus 6 Not Plugged in.");

			}

			try {

				Capabilities.capabilitiesWexConnectEM11(appName);
//				appName = "Wex Connect";
				phoneID = "Emulator Device Android";
//				logs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
				return appName +" started on " + phoneID;

			} catch (org.openqa.selenium.WebDriverException e) {
				System.out.println("Checking Phone: Virtual Nexus 6 Not Plugged in.");

			}

			return "Wex Connect no devices found.";

		}
		
		
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
				// Smart HUB Phone Capabilities

				public String autoPhonePickerSmartHub(String appName) throws Exception {
					androidLogs.setupTestYellow("Phone Picker");
					AppStringsAndroid androidText = new AppStringsAndroid();
					AndroidLogs logs = new AndroidLogs();
					// find first device found connected as uses it for automation.

					try {

						Capabilities.capabilitiesSmartHubPixel2(appName);
//						//appName = "SmartHub";
						phoneID = "Pixel 2";

//						logs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
						return appName +" started on " + phoneID;

					} catch (org.openqa.selenium.WebDriverException e) {
						System.out.println("Checking Phone: Pixel 2 Not Plugged in.");

					}
					try {

						Capabilities.capabilitiesSmartHubEM7(appName);
//						appName = "SmartHub";
						phoneID = "Emulator Device Android";
//						logs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
						return appName +" started on " + phoneID;

					} catch (org.openqa.selenium.WebDriverException e) {
						System.out.println("Checking Phone: Virtual Nexus 6 Not Plugged in.");

					}

					try {

						Capabilities.capabilitiesSmartHubEM10(appName);
//						appName = "SmartHub";
						phoneID = "Emulator Device Android";
//						logs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
						return appName +" started on " + phoneID;

					} catch (org.openqa.selenium.WebDriverException e) {
						System.out.println("Checking Phone: Virtual Nexus 6 Not Plugged in.");

					}

					try {

						Capabilities.capabilitiesSmartHubEM11(appName);
//						appName = "SmartHub";
						phoneID = "Emulator Device Android";
//						logs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
						return appName +" started on " + phoneID;

					} catch (org.openqa.selenium.WebDriverException e) {
						System.out.println("Checking Phone: Virtual Nexus 6 Not Plugged in.");

					}

					return "SmartHub no devices found.";

				}
				
				
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// SHELL FLEET NAVIGATOR HUB Phone Capabilities

				public String autoPhonePickerSFN(String appName) throws Exception {
					androidLogs.setupTestYellow("Phone Picker");
					AppStringsAndroid androidText = new AppStringsAndroid();
					AndroidLogs logs = new AndroidLogs();
					// find first device found connected as uses it for automation.

					try {

						Capabilities.capabilitiesSFNPixel2(appName);
//						appName = "Shell Fleet Navigator";
						phoneID = "Pixel 2";

//						logs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
						return appName +" started on " + phoneID;

					} catch (org.openqa.selenium.WebDriverException e) {
						System.out.println("Checking Phone: Pixel 2 Not Plugged in.");

					}
					try {

						Capabilities.capabilitiesSFNEM7(appName);
//						appName = "Shell Fleet Navigator";
						phoneID = "Emulator Device Android";
//						logs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
						return appName +" started on " + phoneID;

					} catch (org.openqa.selenium.WebDriverException e) {
						System.out.println("Checking Phone: Virtual Nexus 6 Not Plugged in.");

					}

					try {

						Capabilities.capabilitiesSFNEM10(appName);
//						appName = "Shell Fleet Navigator";
						phoneID = "Emulator Device Android";
//						logs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
						return appName +" started on " + phoneID;

					} catch (org.openqa.selenium.WebDriverException e) {
						System.out.println("Checking Phone: Virtual Nexus 6 Not Plugged in.");

					}

					try {

						Capabilities.capabilitiesSFNEM11(appName);
//						appName = "Shell Fleet Navigator";
						phoneID = "Emulator Device Android";
//						logs.CapturedLogs(androidText.INFO, appName + " running on " + PhoneID().toString());
						return appName +" started on " + phoneID;

					} catch (org.openqa.selenium.WebDriverException e) {
						System.out.println("Checking Phone: Virtual Nexus 6 Not Plugged in.");

					}

					return "Shell Fleet Navigator no devices found.";

				}
		
	

}
