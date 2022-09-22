package androidCarrierClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;

public class RepoCarrierAndroid {
	
AndroidLogs AndroidLogs = new AndroidLogs();
AppStringsAndroid androidText = new  AppStringsAndroid();

public String moneycodePageSource = "";
public String cardsPageSource = "";
public String transactionsPageSource = "";
public String billingPageSource = "";
public String accountPageSource = "";
public String extrasPageSource = "";
//String pass = androidText.PASS;
//String fail = androidText.FAIL;
String info = androidText.INFO;


String buttonXpath = "//android.widget.Button[@text=";
String textViewXpath = "//android.widget.TextView[@text=";
String editTextXpath = "//android.widget.EditText[@text=";
String editTextWidgetResource = "//android.widget.EditText[@resource-id=";
String textViewContent = "//android.widget.TextView[@content-desc=";
String widgetTextViewResource = "//android.widget.TextView[@resource-id=";
String radioButton = "//android.widget.RadioButton[@text=";
String switchOption = "//android.widget.Switch[@text=";
String checkBox = "//android.widget.CheckBox[@text=";
String imageButtonCont = "//android.widget.ImageButton[@content-desc=";
String widgetButtonResourceID = "//android.widget.Button[@resource-id=";
String imageView = "//android.widget.ImageView[@resource-id=";
String textViewResource = "//android.widget.TextView[@resource-id=";
String linearLayoutContentDesc = "//android.widget.LinearLayout[@content-desc=";
String widgetLayoutContent = "//android.widget.FrameLayout[@content-desc=";
String frameLayoutContentDesc = "//android.widget.FrameLayout[@content-desc=";


//finds the elements on the page asked for
public Boolean pageElement (String elementLabel, String pageSource) {
	
	if (pageSource == "" || pageSource == null) {
	return false;	
	}
	
	Boolean foundPageSource = false; 

	switch (pageSource) {
	case "moneycode":
		this.moneycodePageSource = lookupPageSource(this.moneycodePageSource);
		foundPageSource = this.moneycodePageSource.contains(elementLabel);
		return foundPageSource;

	case "cards":
		this.cardsPageSource = lookupPageSource(this.cardsPageSource);
		foundPageSource = this.cardsPageSource.contains(elementLabel);
		return foundPageSource;

	case "transactions":
		this.transactionsPageSource = lookupPageSource(this.transactionsPageSource);
		foundPageSource = this.transactionsPageSource.contains(elementLabel);
		return foundPageSource;

	case "billing":
		this.billingPageSource = lookupPageSource(this.billingPageSource);
		foundPageSource = this.billingPageSource.contains(elementLabel);
		return foundPageSource;

	case "account":
		this.accountPageSource = lookupPageSource(this.accountPageSource);
		foundPageSource = this.accountPageSource.contains(elementLabel);
		return foundPageSource;

	default:
		//extras always gets over written as a they are usually done or close etc 
		this.extrasPageSource = Capabilities.driver.getPageSource();
		foundPageSource = this.extrasPageSource.contains(elementLabel);
		return foundPageSource;
	}
}

private String lookupPageSource (String pageSource ) {
	if (pageSource == "") {
		pageSource = Capabilities.driver.getPageSource();
	}
	
	return pageSource;
	
}


//create one of these for every page in the automation
public Boolean findMoneyCodePageElement(String elementLabel) {
	return pageElement(elementLabel, "moneycode");	
} 

//create one of these for every page in the automation
public Boolean findCardsPageElement(String elementLabel) {
	
	return pageElement(elementLabel, "cards");	
} 

//create one of these for every page in the automation
public Boolean findTransactionsPageElement(String elementLabel) {
	return pageElement(elementLabel, "transactions");	
} 

//create one of these for every page in the automation
public Boolean findBillingPageElement(String elementLabel) {
	return pageElement(elementLabel, "billing");	
} 

//create one of these for every page in the automation
public Boolean findAccountPageElement(String elementLabel) {
	return pageElement(elementLabel, "account" );	
} 

//create one of these for every page in the automation
public Boolean findExtrasPageSource(String elementLabel) {
	return pageElement(elementLabel, "default");	
} 


public void clearPageElement(String pageSource) {
pageSource = "";
}







//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
//Web Elements for  Welcome screen

public WebElement WelcomeScreen() throws Exception {
	Thread.sleep(2000); 
	WebElement welcomeScreen = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]");
	AndroidLogs.CapturedLogs(info, "Welcome screen found");
	return welcomeScreen;
	}

public WebElement getStarted() throws Exception {
	if (findExtrasPageSource("GET STARTED")) {
		
		WebElement  getStarted= Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"GET STARTED\"]");
		AndroidLogs.CapturedLogs(info, "Get started button found");
		return getStarted;
	} else {
	 AndroidLogs.CapturedLogs(info, "Get started button not found");
	 return null;
}
}


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~BIOMETRICS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

public WebElement BiometricsPageCarrierControl() throws Exception {
	if (findExtrasPageSource("Enable Biometrics")) {
		WebElement  BiometricsPageCarrierControl = Capabilities.driver.findElementByXPath(textViewXpath+"\"Enable Biometrics\"]");
		AndroidLogs.CapturedLogs(info, "Biometrics page found");
		return BiometricsPageCarrierControl;
	} else {
		AndroidLogs.CapturedLogs(info, "Biometrics page not found");
	 return null;
}
}


public WebElement BiometricsCancelButton() throws Exception {
	if (findExtrasPageSource("CANCEL")) {
		WebElement  BiometricsCancelButton= Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"CANCEL\"]");
		AndroidLogs.CapturedLogs(info, "Biometrics Cancel Button found");
		return BiometricsCancelButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "Biometrics Cancel Button not found");
	 return null;
}
}

public WebElement BiometricsDenyButton() throws Exception {
	if (findExtrasPageSource("Deny")) {
		WebElement  BiometricsDenyButton= Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"Deny\"]");
		AndroidLogs.CapturedLogs(info, "Biometrics Deny Button found");
		return BiometricsDenyButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "Biometrics Deny Button not found");
	 return null;
}
}


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Login~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
public WebElement LoginCarrierTextBox() throws Exception {
	if (findExtrasPageSource("CarrierControl")) {
		WebElement  LoginCarrierTextBox= Capabilities.driver.findElementByXPath(editTextXpath+"\"Username\"]");
		AndroidLogs.CapturedLogs(info, "Login textBox found");
		return LoginCarrierTextBox;
	} else {
	 AndroidLogs.CapturedLogs(info, "login TextBox not found");
	 return null;
}
}

public WebElement LockedLoginCarrierTextBox() throws Exception {
	if (findExtrasPageSource("CarrierControl")) {
		WebElement  LockedLoginCarrierTextBox= Capabilities.driver.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efscarriercontrol.stage:id/username_text_view\"]");
		AndroidLogs.CapturedLogs(info, "Locked login textBox found");
		return LockedLoginCarrierTextBox;
	} else {
	 AndroidLogs.CapturedLogs(info, "Locked login TextBox not found");
	 return null;
}
}


public WebElement LockedLoginCarrierPasswordTextBox() throws Exception {
	if (findExtrasPageSource("CarrierControl")) {
		WebElement  LockedLoginCarrierPasswordTextBox= Capabilities.driver.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efscarriercontrol.stage:id/password_text_view\"]");
		AndroidLogs.CapturedLogs(info, "Locked password textBox found");
		return LockedLoginCarrierPasswordTextBox;
	} else {
	 AndroidLogs.CapturedLogs(info, "Locked password TextBox not found");
	 return null;
}
}


public WebElement PassExpectedLoginCarrierTextBox() throws Exception {
	if (findExtrasPageSource("CarrierControl")) {
		WebElement  PassExpectedLoginCarrierTextBox= Capabilities.driver.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efscarriercontrol.stage:id/username_text_view\"]");
		AndroidLogs.CapturedLogs(info, "Locked login textBox found");
		return PassExpectedLoginCarrierTextBox;
	} else {
	 AndroidLogs.CapturedLogs(info, "Locked login TextBox not found");
	 return null;
}
}



public WebElement PassExpectedLoginCarrierPasswordTextBox() throws Exception {
	if (findExtrasPageSource("CarrierControl")) {
		WebElement  PassExpectedLoginCarrierPasswordTextBox= Capabilities.driver.findElementByXPath(editTextWidgetResource+"\"com.efsllc.efscarriercontrol.stage:id/password_text_view\"]");
		AndroidLogs.CapturedLogs(info, "Login password textBox found");
		return PassExpectedLoginCarrierPasswordTextBox;
	} else {
	 AndroidLogs.CapturedLogs(info, "Login password TextBox not found");
	 return null;
}
}




public WebElement LoginButtonCarrierControl() throws Exception {
	if (findExtrasPageSource("LOGIN")) {
		WebElement  LoginButtonCarrierControl= Capabilities.driver.findElementByXPath(buttonXpath+"\"LOGIN\"]");
		AndroidLogs.CapturedLogs(info, "Login Button found");
		return LoginButtonCarrierControl;
	} else {
	 AndroidLogs.CapturedLogs(info, "login Button not found");
	 return null;
}
}

