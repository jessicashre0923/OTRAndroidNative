package androidCardClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.Sleep;

public class RepoCardAndroid {
	AndroidLogs androidLogs = new AndroidLogs();
	Sleep appSleep = new Sleep();
	AppStringsAndroid androidText = new AppStringsAndroid();
	public String loginPageSource = "";
	public String homePageSource = "";
	public String extrasPageSource = "";
//	String pass = androidText.PASS;
//	String fail = androidText.FAIL;
	String info = androidText.INFO;
	
	
	
	String buttonXpath = "//android.widget.Button[@text=";
	String widgetButtonResourceID = "//android.widget.Button[@resource-id=";
	String textViewXpath = "//android.widget.TextView[@text=";
	String textViewContent = "//android.widget.TextView[@content-desc=";
	String widgetTextViewResource = "//android.widget.TextView[@resource-id=";
	String textViewResource = "//android.widget.TextView[@resource-id=";
	String textViewText = "//android.widget.TextView[@text=";
	String editTextXpath = "//android.widget.EditText[@text=";
	String editTextWidgetResource = "//android.widget.EditText[@resource-id=";
	String radioButton = "//android.widget.RadioButton[@text=";
	String switchOption = "//android.widget.Switch[@text=";
	String checkBox = "//android.widget.CheckBox[@text=";
	String imageButton = "//android.widget.ImageButton[@content-desc=";
	String imageButtonRes = "//android.widget.ImageButton[@resource-id=";
	String imageView = "//android.widget.ImageView[@resource-id=";
	String linearLayoutContentDesc = "//android.widget.LinearLayout[@content-desc=";
	String widgetLayoutContent = "//android.widget.FrameLayout[@content-desc=";
	String recyclerViewResource = "//androidx.recyclerview.widget.RecyclerView[@resource-id=";
	String findSomethingLike ="//*[contains(text(),'"; 
	
	

	//test
	// finds the elements on the page asked for
	public Boolean pageElement(String elementLabel, String pageSource) {

		if (pageSource == "" || pageSource == null) {
			return false;
		}

		Boolean foundPageSource = false;

		switch (pageSource) {
		case "loginpage":
			this.loginPageSource = lookupPageSource(this.loginPageSource);
			foundPageSource = this.loginPageSource.contains(elementLabel);

			return foundPageSource;
			
		case "homepage":
			this.homePageSource = lookupPageSource(this.homePageSource);
			foundPageSource = this.homePageSource.contains(elementLabel);

			return foundPageSource;

		default:
			// extras always gets over written as a they are usually done or close etc
			this.extrasPageSource = Capabilities.driver.getPageSource();
			foundPageSource = this.extrasPageSource.contains(elementLabel);

			return foundPageSource;
		}
	}

	private String lookupPageSource(String pageSource) {
		if (pageSource == "") {
			pageSource = Capabilities.driver.getPageSource();
			// System.out.println(pageSource);
		}

		return pageSource;

	}

	// create one of these for every page in the automation
	public Boolean findLoginPageElement(String elementLabel) {
		return pageElement(elementLabel, "loginpage");
	}
	
	// create one of these for every page in the automation
		public Boolean findHomePageElement(String elementLabel) {
			return pageElement(elementLabel, "homepage");
		}

	// create one of these for every page in the automation
	public Boolean findExtrasPageSource(String elementLabel) {
		return pageElement(elementLabel, "default");
	}

	public void clearPageElement(String pageSource) {
		pageSource = "";
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	// Web Elements for Environment Picker page
	public WebElement TestButton() throws Exception {
		if (findExtrasPageSource("TEST ENVIRONMENT")) {
			WebElement TestButton = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"TEST ENVIRONMENT\"]");
			androidLogs.CapturedLogs(info, "Test environment button found");
			return TestButton;
		} else {
			androidLogs.CapturedLogs(info,
					"Test environment Button not found could be that you already chose an invorement");
			return null;
		}
	}

	public WebElement SITAWSButton() throws Exception {
		if (findExtrasPageSource("SIT (AWS) ENVIRONMENT")) {
			WebElement SITAWSButton = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"SIT (AWS) ENVIRONMENT\"]");
			androidLogs.CapturedLogs(info, "SIT AWS environment button found");
			return SITAWSButton;
		} else {
			androidLogs.CapturedLogs(info,
					"SIT AWS environment Button not found could be that you already chose an invorement");
			return null;
		}
	}
	
	public WebElement AWSDITButton() throws Exception {
		if (findExtrasPageSource("DIT (AWS) ENVIRONMENT")) {
			WebElement AWSDITButton = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"DIT (AWS) ENVIRONMENT\"]");
			androidLogs.CapturedLogs(info, "DIT AWS environment button found");
			return AWSDITButton;
		} else {
			androidLogs.CapturedLogs(info,
					"DIT AWS environment Button not found could be that you already chose an invorement");
			return null;
		}
	}
	
	public WebElement DITButton() throws Exception {
		if (findExtrasPageSource("DIT ENVIRONMENT")) {
			WebElement DITButton = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"DIT ENVIRONMENT\"]");
			androidLogs.CapturedLogs(info, "DIT environment button found");
			return DITButton;
		} else {
			androidLogs.CapturedLogs(info,"DIT Button not found could be that you already chose an environment");

			return null;
		}
	}
	
	
	public WebElement PartnerButton() throws Exception {
		if (findExtrasPageSource("PARTNER ENVIRONMENT")) {
			WebElement PartnerButton = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"PARTNER ENVIRONMENT\"]");
			androidLogs.CapturedLogs(info, "Partner Test environment button found");
			return PartnerButton;
		} else {
			androidLogs.CapturedLogs(info,
					"Partner Test environment Button not found could be that you already chose an environment");
			return null;
		}
	}
	

public WebElement CarrierControlSITAWSButton() throws Exception {
	if (findExtrasPageSource("SIT AWS")) {
		WebElement CarrierControlSITAWSButton = Capabilities.driver
				.findElementByXPath(buttonXpath+"\"SIT AWS\"]");
		androidLogs.CapturedLogs(info, "SIT AWS environment button found");
		return CarrierControlSITAWSButton;
	} else {
		androidLogs.CapturedLogs(info,
				"SIT AWS environment Button not found could be that you already chose an invorement");
		return null;
	}
}

public WebElement CarrierControlAWSDITButton() throws Exception {
	if (findExtrasPageSource("DIT AWS")) {
		WebElement AWSDITButton = Capabilities.driver
				.findElementByXPath(buttonXpath+"\"DIT AWS\"]");
		androidLogs.CapturedLogs(info, "DIT AWS environment button found");
		return AWSDITButton;
	} else {
		androidLogs.CapturedLogs(info,
				"DIT AWS environment Button not found could be that you already chose an invorement");
		return null;
	}
}



public WebElement CarrierControlPartnerButton() throws Exception {
	if (findExtrasPageSource("PARTNER AWS")) {
		WebElement PartnerButton = Capabilities.driver
				.findElementByXPath(buttonXpath+"\"PARTNER AWS\"]");
		androidLogs.CapturedLogs(info, "Partner Test environment button found");
		return PartnerButton;
	} else {
		androidLogs.CapturedLogs(info,
				"Partner Test environment Button not found could be that you already chose an environment");
		return null;
	}
}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~BIOMETRICS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

public WebElement BiometricsPage() throws Exception {
	if (findExtrasPageSource("Allow CardControl to use your fingerprint for login?")) {
		WebElement  BiometricsPage = Capabilities.driver.findElementByXPath(textViewXpath+"\"Allow CardControl to use your fingerprint for login?\"]");
		androidLogs.CapturedLogs(info, "Biometrics page found");
		return BiometricsPage;
	} else {
		androidLogs.CapturedLogs(info, "Biometrics page not found");
	 return null;
}
}


	public WebElement BiometricsCancelButton() throws Exception {
		if (findExtrasPageSource("CANCEL")) {
			WebElement  BiometricsCancelButton= Capabilities.driver.findElementByXPath(buttonXpath+"\"CANCEL\"]");
			androidLogs.CapturedLogs(info, "Biometrics Cancel Button found");
			return BiometricsCancelButton;
		} else {
			androidLogs.CapturedLogs(info, "Biometrics Cancel Button not found");
		 return null;
	}
	}

	public WebElement BiometricsDenyButton() throws Exception {
		if (findExtrasPageSource("Deny")) {
			WebElement  BiometricsDenyButton= Capabilities.driver.findElementByXPath(buttonXpath+"\"Deny\"]");
			androidLogs.CapturedLogs(info, "Biometrics Deny Button found");
			return BiometricsDenyButton;
		} else {
			androidLogs.CapturedLogs(info, "Biometrics Deny Button not found");
		 return null;
	}
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

//Web Elements for Login Page

	public WebElement CardNumberTextBoxClearButton() throws Exception {
		
		if (findLoginPageElement("Card number")) {
//			WebElement CardNumberTextBoxClearButton = Capabilities.driver
//					.findElementByXPath(imageButton+"\"Clear text\"]");
//			
			WebElement CardNumberTextBoxClearButton = Capabilities.driver.findElementByAccessibilityId("Clear text");

			androidLogs.CapturedLogs(info, "Card number clear button found");
			return CardNumberTextBoxClearButton;
		} else {
			androidLogs.CapturedLogs(info, "Card number clear button not found");
			return null;
		}
	}

	
	public WebElement ClearCardNumberTextBox() throws Exception {
		
		if (findExtrasPageSource("Clear text")) {
			WebElement ClearCardNumberTextBox = Capabilities.driver
					.findElementByXPath(imageButton+"\"Clear text\"]");

			androidLogs.CapturedLogs(info, "Clear Card text button found");
			return ClearCardNumberTextBox;
		} else {
			androidLogs.CapturedLogs(info, "Clear Card text button not found");
			return null;
		}
	}
	
	
	
	
	public WebElement CardNumberTextBox() throws Exception {
		 Thread.sleep(3000);
		if (findExtrasPageSource("Card number")) {
			WebElement CardNumberTextBox = Capabilities.driver
					.findElementByXPath(editTextXpath+"\"Card number\"]");

			androidLogs.CapturedLogs(info, "Card number text box found");
			return CardNumberTextBox;
		} else {
			androidLogs.CapturedLogs(info, "Card number text box not found");
			return null;
		}
	}

	public WebElement PinPassTextBox() throws Exception {
		if (findExtrasPageSource("PIN or passcode")) {
			WebElement PinPassTextBox = Capabilities.driver
					.findElementByXPath(editTextXpath+"\"Pin or passcode\"]");
			androidLogs.CapturedLogs(info, "PIN or Passcode empty text box found");
			return PinPassTextBox;
		} else {
			androidLogs.CapturedLogs(info, "PIN or Passcode empty text box not found");
			return null;
		}
	}
	
	public WebElement PinPassTextBoxFilledIN() throws Exception {
		if (findExtrasPageSource("PIN or passcode")) {
			WebElement PinPassTextBoxFilledIN = Capabilities.driver.findElementById("com.efsllc.efsmobileapp.stage:id/pin_passcode_edit_text");
			androidLogs.CapturedLogs(info, "PIN or Passcode pre filled text box found");
			return PinPassTextBoxFilledIN;
		} else {
			androidLogs.CapturedLogs(info, "PIN or Passcode pre filled text box not found");
			return null;
		}
	}
	
	
	

	public WebElement CardLoginButton() throws Exception {
		
		if (findLoginPageElement("Log in")) {
			WebElement CardLoginButton = Capabilities.driver
					.findElementByXPath(textViewXpath+"\"Log in\"]");
			androidLogs.CapturedLogs(info, "Log in button found");
			return CardLoginButton;
		} else {
			androidLogs.CapturedLogs(info, "Log in button not found");
			return null;
		}
	}
	
public WebElement CardLoginButtonSpinner() throws Exception {
		
		if (findLoginPageElement("Logging in")) {
			WebElement CardLoginButtonSpinner = Capabilities.driver
					.findElementByXPath(textViewXpath+"\"Logging in\"]");
			androidLogs.CapturedLogs(info, "Log in button spinner found");
			return CardLoginButtonSpinner;
		} else {
			androidLogs.CapturedLogs(info, "Log in button spinner not found");
			return null;
		}
	}
	
public WebElement SearchNearByLoadingSpinner() throws Exception {
	

	if (findLoginPageElement("Loading stations within 5 miles…")) {
		WebElement SearchNearByLoadingSpinner = Capabilities.driver
				.findElementByXPath(textViewXpath+"\"Loading stations within 5 miles…\"]");
		androidLogs.CapturedLogs(info, "Search nearby spinner found");
		return SearchNearByLoadingSpinner;
	} else {
		androidLogs.CapturedLogs(info, "Search nearby not found");
		return null;
	}
}


public WebElement SearchAlongARouteLoadingSpinner() throws Exception {
	if (findLoginPageElement("Loading stations…")) {
		WebElement SearchAlongARouteLoadingSpinner = Capabilities.driver
				.findElementByXPath(textViewXpath+"\"Loading stations…\"]");
		androidLogs.CapturedLogs(info, "Search nearby spinner found");
		return SearchAlongARouteLoadingSpinner;
	} else {
		androidLogs.CapturedLogs(info, "Search nearby not found");
		return null;
	}
}
	
	
	public WebElement invalidCardTextModalOkButton() throws Exception {
		
		if (findExtrasPageSource("OK")) {
			WebElement invalidCardTextModalOkButton = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"OK\"]");
			androidLogs.CapturedLogs(info, "Unable to login model ok button found");
			return invalidCardTextModalOkButton;
		} else {
			androidLogs.CapturedLogs(info, "Unable to login model ok not button found");
			return null;
		}
	}

	

	public WebElement InformationIcon() throws Exception {
		if (findLoginPageElement("information icon")) {
			WebElement InformationIcon = Capabilities.driver.findElementByXPath("******Not available*********");
			androidLogs.CapturedLogs(info, "Information Icon button found");
			return InformationIcon;
		} else {
			androidLogs.CapturedLogs(info, "Information Icon button not found");
			return null;
		}
	}

	public WebElement InformationIconClose() throws Exception {
		if (findExtrasPageSource("Close")) {
			WebElement InformationIconClose = Capabilities.driver
					.findElementByXPath(textViewContent+"\"Close\"]");
			androidLogs.CapturedLogs(info, "Information Icon close button found");
			return InformationIconClose;
		} else {
			androidLogs.CapturedLogs(info, "Information Icon close button not found");
			return null;
		}
	}

	public WebElement ShowHidePINPasscodeIcon() throws Exception {
		if (findLoginPageElement("Pin or passcode")) {
			WebElement ShowHidePINPasscodeIcon = Capabilities.driver.findElementByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageButton");
			androidLogs.CapturedLogs(info, "Show/hide pin passcode button found");
			return ShowHidePINPasscodeIcon;
		} else {
			androidLogs.CapturedLogs(info, "Show/hide pin passcode button not found");
			return null;
		}
	}

	public WebElement ForgotPINorPasscode() throws Exception {
		if (findLoginPageElement("Forgot PIN or passcode")) {
			WebElement ForgotPINorPasscode = Capabilities.driver
					.findElementByXPath(textViewXpath+"\"Forgot PIN or passcode\"]");
			androidLogs.CapturedLogs(info, "Forgot PIN or passcode link found");
			return ForgotPINorPasscode;
		} else {
			androidLogs.CapturedLogs(info, "Forgot PIN or passcode link not found");
			return null;
		}
	}

	public WebElement ForgotPINorPasscodeCardNumberTextBox() throws Exception {
		if (findExtrasPageSource("Forgot PIN or passcode")) {
			//WebElement ForgotPINorPasscodeCardNumberTextBox = Capabilities.driver.findElementByXPath(
			//		"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView");
			
			WebElement ForgotPINorPasscodeCardNumberTextBox = Capabilities.driver.findElementByXPath(editTextXpath+"\"Card number\"]");

			androidLogs.CapturedLogs(info, "Card number textbox found");
			return ForgotPINorPasscodeCardNumberTextBox;
		} else {
			androidLogs.CapturedLogs(info, "Card number textbox not found");
			return null;
		}
	}

	public WebElement ForgotPINorPasscodeNextButton() throws Exception {
		if (findExtrasPageSource("Next")) {
			WebElement ForgotPINorPasscodeNextButton = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"Next\"]");
			androidLogs.CapturedLogs(info, "Next button found");
			return ForgotPINorPasscodeNextButton;
		} else {
			androidLogs.CapturedLogs(info, "Next button not found");
			return null;
		}
	}

	
	public WebElement ForgotPINNextButton() throws Exception {
		if (findExtrasPageSource("Next")) {
			WebElement ForgotPINNextButton = Capabilities.driver
					.findElementByXPath(widgetButtonResourceID+"\"com.efsllc.efsmobileapp.stage:id/next_button\"]");
			androidLogs.CapturedLogs(info, "Reset PIN next button found");
			return ForgotPINNextButton;
		} else {
			androidLogs.CapturedLogs(info, "Reset PIN next button not found");
			return null;
		}
	}
	
	public WebElement ForgotPINorPasscodeSecurityAnswerTextbox() throws Exception {
		if (findExtrasPageSource("Your answer")) {
			WebElement ForgotPINorPasscodeSecurityAnswerTextbox = Capabilities.driver
					.findElementByXPath(editTextXpath+"\"Your answer\"]");
			androidLogs.CapturedLogs(info, "Security answer textbox found");
			return ForgotPINorPasscodeSecurityAnswerTextbox;
		} else {
			androidLogs.CapturedLogs(info, "Security answer textbox not found");
			return null;
		}
	}

	public WebElement ForgotPINorPasscodeNewPasscodeTextbox() throws Exception {
		if (findExtrasPageSource("New passcode")) {
			WebElement ForgotPINorPasscodeNewPasscodeTextbox = Capabilities.driver
					.findElementByXPath(editTextXpath+"\"New passcode\"]");
			androidLogs.CapturedLogs(info, "New Passcode textbox found");
			return ForgotPINorPasscodeNewPasscodeTextbox;
		} else {
			androidLogs.CapturedLogs(info, "New Passcode textbox not found");
			return null;
		}
	}

	public WebElement ForgotPINorPasscodeConfirmPasscodeTextbox() throws Exception {
		if (findExtrasPageSource("Confirm passcode")) {
			WebElement ForgotPINorPasscodeConfirmPasscodeTextbox = Capabilities.driver
					.findElementByXPath(editTextXpath+"\"Confirm passcode\"]");
			androidLogs.CapturedLogs(info, "Confirm Passcode textbox found");
			return ForgotPINorPasscodeConfirmPasscodeTextbox;
		} else {
			androidLogs.CapturedLogs(info, "Confirm Passcode textbox not found");
			return null;
		}
	}

	public WebElement ContinueToHomeButton() throws Exception {
		if (findExtrasPageSource("Continue to Home")) {
			WebElement ContinueToHomeButton = Capabilities.driver
					.findElementByXPath(textViewXpath+"\"Continue to Home\"]");
			androidLogs.CapturedLogs(info, "Continue to home button found");
			return ContinueToHomeButton;
		} else {
			androidLogs.CapturedLogs(info, "Continye to home button not found");
			return null;
		}
	}
	
	
	public WebElement ContactFleetManagerOkButton() throws Exception {
		if (findExtrasPageSource("OK")) {
			WebElement ForgotPINorPasscodeSecurityAnswerTextbox = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"OK\"]");
			androidLogs.CapturedLogs(info, "Contact fleet manager Ok Button found");
			return ForgotPINorPasscodeSecurityAnswerTextbox;
		} else {
			androidLogs.CapturedLogs(info, "Contact fleet manager Ok Button not found");
			return null;
		}
	}
	
	
	
