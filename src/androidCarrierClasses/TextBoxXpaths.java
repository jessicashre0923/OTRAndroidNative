package androidCarrierClasses;



//TODO	Its time to remove this and use the new xpath system.....




public class TextBoxXpaths {
	//Carrier control starts right here
	
//	final String CARRIER_LOGIN_ID_TEXTBOX = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText";  	
//	final String CARRIER_LOGIN_PASSWORD_TEXTBOX = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText";
	final String CARRIER_FAIL_LOGIN_TEXT="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
	final String CARRIER_PASSWORD_SUSPENDED = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
	final String ACCOUNT_LOCKED_MODAL = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
	final String ACCOUNT_LOCKED_OK_BUTTON = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]";
	final String SOMETHING_WENT_WRONG_MODAL = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
	final String SOMETHING_WENT_WRONG_OK_BUTTON = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button";
	final String LOGIN_BUTTON = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button";
	final String FAIL_LOGIN_TEXT = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[1]";
	
	
	
	//final String FIND_ME = "\"com.efsllc.efscarriercontrol:id/btn_logout\").get(20)";

//public String FindME() throws Exception {
//	String findMe = "\"com.efsllc.efscarriercontrol:id/btn_logout\").get(20)";
//	return findMe;
//}
//	public String SomethingWentWrongModal() throws Exception {
//		String SomethingWentWrongModal = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
//		return SomethingWentWrongModal;
//	}
//	public String SomethingWentWrongOKButton() throws Exception {
//		String SomethingWentWrongOKButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button";
//		return SomethingWentWrongOKButton;
//	}
//	public String CarrierLockedNumber() throws Exception {
//		
//		
//		String CarrierLockedNumber = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[4]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText";
//		
//		return CarrierLockedNumber;
//	}	
//	public String CarrierLockedPass() throws Exception {
//
//		String CarrierLockedPass = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[6]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText";
//
//		return CarrierLockedPass;
//	}	
//	public String CarrierPasswordSuspended() throws Exception {
//
//		String CarrierPasswordSuspended = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
//
//		return CarrierPasswordSuspended;
//	}
//	public String accountLockedModal() throws Exception {
//
//		String accountLockedModal = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
//
//		return accountLockedModal;
//	}
//	public String accountLockedOkButton() throws Exception {
//
//		String accountLockedOkButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]";
//
//		return accountLockedOkButton;
//	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	
	//Card Control Start here  
	
	public String CardPinSuspendedOkButton() throws Exception {

		String CardPinSuspendedOkButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]";

		return CardPinSuspendedOkButton;
	}
	
public String MenuString() throws Exception {
		String mainMenu = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button";
		return mainMenu;
	}

public String InnerMenuButton() throws Exception {
	String innermenubutton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[1]";
	return innermenubutton;
}

public String CardNumber2() throws Exception {
	String cardNumber2 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[4]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText";
	return cardNumber2;
}

public String CardPin2() throws Exception {
	String cardPin2 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[6]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText";
	return cardPin2;
}

public String CardPinSuspended() throws Exception {
	String CardPinSuspended = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]";
	return CardPinSuspended;
}

public String CardNumber() throws Exception {
	String cardNumber = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText";

	return cardNumber;
}

public String CardPin() throws Exception {

	String cardPin = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[4]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText";

	return cardPin;
}

public String LogoutMenuButton() throws Exception {

	String LogoutMenuButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[8]";

	return LogoutMenuButton;
}


public String biometricsCancelButton() throws Exception {

	String biometricsCancelButton = "/hierarchy/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button";

	return biometricsCancelButton;
}

public String VpnConnection() throws Exception {

	String LoginButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View";

	return LoginButton;
}

//public String FailLoginText() throws Exception {
//
//	String FailLoginText = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[1]";
//
//	return FailLoginText;
//}


public String invalidCardText() throws Exception {

	String invalidCardText = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[1]";

	return invalidCardText;
}

public String AccountActivityString() throws Exception {

	String accountActivityString = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[2]";

	return accountActivityString;
}

public String CardMaintenanceString() throws Exception {

	String cardMaintenanceString = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[3]";

	return cardMaintenanceString;
}


public String PriceLocatorString() throws Exception {

	String priceLocatorString = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[4]";

	return priceLocatorString;
}


public String RegisterCheckStrings() throws Exception {

	String registerCheckStrings = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[5]";

	return registerCheckStrings;
}


public String StatemensStrings() throws Exception {

	String statemensStrings = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[6]";

	return statemensStrings;
}

public String StatementsHomeStrings() throws Exception {

	String statemensStrings = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button";

	return statemensStrings;
}


public String TransactionRejectsStrings() throws Exception {

	String transactionRejectsStrings = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[7]";

	return transactionRejectsStrings;
}

public String TransactionRejectsHomeStrings() throws Exception {

	String transactionRejectsStrings = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button";

	return transactionRejectsStrings;
}

public String TransferFundsStrings() throws Exception {

	String transferFundsStrings = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[8]";

	return transferFundsStrings;
}

public String TransferFundsHomeStrings() throws Exception {

	String transferFundsStrings = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button";

	return transferFundsStrings;
}

public String ContactUsStrings() throws Exception {

	String contactUsStrings = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[9]";

	return contactUsStrings;
}

public String ContactUsHomeStrings() throws Exception {

	String contactUsStrings = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button";

	return contactUsStrings;
}

public String LogoutString() throws Exception {

	String logoutMenuString = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[10]";

	return logoutMenuString;
}

public String LogoutYesString() throws Exception {

	String logoutMenuString = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.app.Dialog/android.view.View/android.widget.Button[2]";

	return logoutMenuString;
}


public String AccountActivityHomeStrings() throws Exception {

	String AccountActivityHomeStrings = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button";

	return AccountActivityHomeStrings;
}


public String CardMaintMenuStrings() throws Exception {

	String CardMaintMenuStrings = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button";

	return CardMaintMenuStrings;
}

public String RegisterCheckHomeStrings() throws Exception {

	String RegisterCheckHomeStrings = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.Button";

	return RegisterCheckHomeStrings;
}

public String HomeButton() throws Exception {

	String HomeButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[1]";

	return HomeButton;
}

//~~~~~~~~~~~~~~~~~~~~~//
}