public WebElement SomethingWentWrongOkButton() throws Exception {
	if (findExtrasPageSource("OK")) {
		WebElement  SomethingWentWrongOkButton= Capabilities.driver.findElementByXPath(buttonXpath+"\"OK\"]");
		AndroidLogs.CapturedLogs(info, "Something Went Wrong OK button found");
		return SomethingWentWrongOkButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "Something Went Wrong OK button not found");
	 return null;
}
}

public WebElement LoginCarrierPasswordTextBox() throws Exception {
	if (findExtrasPageSource("CarrierControl")) {
		WebElement  LoginCarrierPasswordTextBox= Capabilities.driver.findElementByXPath(editTextXpath+"\"Password\"]");
		AndroidLogs.CapturedLogs(info, "Password textBox found");
		return LoginCarrierPasswordTextBox;
	} else {
	 AndroidLogs.CapturedLogs(info, "Password TextBox not found");
	 return null;
}
}


public WebElement LoginCarrierShowHidepassword() throws Exception {
	if (findExtrasPageSource("Show password")) {
		
		WebElement  LoginCarrierShowHidepassword= Capabilities.driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Show password\"]");

		AndroidLogs.CapturedLogs(info, "Show Hide Password icon found");
		return LoginCarrierShowHidepassword;
	} else {
	 AndroidLogs.CapturedLogs(info, "Show Hide Password icon not found");
	 return null;
}
}




public WebElement DismissLockedAcountModal() throws Exception {
	if(findExtrasPageSource("Account")) {
	WebElement DismissLockedAcountModal = Capabilities.driver.findElementByXPath(textViewResource+"\"com.efsllc.efscarriercontrol.stage:id/alertTitle\"]");
	AndroidLogs.CapturedLogs(info, "Dismiss locked Account button found");
	return DismissLockedAcountModal;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Dismiss locked Account button not found");
		return null;
	}
	}

public WebElement DismissLockedAcountButton() throws Exception {
	if(findExtrasPageSource("DISMISS")) {
	WebElement DismissLockedAcountButton = Capabilities.driver.findElementByXPath(buttonXpath+"\"DISMISS\"]");
	AndroidLogs.CapturedLogs(info, "Dismiss suspended Account button found");
	return DismissLockedAcountButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Dismiss suspended Account button not found");
		return null;
	}
	}


public WebElement DismissSuspendedAcountButton() throws Exception {
	if(findExtrasPageSource("DISMISS")) {
	WebElement DismissSuspendedAcountButton = Capabilities.driver.findElementByXPath(buttonXpath+"\"DISMISS\"]");
	AndroidLogs.CapturedLogs(info, "Dismiss suspended Account button found");
	return DismissSuspendedAcountButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Dismiss suspended Account button not found");
		return null;
	}
	}


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
//Web Elements for  MoneyCodes Tab

public WebElement MoneyCodesTab() throws Exception {
	Thread.sleep(2000); 
	WebElement moneyCodesTab = Capabilities.driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"MC\"]/android.widget.ImageView");
	AndroidLogs.CapturedLogs(info, "Money Code Tab found");
	return moneyCodesTab;
	}

public WebElement  NewMoneyCodeButton() throws Exception {
	if (findMoneyCodePageElement("NEW MONEYCODE")){
	WebElement newMoneyCodeButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"NEW MONEYCODE\"]");
	AndroidLogs.CapturedLogs(info, "New MoneyCode button found");
	return newMoneyCodeButton;
	} else {
		AndroidLogs.CapturedLogs(info, "New MoneyCode button not found");
	return null;
	}
}

public WebElement SelectContract() throws Exception {
	if(findExtrasPageSource("Select contract")) {
	WebElement selectContract = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView");
	AndroidLogs.CapturedLogs(info, "Select Contract found");
	return selectContract;
	}else {
		AndroidLogs.CapturedLogs(info, "Contract not found");
		return null;
	}
	}

public WebElement PayeeNameTextBox() throws Exception {
		WebElement payeeNameTextBox = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
	AndroidLogs.CapturedLogs(info, "Payee name text box found");
	return payeeNameTextBox;
	}

public WebElement NextButtonMoneyCode() throws Exception {
	if(findExtrasPageSource("NEXT")) {
	WebElement nextButtonMoneyCode = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
	AndroidLogs.CapturedLogs(info, "Next button moneycode found");
	return nextButtonMoneyCode;}
	else {
		AndroidLogs.CapturedLogs(info, "Next button not found");
		return null;
	}
	}

public WebElement AmountMoneyCodeTextBox() throws Exception {
	WebElement amountMoneyCodeTextBox = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
	AndroidLogs.CapturedLogs(info, "Select Contract found");
	return amountMoneyCodeTextBox;
	}

public WebElement AmountNextMoneyCode() throws Exception {
	if(findExtrasPageSource("NEXT")) {
	WebElement amountNextMoneyCode = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
	AndroidLogs.CapturedLogs(info, "Amount Next button moneycode found");
	return amountNextMoneyCode;}
	else {
		AndroidLogs.CapturedLogs(info, "Amount Next button moneycode not found");
		return null;
	}
	}

public WebElement AddFieldsNextButtonMoneyCode() throws Exception {
	if(findExtrasPageSource("SKIP")) {
	WebElement addFieldsNextButtonMoneyCode = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
	AndroidLogs.CapturedLogs(info, "Skip button moneycode found");
	return addFieldsNextButtonMoneyCode;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Skip button moneycode not found");
		return null;
	}
	}

public WebElement InfoDetailsNotesTextBox() throws Exception {
	if(findExtrasPageSource("Notes")) {
	WebElement infoDetailsNotesTextBox = Capabilities.driver.findElementByXPath("//android.widget.EditText[@text=\"Notes\"]");
	AndroidLogs.CapturedLogs(info, "Info details notes textbox moneycode found");		
	return infoDetailsNotesTextBox;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Notes textbox not found");
		return null;
	}
	}

public WebElement InfoDetailsNotesDeductFeeTextBox() throws Exception {
	if(findExtrasPageSource("Notes")) {
	WebElement InfoDetailsNotesDeductFeeTextBox = Capabilities.driver.findElementByXPath("//android.widget.EditText[@text=\"Notes\"]");
	AndroidLogs.CapturedLogs(info, "Info details notes Deduct fee textbox moneycode found");		
	return InfoDetailsNotesDeductFeeTextBox;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Info details notes Deduct fee textbox not found");
		return null;
	}
	}

public WebElement InfoNextButtonMoneyCode() throws Exception {
	if(findExtrasPageSource("NEXT")) {
	WebElement infoNextButtonMoneyCode = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"NEXT\"]");
	AndroidLogs.CapturedLogs(info, "Next button moneycode found");
	return infoNextButtonMoneyCode;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Next button not found");
		return null;
	}
	}

public WebElement IssueMoneyCodeButton() throws Exception {
	if(findExtrasPageSource("ISSUE MONEYCODE")) {
	WebElement issueMoneyCodeButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"ISSUE MONEYCODE\"]");
	AndroidLogs.CapturedLogs(info, "Issue MoneyCode button found");
	return issueMoneyCodeButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Issue MoneyCode not found");
		return null;
	}
	}

public WebElement ReferenceNumber() throws Exception {
	WebElement refNumber = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView[2]");
	AndroidLogs.CapturedLogs(info, "Reference number moneycode found");
	return refNumber;
	}

public WebElement DismissMoneyCodeButton() throws Exception {
	if(findExtrasPageSource("DISMISS")) {
	WebElement dismissMoneyCodeButton = Capabilities.driver.findElementByXPath(" /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]");
	AndroidLogs.CapturedLogs(info, "Dismiss moneycode button found");
	return dismissMoneyCodeButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "DISMISS not found");
		return null;
	}
	}

public WebElement DismissMoneyCodeModalButton() throws Exception {
	WebElement dismissMoneyCodeModalButton = Capabilities.driver.findElementByXPath(" /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]");
	AndroidLogs.CapturedLogs(info, "Dismiss moneycode modal found");
	return dismissMoneyCodeModalButton;
	}



public WebElement OpenCreatedMoneyCode(String refNumber) throws Exception {
	String refNumberSent = refNumber;
	if (findExtrasPageSource("MoneyCodes")) {
		System.out.println("Ref number found: " + refNumber);
		WebElement OpenCreatedMoneyCode = Capabilities.driver.findElementByXPath(textViewXpath+"\""+refNumberSent+"\"]");
		AndroidLogs.CapturedLogs(info, "Created money code found");
		return OpenCreatedMoneyCode;
	} else {
		AndroidLogs.CapturedLogs(info, "Created money code not found");
		return null;
	}
}


public WebElement CreatedMoneyCodeRefNumber() throws Exception {
	WebElement createdMoneyCodeRefNumber = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView[2]");
	AndroidLogs.CapturedLogs(info, "Created money code reference number found");
	return createdMoneyCodeRefNumber;
	}



public WebElement VoidMoneyCodeButton() throws Exception {
	if(findExtrasPageSource("VOID MONEYCODE")) {
	WebElement voidMoneyCodeButton = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"VOID MONEYCODE\"]");
	AndroidLogs.CapturedLogs(info, "Void moneycode button found");
	return voidMoneyCodeButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "VOID MONEYCODE not found");
		return null;
	}
	}