public WebElement HomeHeader() throws Exception {
		
		if (findExtrasPageSource("Home")) {
			WebElement HomeHeader = Capabilities.driver.findElementByXPath(textViewXpath+"\"Home\"]");
			androidLogs.CapturedLogs(info, "Home header seen");
			return HomeHeader;
		} else {
			androidLogs.CapturedLogs(info, "Home header not found");
			return null;
		}
	}
	

public WebElement CompanyHeader() throws Exception {
	
	if (findExtrasPageSource("Company")) {
		WebElement CompanyHeader = Capabilities.driver
				.findElementByXPath(textViewXpath+"\"Company\"]");
		androidLogs.CapturedLogs(info, "Company header seen");
		return CompanyHeader;
	} else {
		androidLogs.CapturedLogs(info, "Company header not found");
		return null;
	}
}

public WebElement SmartFundsHeader() throws Exception {
	
	if (findExtrasPageSource("SmartFunds")) {
		WebElement SmartFundsHeader = Capabilities.driver
				.findElementByXPath(linearLayoutContentDesc+"\"SmartFunds\"]");
		androidLogs.CapturedLogs(info, "Smartfunds header seen");
		return SmartFundsHeader;
	} else {
		androidLogs.CapturedLogs(info, "Smartfunds header not found");
		return null;
	}
}



public WebElement RecuringCashAmmount() throws Exception {
	
	if (findExtrasPageSource("Recurring")) {
		WebElement RecuringCashAmmount = Capabilities.driver
				.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/recurring_cash_amount\"]");
		androidLogs.CapturedLogs(info, "Recurring cash seen");
		return RecuringCashAmmount;
	} else {
		androidLogs.CapturedLogs(info, "Recurring cash not found");
		return null;
	}
}

	
public WebElement OneTimeCashAmmount() throws Exception {
	
	if (findExtrasPageSource("One")) {
		WebElement OneTimeCashAmmount = Capabilities.driver
				.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/one_time_cash_amount\"]");
		androidLogs.CapturedLogs(info, "One time cash ammount seen");
		return OneTimeCashAmmount;
	} else {
		androidLogs.CapturedLogs(info, "One time cash ammount not found");
		return null;
	}
}

public WebElement SmartFundsBalance() throws Exception {
	
	if (findExtrasPageSource("SmartFunds balance")) {
		WebElement SmartFundsBalance = Capabilities.driver
				.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/smartfunds_cash_amount\"]");
		androidLogs.CapturedLogs(info, "SmartFunds balance seen");
		return SmartFundsBalance;
	} else {
		androidLogs.CapturedLogs(info, "SmartFunds balance not found");
		return null;
	}
}

public WebElement RecentTransactions() throws Exception {
	
	if (findExtrasPageSource("Recent transactions")) {
		WebElement RecentTransactions = Capabilities.driver
				.findElementByXPath(textViewXpath+"\"Recent transactions\"]");
		androidLogs.CapturedLogs(info, "Transactions header seen");
		return RecentTransactions;
	} else {
		androidLogs.CapturedLogs(info, "Transactions header not found");
		return null;
	}
}


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	// TABS card login page	


public WebElement HomeTab() throws Exception {
	
	if (findExtrasPageSource("Home")) {
		WebElement HomeTab = Capabilities.driver
				.findElementByXPath(widgetLayoutContent+"\"Home\"]");
		androidLogs.CapturedLogs(info, "Home Tab seen");
		return HomeTab;
	} else {
		androidLogs.CapturedLogs(info, "Home Tab not found");
		return null;
	}
}

public WebElement TransactionsTab() throws Exception {
	
	if (findExtrasPageSource("Transactions")) {
		WebElement TransactionsTab = Capabilities.driver
				.findElementByXPath(widgetLayoutContent+"\"Transactions\"]");
		androidLogs.CapturedLogs(info, "Transactions Tab seen");
		return TransactionsTab;
	} else {
		androidLogs.CapturedLogs(info, "Transactions Tab not found");
		return null;
	}
}


public WebElement FindFuelTab() throws Exception {
	
	if (findExtrasPageSource("Find Fuel")) {
		WebElement FindFuelTab = Capabilities.driver
				.findElementByXPath(widgetLayoutContent+"\"Find Fuel\"]");
		androidLogs.CapturedLogs(info, "FindFuel Tab seen");
		return FindFuelTab;
	} else {
		androidLogs.CapturedLogs(info, "FindFuel Tab not found");
		return null;
	}
}



	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	// Multi card login page	
	
	
	public WebElement CheckForMuliCardLogin() throws Exception {
		
		if (findExtrasPageSource("Select a card")) {
			WebElement CheckForMuliCardLogin = Capabilities.driver
					.findElementByXPath(textViewXpath+"\"Select a card\"]");

			androidLogs.CapturedLogs(info, "Multi card login page found");
			return CheckForMuliCardLogin;
		} else {
			androidLogs.CapturedLogs(info, "Multi card login page not found");
			return null;
		}
	}
	
	
	public WebElement SignInWithDifferentcardButton() throws Exception {
		
		if (findExtrasPageSource("Sign in with a different card")) {
			WebElement SignInWithDifferentcardButton = Capabilities.driver
					.findElementByXPath(textViewXpath+"\"Sign in with a different card\"]");

			androidLogs.CapturedLogs(info, "Sign in with a different card button found found");
			return SignInWithDifferentcardButton;
		} else {
			androidLogs.CapturedLogs(info, "Sign in with a different card button not found");
			return null;
		}
	}
	

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	// Web Elements for Passcode Reset Page
	
	public WebElement CreateAPasscodePage() throws Exception {
		
		if (findExtrasPageSource("Create a passcode")) {
			WebElement CreateAPasscodePage = Capabilities.driver
					.findElementByXPath(textViewResource+"\"com.efsllc.efsmobileapp.stage:id/create_pin_textview\"]");
			androidLogs.CapturedLogs(info, "Create a passcode page found");
			return CreateAPasscodePage;
		} else {
			androidLogs.CapturedLogs(info,
					"Create a passcode page not found this account may already have one setup");
			return null;
		}
	}
	
	public WebElement NewPasscodeTextbox() throws Exception {
		
		if (findExtrasPageSource("New passcode")) {
			WebElement NewPasscodeTextbox = Capabilities.driver
					.findElementByXPath(editTextXpath+"\"New passcode\"]");
			androidLogs.CapturedLogs(info, "New passcode textbox found");
			return NewPasscodeTextbox;
		} else {
			androidLogs.CapturedLogs(info,
					"New passcode textbox not found");
			return null;
		}
	}
	
	public WebElement ConfirmPasscodeTextbox() throws Exception {
		
		if (findExtrasPageSource("Confirm passcode")) {
			WebElement ConfirmPasscodeTextbox = Capabilities.driver
					.findElementByXPath(editTextXpath+"\"Confirm passcode\"]");
			androidLogs.CapturedLogs(info, "Confirm passcode textbox found");
			return ConfirmPasscodeTextbox;
		} else {
			androidLogs.CapturedLogs(info,
					"Confirm passcode textbox not found");
			return null;
		}
	}
	
	
	public WebElement cardSuspendedOKButton() throws Exception {
		 Thread.sleep(3000);
		if (findExtrasPageSource("OK")) {
			WebElement cardSuspendedOKButton = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"OK\"]");
			androidLogs.CapturedLogs(info, "Card Suspened modal is found");
			return cardSuspendedOKButton;
		} else {
			androidLogs.CapturedLogs(info, "Card Suspened modal is not found");
			return null;
		}
	}
	
	
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		// Web Elements for Pin Reset Page
		
		public WebElement CreateAPinPage() throws Exception {
			
			if (findExtrasPageSource("Create a PIN")) {
				WebElement CreateAPinPage = Capabilities.driver
						.findElementByXPath(textViewText+"\"Create a PIN\"]");
				androidLogs.CapturedLogs(info, "Create a pin page found");
				return CreateAPinPage;
			} else {
				androidLogs.CapturedLogs(info,
						"Create a pin page not found this account may already have one setup");
				return null;
			}
		}
		
		public WebElement NewPinTextbox() throws Exception {
			
			if (findExtrasPageSource("New PIN")) {
				WebElement NewPinTextbox = Capabilities.driver
						.findElementByXPath(editTextXpath+"\"New PIN\"]");
				androidLogs.CapturedLogs(info, "New pin textbox found");
				return NewPinTextbox;
			} else {
				androidLogs.CapturedLogs(info,
						"New pin textbox not found");
				return null;
			}
		}
		
		public WebElement ConfirmPinTextbox() throws Exception {
			
			if (findExtrasPageSource("Confirm PIN")) {
				WebElement ConfirmPinTextbox = Capabilities.driver
						.findElementByXPath(editTextXpath+"\"Confirm PIN\"]");
				androidLogs.CapturedLogs(info, "Confirm pin textbox found");
				return ConfirmPinTextbox;
			} else {
				androidLogs.CapturedLogs(info,
						"Confirm pin textbox not found");
				return null;
			}
		}
		
			
	
	