public WebElement VoidMoneyModalCancelButton() throws Exception {
	if(findExtrasPageSource("CANCEL")) {
	WebElement VoidMoneyModalCancelButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"CANCEL\"]");
	AndroidLogs.CapturedLogs(info, "Void moneycode modal cancel button found");		
	return VoidMoneyModalCancelButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "CANCEL not found");
		return null;
	}
	}

public WebElement VoidMoneyModalVoidButton() throws Exception {
	if(findExtrasPageSource("VOID")) {
	WebElement VoidMoneyModalVoidButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"VOID\"]");
	AndroidLogs.CapturedLogs(info, "Void button moneycode found");		
	return VoidMoneyModalVoidButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Void button not found");
		return null;
	}
	}



public WebElement verifyMoneyCodesActiveIcon() throws Exception {
	if(findExtrasPageSource("Active")) {
	WebElement verifyMoneyCodesActiveIcon = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"Active\"]");
	AndroidLogs.CapturedLogs(info, "moneyCode Active details icon found");		
	return verifyMoneyCodesActiveIcon;
	}
	else {
		AndroidLogs.CapturedLogs(info, "moneyCode Active details icon not found");
		return null;
	}
	}

public WebElement verifyMoneyCodesVoidedIcon() throws Exception {
	if(findExtrasPageSource("Voided")) {
	WebElement verifyMoneyCodesVoidedIcon = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"Voided\"]");
	AndroidLogs.CapturedLogs(info, "moneyCode void details icon found");		
	return verifyMoneyCodesVoidedIcon;
	}
	else {
		AndroidLogs.CapturedLogs(info, "moneyCode void details icon not found");
		return null;
	}
	}


public WebElement MultiUseMoneyCodeSeen() throws Exception {
	if(findExtrasPageSource("(multi-use)")) {
	WebElement MultiUseMoneyCodeSeen = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"(multi-use)\"]");
	AndroidLogs.CapturedLogs(info, "Multiuse Moneycode found in list");		
	return MultiUseMoneyCodeSeen;
	}
	else {
		AndroidLogs.CapturedLogs(info, "MultiUse MoneyCode not found in list");
		return null;
	}
	}





public WebElement MoneyCodesVoidBackbutton() throws Exception {
	WebElement moneyCodesVoidBackbutton = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton");
	AndroidLogs.CapturedLogs(info, "Void moneycode back button found");
	return moneyCodesVoidBackbutton;
	}

public WebElement ViewAllTopButton() throws Exception {
	if(findMoneyCodePageElement("VIEW ALL")) {
	WebElement viewAllButtonTop = Capabilities.driver.findElementByXPath("//android.widget.TextView [@text = \"VIEW ALL\"]");
	AndroidLogs.CapturedLogs(info, "View all button top moneycode found");
	return viewAllButtonTop;
	}else {
		AndroidLogs.CapturedLogs(info, "View all button not found");
		return null;
	}
	}

public WebElement MoneyCodeActivityBackButton() throws Exception {
	WebElement moneyCodeActivityBackButton = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton");
	AndroidLogs.CapturedLogs(info, "Back button moneycode found");
	return moneyCodeActivityBackButton;
	}

public WebElement ViewAllBottomButton() throws Exception {
	if(findMoneyCodePageElement("VIEW ALL")) {
	WebElement ViewAllBottomButton = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"VIEW ALL\"]");
	AndroidLogs.CapturedLogs(info, "View all bottom button found");
	return ViewAllBottomButton;
	}else {
		AndroidLogs.CapturedLogs(info, "View all bottom button not found");
		return null;
	}
	}

public WebElement InfoFieldsDriverIDCheckBox() throws Exception {
	if(findExtrasPageSource("Driver ID")) {
	WebElement InfoFieldsDriverIDCheckBox = Capabilities.driver.findElementByXPath("//android.widget.CheckBox[@text=\"Driver ID\"]");
	AndroidLogs.CapturedLogs(info, "Info fields driver ID check box found");
	return InfoFieldsDriverIDCheckBox;
	}
else {
	AndroidLogs.CapturedLogs(info, "Driver ID check box not found");
	return null;
	}
	}

public WebElement Add1FieldsButton() throws Exception {
	if(findExtrasPageSource("ADD (1) FIELDS")) {
	WebElement Add1FieldsButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"ADD (1) FIELDS\"]");
	AndroidLogs.CapturedLogs(info, "Add (1) fields button found");
	return Add1FieldsButton;
	}
else {
		AndroidLogs.CapturedLogs(info, "Add 1 Fields button button not found");
		return null;
	}
	}

public WebElement InfoFieldsDriverTextBox() throws Exception {
	if(findExtrasPageSource("Driver ID")) {
	WebElement InfoFieldsDriverTextBox = Capabilities.driver.findElementByXPath("//android.widget.EditText[@text=\"Driver ID\"]");
	AndroidLogs.CapturedLogs(info, "Info fields driver text box found");
	return InfoFieldsDriverTextBox;
	}else {
		AndroidLogs.CapturedLogs(info, "Driver ID text box not found");
		return null;
	}
	}


public WebElement InfoFieldsDriverDeductFeeTextBox() throws Exception {
	if(findExtrasPageSource("Driver ID")) {
	WebElement InfoFieldsDriverDeductFeeTextBox = Capabilities.driver.findElementByXPath("//android.widget.EditText[@text=\"Driver ID\"]");
	AndroidLogs.CapturedLogs(info, "Info fields driver Deduct fee text box found");
	return InfoFieldsDriverDeductFeeTextBox;
	}else {
		AndroidLogs.CapturedLogs(info, "Info fields driver Deduct fee text not found");
		return null;
	}
	}

public WebElement EditFeeIcon() throws Exception {
	WebElement EditFeeIcon = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.ImageButton");

	AndroidLogs.CapturedLogs(info, "Edit fee icon moneycode found");
	return EditFeeIcon;
	}

public WebElement DeductFeeNowRadioButton() throws Exception {
	if(findExtrasPageSource("Deduct fee now")) {
	WebElement DeductFeeNowRadioButton = Capabilities.driver.findElementByXPath("//android.widget.RadioButton[@text=\"Deduct fee now\"]");
	AndroidLogs.CapturedLogs(info, "Deduct fee now radio button found");
	return DeductFeeNowRadioButton;
	}else {
		AndroidLogs.CapturedLogs(info, "Decduct fee now Radio button not found");
		return null;
	}
	}

public WebElement SendToPayeeButton() throws Exception {
	if(findExtrasPageSource("SEND TO PAYEE")) {
	WebElement DeductFeeNowRadioButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"SEND TO PAYEE\"]");
	AndroidLogs.CapturedLogs(info, "Send to payee  moneycode found");
	return DeductFeeNowRadioButton;
	}else {
		AndroidLogs.CapturedLogs(info, "Send To Payee Button not found");
		return null;
	}
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

//Web Elements for cards Tab section
public WebElement CardsTab() throws Exception {
	WebElement cardsTab = Capabilities.driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Cards\"]");
	AndroidLogs.CapturedLogs(info, "Cards Tab found");
	return cardsTab;
	}

public WebElement SearchIcon() throws Exception{
	Thread.sleep(2000); 
	if(findCardsPageElement("Search")) {
	WebElement searchIcon= Capabilities.driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Search\"]");
	AndroidLogs.CapturedLogs(info, "Search icon found");
	return searchIcon;
}
	else {
		AndroidLogs.CapturedLogs(info, "Search icon not found");
		return null;
	}
}

public WebElement ClearSearchBoxIcon() throws Exception{
	Thread.sleep(2000); 
	if(findExtrasPageSource("Clear query")) {
	WebElement clearSearchBoxIcon= Capabilities.driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Clear query\"]");
	AndroidLogs.CapturedLogs(info, "Clear icon found");
	return clearSearchBoxIcon;
}else {
	AndroidLogs.CapturedLogs(info, "Clear icon not found");
	return null;
}
}
	
public WebElement DriverSelection() throws Exception {
	Thread.sleep(2000); 
	if(findCardsPageElement("DRIVER")) {
	WebElement driverSelection = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"DRIVER\"]");
	AndroidLogs.CapturedLogs(info, "Driver tab  found");
	return driverSelection;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Driver tab not found");
		return null;
	}
}

public WebElement DriverSearch() throws Exception {
	WebElement driverSearch = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
	AndroidLogs.CapturedLogs(info, "Driver Search textbox found");
	return driverSearch;
}

public WebElement PhysicalSearchButton() throws Exception {
	WebElement physicalSearchButton = Capabilities.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Search\"]");
	AndroidLogs.CapturedLogs(info, "Physical search button found");
	return physicalSearchButton;
}

public WebElement DriverSearchResult() throws Exception {
	WebElement driverSearchResult = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]");
	AndroidLogs.CapturedLogs(info, "Driver Search result found");
	return driverSearchResult;
}

public WebElement UnitSelection() throws Exception {
	Thread.sleep(2000); 
	if(findCardsPageElement("UNIT")) {
	WebElement unitSelection = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"UNIT\"]");
	AndroidLogs.CapturedLogs(info, "Unit tab found");
	return unitSelection;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Unit tab not found");
		return null;
	}
}

public WebElement UnitSearch() throws Exception {
	WebElement unitSearch = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
	AndroidLogs.CapturedLogs(info, "Unit search texbox found");
	return unitSearch;
}