//	public WebElement NextButton() throws Exception {
//		
//		if (findExtrasPageSource("Confirm passcode")) {
//			WebElement NextButton = Capabilities.driver
//					.findElementByXPath(editTextXpath+"\"Confirm passcode\"]");
//			androidLogs.CapturedLogs(info, "Next Button found");
//			return NextButton;
//		} else {
//			androidLogs.CapturedLogs(info,
//					"Next Button not found");
//			return null;
//		}
//	}
	

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	// Web Elements for Profile setup Pages

	public WebElement ProfileSetup() throws Exception {
		
		if (findExtrasPageSource("Setup profile")) {
			WebElement ProfileSetup = Capabilities.driver.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/registration_header_textview\"]");
			androidLogs.CapturedLogs(info, "Profile setup page found");
			return ProfileSetup;
		} else {
			androidLogs.CapturedLogs(info,
					"Profile setup page not found this account may not have a profile or it was setup on a prior run");
			return null;
		}
	}

	public WebElement FirstNameTextbox() throws Exception {
		
		if (findExtrasPageSource("First name")) {
			WebElement FirstNameTextbox = Capabilities.driver
					.findElementByXPath(editTextXpath+"\"First name\"]");
			androidLogs.CapturedLogs(info, "First Name textbox found");
			return FirstNameTextbox;
		} else {
			androidLogs.CapturedLogs(info, "First Name textbox not found");
			return null;
		}
	}

	public WebElement LastNameTextbox() throws Exception {
		
		if (findExtrasPageSource("Last name")) {
			WebElement LastNameTextbox = Capabilities.driver
					.findElementByXPath(editTextXpath+"\"Last name\"]");
			androidLogs.CapturedLogs(info, "Last Name textbox found");
			return LastNameTextbox;
		} else {
			androidLogs.CapturedLogs(info, "Last Name textbox not found");
			return null;
		}
	}

	public WebElement NextButton() throws Exception {
		
		if (findExtrasPageSource("Next")) {
			WebElement NextButton = Capabilities.driver.findElementByXPath(buttonXpath+"\"Next\"]");
			androidLogs.CapturedLogs(info, "Next Button found");
			return NextButton;
		} else {
			androidLogs.CapturedLogs(info, "Next Button not found");
			return null;
		}
	}

	public WebElement DateOfBirth() throws Exception {
		
		if (findExtrasPageSource("DOB")) {
			WebElement DateOfBirth = Capabilities.driver.findElementByXPath(editTextXpath+"\"DOB\"]");
			androidLogs.CapturedLogs(info, "Date of Birth Textbox found");
			return DateOfBirth;
		} else {
			androidLogs.CapturedLogs(info, "Date of Birth Textbox not found");
			return null;
		}
	}

	public WebElement PhoneNumberTextBox() throws Exception {
		
		if (findExtrasPageSource("Phone number")) {
			WebElement PhoneNumberTextBox = Capabilities.driver
					.findElementByXPath(editTextXpath+"\"Phone number\"]");
			androidLogs.CapturedLogs(info, "Phone Number Textbox found");
			return PhoneNumberTextBox;
		} else {
			androidLogs.CapturedLogs(info, "Phone Number Textbox not found");
			return null;
		}
	}

	public WebElement EmailTextBox() throws Exception {
		
		if (findExtrasPageSource("Email address")) {
			WebElement EmailTextBox = Capabilities.driver
					.findElementByXPath(editTextXpath+"\"Email address\"]");
			androidLogs.CapturedLogs(info, "Email Textbox found");
			return EmailTextBox;
		} else {
			androidLogs.CapturedLogs(info, "Email Textbox not found");
			return null;
		}
	}

	public WebElement SocialTextBox() throws Exception {
		
		if (findExtrasPageSource("SSN")) {
			WebElement SocialTextBox = Capabilities.driver
					.findElementByXPath(editTextXpath+"\"SSN\"]");
			androidLogs.CapturedLogs(info, "Social Textbox found");
			return SocialTextBox;
		} else {
			androidLogs.CapturedLogs(info, "Social Textbox not found");
			return null;
		}
	}

	public WebElement HomeAddressTextBox() throws Exception {
		
		if (findExtrasPageSource("Search for address")) {
			WebElement HomeAddressTextBox = Capabilities.driver
					.findElementByXPath(editTextXpath+"\"Search for address\"]");
			androidLogs.CapturedLogs(info, "Address Textbox found");
			return HomeAddressTextBox;
		} else {
			androidLogs.CapturedLogs(info, "Address Textbox not found");
			return null;
		}
	}

	public WebElement AddressSelector() throws Exception {
		
		if (findExtrasPageSource("1 Hancock Street")) {
			WebElement AddressSelector = Capabilities.driver
					.findElementByXPath(textViewXpath+"\"1 Hancock Street\"]");
			androidLogs.CapturedLogs(info, "Address selector found");
			return AddressSelector;
		} else {
			androidLogs.CapturedLogs(info, "Address selector not found");
			return null;
		}
	}

	public WebElement AddressLineTwo() throws Exception {
		
		if (findExtrasPageSource("Unit or apt number (optional)")) {
			WebElement AddressLineTwo = Capabilities.driver
					.findElementByXPath(editTextXpath+"\"Unit or apt number (optional)\"]");
			androidLogs.CapturedLogs(info, "Address line two found");
			return AddressLineTwo;
		} else {
			androidLogs.CapturedLogs(info, "Address line two not found");
			return null;
		}
	}

	public WebElement ProfileFinishButton() throws Exception {
		
		if (findExtrasPageSource("Finish")) {
			WebElement ProfileFinishButton = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"Finish\"]");
			androidLogs.CapturedLogs(info, "Finish Button found");
			return ProfileFinishButton;
		} else {
			androidLogs.CapturedLogs(info, "Finish Button not found");
			return null;
		}
	}

	public WebElement GetStartedButton() throws Exception {
		
		if (findExtrasPageSource("Get started")) {
			WebElement GetStartedButton = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"Get started\"]");
			androidLogs.CapturedLogs(info, "Get Started Button found");
			return GetStartedButton;
		} else {
			androidLogs.CapturedLogs(info, "Get Started Button not found");
			return null;
		}
	}
	
	
public WebElement SecurityQuestionOne() throws Exception {
		
		if (findExtrasPageSource("Security question")) {
			WebElement SecurityQuestionOne = Capabilities.driver.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/security_question_header_textview\"]");
			androidLogs.CapturedLogs(info, "Security Question 1 found");
			return SecurityQuestionOne;
		} else {
			androidLogs.CapturedLogs(info,
					"Security Question 1 not found this account may not have a profile or it was setup on a prior run");
			return null;
		}
	}
	
public WebElement SecurityQuestionOneAnswer() throws Exception {
	
	if (findExtrasPageSource("Your answer")) {
		WebElement SecurityQuestionOneAnswer = Capabilities.driver.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/answer_edit_text\"]");
		androidLogs.CapturedLogs(info, "Security Question answer 1 found");
		return SecurityQuestionOneAnswer;
	} else {
		androidLogs.CapturedLogs(info,
				"\"Security Question answer 1 not found this account may not have a profile or it was setup on a prior run");
		return null;
	}
}


public WebElement SecurityQuestionNextButton() throws Exception {
	
	if (findExtrasPageSource("Next")) {
		WebElement SecurityQuestionNextButton = Capabilities.driver.findElementByXPath(widgetButtonResourceID+"\"com.efsllc.efsmobileapp.stage:id/next_button\"]");
		androidLogs.CapturedLogs(info, "Next Button found");
		return SecurityQuestionNextButton;
	} else {
		androidLogs.CapturedLogs(info,
				"\"Next Button not found this account may not have a profile or it was setup on a prior run");
		return null;
	}
}


	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	// Web Elements for Secure Fuel Check in page

	public WebElement FuelCheckInButton() throws Exception {
		if (findHomePageElement("Fuel Check-in")) {
			WebElement FuelCheckInButton = Capabilities.driver
					.findElementByXPath(textViewXpath+"\"Fuel Check-in\"]");
			androidLogs.CapturedLogs(info, "Fuel check in button found");
			return FuelCheckInButton;
		} else {
			androidLogs.CapturedLogs(info, "Fuel check in button not found");
			return null;
		}
	}

	public WebElement UnitNumberTextBox() throws Exception {
		if (findExtrasPageSource("Unit Number")) {
			WebElement UnitNumberTextBox = Capabilities.driver
					.findElementByXPath(editTextXpath+"\"Unit Number\"]");
			androidLogs.CapturedLogs(info, "Unit number text box found");
			return UnitNumberTextBox;
		} else {
			androidLogs.CapturedLogs(info, "Unit number text box not found");
			return null;
		}
	}

	public WebElement CheckInButton() throws Exception {
		if (findExtrasPageSource("Check-in")) {
			WebElement CheckInButton = Capabilities.driver
					.findElementByXPath(textViewXpath+"\"Check-in\"]");
			androidLogs.CapturedLogs(info, "Check-in button found");
			return CheckInButton;
		} else {
			androidLogs.CapturedLogs(info, "Check-in button not found");
			return null;
		}
	}

	public WebElement AllowLocationModal() throws Exception {
		if (findExtrasPageSource("While using the app")) {
			WebElement AllowLocationModal = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"While using the app\"]");
			androidLogs.CapturedLogs(info, "Allow location modal emulator found");
			return AllowLocationModal;
		} else {
			androidLogs.CapturedLogs(info, "Allow location modal emulator not found");
			return null;
		}
	}
	

	public WebElement AllowLocationModalOther() throws Exception {
		if (findExtrasPageSource("Allow only while using the app")) {
			WebElement AllowLocationModalOther = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"Allow only while using the app\"]");
			androidLogs.CapturedLogs(info, "Allow location modal emulator found");
			return AllowLocationModalOther;
		} else {
			androidLogs.CapturedLogs(info, "Allow location modal emulator not found");
			return null;
		}
	}
	
	public WebElement AllowLocationModalRealDevice() throws Exception {
		if (findExtrasPageSource("Allow")) {
			WebElement AllowLocationModalRealDevice = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"Allow\"]");
			androidLogs.CapturedLogs(info, "Allow location modal found real device");
			return AllowLocationModalRealDevice;
		} else {
			androidLogs.CapturedLogs(info, "Allow location modal found real device not found");
			return null;
		}
	}

	public WebElement UnableToGetLocationLaterModal() throws Exception {
		if (findExtrasPageSource("Later")) {
			WebElement UnableToGetLocationLaterModal = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"Later\"]");
			androidLogs.CapturedLogs(info, "Unable to get location modal found");
			return UnableToGetLocationLaterModal;
		} else {
			androidLogs.CapturedLogs(info, "Unable to get location modal not found");
			return null;
		}
	}

	public WebElement DismissFuelCheckinButton() throws Exception {
		if (findExtrasPageSource("Dismiss")) {
			WebElement DismissFuelCheckinButton = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"Dismiss\"]");

			androidLogs.CapturedLogs(info, "Dismiss check in button found");
			return DismissFuelCheckinButton;
		} else {
			androidLogs.CapturedLogs(info, "Dismiss check in button not found");
			return null;
		}
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	// Web Elements for Register checks page
	
	public WebElement RegisterCheckIconButton() throws Exception {
		if (findHomePageElement("Register Check")) {
			WebElement RegisterCheckIconButton = Capabilities.driver.findElementByXPath(textViewXpath+"\"Register Check\"]");
			 androidLogs.CapturedLogs(info, "Register Check button found");
			return RegisterCheckIconButton;
		} else {
			androidLogs.CapturedLogs(info, "Register Check button not found");
			return null;
		}
	}
	
	public WebElement AmountTextBoxRegisterCheck() throws Exception {
		if (findExtrasPageSource("$0.00")) {
			WebElement AmountTextBoxRegisterCheck = Capabilities.driver.findElementByXPath(editTextXpath+"\"$0.00\"]");
			
			//WebElement AmountTextBoxRegisterCheck = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");

		
			
			androidLogs.CapturedLogs(info, "Amount text box found");
			return AmountTextBoxRegisterCheck;
		} else {
			androidLogs.CapturedLogs(info, "Amount text box not found");
			return null;
		}
	}
	
	public WebElement NextButtonRegisterCheck() throws Exception {
		if (findExtrasPageSource("Next")) {
			WebElement NextButtonRegisterCheck = Capabilities.driver.findElementByXPath(buttonXpath+"\"Next\"]");
			androidLogs.CapturedLogs(info, "Next button found");
			return NextButtonRegisterCheck;
		} else {
			androidLogs.CapturedLogs(info, "Next button not found");
			return null;
		}
	}
	
	public WebElement CheckNumberTextBox() throws Exception {
		if (findExtrasPageSource("Check number")) {
			WebElement CheckNumberTextBox = Capabilities.driver.findElementByXPath(editTextXpath+"\"Check number\"]");
			androidLogs.CapturedLogs(info, "Check Number Text Box found");
			return CheckNumberTextBox;
		} else {
			androidLogs.CapturedLogs(info, "Check Number Text Box not found");
			return null;
		}
	}
	
	public WebElement SubmitButtonRegisterCheck() throws Exception {
		if (findExtrasPageSource("Submit")) {
			WebElement SubmitButtonRegisterCheck = Capabilities.driver.findElementByXPath(textViewXpath+"\"Submit\"]");
			androidLogs.CapturedLogs(info, "Submit button found");
			return SubmitButtonRegisterCheck;
		} else {
			androidLogs.CapturedLogs(info, "Submit button not found");
			return null;
		}
	}
	
	public WebElement DismissButtonRegisterCheck() throws Exception {
		if (findExtrasPageSource("Dismiss")) {
			WebElement DismissButtonRegisterCheck = Capabilities.driver.findElementByXPath(buttonXpath+"\"Dismiss\"]");
			androidLogs.CapturedLogs(info, "Dismiss button found");
			return DismissButtonRegisterCheck;
		} else {
			androidLogs.CapturedLogs(info, "Dismiss button not found");
			return null;
		}
	}
	
	public WebElement CancelButtonRegisterCheck() throws Exception {
		if (findExtrasPageSource("Cancel")) {
			WebElement CancelButtonRegisterCheck = Capabilities.driver.findElementByXPath(buttonXpath+"\"Cancel\"]");
			androidLogs.CapturedLogs(info, "Cancel button found");
			return CancelButtonRegisterCheck;
		} else {
			androidLogs.CapturedLogs(info, "Cancel button not found");
			return null;
		}
	}
	
	public WebElement DismissCodeButtonRegisterCheck() throws Exception {
		if (findExtrasPageSource("Dismiss code")) {
			WebElement DismissCodeButtonRegisterCheck = Capabilities.driver.findElementByXPath(buttonXpath+"\"Dismiss code\"]");
			androidLogs.CapturedLogs(info, "Dismiss code button found");
			return DismissCodeButtonRegisterCheck;
		} else {
			androidLogs.CapturedLogs(info, "Dismiss code button not found");
			return null;
		}
	}
	