public WebElement UnitSearchResult() throws Exception {
	WebElement unitSearchResult = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]");
	AndroidLogs.CapturedLogs(info, "Unit Search result found");
	return unitSearchResult;
}

public WebElement CardSelection() throws Exception {
	Thread.sleep(2000); 
	if(findCardsPageElement("CARD")) {
	WebElement cardSelection = Capabilities.driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Card\"]/android.widget.TextView");
	AndroidLogs.CapturedLogs(info, "Card search tab found");
	return cardSelection;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Card search tab not found");
		return null;
}}


public WebElement CardSearch() throws Exception {
	WebElement cardSearch = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
	AndroidLogs.CapturedLogs(info, "Card Search Textbox found");
	return cardSearch;
}

public WebElement CardSearchResult() throws Exception {
	WebElement cardSearchResult = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]");
	AndroidLogs.CapturedLogs(info, "Card Search Textbox found");
	return cardSearchResult;
}

public WebElement DriverIDSelection() throws Exception {
	Thread.sleep(2000); 
	if(findCardsPageElement("DRIVER ID")) {
	WebElement driverIDSelection = Capabilities.driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Driver ID\"]");
	AndroidLogs.CapturedLogs(info, "Driver ID tab found");
	return driverIDSelection;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Driver ID tab not found");
		return null;
}
}

public WebElement DriverIDSearch() throws Exception {
	WebElement driverIDSearch = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
	AndroidLogs.CapturedLogs(info, "Driver ID search textbox found");
	return driverIDSearch;
}


public WebElement DriverIDSearchResult() throws Exception {
	WebElement driverIDSearchResult = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]");
	AndroidLogs.CapturedLogs(info, "Driver ID search result found");
	return driverIDSearchResult;
}

public WebElement PolicySelection() throws Exception {
	Thread.sleep(2000); 
	if(findCardsPageElement("POLICY")) {
	WebElement policySelection = Capabilities.driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Policy\"]/android.widget.TextView");
	AndroidLogs.CapturedLogs(info, "Policy tab found");
	return policySelection;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Policy tab not found");
		return null;
}
}


public WebElement PolicySearch() throws Exception {
	WebElement policySearch = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
	AndroidLogs.CapturedLogs(info, "Policy Search textboxfound");
	return policySearch;
}

public WebElement PolicySearchResult() throws Exception {
	WebElement policySearchResult = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]");
	AndroidLogs.CapturedLogs(info, "Policy search result found");
	return policySearchResult;
}

public WebElement CardSearchResultCell() throws Exception{
	WebElement cardSearchResultCell=Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout");
	AndroidLogs.CapturedLogs(info, "Policy result found");
	return cardSearchResultCell;
}

//*********** Web Elements for Cards overview page *************//

public WebElement CompanyTab() throws Exception {
	Thread.sleep(2000); 
	if(findExtrasPageSource("COMPANY")) {
	WebElement CompanyTab = Capabilities.driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Company\"]");
	AndroidLogs.CapturedLogs(info, "Company tab found");
	return CompanyTab;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Company tab not found");
		return null;
}
}

//Load cash ~~~~~~~~~~~~//
public WebElement LoadCashButton() throws Exception {
	Thread.sleep(2000); 
	if(findExtrasPageSource("LOAD CASH")) {
	WebElement LoadCashButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"LOAD CASH\"]");
	AndroidLogs.CapturedLogs(info, "Load cash button found");
	return LoadCashButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Load cash button not found");
		return null;
}
}

public WebElement LoadCashAmountTextBox() throws Exception{
	Thread.sleep(2000);
	WebElement LoadCashAmountTextBox=Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
	AndroidLogs.CapturedLogs(info, "Load cash amount text box found");
	return LoadCashAmountTextBox;
}

public WebElement LoadCashNextButton() throws Exception {
	Thread.sleep(2000); 
	if(findExtrasPageSource("NEXT")) {
	WebElement LoadCashNextButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"NEXT\"]");
	AndroidLogs.CapturedLogs(info, "Next button found");
	return LoadCashNextButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Next button not found");
		return null;
}
}

public WebElement LoadCashAmountButton() throws Exception {
	Thread.sleep(2000); 
	if(findExtrasPageSource("LOAD $1.99")) {
	WebElement LoadCashAmountButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"LOAD $1.99\"]");
	//only works if amount is $1.99
	AndroidLogs.CapturedLogs(info, "Load amount button found");
	return LoadCashAmountButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Load amount button not found");
		return null;
}
}

public WebElement SmartfundsTab() throws Exception {
	Thread.sleep(2000); 
	if(findExtrasPageSource("SMARTFUNDS")) {
	WebElement SmartfundsTab = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"SMARTFUNDS\"]");
	
	AndroidLogs.CapturedLogs(info, "Smartfunds tab found");
	return SmartfundsTab;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Smartfunds tab not found");
		return null;
}
}

//Remove cash ~~~~~~~~~~~~//

public WebElement RemoveCashButton() throws Exception {
	Thread.sleep(2000); 
	if(findExtrasPageSource("REMOVE CASH")) {
	WebElement RemoveCashButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"REMOVE CASH\"]");
	AndroidLogs.CapturedLogs(info, "Remove cash button found");
	return RemoveCashButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Remove cash button not found");
		return null;
}
}

public WebElement RemoveCashAmountTextBox() throws Exception{
	Thread.sleep(2000);
	WebElement RemoveCashAmountTextBox=Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
	AndroidLogs.CapturedLogs(info, "Remove cash text box found");
	return RemoveCashAmountTextBox;
}

public WebElement RemoveCashNextButton() throws Exception {
	 
	if(findExtrasPageSource("NEXT")) {
	WebElement RemoveCashNextButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"NEXT\"]");
	AndroidLogs.CapturedLogs(info, "Next button found");
	return RemoveCashNextButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Next button not found");
		return null;
}
}

public WebElement RemoveCashAmountButton() throws Exception {
	 
	if(findExtrasPageSource("REMOVE $1.99")) {
	WebElement RemoveCashAmountButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"REMOVE $1.99\"]");
	//only works if amount is $1.99
	AndroidLogs.CapturedLogs(info, "Remove amount button found");
	return RemoveCashAmountButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Remove amount button not found");
		return null;
}
}

//Network overrides *********

public WebElement NetworkOverridesButton() throws Exception {
	 
	if(findExtrasPageSource("Network Overrides")) {
	WebElement NetworkOverridesButton = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"Network Overrides\"]");
	AndroidLogs.CapturedLogs(info, "Network overrides button found");
	return NetworkOverridesButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Network overrides button not found");
		return null;
}
}

public WebElement NetworkOverridePlusButton() throws Exception{
	Thread.sleep(2000);
	WebElement NetworkOverridePlusButton=Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageButton[2]");
	AndroidLogs.CapturedLogs(info, "Newtwork override plus button found");
	return NetworkOverridePlusButton;
}

public WebElement EnableNetworkOverrideButton() throws Exception {
	 
	if(findExtrasPageSource("ENABLE 1 OVERRIDE")) {
	WebElement EnableNetworkOverrideButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"ENABLE 1 OVERRIDE\"]") ;
	AndroidLogs.CapturedLogs(info, "Enable 1 override button found");
	return EnableNetworkOverrideButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Enable 1 override button not found");
		return null;
}
}

public WebElement DisableNetworkOverrideModalButton() throws Exception {
	if(findExtrasPageSource("DISABLE")) {
	WebElement DisableNetworkOverrideModalButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"DISABLE\"]");
	AndroidLogs.CapturedLogs(info, "Disable button found");
	return DisableNetworkOverrideModalButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Disable button not found");
		return null;
}
}

//Card information*******
public WebElement CardInformationButton() throws Exception {
	 
	if(findExtrasPageSource("Card Information")) {
	WebElement CardInformationButton = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"Card Information\"]");
	AndroidLogs.CapturedLogs(info, "Card information button found");
	return CardInformationButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Card information button not found");
		return null;
}
}

public WebElement OverrideMileageButton() throws Exception {
	 
	if(findExtrasPageSource("OVERRIDE MILEAGE")) {
	WebElement OverrideMileageButton = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"OVERRIDE MILEAGE\"]");
	AndroidLogs.CapturedLogs(info, "Override mileage button found");
	return OverrideMileageButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Override Mileage button not found");
		return null;
}
}

public WebElement HubometerRadioButton() throws Exception {
	 
	if(findExtrasPageSource("Select mileage type")) {
	WebElement HubometerRadioButton = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup");
	AndroidLogs.CapturedLogs(info, "Hubometer Radio button found");
	return HubometerRadioButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Hubometer Radio button not found");
		return null;
}
}



public WebElement OverrideMileageNextButton() throws Exception {
	 
	if(findExtrasPageSource("NEXT")) {
	WebElement OverrideMileageNextButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"NEXT\"]");
	AndroidLogs.CapturedLogs(info, "Next button found");
	return OverrideMileageNextButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Next button not found");
		return null;
}
}

public WebElement MileageTextBox() throws Exception {
	 
	if(findExtrasPageSource("Mileage")) {
	WebElement MileageTextBox = Capabilities.driver.findElementByXPath("//android.widget.EditText[@text=\"Mileage\"]");
	AndroidLogs.CapturedLogs(info, "Mileage textbox found");
	return MileageTextBox;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Mileage textbox not found");
		return null;
}
}