//TODO add clicking newly made check and closing it. 
	public WebElement OpenNewRegisterCheck() throws Exception {
		if (findExtrasPageSource("REGISTERED CHECK")) {
			WebElement OpenNewRegisterCheck = Capabilities.driver.findElementByXPath(textViewXpath+"\"REGISTERED CHECK\"]");
			androidLogs.CapturedLogs(info, "New register check line item found");
			return OpenNewRegisterCheck;
		} else {
			androidLogs.CapturedLogs(info, "New register check line item not found");
			return null;
		}
	}
	
	
	public WebElement CloseNewRegisterCheckPage() throws Exception {
		if (findExtrasPageSource("REGISTERED CHECK")) {
			WebElement CloseNewRegisterCheckPage = Capabilities.driver.findElementByXPath(textViewContent+"\"Close\"]");
			androidLogs.CapturedLogs(info, "Close button inside new register check found");
			return CloseNewRegisterCheckPage;
		} else {
			androidLogs.CapturedLogs(info, "Close button inside new register check not found");
			return null;
		}
	}
	
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	//WebElements for Dynamic PIN
	
	public WebElement DynamicPINButton() throws Exception {
		if (findExtrasPageSource("Dynamic PIN")) {
			WebElement DynamicPINButton = Capabilities.driver.findElementByXPath(textViewXpath+"\"Dynamic PIN\"]");
			androidLogs.CapturedLogs(info, "Dynamic PIN button found");
			return DynamicPINButton;
		} else {
			androidLogs.CapturedLogs(info, "Dynamic PIN button not found");
			return null;
		}
	}
	
	public WebElement DismissDynamicPINbutton() throws Exception {
		if (findExtrasPageSource("Dismiss")) {
			WebElement DismissDynamicPINbutton = Capabilities.driver.findElementByXPath(buttonXpath+"\"Dismiss\"]");
			androidLogs.CapturedLogs(info, "Dismiss Dynamic PIN button found");
			return DismissDynamicPINbutton;
		} else {
			androidLogs.CapturedLogs(info, "Dismiss Dynamic PIN button not found");
			return null;
		}
	}
	
	public WebElement DynamicPINNumber() throws Exception {
		if (findExtrasPageSource("Dynamic PIN")) {
//			WebElement DynamicPINNumber = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]");
			WebElement DynamicPINNumber = Capabilities.driver.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/dynamic_pin_number\"]");
			

			
			androidLogs.CapturedLogs(info, "Dynamic PIN numbers found");
			return DynamicPINNumber;
		} else {
			androidLogs.CapturedLogs(info, "Dynamic PIN numbers not found");
			return null;
		}
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	//Web elements for Transfer Funds
	public WebElement TransferFundsButton() throws Exception {
		if (findExtrasPageSource("Transfer Funds")) {
			WebElement TransferFundsButton = Capabilities.driver.findElementByXPath(textViewXpath+"\"Transfer Funds\"]");
			androidLogs.CapturedLogs(info, "Transfer funds button found");
			return TransferFundsButton;
		} else {
			androidLogs.CapturedLogs(info, "Transfer funds button not found");
			return null;
		}
		}
	
//	public WebElement SmartFundsTab() throws Exception {
//		if (findExtrasPageSource("SmartFunds")) {
//			WebElement SmartFundsTab = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"SmartFunds\"]");
//			androidLogs.CapturedLogs(info, "SmartFunds tab found");
//			return SmartFundsTab;
//		} else {
//			androidLogs.CapturedLogs(info, "SmartFunds tab not found");
//			return null;
//		}
//		}
		
		public WebElement OneTimeTransferRadioButton() throws Exception {
			if (findExtrasPageSource("One time transfer")) {
				WebElement OneTimeTransferRadioButton = Capabilities.driver.findElementByXPath(textViewXpath+"\"One time transfer\"]");
				androidLogs.CapturedLogs(info, "One time transfer radio button found");
				return OneTimeTransferRadioButton;
			} else {
				androidLogs.CapturedLogs(info, "One time transfer radio button not found");
				return null;
			}	
	}
		
		public WebElement NextTransferFundsButton() throws Exception {
			if (findExtrasPageSource("Next")) {
				WebElement NextTransferFundsButton = Capabilities.driver.findElementByXPath(buttonXpath+"\"Next\"]");
				androidLogs.CapturedLogs(info, "Next button select type screen found");
				return NextTransferFundsButton;
			} else {
				androidLogs.CapturedLogs(info, "Next button select type screen not found");
				return null;
			}	
	}
		
		public WebElement EnterAmountTextBox() throws Exception {
			if (findExtrasPageSource("$0.00")) {
				WebElement EnterAmountTextBox = Capabilities.driver.findElementByXPath(editTextXpath+"\"$0.00\"]");
				androidLogs.CapturedLogs(info, "Enter amount textbox found");
				return EnterAmountTextBox;
			} else {
				androidLogs.CapturedLogs(info, "Enter amount textbox not found");
				return null;
			}	
	}
		
		public WebElement SubmitButton() throws Exception {
			if (findExtrasPageSource("Submit")) {
				WebElement SubmitButton = Capabilities.driver.findElementByXPath(buttonXpath+"\"Submit\"]");
				androidLogs.CapturedLogs(info, "Submit button found");
				return SubmitButton;
			} else {
				androidLogs.CapturedLogs(info, "Submit button not found");
				return null;
			}	
	}
		
		public WebElement DismissButtonTransferFunds() throws Exception {
			if (findExtrasPageSource("Dismiss")) {
				WebElement DismissButtonTransferFunds = Capabilities.driver.findElementByXPath(buttonXpath+"\"Dismiss\"]");
				androidLogs.CapturedLogs(info, "Dismiss button found");
				return DismissButtonTransferFunds;
			} else {
				androidLogs.CapturedLogs(info, "Dismiss button not found");
				return null;
			}	
	}
		
	// Web elements for Repeat transfer funds flow

		public WebElement RepeatTransferRadioButton() throws Exception {
			if (findExtrasPageSource("Repeat transfer")) {
				WebElement RepeatTransferRadioButton = Capabilities.driver.findElementByXPath(textViewXpath+"\"Repeat transfer\"]");
				androidLogs.CapturedLogs(info, "Repeat transfer radio button found");
				return RepeatTransferRadioButton;
			} else {
				androidLogs.CapturedLogs(info, "Repeat transfer radio button not found");
				return null;
			}	
	}
		
	public WebElement SelectBankAccount() throws Exception {
		if (findExtrasPageSource("Transfer to")) {
			WebElement RepeatTransferRadioButton = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
			androidLogs.CapturedLogs(info, "Bank account radio button found");
			return RepeatTransferRadioButton;
		} else {
			androidLogs.CapturedLogs(info, "Bank account radio button not found");
			return null;
		}
	}
	
	public WebElement PercentOfBalanceTab() throws Exception {
		if (findExtrasPageSource("% of balance")) {
			WebElement PercentOfBalanceTab = Capabilities.driver.findElementByXPath(textViewXpath+"\"% of balance\"]");
			androidLogs.CapturedLogs(info, "% of balance tab found");
			return PercentOfBalanceTab;
		} else {
			androidLogs.CapturedLogs(info, "% of balance tab not found");
			return null;
		}
	}
		
	public WebElement EnterPercentTextBox() throws Exception {
		if (findExtrasPageSource("0")) {
			WebElement EnterPercentTextBox = Capabilities.driver.findElementByXPath(editTextXpath+"\"0\"]");
			androidLogs.CapturedLogs(info, "Enter Percent textbox found");
			return EnterPercentTextBox;
		} else {
			androidLogs.CapturedLogs(info, "Enter Percent textbox not found");
			return null;
		}	
}
	
	public WebElement SetStartDatePicker() throws Exception {
		if (findExtrasPageSource("")) {
			WebElement SetStartDatePicker = Capabilities.driver.findElementByXPath(editTextXpath+"\"\"]");
			androidLogs.CapturedLogs(info, "Set Start date found");
			return SetStartDatePicker;
		} else {
			androidLogs.CapturedLogs(info, "Set start date not found");
			return null;
		}	
}
	
	
	public WebElement DailyRepeatSchedule() throws Exception {
		if (findExtrasPageSource("Daily")) {
			WebElement DailyRepeatSchedule = Capabilities.driver.findElementByXPath(radioButton+"\"Daily\"]");
			androidLogs.CapturedLogs(info, "Daily Repeat schedule found");
			return DailyRepeatSchedule;
		} else {
			androidLogs.CapturedLogs(info, "Daily Repeat schedule not found");
			return null;
		}
	}
	
	public WebElement SetEndDateSwitch() throws Exception {
		if (findExtrasPageSource("End date OFF")) {
			WebElement SetEndDateSwitch = Capabilities.driver.findElementByXPath(switchOption+"\"End date OFF\"]");
			androidLogs.CapturedLogs(info, "Set End date switch found");
			return SetEndDateSwitch;
		} else {
			androidLogs.CapturedLogs(info, "Set End date switch not found");
			return null;
		}
	}
	
	public WebElement WeeklyRepeatSchedule() throws Exception {
		if (findExtrasPageSource("Weekly")) {
			WebElement WeeklyRepeatSchedule = Capabilities.driver.findElementByXPath(radioButton+"\"Weekly\"]");
			androidLogs.CapturedLogs(info, "Weekly Repeat schedule found");
			return WeeklyRepeatSchedule;
		} else {
			androidLogs.CapturedLogs(info, "Weekly Repeat schedule not found");
			return null;
		}
	}
	
	public WebElement SaturdayWeekly() throws Exception {
		if (findExtrasPageSource("Saturday")) {
			WebElement MondayWeekly = Capabilities.driver.findElementByXPath(checkBox+"\"Saturday\"]");
			androidLogs.CapturedLogs(info, "Saturday found");
			return MondayWeekly;
		} else {
			androidLogs.CapturedLogs(info, "Saturday not found");
			return null;
		}
	}
	
	public WebElement MonthlyRepeatSchedule() throws Exception {
		if (findExtrasPageSource("Monthly")) {
			WebElement MonthlyRepeatSchedule = Capabilities.driver.findElementByXPath(radioButton+"\"Monthly\"]");
			androidLogs.CapturedLogs(info, "Monthly Repeat schedule found");
			return MonthlyRepeatSchedule;
		} else {
			androidLogs.CapturedLogs(info, "Monthly Repeat schedule not found");
			return null;
		}
	}
	
	public WebElement MonthlyDate1RepeatSchedule() throws Exception {
		if (findExtrasPageSource("1")) {
			WebElement MonthlyDate1RepeatSchedule = Capabilities.driver.findElementByXPath(textViewXpath+"\"1\"]");
			androidLogs.CapturedLogs(info, "Day 1 on Monthly Repeat schedule found");
			return MonthlyDate1RepeatSchedule;
		} else {
			androidLogs.CapturedLogs(info, "Day 1 on Monthly Repeat schedule not found");
			return null;
		}
	}
	
	public WebElement MonthlyDate2RepeatSchedule() throws Exception {
		if (findExtrasPageSource("2")) {
			WebElement MonthlyRepeatSchedule = Capabilities.driver.findElementByXPath(textViewXpath+"\"2\"]");
			androidLogs.CapturedLogs(info, "Day 2 Monthly Repeat schedule found");
			return MonthlyRepeatSchedule;
		} else {
			androidLogs.CapturedLogs(info, "Day 2 Monthly Repeat schedule not found");
			return null;
		}
	}
	
	public WebElement NextTransferMonthlyDaysFundsButton() throws Exception {
		if (findExtrasPageSource("Next")) {
			WebElement NextTransferMonthlyDaysFundsButton = Capabilities.driver.findElementByXPath(widgetButtonResourceID+"\"com.efsllc.efsmobileapp.stage:id/transfer_next_button\"]");
			androidLogs.CapturedLogs(info, "Next button days screen found");
			return NextTransferMonthlyDaysFundsButton;
		} else {
			androidLogs.CapturedLogs(info, "Next button days screen not found");
			return null;
		}	
}
	
	public WebElement OnceNewSmartFundsAreLoadedRepeatSchedule() throws Exception {
		if (findExtrasPageSource("Once new SmartFunds are loaded")) {
			WebElement OnceNewSmartFundsAreLoadedRepeatSchedule = Capabilities.driver.findElementByXPath(radioButton+"\"Once new SmartFunds are loaded\"]");
			androidLogs.CapturedLogs(info, "Once new smartfunds are loaded Repeat schedule found");
			return OnceNewSmartFundsAreLoadedRepeatSchedule;
		} else {
			androidLogs.CapturedLogs(info, "Once new smartfunds are loaded Repeat schedule not found");
			return null;
		}
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	// Web Elements for Logout Page

	public WebElement HelpScreenContinue() throws Exception {
		if (findExtrasPageSource("Continue")) {
			WebElement HelpScreenContinue = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"Continue\"]");
			androidLogs.CapturedLogs(info, "Help Screen Continue button found");
			return HelpScreenContinue;
		} else {
			androidLogs.CapturedLogs(info, "Help Screen Continue not found");
			return null;
		}
	}
	
	
	public WebElement LogoutHelpScreenContinue() throws Exception {
		if (findExtrasPageSource("Continue")) {
			WebElement LogoutHelpScreenContinue = Capabilities.driver.findElementByXPath(widgetButtonResourceID+"\"com.efsllc.efsmobileapp.stage:id/onboarding_continue_button\"]");
			androidLogs.CapturedLogs(info, "Logout Help Screen Continue button found");
			return LogoutHelpScreenContinue;
		} else {
			androidLogs.CapturedLogs(info, "Logout Help Screen Continue not found");
			return null;
		}
	}
	
	
	public WebElement ProfileHelpScreenContinue() throws Exception {
		if (findExtrasPageSource("Complete your profile")) {
			WebElement ProfileHelpScreenContinue = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"Continue\"]");
			androidLogs.CapturedLogs(info, "Help Screen Continue button found");
			return ProfileHelpScreenContinue;
		} else {
			androidLogs.CapturedLogs(info, "Help Screen Continue not found");
			return null;
		}
	}
	
	public WebElement CompleteYourProfilePage() throws Exception {
		if (findExtrasPageSource("Complete your profile")) {
			WebElement CompleteYourProfilePage = Capabilities.driver
					.findElementByXPath(textViewXpath+"\"Complete your profile\"]");
			androidLogs.CapturedLogs(info, "Complete your profile page found");
			return CompleteYourProfilePage;
		} else {
			androidLogs.CapturedLogs(info, "Complete your profile page not found");
			return null;
		}
	}

	
	public WebElement ProfileButtonFromHome() throws Exception {
		Thread.sleep(2000);
		if (findExtrasPageSource("Navigate up")) {
			
			//web element not yet named trying to use accesibility id's instead.
			//WebElement ProfileButtonFromHome = Capabilities.driver.findElementByXPath(imageButton+"\"Navigate up\"]");
			
			WebElement ProfileButtonFromHome = Capabilities.driver.findElementByAccessibilityId("Navigate up");
			
			androidLogs.CapturedLogs(info, "Profile button found");
			return ProfileButtonFromHome;
		} else {
			androidLogs.CapturedLogs(info, "Profile button not found");
			return null;
		}
	}
	
	
	public WebElement ProfileCardHolderInfoLoaded() throws Exception {
		if (findExtrasPageSource("CARD HOLDER INFORMATION")) {
			WebElement ProfileCardHolderInfoLoaded = Capabilities.driver
					.findElementByXPath(textViewXpath+"\"CARD HOLDER INFORMATION\"]");
			androidLogs.CapturedLogs(info, "Card holder page loaded");
			return ProfileCardHolderInfoLoaded;
		} else {
			androidLogs.CapturedLogs(info, "Card holder page did not load");
			return null;
		}
	}

	
	public WebElement CardLogoutButton() throws Exception {
		Thread.sleep(2000);
		if (findExtrasPageSource("LOG OUT")) {
			WebElement CardLogoutButton = Capabilities.driver
					.findElementByXPath(textViewXpath+"\"LOG OUT\"]");
			androidLogs.CapturedLogs(info, "Log out button on profile page found");
			return CardLogoutButton;
		} else {
			androidLogs.CapturedLogs(info, "Log out button on profile page not found");
			return null;
		}
	}
	
	
	public WebElement CardLogoutModalCancelButton() throws Exception {
		Thread.sleep(2000);
		if (findExtrasPageSource("Cancel")) {
			WebElement CardLogoutModalCancelButton = Capabilities.driver
					.findElementByXPath(buttonXpath+"\"Cancel\"]");
			androidLogs.CapturedLogs(info, "Log out modal Cancel button found");
			return CardLogoutModalCancelButton;
		} else {
			androidLogs.CapturedLogs(info, "Log out modal Cancel button not found");
			return null;
		}
	}
		
		public WebElement CardLogoutModalButton() throws Exception {
			Thread.sleep(2000);
			if (findExtrasPageSource("Log out")) {
				WebElement CardLogoutModalButton = Capabilities.driver
						.findElementByXPath(buttonXpath+"\"Log out\"]");
				androidLogs.CapturedLogs(info, "Log out Modal button found");
				return CardLogoutModalButton;
			} else {
				androidLogs.CapturedLogs(info, "Log out modal button not found");
				return null;
			}
		}		
			// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

			// Web Elements for Spinners
			
		public WebElement checkInSpinnerSecureFuelCardControl() throws Exception {
			if(findExtrasPageSource("ProgressBar")) {
				WebElement checkInSpinnerSecureFuelCardControl = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ProgressBar");
				androidLogs.CapturedLogs(info, "A loading Spinner was located on page wait initalized");
			return checkInSpinnerSecureFuelCardControl;
			}else {
				androidLogs.CapturedLogs(info, "Loading Spinner was not found");
				return null;
			}
			}
		
		
		public WebElement loginButtonSpinner() throws Exception {
			if(findExtrasPageSource("Logging in")) {
				WebElement loginButtonSpinner = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ProgressBar");
				androidLogs.CapturedLogs(info, "A loading Spinner was located on page wait initalized");
			return loginButtonSpinner;
			}else {
				androidLogs.CapturedLogs(info, "Loading Spinner was not found");
				return null;
			}
			}
		
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		// Web Elements for Profile/Account Page
		
		
			
		public WebElement editCardHolderInfoButton() throws Exception {
			if (findExtrasPageSource("Account")) {
				WebElement editCardHolderInfoButton = Capabilities.driver
						.findElementByXPath(imageView+"\"com.efsllc.efsmobileapp.stage:id/editbutton\"]");
				androidLogs.CapturedLogs(info, "Edit Card Holder Button button found");
				return editCardHolderInfoButton;
			} else {
				androidLogs.CapturedLogs(info, "Edit Card Holder Info Button not found");
				return null;
			}
		}
		
		

		public WebElement OpenEditName() throws Exception {
			if (findExtrasPageSource("Name")) {
				WebElement OpenEditName = Capabilities.driver
						.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/tv_name\"]");
				androidLogs.CapturedLogs(info, "Edit Name found");
				return OpenEditName;
			} else {
				androidLogs.CapturedLogs(info, "Edit name not found");
				return null;
			}
		}
		

		public WebElement EditFirstName() throws Exception {
			if (findExtrasPageSource("Edit name")) {
				WebElement EditFirstName = Capabilities.driver
						.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/registration_first_name_edittext\"]");
				androidLogs.CapturedLogs(info, "Edit fist Name text box found");
				return EditFirstName;
			} else {
				androidLogs.CapturedLogs(info, "Edit fist Name text box not found");
				return null;
			}
		}
		

		public WebElement EditLastName() throws Exception {
			if (findExtrasPageSource("Edit name")) {
				WebElement EditLastName = Capabilities.driver
						.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/registration_last_name_edittext\"]");
				androidLogs.CapturedLogs(info, "Edit Last Name textbox found");
				return EditLastName;
			} else {
				androidLogs.CapturedLogs(info, "Edit Last Name textbox not found");
				return null;
			}
		}
		

		public WebElement SaveName() throws Exception {
			if (findExtrasPageSource("Save")) {
				WebElement SaveName = Capabilities.driver
						.findElementByXPath(widgetButtonResourceID+"\"com.efsllc.efsmobileapp.stage:id/saveNameButton\"]");
				androidLogs.CapturedLogs(info, "Save Name button found");
				return SaveName;
			} else {
				androidLogs.CapturedLogs(info, "Save Name button not found");
				return null;
			}
		}
		
		


		public WebElement OpenEditEmail() throws Exception {
			if (findExtrasPageSource("Email")) {
				WebElement OpenEditEmail = Capabilities.driver
						.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/tv_email\"]");
				androidLogs.CapturedLogs(info, "Edit Email found");
				return OpenEditEmail;
			} else {
				androidLogs.CapturedLogs(info, "Edit Email not found");
				return null;
			}
		}
		

		public WebElement editEmailAddress() throws Exception {
			if (findExtrasPageSource("Edit email")) {
				WebElement editEmailAddress = Capabilities.driver
						.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/registration_email_edittext\"]");
				androidLogs.CapturedLogs(info, "Email Address edit textbox found");
				return editEmailAddress;
			} else {
				androidLogs.CapturedLogs(info, "Email Address edit textbox not found");
				return null;
			}
		}
		

		public WebElement SaveEmail() throws Exception {
			if (findExtrasPageSource("Save")) {
				WebElement SaveEmail = Capabilities.driver
						.findElementByXPath(widgetButtonResourceID+"\"com.efsllc.efsmobileapp.stage:id/saveEmailButton\"]");
				androidLogs.CapturedLogs(info, "Save Email button found");
				return SaveEmail;
			} else {
				androidLogs.CapturedLogs(info, "Save Email button not found");
				return null;
			}
		}
		
		
		public WebElement OpenEditMobilePhone() throws Exception {
			if (findExtrasPageSource("Mobile")) {
				WebElement OpenEditName = Capabilities.driver
						.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/tv_mobile_number\"]");
				androidLogs.CapturedLogs(info, "Edit Mobile found");
				return OpenEditName;
			} else {
				androidLogs.CapturedLogs(info, "Edit Mobile not found");
				return null;
			}
		}
		

		public WebElement EditMobilePhone() throws Exception {
			if (findExtrasPageSource("Edit mobile")) {
				WebElement OpenEditName = Capabilities.driver
						.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/registration_phone_edittext\"]");
				androidLogs.CapturedLogs(info, "Edit Mobile phone textbox found");
				return OpenEditName;
			} else {
				androidLogs.CapturedLogs(info, "Edit Mobile phone textbox not found");
				return null;
			}
		}
			

		public WebElement SavePhone() throws Exception {
			if (findExtrasPageSource("Save")) {
				WebElement SavePhone = Capabilities.driver
						.findElementByXPath(widgetButtonResourceID+"\"com.efsllc.efsmobileapp.stage:id/savePhoneButton\"]");
				androidLogs.CapturedLogs(info, "Save Phone button found");
				return SavePhone;
			} else {
				androidLogs.CapturedLogs(info, "Save Phone button not found");
				return null;
			}
		}
		

		public WebElement OpenEditHomeAddress() throws Exception {
			if (findExtrasPageSource("Home")) {
				WebElement OpenEditName = Capabilities.driver
						.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/tv_address\"]");
				androidLogs.CapturedLogs(info, "Edit Address found");
				return OpenEditName;
			} else {
				androidLogs.CapturedLogs(info, "Edit Address not found");
				return null;
			}
		}
		
				
		
		public WebElement EditHomeAddress() throws Exception {
			if (findExtrasPageSource("Edit home")) {
				WebElement OpenEditName = Capabilities.driver
						.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/registration_address_search_edit_text\"]");
				androidLogs.CapturedLogs(info, "Edit Address textbox found");
				return OpenEditName;
			} else {
				androidLogs.CapturedLogs(info, "Edit Address textbox not found");
				return null;
			}
		}
		
		
		public WebElement SaveHomeAddress() throws Exception {
			if (findExtrasPageSource("Save")) {
				WebElement SavePhone = Capabilities.driver
						.findElementByXPath(widgetButtonResourceID+"\"com.efsllc.efsmobileapp.stage:id/savePhoneButton\"]");
				androidLogs.CapturedLogs(info, "Save Home Address button found");
				return SavePhone;
			} else {
				androidLogs.CapturedLogs(info, "Save Home Address button not found");
				return null;
			}
		}
		
		

		public WebElement CloseHomeAddress() throws Exception {
			if (findExtrasPageSource("Navigate up")) {
				WebElement CloseHomeAddress = Capabilities.driver
						.findElementByXPath(imageButton+"\"Navigate up\"]");
				androidLogs.CapturedLogs(info, "Close Home Address button found");
				
				return CloseHomeAddress;
			} else {
				androidLogs.CapturedLogs(info, "Close Home Address button not found");
				return null;
			}
		}
		
		
		public WebElement closeProfileXButton() throws Exception {
			Thread.sleep(2000);
			if (findExtrasPageSource("Close")) {
				WebElement closeProfileXButton = Capabilities.driver
						.findElementByXPath(textViewContent+"\"Close\"]");
				androidLogs.CapturedLogs(info, "Profile Close X button found");
				return closeProfileXButton;
			} else {
				androidLogs.CapturedLogs(info, "Profile Close X button not found");
				return null;
			}
		}
		
	
		public WebElement changePinButtonFromProfile() throws Exception {
				if (findExtrasPageSource("Change PIN")) {
				WebElement changePinButtonFromProfile = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Change PIN\"]");
				androidLogs.CapturedLogs(info, "Change Pin button on profile found");
				return changePinButtonFromProfile;
			} else {
				androidLogs.CapturedLogs(info, "Change Pin button on profile not found or this is a passcode account");
				return null;
			}
		}
		

		public WebElement currentPinOnProfileTextBox() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Current PIN")) {
				WebElement changePinButtonFromProfile = Capabilities.driver
						.findElementByXPath(editTextXpath+"\"Current PIN\"]");
				androidLogs.CapturedLogs(info, "Current Pin on profile textbox is found");
				return changePinButtonFromProfile;
			} else {
				androidLogs.CapturedLogs(info, "Current Pin on profile textbox is not found");
				return null;
			}
		}
		
		
		public WebElement newCurrentPinOnProfileTextBox() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("New PIN")) {
				WebElement newCurrentPinOnProfileTextBox = Capabilities.driver
						.findElementByXPath(editTextXpath+"\"New PIN\"]");
				androidLogs.CapturedLogs(info, "New Pin on profile textbox is found");
				return newCurrentPinOnProfileTextBox;
			} else {
				androidLogs.CapturedLogs(info, "New Pin on profile textbox is not found");
				return null;
			}
		}
		
		
		
		public WebElement confirmNewcurrentPinOnProfileTextBox() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Confirm new PIN")) {
				WebElement confirmNewcurrentPinOnProfileTextBox = Capabilities.driver
						.findElementByXPath(editTextXpath+"\"Confirm new PIN\"]");
				androidLogs.CapturedLogs(info, "Confirm new Pin on profile textbox is found");
				return confirmNewcurrentPinOnProfileTextBox;
			} else {
				androidLogs.CapturedLogs(info, "Confirm new pin on profile textbox is not found");
				return null;
			}
		}
		
		
		public WebElement confirmNewPinSaveButton() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Save")) {
				WebElement confirmNewcurrentPinOnProfileTextBox = Capabilities.driver
						.findElementByXPath(buttonXpath+"\"Save\"]");
				androidLogs.CapturedLogs(info, "Confirm new Pin save Button is found");
				return confirmNewcurrentPinOnProfileTextBox;
			} else {
				androidLogs.CapturedLogs(info, "Confirm new Pin save Button is not found");
				return null;
			}
		}
		

		public WebElement pinsDontMatchModalOkButton() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("OK")) {
				WebElement pinsDontMatchModalOkButton = Capabilities.driver
						.findElementByXPath(buttonXpath+"\"OK\"]");
				androidLogs.CapturedLogs(info, "Pins Dont match modal is found");
				return pinsDontMatchModalOkButton;
			} else {
				androidLogs.CapturedLogs(info, "Pins Dont match modal is not found");
				return null;
			}
		}
		
		
		public WebElement currentPinWrongModalOkButton() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("OK")) {
				WebElement currentPinWrongModalOkButton = Capabilities.driver
						.findElementByXPath(buttonXpath+"\"OK\"]");
				androidLogs.CapturedLogs(info, "Current pin incorrect modal is found");
				return currentPinWrongModalOkButton;
			} else {
				androidLogs.CapturedLogs(info, "Current pin incorrect modal is not found");
				return null;
			}
		}
		
		public WebElement lastFourWrongModalOkButton() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("OK")) {
				WebElement lastFourWrongModalOkButton = Capabilities.driver
						.findElementByXPath(buttonXpath+"\"OK\"]");
				androidLogs.CapturedLogs(info, "Last four of card modal is found");
				return lastFourWrongModalOkButton;
			} else {
				androidLogs.CapturedLogs(info, "Last four of card modal  is not found");
				return null;
			}
		}
		
		public WebElement changePassCodeButtonFromProfile() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Change passcode")) {
				WebElement changePassCodeButtonFromProfile = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Change passcode\"]");
				androidLogs.CapturedLogs(info, "Change passcode button on profile found");
				return changePassCodeButtonFromProfile;
			} else {
				androidLogs.CapturedLogs(info, "Change passcode button on profile not found or this is a PIN account");
				return null;
			}
		}
		
		
		
		public WebElement currentPasscodeOnProfileTextBox() throws Exception {
				if (findExtrasPageSource("Current passcode")) {
				WebElement currentPasscodeOnProfileTextBox = Capabilities.driver
						.findElementByXPath(editTextXpath+"\"Current passcode\"]");
				androidLogs.CapturedLogs(info, "Current Passcode on profile textbox is found");
				return currentPasscodeOnProfileTextBox;
			} else {
				androidLogs.CapturedLogs(info, "Current Passcode on profile textbox is not found");
				return null;
			}
		}
		
		
		public WebElement newCurrentPasscodeOnProfileTextBox() throws Exception {
				if (findExtrasPageSource("New passcode")) {
				WebElement newCurrentPinOnProfileTextBox = Capabilities.driver
						.findElementByXPath(editTextXpath+"\"New passcode\"]");
				androidLogs.CapturedLogs(info, "New Passcode on profile textbox is found");
				return newCurrentPinOnProfileTextBox;
			} else {
				androidLogs.CapturedLogs(info, "New Passcode on profile textbox is not found");
				return null;
			}
		}
		
		
		
		public WebElement confirmNewcurrentPasscodeOnProfileTextBox() throws Exception {
				if (findExtrasPageSource("Confirm new passcode")) {
				WebElement confirmNewcurrentPinOnProfileTextBox = Capabilities.driver
						.findElementByXPath(editTextXpath+"\"Confirm new passcode\"]");
				androidLogs.CapturedLogs(info, "Confirm new Passcode on profile textbox is found");
				return confirmNewcurrentPinOnProfileTextBox;
			} else {
				androidLogs.CapturedLogs(info, "Confirm new Passcode on profile textbox is not found");
				return null;
			}
		}
		
		
		public WebElement confirmNewPasscodeSaveButton() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Save")) {
				WebElement confirmNewcurrentPinOnProfileTextBox = Capabilities.driver
						.findElementByXPath(buttonXpath+"\"Save\"]");
				androidLogs.CapturedLogs(info, "Confirm new Pin save Button is found");
				return confirmNewcurrentPinOnProfileTextBox;
			} else {
				androidLogs.CapturedLogs(info, "Confirm new Passcode save Button is not found");
				return null;
			}
		}
		
		public WebElement passcodeDontMatchModalOkButton() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("OK")) {
				WebElement passcodeDontMatchModalOkButton = Capabilities.driver
						.findElementByXPath(buttonXpath+"\"OK\"]");
				androidLogs.CapturedLogs(info, "Passcode Dont match modal is found");
				return passcodeDontMatchModalOkButton;
			} else {
				androidLogs.CapturedLogs(info, "Passcode Dont match modal is not found");
				return null;
			}
		}
		

		public WebElement currentPasscodeWrongModalOkButton() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("OK")) {
				WebElement currentPasscodeWrongModalOkButton = Capabilities.driver
						.findElementByXPath(buttonXpath+"\"OK\"]");
				androidLogs.CapturedLogs(info, "Current passcode incorrect modal is found");
				return currentPasscodeWrongModalOkButton;
			} else {
				androidLogs.CapturedLogs(info, "Current passcode incorrect modal is not found");
				return null;
			}
		}
		
		public WebElement passcodeLastSixModalOkButton() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("OK")) {
				WebElement passcodeLastSixModalOkButton = Capabilities.driver
						.findElementByXPath(buttonXpath+"\"OK\"]");
				androidLogs.CapturedLogs(info, "Passcode last six modal is found");
				return passcodeLastSixModalOkButton;
			} else {
				androidLogs.CapturedLogs(info, "Passcode last six modal is not found");
				return null;
			}
		}
		

		
		public WebElement SmartFundsAlertsButton() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("SmartFunds alert settings")) {
				WebElement SmartFundsAlertsButton = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"SmartFunds alert settings\"]");
				androidLogs.CapturedLogs(info, "SmartFunds Alert settings button is found");
				return SmartFundsAlertsButton;
			} else {
				androidLogs.CapturedLogs(info, "SmartFunds Alert settings is not found");
				return null;
			}
		}
		
		
		public WebElement SmartFundsAlertsCloseButton() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Close")) {
				WebElement SmartFundsAlertsCloseButton = Capabilities.driver
						.findElementByXPath(textViewContent+"\"Close\"]");
				androidLogs.CapturedLogs(info, "SmartFunds Alert close is found");
				return SmartFundsAlertsCloseButton;
			} else {
				androidLogs.CapturedLogs(info, "SmartFunds Alert close is not found");
				return null;
			}
		}
		
		
		
		public WebElement SmartFundsstatementsButton() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("SmartFunds statements")) {
				WebElement SmartFundsstatementsButton = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"SmartFunds statements\"]");
				androidLogs.CapturedLogs(info, "Statement button is found");
				return SmartFundsstatementsButton;
			} else {
				androidLogs.CapturedLogs(info, "Statement button is not found");
				return null;
			}
		}
		
		
		public WebElement SmartFundsstatementsCloseButton() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Close")) {
				WebElement SmartFundsstatementsCloseButton = Capabilities.driver
						.findElementByXPath(textViewContent+"\"Close\"]");
				androidLogs.CapturedLogs(info, "Statement close button is found");
				return SmartFundsstatementsCloseButton;
			} else {
				androidLogs.CapturedLogs(info, "Statement close button is not found");
				return null;
			}
		}
		
				
		public WebElement TouchIDBiometricsToggle() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Use touch ID OFF")) {
				WebElement TouchIDBiometricsToggle = Capabilities.driver
						.findElementByXPath(switchOption+"\"Use touch ID OFF\"]");
				androidLogs.CapturedLogs(info, "Biometrics toggle is found");
				return TouchIDBiometricsToggle;
			} else {
				androidLogs.CapturedLogs(info, "Biometrics toggle is not found");
				return null;
			}
		}
		
		
		public WebElement TouchIDBiometricsToggleDenyModal() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Deny")) {
				WebElement TouchIDBiometricsToggleDenyModal = Capabilities.driver
						.findElementByXPath(buttonXpath+"\"Deny\"]");
				androidLogs.CapturedLogs(info, "Biometrics Deny toggle is found");
				return TouchIDBiometricsToggleDenyModal;
			} else {
				androidLogs.CapturedLogs(info, "Biometrics Deny toggle is not found");
				return null;
			}
		}

		
		public WebElement SecurityQuestions() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Security questions")) {
				WebElement SecurityQuestions = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Security questions\"]");
				androidLogs.CapturedLogs(info, "Security questions button is found");
				return SecurityQuestions;
			} else {
				androidLogs.CapturedLogs(info, "Security questions button is not found");
				return null;
			}
		}
		
		public WebElement OpenSecurityQuestionOne() throws Exception {
			if (findExtrasPageSource("Question 1")) {
				WebElement OpenSecurityQuestionOne = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Question 1\"]");
				androidLogs.CapturedLogs(info, "Security questions one button is found");
				return OpenSecurityQuestionOne;
			} else {
				androidLogs.CapturedLogs(info, "Security questions one button is not found");
				return null;
			}
		}
		
				
			
		public WebElement OpenSecurityQuesrtionPicker() throws Exception {
			if (findExtrasPageSource("Security question")) {
				WebElement OpenSecurityQuesrtionPicker = Capabilities.driver
						.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/question_select_edit_text\"]");
									
				androidLogs.CapturedLogs(info, "New security questions one is found");
				return OpenSecurityQuesrtionPicker;
			} else {
				androidLogs.CapturedLogs(info, "New security questions one is not found");
				return null;
			}
		}
		
		
		
		public WebElement SelectNewQuestionByNameOne() throws Exception {
			if (findExtrasPageSource("Choose question")) {
				WebElement SelectNewQuestionByNameOne = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"What is your mother's maiden name?\"]");
				
				//WebElement PickNewSecurityQuesrtionOne = Capabilities.driver
				//		.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/question_select_edit_text\"]");
			
				
				androidLogs.CapturedLogs(info, "New security questions one is found");
				return SelectNewQuestionByNameOne;
			} else {
				androidLogs.CapturedLogs(info, "New security questions one is not found");
				return null;
			}
		}
		
		
		public WebElement CloseNewSecurityOne() throws Exception {
			if (findExtrasPageSource("Close")) {
				WebElement CloseNewSecurityOne = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Close\"]");
				androidLogs.CapturedLogs(info, "Close new security questions one button is found");
				return CloseNewSecurityOne;
			} else {
				androidLogs.CapturedLogs(info, "Close new security questions one is not found");
				return null;
			}
		}

		public WebElement AnswerSecurityQuestionOne() throws Exception {
			if (findExtrasPageSource("Your answer")) {
				WebElement AnswerSecurityQuestionOne = Capabilities.driver
						.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/answer_selected_edit_text\"]");
				androidLogs.CapturedLogs(info, "Security questions one textbox button is found");
				return AnswerSecurityQuestionOne;
			} else {
				androidLogs.CapturedLogs(info, "Security questions one textbox is not found");
				return null;
			}
		}
		
		

		public WebElement SaveSecurityQuestions() throws Exception {
			if (findExtrasPageSource("Save")) {
				WebElement AnswerSecurityQuestionOne = Capabilities.driver
						.findElementByXPath(widgetButtonResourceID+"\"com.efsllc.efsmobileapp.stage:id/security_question_save_button\"]");
				androidLogs.CapturedLogs(info, "Security questions Save button is found");
				return AnswerSecurityQuestionOne;
			} else {
				androidLogs.CapturedLogs(info, "Security questions Save is not found");
				return null;
			}
		}
		

		public WebElement OpenSecurityQuestionTwo() throws Exception {
			if (findExtrasPageSource("Question 2")) {
				WebElement OpenSecurityQuestionTwo = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Question 2\"]");
				androidLogs.CapturedLogs(info, "Security questions two button is found");
				return OpenSecurityQuestionTwo;
			} else {
				androidLogs.CapturedLogs(info, "Security questions two button is not found");
				return null;
			}
		}
		
		
		public WebElement OpenNewSecurityQuesrtionTwo() throws Exception {
			if (findExtrasPageSource("Security question 1")) {
				WebElement OpenNewSecurityQuesrtionTwo = Capabilities.driver
						.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/question_select_edit_text\"]");
				androidLogs.CapturedLogs(info, "Open new security questions two is found");
				return OpenNewSecurityQuesrtionTwo;
			} else {
				androidLogs.CapturedLogs(info, "Open new security questions two is not found");
				return null;
			}
		}
		

		

		public WebElement PickNewSecurityQuestionTwo() throws Exception {
			if (findExtrasPageSource("Choose question")) {
				WebElement PickNewSecurityQuesrtionTwo = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"What was your childhood nickname?\"]");
				androidLogs.CapturedLogs(info, "New security questions teo is found");
				return PickNewSecurityQuesrtionTwo;
			} else {
				androidLogs.CapturedLogs(info, "New security questions two is not found");
				return null;
			}
		}
		
		public WebElement CloseNewSecuritytwo() throws Exception {
		if (findExtrasPageSource("Close")) {
				WebElement CloseNewSecuritytwo = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Close\"]");
				androidLogs.CapturedLogs(info, "Close security questions two button is found");
				return CloseNewSecuritytwo;
			} else {
				androidLogs.CapturedLogs(info, "Close security questions two is not found");
				return null;
			}
		}
		
		public WebElement AnswerSecurityQuestionTwo() throws Exception {
			if (findExtrasPageSource("Security")) {
				WebElement AnswerSecurityQuestionTwo = Capabilities.driver
						.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/answer_selected_edit_text\"]");
				androidLogs.CapturedLogs(info, "Security questions two textbox button is found");
				return AnswerSecurityQuestionTwo;
			} else {
				androidLogs.CapturedLogs(info, "Security questions two textbox is not found");
				return null;
			}
		}
		
		public WebElement OpenSecurityQuestionThree() throws Exception {
			if (findExtrasPageSource("Question 3")) {
				WebElement OpenSecurityQuestionThree = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Question 3\"]");
				androidLogs.CapturedLogs(info, "Security questions three button is found");
				return OpenSecurityQuestionThree;
			} else {
				androidLogs.CapturedLogs(info, "Security questions three button is not found");
				return null;
			}
		}
		
		
		public WebElement OpenNewSecurityQuesrtionThree() throws Exception {
			if (findExtrasPageSource("Security question 1")) {
				WebElement OpenNewSecurityQuesrtionThree = Capabilities.driver
						.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/question_select_edit_text\"]");
				androidLogs.CapturedLogs(info, "Open new security questions three is found");
				return OpenNewSecurityQuesrtionThree;
			} else {
				androidLogs.CapturedLogs(info, "Open new security questions three is not found");
				return null;
			}
		}
		

		public WebElement PickNewSecurityQuesrtionThree() throws Exception {
			if (findExtrasPageSource("Choose question")) {
				WebElement PickNewSecurityQuesrtionThree = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"What is your favorite movie?\"]");
				androidLogs.CapturedLogs(info, "New security questions thee is found");
				return PickNewSecurityQuesrtionThree;
			} else {
				androidLogs.CapturedLogs(info, "New security questions three is not found");
				return null;
			}
		}
		
		public WebElement CloseNewSecuritythree() throws Exception {
			if (findExtrasPageSource("Close")) {
				WebElement CloseNewSecuritythree = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Close\"]");
				androidLogs.CapturedLogs(info, "Close security questions three button is found");
				return CloseNewSecuritythree;
			} else {
				androidLogs.CapturedLogs(info, "Close security questions three is not found");
				return null;
			}
		}
		
		public WebElement AnswerSecurityQuestionThree() throws Exception {
			if (findExtrasPageSource("Security")) {
				WebElement AnswerSecurityQuestionThree = Capabilities.driver
						.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efsmobileapp.stage:id/answer_selected_edit_text\"]");
				androidLogs.CapturedLogs(info, "Security questions three textbox button is found");
				return AnswerSecurityQuestionThree;
			} else {
				androidLogs.CapturedLogs(info, "Security questions three textbox is not found");
				return null;
			}
		}
		
		
		public WebElement CloseSecurityQuestionPage() throws Exception {
			if (findExtrasPageSource("Security")) {
				WebElement CloseSecurityQuestionPage = Capabilities.driver
						.findElementByXPath(textViewResource+"\"com.efsllc.efsmobileapp.stage:id/close_item\"]");
				androidLogs.CapturedLogs(info, "Close Security questions button is found");
				return CloseSecurityQuestionPage;
			} else {
				androidLogs.CapturedLogs(info, "Close Security questions is not found");
				return null;
			}
		}
		
		
		
		
		public WebElement PrivacyPolicy() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Privacy policy")) {
				WebElement PrivacyPolicy = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Privacy policy\"]");
				androidLogs.CapturedLogs(info, "Privacy Policy is found");
				return PrivacyPolicy;
			} else {
				androidLogs.CapturedLogs(info, "Privacy Policy is not found");
				return null;
			}
		}
		
		
		public WebElement PrivacyPolicyClose() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Privacy policy")) {
				WebElement PrivacyPolicyClose = Capabilities.driver
						.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/close_item\"]");
				androidLogs.CapturedLogs(info, "Privacy Policy close button is found");
				return PrivacyPolicyClose;
			} else {
				androidLogs.CapturedLogs(info, "Privacy Policy close Button is not found");
				return null;
			}
		}
		
		
		public WebElement TermsOfUse() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Terms of use")) {
				WebElement TermsOfUse = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Terms of use\"]");
				androidLogs.CapturedLogs(info, "Privacy Policy Button is found");
				return TermsOfUse;
			} else {
				androidLogs.CapturedLogs(info, "Privacy Policy Button is not found");
				return null;
			}
		}
		
		
		public WebElement TermsOfUseClose() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Terms of use")) {
				WebElement TermsOfUseClose = Capabilities.driver
						.findElementByXPath(widgetTextViewResource+"\"com.efsllc.efsmobileapp.stage:id/close_item\"]");
				androidLogs.CapturedLogs(info, "Terms of use close button is found");
				return TermsOfUseClose;
			} else {
				androidLogs.CapturedLogs(info, "Terms of use close Button is not found");
				return null;
			}
		}
		

		public WebElement CallCustomerSupportButton() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Call customer support")) {
				WebElement CallCustomerSupportButton = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Call customer support\"]");
				androidLogs.CapturedLogs(info, "Call Customer support button is found");
				return CallCustomerSupportButton;
			} else {
				androidLogs.CapturedLogs(info, "Call Customer support button is not found");
				return null;
			}
		}		
		

		
		public WebElement AppVersionHomeAccountPage() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Account")) {
				WebElement AppVersionHomeAccountPage = Capabilities.driver
						.findElementByXPath(textViewResource+"\"com.efsllc.efsmobileapp.stage:id/version_text\"]");
				androidLogs.CapturedLogs(info, "App version is found");
				return AppVersionHomeAccountPage;
			} else {
				androidLogs.CapturedLogs(info, "App version is not found");
				return null;
			}
		}	
		
		
		public WebElement HelpScreenOpenButton() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Help screens")) {
				WebElement HelpScreenOpenButton = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Help screens\"]");
				androidLogs.CapturedLogs(info, "Help Screens button from home page is found");
				return HelpScreenOpenButton;
			} else {
				androidLogs.CapturedLogs(info, "Help Screens button from home page is not found");
				return null;
			}
		}
		
		public WebElement HelpScreensHome() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Home")) {
				WebElement HelpScreensHome = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Home\"]");
				androidLogs.CapturedLogs(info, "Help Screens home button is found");
				return HelpScreensHome;
			} else {
				androidLogs.CapturedLogs(info, "Help Screens button home button is not found");
				return null;
			}
		}
		
		public WebElement HelpScreensAccount() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Account")) {
				WebElement HelpScreensAccount = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Account\"]");
				androidLogs.CapturedLogs(info, "Help Screens acccount button is found");
				return HelpScreensAccount;
			} else {
				androidLogs.CapturedLogs(info, "Help Screens account button is not found");
				return null;
			}
		}
		
		public WebElement HelpScreensTransactions() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Transactions")) {
				WebElement HelpScreensTransactions = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Transactions\"]");
				androidLogs.CapturedLogs(info, "Help Screens transations button is found");
				return HelpScreensTransactions;
			} else {
				androidLogs.CapturedLogs(info, "Help Screens transations button is not found");
				return null;
			}
		}
		
		public WebElement HelpScreensFindFuelNearby() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Find Fuel")) {
				WebElement HelpScreensFindFuelNearby = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Find Fuel\"]");
				androidLogs.CapturedLogs(info, "Help Screens find fuel button is found");
				return HelpScreensFindFuelNearby;
			} else {
				androidLogs.CapturedLogs(info, "Help Screens find fuel button is not found");
				return null;
			}
		}
		
		public WebElement HelpScreensFindFuelPlanATrip() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Find fuel plan a trip")) {
				WebElement HelpScreensFindFuelPlanATrip = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Find fuel plan a trip\"]");
				androidLogs.CapturedLogs(info, "Help Screens find fuel plan a trip button is found");
				return HelpScreensFindFuelPlanATrip;
			} else {
				androidLogs.CapturedLogs(info, "Help Screens find fuel plan a trip button is not found");
				return null;
			}
		}
		
		
		public WebElement HelpScreensCloseButton() throws Exception {
			 Thread.sleep(3000);
			if (findExtrasPageSource("Close")) {
				WebElement HelpScreensCloseButton = Capabilities.driver
						.findElementByXPath(textViewResource+"\"com.efsllc.efsmobileapp.stage:id/close_item\"]");
						androidLogs.CapturedLogs(info, "Help Screens close button is found");
				return HelpScreensCloseButton;
			} else {
				androidLogs.CapturedLogs(info, "Help Screens close button is not found");
				return null;
			}
		}	
		
		


		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

				// Web Elements for MultiCard Login Page	
		
		public WebElement EditPencilButton() throws Exception {
			
			if (findExtrasPageSource("Select a card")) {
				WebElement EditPencilButton = Capabilities.driver.findElementByXPath(imageView+"\"com.efsllc.efsmobileapp.stage:id/editButton\"]");
				androidLogs.CapturedLogs(info, "Edit pencil Button found");
				return EditPencilButton;
			} else {
				androidLogs.CapturedLogs(info, "Edit pencil Button not found");
				return null;
			}
		}
		
		