public WebElement MileageSaveButton() throws Exception {
	 
	if(findExtrasPageSource("SAVE")) {
	WebElement MileageSaveButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"SAVE\"]");
	AndroidLogs.CapturedLogs(info, "Save button found");
	return MileageSaveButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Save button not found");
		return null;
}
}

//Change status*******
public WebElement ChangeStatusButton() throws Exception {
	 
	if(findExtrasPageSource("CHANGE STATUS")) {
	WebElement ChangeStatusButton = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"CHANGE STATUS\"]");
	AndroidLogs.CapturedLogs(info, "Change status button found");
	return ChangeStatusButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Change status button not found");
		return null;
}
}

public WebElement ActiveStatus() throws Exception {
	 
	if(findExtrasPageSource("ACTIVE")) {
	WebElement ActiveStatus = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"ACTIVE\"]");
	AndroidLogs.CapturedLogs(info, "Active status button found");
	return ActiveStatus;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Active status button not found");
		return null;
}
}

public WebElement HoldStatus() throws Exception {
	 
	if(findExtrasPageSource("HOLD")) {
	WebElement HoldStatus = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"HOLD\"]");
	AndroidLogs.CapturedLogs(info, "Hold status button found");
	return HoldStatus;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Hold status button not found");
		return null;
}
}

public WebElement InactiveStatus() throws Exception {
	 
	if(findExtrasPageSource("INACTIVE")) {
	WebElement InactiveStatus = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"INACTIVE\"]");
	AndroidLogs.CapturedLogs(info, "Inactive status button found");
	return InactiveStatus;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Inactive status button not found");
		return null;
}
}

public WebElement FollowsStatus() throws Exception {
	 
	if(findExtrasPageSource("FOLLOWS")) {
	WebElement FollowsStatus = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"FOLLOWS\"]");
	AndroidLogs.CapturedLogs(info, "Follows status button found");
	return FollowsStatus;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Follows status button not found");
		return null;
}
}

public WebElement StatusChangeSaveButton() throws Exception {
	 
	if(findExtrasPageSource("SAVE")) {
	WebElement StatusChangeSaveButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"SAVE\"]");
	AndroidLogs.CapturedLogs(info, "Save status button found");
	return StatusChangeSaveButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Change status button not found");
		return null;
}
}

//Activity

public WebElement ActivityViewAllTop() throws Exception {
	 
	if(findExtrasPageSource("VIEW ALL")) {
	WebElement ActivityViewAllTop = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"VIEW ALL\"]");
	AndroidLogs.CapturedLogs(info, "View all top button found");
	return ActivityViewAllTop;
	}
	else {
		AndroidLogs.CapturedLogs(info, "View all top button not found");
		return null;
}
}

public WebElement TransactionActivityCell() throws Exception{
	Thread.sleep(2000);
	WebElement TransactionActivityCell=Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");
	AndroidLogs.CapturedLogs(info, "Transaction Cell found");
	return TransactionActivityCell;
}

public WebElement TransactionActivityCellBackButton() throws Exception{
	Thread.sleep(2000);
	WebElement TransactionActivityCellBackButton=Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton");
	AndroidLogs.CapturedLogs(info, "Back button found");
	return TransactionActivityCellBackButton;
}

public WebElement TransactionActivityViewAllBackButton() throws Exception{
	Thread.sleep(2000);
	WebElement TransactionActivityViewAllBackButton=Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton");
	AndroidLogs.CapturedLogs(info, "View all back button found");
	return TransactionActivityViewAllBackButton;
}

public WebElement ActivityViewAllBottom() throws Exception {
	 
	if(findExtrasPageSource("VIEW ALL")) {
	WebElement ActivityViewAllBottom = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"VIEW ALL\"]");
	AndroidLogs.CapturedLogs(info, "View all bottom button found");
	return ActivityViewAllBottom;
	}
	else {
		AndroidLogs.CapturedLogs(info, "View all bottom button not found");
		return null;
}
}

//Cards overview sub user smartFunds card elements//*************************

public WebElement SmartfundsCardImage() throws Exception {
	 
	if(findExtrasPageSource("SmartFunds")) {
	WebElement SmartfundsCardImage = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"SmartFunds\"]");
	AndroidLogs.CapturedLogs(info, "Smartfunds Card Image found");
	return SmartfundsCardImage;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Smartfunds Card Image not found");
		return null;
}
}

public WebElement CardInformationBackButton() throws Exception {
	
	WebElement CardInformationBackButton = Capabilities.driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	AndroidLogs.CapturedLogs(info, "Card information back button found");
	return CardInformationBackButton;
	}


//*****************Cards overview for company card *****************
public WebElement CompanyCardImage() throws Exception {
	 
	if(findExtrasPageSource("Company")) {
	WebElement CompanyCardImage = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"Company\"]");
	AndroidLogs.CapturedLogs(info, "Company Card Image found");
	return CompanyCardImage;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Company Card Image not found");
		return null;
}
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~//

//Web Elements for transaction tab section
public WebElement RejectsTab() throws Exception {
	
	WebElement RejectsTab = Capabilities.driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Rejects\"]");
	AndroidLogs.CapturedLogs(info, "Rejects tab found");
	return RejectsTab;
	}

public WebElement RequestTimeOutOKButton() throws Exception {
	
	if(findExtrasPageSource("OK")) {
	WebElement requestTimeOutOKButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"OK\"]");
	AndroidLogs.CapturedLogs(info, "Request time out modal with OK button found");
	return requestTimeOutOKButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Request time out modal OK button not found as expected");
		return null;
	}
	}



public WebElement WaitForTransactionLoad() throws Exception {
	
	WebElement waitForTransactionLoad = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
	AndroidLogs.CapturedLogs(info, "Wait for transaction load found");
	return waitForTransactionLoad;
	}

public WebElement ViewAllTopButtonTrans() throws Exception {
	
	if(findTransactionsPageElement("VIEW ALL")) {
	WebElement viewAllTopButton = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"VIEW ALL\"]"); 
	AndroidLogs.CapturedLogs(info, "View all button found");
	return viewAllTopButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "View all button not found");
		return null;
	}
	}


public WebElement WaitForRejectHistoryLoad() throws Exception {
	
	WebElement waitForRejectHistoryLoad = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]"); 
	AndroidLogs.CapturedLogs(info, "Wait for reject history load found");
	return waitForRejectHistoryLoad;
	}

public WebElement NoActivityYetText() throws Exception {
	
	
	if(findExtrasPageSource("No activity yet")) {
	WebElement noActivityYetText = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"No activity yet\"]");
	AndroidLogs.CapturedLogs(info, "No activity yet text found");
	return noActivityYetText;
	}else {
	AndroidLogs.CapturedLogs(info, "No activity yet text not found");
	return null;
}
}



public WebElement RejectDetailsBackButton() throws Exception {
	
	WebElement rejectDetailsBackButton = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton");
	AndroidLogs.CapturedLogs(info, "Reject details back button found");
	return rejectDetailsBackButton;
	}

public WebElement RejectHistoryBackButton() throws Exception {
	
	WebElement rejectHistoryBackButton = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ImageButton");
	AndroidLogs.CapturedLogs(info, "Reject history back button found");
	return rejectHistoryBackButton;
	}


public WebElement ViewAllBottomButtonTrans() throws Exception {
	
	if(findTransactionsPageElement("VIEW ALL")) {
	WebElement viewAllBottom = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"VIEW ALL\"]");
	AndroidLogs.CapturedLogs(info, "View all button found");
	return viewAllBottom;
	}
	else {
		AndroidLogs.CapturedLogs(info, "View all button not found");
		return null;
	}
	}
//*********Card details inside of transactions view all *************

public WebElement CardDetailsButton() throws Exception {
	
	if(findExtrasPageSource("CARD DETAILS")) {
	WebElement CardDetailsButton = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"CARD DETAILS\"]");
	AndroidLogs.CapturedLogs(info, "Card Details Button found");
	return CardDetailsButton;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Card Details Button not found");
		return null;
	}
	}

public WebElement CardDetailsBackButton() throws Exception {
	WebElement CardDetailsBackButton = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton");
	AndroidLogs.CapturedLogs(info, "Card details back button found");
	return CardDetailsBackButton;
	}


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

//Web Elements for Billing tab section
public WebElement BillingTab() throws Exception {
	if(findExtrasPageSource("Billing")) {
	WebElement billingTab = Capabilities.driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Billing\"]");
	AndroidLogs.CapturedLogs(info, "Billing tab found");
	return billingTab;
	}else {
		AndroidLogs.CapturedLogs(info, "Billing tab not found");
		return null;
	}
}

public WebElement SelectAR() throws Exception{
		if(findBillingPageElement("Billing")) {
		WebElement selectAR=Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"0003913900010\"]");
		AndroidLogs.CapturedLogs(info, "AR selected");
		return selectAR;
		
	}else {
		AndroidLogs.CapturedLogs(info, "AR not found");
		return null;
	}
}

public WebElement PayNowButton() throws Exception{
	
	if(findExtrasPageSource("PAY NOW")) {
		WebElement payNowButton=Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"PAY NOW\"]");
		AndroidLogs.CapturedLogs(info, "Pay now button selected");
		return payNowButton;
	}else {
		AndroidLogs.CapturedLogs(info, "Pay Now button not found");
		return null;
	}
}

//public WebElement SelectInvoice() throws Exception {
//	
//	WebElement selectInvoice = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
//	logs.CapturedLogs("Test Info", "invoice selected");
//	return selectInvoice;
//	}

public WebElement SelectNextButton() throws Exception{
	
	if(findExtrasPageSource("Next")) {
		WebElement selectInvoiceNextButton=Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"Next\"]");
		AndroidLogs.CapturedLogs(info, "Select next button clicked");
		return selectInvoiceNextButton;
	}else {
		AndroidLogs.CapturedLogs(info, "Next button not found");
		return null;
	}
}

public WebElement SelectBankAccount() throws Exception {
	
	if(findExtrasPageSource("Select bank account")) {
	WebElement selectBankAccount = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
	AndroidLogs.CapturedLogs(info, "Bank account selected");
	return selectBankAccount;
	}else {
		AndroidLogs.CapturedLogs(info, "Bank account not found");
		return null;
	}
	}

//   /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ProgressBar





public WebElement EditPaymentAmountButton() throws Exception {
	
	WebElement editPaymentAmountButton = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView[2]");
	AndroidLogs.CapturedLogs(info, "edit button selected");
	return editPaymentAmountButton;
	}

public WebElement PaymentAmountTextBox() throws Exception {
	
	WebElement paymentAmountTextBox = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
	AndroidLogs.CapturedLogs(info, "payment amount textbox selected");
	return paymentAmountTextBox;
	}

public WebElement SaveButton() throws Exception{
	
	if(findExtrasPageSource("SAVE")) {
		WebElement saveButton=Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"SAVE\"]");
		AndroidLogs.CapturedLogs(info, "Save button clicked");
		return saveButton;
	}else {
		AndroidLogs.CapturedLogs(info, "Save not found");
		return null;
	}
}

public WebElement SchedulePaymentButton() throws Exception{
	
	if(findExtrasPageSource("Schedule Payment")) {
		WebElement schedulePaymentButton=Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"Schedule Payment\"]");
		AndroidLogs.CapturedLogs(info, "schedule Payment Button clicked");
		return schedulePaymentButton;
	}else {
		AndroidLogs.CapturedLogs(info, "Schedule Payment Button not found");
		return null;
	}
}

public WebElement DoneButton() throws Exception{
	
	if(findExtrasPageSource("DONE")) {
		WebElement doneButton=Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"DONE\"]");
		AndroidLogs.CapturedLogs(info, "Done Button clicked");
		return doneButton;
	}else {
		AndroidLogs.CapturedLogs(info, "Done Button not found");
		return null;
	}
}



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

//Web Elements for ACCOUNT tab section

public WebElement AccountTab() throws Exception {
	if(findExtrasPageSource("Account")) {
	//WebElement accountTab = Capabilities.driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Account\"]/android.widget.ImageView");
	WebElement accountTab = Capabilities.driver.findElementByXPath(frameLayoutContentDesc+"\"Account\"]");
		
	AndroidLogs.CapturedLogs(info, "Accounts tab found");
	return accountTab;
	} else {
		 AndroidLogs.CapturedLogs(info, "Accounts tab found not found");
		 return null;
	}
	}

//************MANAGE YOUR PROFILE************//
public WebElement ManageYourProfile() throws Exception {
		if (findAccountPageElement("MANAGE YOUR PROFILE")) {
			
		WebElement manageYourProfile = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"MANAGE YOUR PROFILE\"]");
		AndroidLogs.CapturedLogs(info, "Manage your profile opened");
		return manageYourProfile;
	} else {
	 AndroidLogs.CapturedLogs(info, "Manage your profile not found");
	 return null;
}
}

public WebElement EditNameButton() throws Exception {
	if (findExtrasPageSource("Profile")) {
	
	WebElement EditNameButton = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageButton");
	AndroidLogs.CapturedLogs(info, "Edit name button found");
	return EditNameButton;
	}else {
		 AndroidLogs.CapturedLogs(info, "Edit name button not found");
		 return null;
	}
	}

public WebElement FirstNameTextBox() throws Exception {
	
	WebElement FirstNameTextBox = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText");
	AndroidLogs.CapturedLogs(info, "First name Text box found");
	return FirstNameTextBox;
	}

public WebElement LastNameTextBox() throws Exception {
	
	WebElement LastNameTextBox = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText");
	AndroidLogs.CapturedLogs(info, "last name text box found");
	return LastNameTextBox;
	}

public WebElement SaveEditNameButton() throws Exception {
	if (findAccountPageElement("SAVE")) {
		WebElement SaveEditNameButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"SAVE\"]");
		AndroidLogs.CapturedLogs(info, "Save for edit name button found");
		return SaveEditNameButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "Save for edit name button not found");
	 return null;
}
}


public WebElement SaveEditOfOriginalNameButton() throws Exception {
	if (findAccountPageElement("SAVE")) {
		
		WebElement SaveEditOfOriginalNameButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"SAVE\"]");
		AndroidLogs.CapturedLogs(info, "Save for edit name button found");
		return SaveEditOfOriginalNameButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "Save for edit name button not found");
	 return null;
}
}

public WebElement EditEmailButton() throws Exception {
	
	if (findExtrasPageSource("Profile")) {
	WebElement EditEmailButton = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageButton");
	AndroidLogs.CapturedLogs(info, "Edit email button found");
	return EditEmailButton;
	}else {
		 AndroidLogs.CapturedLogs(info, "Edit email button not found");
		 return null;
	}
	}

public WebElement EmailTextBox() throws Exception {
	
	WebElement EmailTextBox = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
	AndroidLogs.CapturedLogs(info, "email text box found");
	return EmailTextBox;
	}

public WebElement SaveEditEmailButton() throws Exception {
	if (findAccountPageElement("SAVE")) {
		
		WebElement SaveEditEmailButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"SAVE\"]");
		AndroidLogs.CapturedLogs(info, "Save for edit email button found");
		return SaveEditEmailButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "Save for edit email not found");
	 return null;
}
}

public WebElement EditPhoneButton() throws Exception {
	
	if (findExtrasPageSource("Profile")) {
	WebElement EditPhoneButton = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageButton");
	AndroidLogs.CapturedLogs(info, "Edit phone button found");
	return EditPhoneButton;
	}else {
		 AndroidLogs.CapturedLogs(info, "Edit phone button not found");
		 return null;
	}
	}

public WebElement EditPhoneTextBox() throws Exception {
	
	WebElement EditPhoneTextBox = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
	AndroidLogs.CapturedLogs(info, "Edit phone textbox found");
	return EditPhoneTextBox;
	}

public WebElement SaveEditPhoneButton() throws Exception {
	if (findAccountPageElement("SAVE")) {
		
		WebElement SaveEditPhoneButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"SAVE\"]");
		AndroidLogs.CapturedLogs(info, "Save button found");
		return SaveEditPhoneButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "Save button not found");
	 return null;
}
}

public WebElement ManageYourProfileBackButton() throws Exception {
		if (findExtrasPageSource("Navigate up")) {
			WebElement ManageYourProfileBackButton = Capabilities.driver.findElementByXPath(imageButtonCont+"\"Navigate up\"]");
			AndroidLogs.CapturedLogs(info, "Profile back button found");
			return ManageYourProfileBackButton;
		} else {
			AndroidLogs.CapturedLogs(info, "Profile backnot found");
			return null;
		}
	}
	
	
//*********TRANSFER TO BANK**************//
public WebElement TransferToYourBank() throws Exception {
	if (findExtrasPageSource("Transfer to your bank")) {
		
		WebElement transferToYourBank = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"Transfer to your bank\"]");
		AndroidLogs.CapturedLogs(info, "Transfer to your bank found");
		return transferToYourBank;
	} else {
	 AndroidLogs.CapturedLogs(info, "Transfer to bank account not found");
	 return null;
}
}

public WebElement TransferToYourBankDeleteTransfer() throws Exception {
	if (findExtrasPageSource("Transfer to your bank")) {
		
		WebElement transferToYourBankDeleteTransfer = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"Transfer to your bank\"]");
		AndroidLogs.CapturedLogs(info, "Transfer to your bank found");
		return transferToYourBankDeleteTransfer;
	} else {
	 AndroidLogs.CapturedLogs(info, "Transfer to bank account not found");
	 return null;
}
}

public WebElement TransferFromSelectContract() throws Exception {
		
		WebElement transferFromSelectContract = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView");
		AndroidLogs.CapturedLogs(info, "Transfer from select contract found");
		return transferFromSelectContract;
}

public WebElement TransferNextButton() throws Exception {
	if (findExtrasPageSource("NEXT")) {
			WebElement transferNextButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"NEXT\"]");
		AndroidLogs.CapturedLogs(info, "NEXT button found");
		return transferNextButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "NEXT button not found");
	 return null;
}
}

public WebElement TransferSelectBankAccount() throws Exception {
	if (findExtrasPageSource("Select bank account")) {
		
		WebElement transferSelectBankAccount = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
		AndroidLogs.CapturedLogs(info, "Select bank account found");
		return transferSelectBankAccount;
	} else {
	 AndroidLogs.CapturedLogs(info, "Select bank account not found");
	 return null;
}
}