public WebElement XCloseButton() throws Exception {
			
			if (findExtrasPageSource("Select a card")) {
				WebElement XCloseButton = Capabilities.driver.findElementByXPath(imageView+"\"com.efsllc.efsmobileapp.stage:id/editButton\"]");
				androidLogs.CapturedLogs(info, "X close Button found");
				return XCloseButton;
			} else {
				androidLogs.CapturedLogs(info, "X close Button not found");
				return null;
			}
		}
		

public WebElement RemoveCardButton() throws Exception {
	
	if (findExtrasPageSource("Select a card")) {
		WebElement RemoveCardButton = Capabilities.driver.findElementByXPath(textViewResource+"\"com.efsllc.efsmobileapp.stage:id/removeCardButton\"]");
		androidLogs.CapturedLogs(info, "Remove card Button found");
		return RemoveCardButton;
	} else {
		androidLogs.CapturedLogs(info, "Remove card Button not found");
		return null;
	}
}


		WebElement MultiCardSelector(String cardNum) throws Exception {
			
			if (findLoginPageElement("•••• " + cardNum)) {
				WebElement MultiCardSelector = Capabilities.driver.findElementByXPath(textViewXpath+"\"•••• "+cardNum+"\"]");
				androidLogs.CapturedLogs(info, "MultiCard Selector for 6344 found");
				return MultiCardSelector;
			} else {
				androidLogs.CapturedLogs(info, "MultiCard Selector for 6344 not found");
				return null;
			}
		}
			
		
		public WebElement MultiCardPinPassTextBox() throws Exception {
			if (findExtrasPageSource("PIN or passcode")) {
				WebElement MultiCardPinPassTextBox = Capabilities.driver
						.findElementByXPath(editTextXpath+"\"Pin or passcode\"]");
				androidLogs.CapturedLogs(info, " MultiCard PIN or Passcode text box found");
				return MultiCardPinPassTextBox;
			} else {
				androidLogs.CapturedLogs(info, "MultiCard PIN or Passcode text box not found");
				return null;
			}
		}
		
		public WebElement MultiCardLoginButton() throws Exception {
			
			if (findExtrasPageSource("Log in")) {
				WebElement MultiCardLoginButton = Capabilities.driver
						.findElementByXPath(textViewXpath+"\"Log in\"]");
				androidLogs.CapturedLogs(info, "MultiCard Log in button found");
				return MultiCardLoginButton;
			} else {
				androidLogs.CapturedLogs(info, "MultiCard Log in button not found");
				return null;
			}
		}
		