public WebElement TransferEnterAmountTextBox() throws Exception {
	if (findExtrasPageSource("Enter amount")) {
		WebElement transferEnterAmountTextBox = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
		AndroidLogs.CapturedLogs(info, "Enter Amount Text box found");
		return transferEnterAmountTextBox;
	} else {
	 AndroidLogs.CapturedLogs(info, "Enter amount text box not found");
	 return null;
}
}

public WebElement TransferSubmitButton() throws Exception {
	if (findExtrasPageSource("Submit")) {
		WebElement transferSubmitButton = Capabilities.driver.findElementByXPath(buttonXpath+"\"Submit\"]");
		AndroidLogs.CapturedLogs(info, "Submit button found");
		return transferSubmitButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "Submit button not found");
	 return null;
}
}

public WebElement TransferDoneButton() throws Exception {
		if (findExtrasPageSource("DONE")) {
		WebElement transferDoneButton = Capabilities.driver.findElementByXPath(buttonXpath+"\"DONE\"]");
		AndroidLogs.CapturedLogs(info, "Done button found");
		return transferDoneButton;
	} else {
			 AndroidLogs.CapturedLogs(info, "Done button not found");
			 return null;
}
}

public WebElement PendingTransfer() throws Exception {
	
	WebElement pendingTransfer = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
	AndroidLogs.CapturedLogs(info, "Pending transfer found");
	return pendingTransfer;
	}

public WebElement CancelTransferButton() throws Exception {
	if (findExtrasPageSource("CANCEL TRANSFER")) {
		
		WebElement cancelTransferButton = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"CANCEL TRANSFER\"]");
		AndroidLogs.CapturedLogs(info, "cancel transfer button found");
		return cancelTransferButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "cancel transfer button not found");
	 return null;
}
}

public WebElement BackModalButton() throws Exception {
	if (findExtrasPageSource("BACK")) {
		
		WebElement backModalButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"BACK\"]");
		AndroidLogs.CapturedLogs(info, "back modal button found");
		return backModalButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "back modal button not found");
	 return null;
}
}

public WebElement CancelModalButton() throws Exception {
	if (findExtrasPageSource("YES, CANCEL")) {
		
		WebElement cancelModalButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"YES, CANCEL\"]");
		AndroidLogs.CapturedLogs(info, "cancel modal button found");
		return cancelModalButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "cancel modal button not found");
	 return null;
}
}

public WebElement CancelPendingPaymentXButton() throws Exception {
	WebElement cancelPendingPaymentXButton = Capabilities.driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Close\"]");
	AndroidLogs.CapturedLogs(info, "Cancel pending payement close button found");
	return cancelPendingPaymentXButton;
	}


public WebElement CancelModalButtonX() throws Exception {
	if (findExtrasPageSource("Cancel pending transfer?")) {
		
		WebElement CancelModalButtonX = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"YES, CANCEL\"]");
	
		AndroidLogs.CapturedLogs(info, "cancel modal button found");
		return CancelModalButtonX;
	} else {
	 AndroidLogs.CapturedLogs(info, "cancel modal button not found");
	 return null;
}
}

public WebElement TransferToYourBankBackButton() throws Exception {
	
	WebElement transferToYourBankBackButton = Capabilities.driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	AndroidLogs.CapturedLogs(info, "Transfer to your bank back button found");
	return transferToYourBankBackButton;
	}
//*******************************************************************************//
//Transfer to your bank Add new bank account web elements

public WebElement AddNewBankAccountButton() throws Exception {
	if (findExtrasPageSource("Add new bank account")) {
		
		WebElement AddNewBankAccountButton = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"Add new bank account\"]");
		AndroidLogs.CapturedLogs(info, "Add new bank account button found");
		return AddNewBankAccountButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "Add new bank account button not found");
	 return null;
}
}

public WebElement RoutingNumberTextBox() throws Exception {
	if (findExtrasPageSource("Routing number")) {
		WebElement RoutingNumberTextBox = Capabilities.driver.findElementByXPath(editTextXpath+"\"Routing number\"]");
		AndroidLogs.CapturedLogs(info, "Routing Number TextBox found");
		return RoutingNumberTextBox;
	} else {
	 AndroidLogs.CapturedLogs(info, "Routing Number TextBox not found");
	 return null;
}
}

public WebElement AccountNumberTextBox() throws Exception {
	if (findExtrasPageSource("Account number")) {
		WebElement AccountNumberTextBox = Capabilities.driver.findElementByXPath(editTextXpath+"\"Account number\"]");
		AndroidLogs.CapturedLogs(info, "Account Number TextBox found");
		return AccountNumberTextBox;
	} else {
	 AndroidLogs.CapturedLogs(info, "Account Number TextBox not found");
	 return null;
}
}



public WebElement WhereDoIFindTheseButton() throws Exception {
	if (findExtrasPageSource("Where do I find these?")) {
		
		WebElement WhereDoIFindTheseButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"Where do I find these?\"]");
		AndroidLogs.CapturedLogs(info, "Where Do I Find These Button found");
		return WhereDoIFindTheseButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "Where Do I Find These Button not found");
	 return null;
}
}

public WebElement WhereDoIFindTheseCloseButton() throws Exception {
	WebElement WhereDoIFindTheseCloseButton = Capabilities.driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Close\"]");
	AndroidLogs.CapturedLogs(info, "Where do i find these close button found");
	return WhereDoIFindTheseCloseButton;
	}


public WebElement AddBankAccountNextButton() throws Exception {
	if (findExtrasPageSource("NEXT")) {
		
		WebElement AddBankAccountNextButton = Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"NEXT\"]");
		AndroidLogs.CapturedLogs(info, "Add Bank Account Next Button found");
		return AddBankAccountNextButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "Add Bank Account Next Button not found");
	 return null;
}
}

public WebElement BankNameTextBox() throws Exception {
	if (findExtrasPageSource("Bank name")) {
		
		WebElement  BankNameTextBox= Capabilities.driver.findElementByXPath("//android.widget.EditText[@text=\"Bank name\"]");
		AndroidLogs.CapturedLogs(info, "Bank Name TextBox found");
		return BankNameTextBox;
	} else {
	 AndroidLogs.CapturedLogs(info, "Bank Name TextBox not found");
	 return null;
}
}

public WebElement AccountOwnerTextBox() throws Exception {
	if (findExtrasPageSource("Account owner")) {
		
		WebElement  AccountOwnerTextBox= Capabilities.driver.findElementByXPath("//android.widget.EditText[@text=\"Account owner\"]");
		AndroidLogs.CapturedLogs(info, "Account Owner TextBox found");
		return AccountOwnerTextBox;
	} else {
	 AndroidLogs.CapturedLogs(info, "Account Owner TextBox not found");
	 return null;
}
}


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
// ACH transfer secion continues
public WebElement CheckingButton() throws Exception {
	if (findExtrasPageSource("Checking")) {
		
		WebElement  CheckingButton= Capabilities.driver.findElementByXPath("//android.widget.RadioButton[@text=\"Checking\"]");
		AndroidLogs.CapturedLogs(info, "Checking Button found");
		return CheckingButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "Checking Button not found");
	 return null;
}
}

public WebElement SavingsButton() throws Exception {
	if (findExtrasPageSource("Savings")) {
		
		WebElement  SavingsButton= Capabilities.driver.findElementByXPath("//android.widget.RadioButton[@text=\"Savings\"]");
		AndroidLogs.CapturedLogs(info, "Savings Button found");
		return SavingsButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "Savings Button not found");
	 return null;
}
}

public WebElement AddBankDetailsNextButton() throws Exception {
	if (findExtrasPageSource("NEXT")) {
		
		WebElement  AddBankDetailsNextButton= Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"NEXT\"]");
		AndroidLogs.CapturedLogs(info, "Add Bank Details Next Button found");
		return AddBankDetailsNextButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "Add Bank Details Next Button not found");
	 return null;
}
}

public WebElement NewBankAccountOKButton() throws Exception {
	if (findExtrasPageSource("OK")) {
		WebElement  NewBankAccountOKButton= Capabilities.driver.findElementByXPath(buttonXpath+"\"OK\"]");
		AndroidLogs.CapturedLogs(info, "OK Button found");
		return NewBankAccountOKButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "OK Button not found");
	 return null;
}
}

public WebElement SomethingWentWrongModal() throws Exception {
	if (findExtrasPageSource("Something Went Wrong")) {
		
		WebElement  SomethingWentWrongModal= Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"Something Went Wrong\"]");

		AndroidLogs.CapturedLogs(info, "Something went wrong modal found");
		return SomethingWentWrongModal;
	} else {
	 AndroidLogs.CapturedLogs(info, "Something went wrong modal not found");
	 return null;
}
}


public WebElement InvalidUserNameOrPasswordModal() throws Exception {
	if (findExtrasPageSource("Invalid Username or Password")) {
		WebElement  InvalidUserNameOrPasswordModal= Capabilities.driver.findElementByXPath(textViewXpath+"\"Invalid Username or Password\"]");
		AndroidLogs.CapturedLogs(info, "Invalid Username modal found");
		return InvalidUserNameOrPasswordModal;
	} else {
	 AndroidLogs.CapturedLogs(info, "Invalid Username modal  not found");
	 return null;
}
}


public WebElement InvalidUserNameOrPasswordSuspendedModal() throws Exception {
	if (findExtrasPageSource("Invalid Username or Password")) {
		WebElement  InvalidUserNameOrPasswordSuspendedModal= Capabilities.driver.findElementByXPath(textViewXpath+"\"Invalid Username or Password\"]");
		AndroidLogs.CapturedLogs(info, "Invalid Username modal found");
		return InvalidUserNameOrPasswordSuspendedModal;
	} else {
	 AndroidLogs.CapturedLogs(info, "Invalid Username modal  not found");
	 return null;
}
}

public WebElement SuspendedOKButton() throws Exception {
	if (findExtrasPageSource("OK")) {
		WebElement  SuspendedOKButton= Capabilities.driver.findElementByXPath(widgetButtonResourceID+"\"android:id/button1\"]");
		AndroidLogs.CapturedLogs(info, "OK Button found");
		return SuspendedOKButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "OK Button not found");
	 return null;
}
}

public WebElement TransferToYourBankCloseButton() throws Exception {
	WebElement TransferToYourBankCloseButton = Capabilities.driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Close\"]");
	AndroidLogs.CapturedLogs(info, "Transfer to your bank close button found");
	return TransferToYourBankCloseButton;
	}

public WebElement TransferToYourBankCancelModalButton() throws Exception {
	if (findExtrasPageSource("YES, CANCEL")) {
		
		WebElement  TransferToYourBankCancelModalButton= Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"YES, CANCEL\"]");
		AndroidLogs.CapturedLogs(info, "YES, Cancel Button found");
		return TransferToYourBankCancelModalButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "YES, Cancel Button not found");
	 return null;
}
}


public WebElement BillingExitButton() throws Exception {
	if (findExtrasPageSource("EXIT")) {
		
		WebElement  BillingExitButton= Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"EXIT\"]");
		AndroidLogs.CapturedLogs(info, "Exit Button found");
		return BillingExitButton;
	} else {
	 AndroidLogs.CapturedLogs(info, "Exit Button not found");
	 return null;
}
}

//*********************BIO SWITCH Account continued**********************************************************//
public WebElement BioSwitchToOn() throws Exception {
	WebElement fingerToggle = Capabilities.driver.findElementByXPath("//android.widget.Switch[@text=\"OFF\"]");
	AndroidLogs.CapturedLogs(info, "Biometric switch found");
	return fingerToggle;
	}

public WebElement BioSwitchToOff() throws Exception {
	WebElement fingerToggle = Capabilities.driver.findElementByXPath("//android.widget.Switch[@text=\"ON\"]");
	AndroidLogs.CapturedLogs(info, "Biometric switch found");
	return fingerToggle;
	}

public WebElement ChangePassword() throws Exception {
	if (Capabilities.driver.getPageSource().contains("Change Password")) {
		Thread.sleep(2000);
		WebElement changePassword = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"Change Password\"]");
		AndroidLogs.CapturedLogs(info, "Change password found");
		return changePassword;
	} else {
	 AndroidLogs.CapturedLogs(info, "Change Password not found");
	 return null;
}
}

public WebElement CallCustomerService() throws Exception {
	
	if (findAccountPageElement("Call customer service")){
		Thread.sleep(2000);
		WebElement callCustomerService = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"Call customer service\"]");
		AndroidLogs.CapturedLogs(info, "Call customer service link found");
		return callCustomerService;
	}else {
		AndroidLogs.CapturedLogs(info, "Call customer service not found");
		 return null;
	}
	}

public WebElement WelcomeTutorial() throws Exception {
	if(findAccountPageElement("View welcome tutorial")) {
		Thread.sleep(2000);
		WebElement welcomeTutorial = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"View welcome tutorial\"]");
		AndroidLogs.CapturedLogs(info, "Welcome tutorial link found");
		return welcomeTutorial;
	}else {
		AndroidLogs.CapturedLogs(info, "View welcome tutorial not found");
		 return null;
	}
	}

public WebElement WelcomeTutorialXButton() throws Exception {
	Thread.sleep(2000);
	if (findExtrasPageSource("Close")) {
	WebElement welcomeTutorialXButton = Capabilities.driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Close\"]");
	AndroidLogs.CapturedLogs(info, "Welcome tutorial Close button found");
	return welcomeTutorialXButton;
	}else {
		AndroidLogs.CapturedLogs(info, "X for close button is not found");
		 return null;
	}
	}

public WebElement TermsOfUse() throws Exception {
	Thread.sleep(2000);
	if(findExtrasPageSource("Terms of Use")) {
	WebElement termsOfUse = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"Terms of Use\"]");
	AndroidLogs.CapturedLogs(info, "Terms of use found");
	return termsOfUse;
	}else {
		AndroidLogs.CapturedLogs(info, "Terms of use not found");
		return null;
	}
	}

public WebElement PrivacyPolicy() throws Exception {
	Thread.sleep(2000);
	if(findExtrasPageSource("Privacy Policy")) {
	WebElement privacyPolicy = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"Privacy Policy\"]");
	AndroidLogs.CapturedLogs(info, "Privacy policy link found");
	return privacyPolicy;
	}else {
		AndroidLogs.CapturedLogs(info, "Privacy policy not found");
		return null;
	}
	}


public WebElement appVersionNumber() throws Exception {
	Thread.sleep(2000);
//	if(findExtrasPageSource("CarrierControl")) {
	WebElement appVersionNumber = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[13]");
	AndroidLogs.CapturedLogs(info, "App Version number found");
	return appVersionNumber;
	}
//else {
//		AndroidLogs.CapturedLogs(info, "App Version number not found");
//		return null;
//	}
//	}


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Log out~~~~~~~~~~~~~~~~~~~~~~~~~//

public WebElement LogOutButton() throws Exception {
	Thread.sleep(2000);
	if(findAccountPageElement("LOG OUT")) {
	WebElement logOutButton = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"LOG OUT\"]");
	AndroidLogs.CapturedLogs(info, "Log out  button found");
	return logOutButton;}
	else {
		AndroidLogs.CapturedLogs(info, "LOG OUT not found");
		return null;
	}
	}

public WebElement LogOutCancelModal() throws Exception {
	Thread.sleep(2000);
	WebElement logOutCancelModal= Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"CANCEL\"]");
	AndroidLogs.CapturedLogs(info, "Cancel modal button found");
	return logOutCancelModal;
	}

public WebElement LogOutButtonModal() throws Exception {
	Thread.sleep(2000);
	WebElement logOutButtonModal= Capabilities.driver.findElementByXPath("//android.widget.Button[@text=\"LOG OUT\"]");
	AndroidLogs.CapturedLogs(info, "Log out modal button found");
	return logOutButtonModal;
	}





//~~~~~~~~~~~~~~~Loading progress spinner~~~~~~~~~~~~~~~~~~//

public WebElement LoadingTransactionSpinnerText() throws Exception {
	
	if(findExtrasPageSource("Loading activity…")) {
	WebElement loadingSpinnerText = Capabilities.driver.findElementByXPath("//android.widget.TextView[@text=\"Loading activity…\"]"); 
	AndroidLogs.CapturedLogs(info, "Loading Spinner text was found");
	return loadingSpinnerText;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Loading Spinner text was not found");
		return null;
	}
	}


public WebElement LoadingTransactionViewallSpinnerText() throws Exception {
	if(findExtrasPageSource("**********")) {
	WebElement loadingSpinnerText = Capabilities.driver.findElementByXPath(	"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]"); 
	AndroidLogs.CapturedLogs(info, "Loading Spinner text was found");
	return loadingSpinnerText;
	}
	else {
		AndroidLogs.CapturedLogs(info, "Loading Spinner text was not found");
		return null;
	}
	}


public WebElement progressSpinnerSubmitPaymentInvoice() throws Exception {
	if(findExtrasPageSource("ProgressBar")) {
	WebElement progressSpinnerSubmitPaymentInvoice = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ProgressBar");
	AndroidLogs.CapturedLogs(info, "A loading Spinner was located on page wait initalized");
	return progressSpinnerSubmitPaymentInvoice;
	}else {
		AndroidLogs.CapturedLogs(info, "Loading Spinner was not found");
		return null;
	}
	}


public WebElement progressSpinnerLoadMoneyCodes() throws Exception {
	if(findExtrasPageSource("ProgressBar")) {
	WebElement progressSpinnerLoadMoneyCodes = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ProgressBar");
	AndroidLogs.CapturedLogs(info, "A loading Spinner was located on page wait initalized");
	return progressSpinnerLoadMoneyCodes;
	}else {
		AndroidLogs.CapturedLogs(info, "Loading Spinner was not found");
		return null;
	}
	}

public WebElement progressSpinnerSaveEmail() throws Exception {
	if(findExtrasPageSource("ProgressBar")) {
	WebElement progressSpinnerSaveEmail = Capabilities.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button");
	AndroidLogs.CapturedLogs(info, "A loading Spinner was located on page wait initalized");
	return progressSpinnerSaveEmail;
	}else {
		AndroidLogs.CapturedLogs(info, "Loading Spinner was not found");
		return null;
	}
	}

}