//		public WebElement progressSpinnerLoadMoneyCodes() throws Exception {
//			if(findExtrasPageSource("ProgressBar")) {
//			WebElement progressSpinnerLoadMoneyCodes = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ProgressBar");
//
//			androidLogs.CapturedLogs(info, "A loading Spinner was located on page wait initalized");
//			return progressSpinnerLoadMoneyCodes;
//			}else {
//				androidLogs.CapturedLogs(info, "Loading Spinner was not found");
//				return null;
//			}
//			}
		

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

				// Web Elements for Onbarding and tabs extras	
		
		
public WebElement OpenTransactionsTab() throws Exception {
			
			if (findExtrasPageSource("Transactions")) {
				WebElement OpenTransactionsTab = Capabilities.driver
						.findElementByXPath(widgetLayoutContent+"\"Transactions\"]");
				androidLogs.CapturedLogs(info, "Transactions Tab found");
				return OpenTransactionsTab;
			} else {
				androidLogs.CapturedLogs(info, "Transactions Tab not found");
				return null;
			}
		}


public WebElement TransactionHelpScreenContinue() throws Exception {
	
	if (findExtrasPageSource("Continue")) {
		WebElement TransactionHelpScreenContinue = Capabilities.driver
				.findElementByXPath(buttonXpath+"\"Continue\"]");
		androidLogs.CapturedLogs(info, "Transaction help Screen continue Button found");
		return TransactionHelpScreenContinue;
	} else {
		androidLogs.CapturedLogs(info, "Transaction help Screen continue Button not found");
		return null;
	}
}




// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		// Web Elements for Find Fuel	


public WebElement OpenFindFuelTab() throws Exception {
	
	if (findExtrasPageSource("Find Fuel")) {
		WebElement OpenFindFuelTab = Capabilities.driver
				.findElementByXPath(widgetLayoutContent+"\"Find Fuel\"]");
		androidLogs.CapturedLogs(info, "Find Fuel Tab found");
		return OpenFindFuelTab;
	} else {
		androidLogs.CapturedLogs(info, "Find Fuel Tab not found");
		return null;
	}
}
		
public WebElement AllowModal() throws Exception {
	
	if (findExtrasPageSource("Allow")) {
		WebElement AllowModal = Capabilities.driver
				.findElementByXPath(buttonXpath+"\"Allow\"]");
		androidLogs.CapturedLogs(info, "Allow Button found");
		return AllowModal;
	} else {
		androidLogs.CapturedLogs(info, "Allow Button not found");
		return null;
	}
}

public WebElement SearchNearbyButton() throws Exception {
	
	if (findExtrasPageSource("Search nearby")) {
		WebElement SearchNearbyButton = Capabilities.driver
				.findElementByXPath(textViewXpath+"\"Search nearby\"]");
		androidLogs.CapturedLogs(info, "Search Nearby Button found");
		return SearchNearbyButton;
	} else {
		androidLogs.CapturedLogs(info, "Search Nearby Button not found");
		return null;
	}
}




public WebElement OpenUsingImageBrand() throws Exception {
	
	if (findExtrasPageSource("stations")) {
		WebElement SearchNearbyButton = Capabilities.driver
				.findElementByXPath(imageView+"\"com.efsllc.efsmobileapp.stage:id/image_brand\"]");
		androidLogs.CapturedLogs(info, "Brand Image found");
		return SearchNearbyButton;
	} else {
		androidLogs.CapturedLogs(info, "Brand Image not found");
		return null;
	}
}




public WebElement StationBackButton() throws Exception {
	
	if (findExtrasPageSource("miles")) {
		WebElement StationBackButton = Capabilities.driver
				.findElementByXPath(imageView+"\"com.efsllc.efsmobileapp.stage:id/station_detail_back_button\"]");
		androidLogs.CapturedLogs(info, "Brand Image found");
		return StationBackButton;
	} else {
		androidLogs.CapturedLogs(info, "Brand Image not found");
		return null;
	}
}


public WebElement FiltersButton() throws Exception {
	
	if (findExtrasPageSource("Filters")) {
		WebElement FiltersButton = Capabilities.driver
				.findElementByXPath(buttonXpath+"\"Filters (3)\"]");
		androidLogs.CapturedLogs(info, "Filters Button found");
		return FiltersButton;
	} else {
		androidLogs.CapturedLogs(info, "Filters Button not found");
		return null;
	}
}

public WebElement FiltersCloseButton() throws Exception {
	
	if (findExtrasPageSource("Close")) {
		WebElement FiltersCloseButton = Capabilities.driver
				.findElementByXPath(textViewContent+"\"Close\"]");
		androidLogs.CapturedLogs(info, "Filters close button found");
		return FiltersCloseButton;
	} else {
		androidLogs.CapturedLogs(info, "Filters close button not found");
		return null;
	}
}


public WebElement SearchAlongARouteButton() throws Exception {
if (findExtrasPageSource("Search along a route")) {
	WebElement SearchAlongARouteButton = Capabilities.driver
			.findElementByXPath(buttonXpath+"\"Search along a route\"]");
	androidLogs.CapturedLogs(info, "Search Along a route Button found");
	return SearchAlongARouteButton;
} else {
	androidLogs.CapturedLogs(info, "Search Along a route Button not found");
	return null;
}
}

public WebElement DestinationTextBox() throws Exception {
	if (findExtrasPageSource("Enter destination")) {
		WebElement DestinationTextBox = Capabilities.driver.findElementByXPath(editTextXpath+"\"Enter destination\"]");
		androidLogs.CapturedLogs(info, "Enter Destination textbox found");
		return DestinationTextBox;
	} else {
		androidLogs.CapturedLogs(info, "Enter Destination textbox not found");
		return null;
	}	
}


public WebElement DestinationPicker() throws Exception {
	if (findExtrasPageSource("Salt Lake City")) {
		WebElement DestinationPicker = Capabilities.driver.findElementByXPath(textViewXpath+"\"Salt Lake City\"]");
		androidLogs.CapturedLogs(info, "Destination added to text box found");
		return DestinationPicker;
	} else {
		androidLogs.CapturedLogs(info, "Destination added to text box not found");
		return null;
	}	
}


public WebElement DestinationSearchButton() throws Exception {
	if (findExtrasPageSource("Search")) {
		WebElement DestinationSearchButton = Capabilities.driver.findElementByXPath(buttonXpath+"\"Search\"]");
		androidLogs.CapturedLogs(info, "Destination search button found");
		return DestinationSearchButton;
	} else {
		androidLogs.CapturedLogs(info, "Destination search button not found");
		return null;
	}	
}

public WebElement NearByStation() throws Exception {
	
	if (findExtrasPageSource("Nearby stations")) {
		WebElement NearByStation = Capabilities.driver
				.findElementByXPath(textViewXpath+"\"Nearby stations\"]");
		androidLogs.CapturedLogs(info, "Allow Button found");
		return NearByStation;
	} else {
		androidLogs.CapturedLogs(info, "Allow Button not found");
		return null;
	}
}


public WebElement FindFuelNearbyhelpScreenContinue() throws Exception {
	
	if (findExtrasPageSource("Continue")) {
		WebElement FindFuelNearbyhelpScreenContinue = Capabilities.driver
				.findElementByXPath(buttonXpath+"\"Continue\"]");
		androidLogs.CapturedLogs(info, "Find Fuel Nearb help Screen continue Button found");
		return FindFuelNearbyhelpScreenContinue;
	} else {
		androidLogs.CapturedLogs(info, "Find Fuel Nearb help Screen continue Button not found");
		return null;
	}
}

public WebElement FindFuelNearbyBackButton() throws Exception {
	if (findExtrasPageSource("com.efsllc.efsmobileapp.stage:id/back_button")) {
		WebElement FindFuelNearbyBackButton = Capabilities.driver
				.findElementByXPath(imageView+"\"com.efsllc.efsmobileapp.stage:id/back_button\"]");
		androidLogs.CapturedLogs(info, "Find Fuel Nearby back Button found");
		return FindFuelNearbyBackButton;
	} else {
		androidLogs.CapturedLogs(info, "Find Fuel Nearby back Button not found");
		return null;
	}
}


public WebElement SearchAlongARouteBackButton() throws Exception {
	if (findExtrasPageSource("Navigate up")) {
		WebElement SearchAlongARouteBackButton = Capabilities.driver
				.findElementByXPath(imageButton+"\"Navigate up\"]");
		androidLogs.CapturedLogs(info, "Find Fuel Nearby back Button found");
		return SearchAlongARouteBackButton;
	} else {
		androidLogs.CapturedLogs(info, "Find Fuel Nearby back Button not found");
		return null;
	}
}

public WebElement PlanATripButton() throws Exception {
	

	if (findExtrasPageSource("Plan a trip")) {
		WebElement PlanATripButton = Capabilities.driver
				.findElementByXPath(buttonXpath+"\"Plan a trip\"]");
		androidLogs.CapturedLogs(info, "Plan a trip Button found");
		return PlanATripButton;
	} else {
		androidLogs.CapturedLogs(info, "Plan a trip Button not found");
		return null;
	}
}
		
public WebElement PlanATripScreenContinue() throws Exception {
	
	if (findExtrasPageSource("Continue")) {
		WebElement PlanATripScreenContinue = Capabilities.driver
				.findElementByXPath(buttonXpath+"\"Continue\"]");
		androidLogs.CapturedLogs(info, "Plan a trip Button found");
		return PlanATripScreenContinue;
	} else {
		androidLogs.CapturedLogs(info, "Plan a trip Button not found");
		return null;
	}
}


public WebElement PlanATripScreenBackButton() throws Exception {
	
	

	if (findExtrasPageSource("Navigate up")) {
		WebElement PlanATripScreenBackButton = Capabilities.driver
				.findElementByXPath(imageButton+"\"Navigate up\"]");
		androidLogs.CapturedLogs(info, "Plan a trip back Button found");
		return PlanATripScreenBackButton;
	} else {
		androidLogs.CapturedLogs(info, "Plan a trip back Button not found");
		return null;
	}
}


public WebElement HomeTabButton() throws Exception {
	
	if (findExtrasPageSource("Home")) {
		WebElement HomeTabButton = Capabilities.driver
				.findElementByXPath(widgetLayoutContent+"\"Home\"]");
		androidLogs.CapturedLogs(info, "Home tab found");
		return HomeTabButton;
	} else {
		androidLogs.CapturedLogs(info, "Home tab not found");
		return null;
	}
}
	


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		// Wex Connect 	


public WebElement ServiceTab() throws Exception {
	
	if (findExtrasPageSource("Service")) {
		WebElement ServiceTab = Capabilities.driver
				.findElementByXPath(widgetLayoutContent+"\"Service\"]");
		androidLogs.CapturedLogs(info, "Service Tab found");
		return ServiceTab;
	} else {
		androidLogs.CapturedLogs(info, "Service Tab not found");
		return null;
	}
}

public WebElement ChargeTab() throws Exception {
	
	if (findExtrasPageSource("Charge")) {
		WebElement ServiceTab = Capabilities.driver
				.findElementByXPath(widgetLayoutContent+"\"Charge\"]");
		androidLogs.CapturedLogs(info, "Service Tab found");
		return ServiceTab;
	} else {
		androidLogs.CapturedLogs(info, "Service Tab not found");
		return null;
	}
}

public WebElement CarWashTab() throws Exception {
if (findExtrasPageSource("Carwash")) {
	WebElement ServiceTab = Capabilities.driver
			.findElementByXPath(widgetLayoutContent+"\"Carwash\"]");
	androidLogs.CapturedLogs(info, "Carwash Tab found");
	return ServiceTab;
} else {
	androidLogs.CapturedLogs(info, "Carwash Tab not found");
	return null;
}
}

public WebElement GasTab() throws Exception {
if (findExtrasPageSource("Gas")) {
	WebElement GasTab = Capabilities.driver
			.findElementByXPath(widgetLayoutContent+"\"Gas\"]");
	androidLogs.CapturedLogs(info, "Gas Tab found");
	return GasTab;
} else {
	androidLogs.CapturedLogs(info, "Gas Tab not found");
	return null;
}
}


public WebElement MoreTab() throws Exception {
if (findExtrasPageSource("More")) {
	WebElement MoreTab = Capabilities.driver
			.findElementByXPath(widgetLayoutContent+"\"More\"]");
	androidLogs.CapturedLogs(info, "More Tab found");
	return MoreTab;
} else {
	androidLogs.CapturedLogs(info, "More Tab not found");
	return null;
}
}


public WebElement SearchNearby() throws Exception {
	
	if (findExtrasPageSource("Search Nearby")) {
		WebElement SearchNearby = Capabilities.driver
				.findElementByXPath(textViewXpath+"\"Search Nearby\"]");
		androidLogs.CapturedLogs(info, "Search nearby textbox found");
		return SearchNearby;
	} else {
		androidLogs.CapturedLogs(info, "Search nearby textbox not found");
		return null;
	}
}


public WebElement ClearButtonGasTab() throws Exception {
	

	if (findExtrasPageSource("com.wex.octane.stage:id/imagebutton_header_clear_icon")) {
		WebElement ClearButtonGasTab = Capabilities.driver
				.findElementByXPath(imageButtonRes+"\"com.wex.octane.stage:id/imagebutton_header_clear_icon\"]");
		androidLogs.CapturedLogs(info, "Clear Button found");
		return ClearButtonGasTab;
	} else {
		androidLogs.CapturedLogs(info, "Clear Button not found");
		return null;
	}
}


public WebElement ClearButtonChargeListTab() throws Exception {
	if (findExtrasPageSource("com.wex.octane.stage:id/imagebutton_header_clear_icon_charge")) {
		WebElement ClearButtonChargeListTab = Capabilities.driver
				.findElementByXPath(imageButtonRes+"\"com.wex.octane.stage:id/imagebutton_header_clear_icon_charge\"]");
		androidLogs.CapturedLogs(info, "Clear Button found");
		return ClearButtonChargeListTab;
	} else {
		androidLogs.CapturedLogs(info, "Clear Button not found");
		return null;
	}
}


public WebElement evOkButton() throws Exception {
	if (findExtrasPageSource("OK")) {
		WebElement evOkButton = Capabilities.driver
				.findElementByXPath(buttonXpath+"\"OK\"]");
		androidLogs.CapturedLogs(info, "EV OK Button found");
		return evOkButton;
	} else {
		androidLogs.CapturedLogs(info, "EV OK Button not found");
		return null;
	}
}



public WebElement SearchNearbyTextBox(String Location) throws Exception {
	
	if (findExtrasPageSource("Search")) {
		WebElement SearchNearbyTextBox = Capabilities.driver
				.findElementByXPath(editTextXpath+"\"Search\"]");
		androidLogs.CapturedLogs(info, "Search nearby textbox for " +Location+" found");
		return SearchNearbyTextBox;
	} else {
		androidLogs.CapturedLogs(info, "Search nearby textbox for " +Location+" not found");
		return null;
	}
}

public WebElement SelectLocation(String location) throws Exception {
	if (findExtrasPageSource(location)) {
		WebElement SelectLocation = Capabilities.driver
				.findElementByXPath(textViewXpath+"\""+location+"\"]");
		androidLogs.CapturedLogs(info, "Searched location found");
		return SelectLocation;
	} else {
		androidLogs.CapturedLogs(info, "Searched location  not found");
		return null;
	}
}


public WebElement MapButton() throws Exception {
	if (findExtrasPageSource("com.wex.octane.stage:id/imagebutton_header_left_icon")) {
		WebElement MapButton = Capabilities.driver
				.findElementByXPath(imageButtonRes+"\"com.wex.octane.stage:id/imagebutton_header_left_icon\"]");
		androidLogs.CapturedLogs(info, "Searched location found");
		return MapButton;
	} else {
		androidLogs.CapturedLogs(info, "Searched location  not found");
		return null;
	}
}


public WebElement MapChargeButton() throws Exception {
	if (findExtrasPageSource("com.wex.octane.stage:id/imagebutton_header_left_icon_charge")) {
		WebElement MapChargeButton = Capabilities.driver
				.findElementByXPath(imageButtonRes+"\"com.wex.octane.stage:id/imagebutton_header_left_icon_charge\"]");
		androidLogs.CapturedLogs(info, "Searched location found");
		return MapChargeButton;
	} else {
		androidLogs.CapturedLogs(info, "Searched location  not found");
		return null;
	}
}


public WebElement MapDirectionsButton() throws Exception {
	if (findExtrasPageSource("com.wex.octane.stage:id/button_get_directions")) {
		WebElement  MapDirectionsButton = Capabilities.driver.findElementByXPath(widgetButtonResourceID+"\"com.wex.octane.stage:id/button_get_directions\"]");
		androidLogs.CapturedLogs(info, "Map Directions Button found");
		return MapDirectionsButton;
	} else {
		androidLogs.CapturedLogs(info, "Map Directions Button not found");
	 return null;
}
}

public WebElement MapDirectionsLikeButton() throws Exception {
	if (findExtrasPageSource("DIRECTIONS")) {
		String directions = "DIRECTIONS";
		//WebElement  MapDirectionsLikeButton = Capabilities.driver.findElementByXPath("//*[contains(text(), '" + directions+"')]");
		
		WebElement  MapDirectionsLikeButton = Capabilities.driver.findElementByXPath(findSomethingLike + directions+"')]");
		
		
		androidLogs.CapturedLogs(info, "Map Directions Button found");
		return MapDirectionsLikeButton;
	} else {
		androidLogs.CapturedLogs(info, "Map Directions Button not found");
	 return null;
}
}

//MORE PAGE 

public WebElement WexConnectPromoCodesButton() throws Exception {
	if (findExtrasPageSource("Promo codes")) {
		WebElement WexConnectPromoCodesButton = Capabilities.driver
				.findElementByXPath(textViewXpath+"\"Promo codes\"]");
		androidLogs.CapturedLogs(info, "Promo codes Button found");
		return WexConnectPromoCodesButton;
	} else {
		androidLogs.CapturedLogs(info, "Promo codes Button not found");
		return null;
	}
}


public WebElement WexConnectPromoCodeTextBox(String promoCode) throws Exception {
	if (findExtrasPageSource("Enter code")) {
		WebElement WexConnectPromoCodeTextBox = Capabilities.driver
				.findElementByXPath(editTextXpath+"\"Enter code\"]");
		androidLogs.CapturedLogs(info, "Promo codes for " + promoCode +" Button found");
		return WexConnectPromoCodeTextBox;
	} else {
		androidLogs.CapturedLogs(info, "Promo codes for " + promoCode +" Button not found");
		return null;
	}
}




public WebElement WexConnectPromoCodeEnterCodeButton() throws Exception {
	if (findExtrasPageSource("ENTER CODE")) {
		WebElement WexConnectPromoCodeEnterCodeButton = Capabilities.driver
				.findElementByXPath(buttonXpath+"\"ENTER CODE\"]");
		androidLogs.CapturedLogs(info, "Enter Coce Button found");
		return WexConnectPromoCodeEnterCodeButton;
	} else {
		androidLogs.CapturedLogs(info, "Enter Code Button not found");
		return null;
	}
}


public WebElement WexConnectPromoCodeAddCodeButton() throws Exception {
	if (findExtrasPageSource("ADD PROMO")) {
		WebElement WexConnectPromoCodeAddCodeButton = Capabilities.driver
				.findElementByXPath(textViewContent+"\"ADD PROMO\"]");
		androidLogs.CapturedLogs(info, "ADD Promo codes Button found");
		return WexConnectPromoCodeAddCodeButton;
	} else {
		androidLogs.CapturedLogs(info, "ADD Promo codes Button not found");
		return null;
	}
}


public WebElement WexConnectShareButton() throws Exception {
	if (findExtrasPageSource("Share")) {
		WebElement WexConnectShareButton = Capabilities.driver
				.findElementByXPath(textViewXpath+"\"Share\"]");
		androidLogs.CapturedLogs(info, "Share Button found");
		return WexConnectShareButton;
	} else {
		androidLogs.CapturedLogs(info, "Share Button not found");
		return null;
	}
}


public WebElement WexConnectTOUButton() throws Exception {
	if (findExtrasPageSource("Terms of Use")) {
		WebElement WexConnectTOUButton = Capabilities.driver
				.findElementByXPath(textViewXpath+"\"Terms of Use\"]");
		androidLogs.CapturedLogs(info, "Terms of Use Button found");
		return WexConnectTOUButton;
	} else {
		androidLogs.CapturedLogs(info, "Terms of Use Button not found");
		return null;
	}
}


public WebElement WexConnectPPButton() throws Exception {
	if (findExtrasPageSource("Privacy Policy")) {
		WebElement WexConnectPPButton = Capabilities.driver
				.findElementByXPath(textViewXpath+"\"Privacy Policy\"]");
		androidLogs.CapturedLogs(info, "Privacy Policy Button found");
		return WexConnectPPButton;
	} else {
		androidLogs.CapturedLogs(info, "Privacy Policy Button not found");
		return null;
	}
}


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

		// SmartHUB 	


public WebElement SmartHubUsernameTextBox() throws Exception {
	
	if (findExtrasPageSource("Username")) {
		WebElement ServiceTab = Capabilities.driver
				.findElementByXPath(editTextXpath+"\"Username\"]");
		androidLogs.CapturedLogs(info, "Service Tab found");
		return ServiceTab;
	} else {
		androidLogs.CapturedLogs(info, "Service Tab not found");
		return null;
	}
}

public WebElement SmartHubPasswordTextBox() throws Exception {
	
	if (findExtrasPageSource("Password")) {
		WebElement ServiceTab = Capabilities.driver
				.findElementByXPath(editTextXpath+"\"Password\"]");
		androidLogs.CapturedLogs(info, "Service Tab found");
		return ServiceTab;
	} else {
		androidLogs.CapturedLogs(info, "Service Tab not found");
		return null;
	}
}

public WebElement SmartHubLoginButton() throws Exception {
	
	if (findExtrasPageSource("LOG IN")) {
		WebElement ServiceTab = Capabilities.driver
				.findElementByXPath(buttonXpath+"\"LOG IN\"]");
		androidLogs.CapturedLogs(info, "Service Tab found");
		return ServiceTab;
	} else {
		androidLogs.CapturedLogs(info, "Service Tab not found");
		return null;
	}
}


}
