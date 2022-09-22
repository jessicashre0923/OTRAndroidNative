package androidSharedClasses;

import java.io.IOException;

import com.github.javafaker.Faker;

import androidCarrierClasses.LocalConfiguration;

public class AppStringsAndroid {
	LocalConfiguration TestData;
	AndroidLogs logs = new AndroidLogs();
	
	
	public AppStringsAndroid() {
		
	}
//TODO 
/*
Step 1. create a new properties file per server with test data 
	A. Find data on other enviroments 
Step 2. Fix invorment local config on line 30 to point to the right document
Step 3. create a switch case to go through the environments
Step 4. Update all login strings to go to right place. 
	Example 1: CardNumberTextBox.sendKeys(androidText.appConfigValue("CARD NUMBER OR PIN"));
	 
Step 5. Add to iOS Side 	
	

	
	*/



public AppStringsAndroid(String environment) throws Exception {
	//System.out.println("Inside of app string android. MY enviroment is: " + environment);
	AppStringsAndroid androidText = new  AppStringsAndroid();
	int envPicked = 0;


	switch (environment) {
	case "TEST":  envPicked = 1;
	TestData = new LocalConfiguration("TestData.txt");
	logs.CapturedLogs(androidText.INFO, "TestData.TXT found");
	break;
	case "PARTNER": envPicked = 2;
	TestData = new LocalConfiguration("PartnerData.txt");
	logs.CapturedLogs(androidText.INFO, "PartnerData.TXT found");
	break;
	case "AWSSIT": envPicked = 3;
	TestData = new LocalConfiguration("AWSSITData.txt");
	logs.CapturedLogs(androidText.INFO, "AWSSIT.TXT found");
	break;
	case "AWSDIT": envPicked = 4;
	TestData = new LocalConfiguration("AWSDITData.txt");
	logs.CapturedLogs(androidText.INFO, "AWSDITData.TXT found");
	break;
	default:
	logs.CapturedLogs(androidText.INFO, "No server DATA found to test on.");
	}	
}


public String getENVData(String DataName) throws IOException {
	System.out.println("Start getting data: " + DataName );
	System.out.println("Start getting data2: " + TestData );
	String configdata = TestData.getConfigurationValue(DataName);

	System.out.println("After data is: " + configdata);
//		return TestData.getConfigurationValue(DataName);
	return configdata;

}



//~~~~~~~~~~~~~~~~~~~~~PASS FAIL INFO~~~~~~~~~~~~~~~~//		
	public final String PASS = "Test Pass";
	public final String INFO = "Test Info";
	public final String FAIL = "Test Fail";
	
	
	

//~~~~~~~~~~~~~~~~~~~~~OLD WAY EVENTUALLY MOVE THEM ALL~~~~~~~//	
	//~~~~~~~~~~~~~~~~~~~~~ID Strings for Carrier control Profile iOS login~~~~~~~~~~~~~~~~//	
			public final String PROFILE_FIRST_NAME = "Android";
			public final String PROFILE_LAST_NAME = "Automation";
			public final String PROFILE_EMAIL = "AndroidAutomation@wexinc.com";
			public final String PROFILE_PHONE = "8015555555";

//~~~~~~~~~~~~~~~~~~~~~ID Strings for carrier Control Android login~~~~~~~~~~~~~~~~//	
	public final String CARRIER_LOGIN_ID_SMARTFUNDS_100045 = "100045";
	// public final String CARRIER_LOGIN_ID_SMARTFUNDS = "102698";
	public final String CARRIER_LOGIN_ID_SUB_USER_102698db = "102698db";
	public final String CARRIER_LOGIN_ID_UNIVERSAL_129698 = "129698";
	public final String CARRIER_LOGIN_ID_COMPANY_103526 = "103526";
	public final String CARRIER_LOGIN_ID_FAIL_EXPECTED = "000000";
	public final String CARRIER_LOGIN_ID_LOCKED_100045 = "100045";
	public final String CARRIER_LOGIN_ID_PASSWORDCHANGE = "";

//~~~~~~~~~~~~~~~~~~~~~Pass Strings for carrier Control Android login~~~~~~~~~~~~~~~~//	
	public final String CARRIER_LOGIN_PASSWORD_SMARTFUUNDS = "985477";
	// public final String CARRIER_LOGIN_PASSWORD_SUB_USER = "985477";
	public final String CARRIER_LOGIN_PASSWORD_SUB_USER = "NGFC123";
	public final String CARRIER_LOGIN_PASSWORD_UNIVERSAL = "985477";
	public final String CARRIER_LOGIN_PASSWORD_COMPANY = "985477";
	public final String CARRIER_LOGIN_PASSWORD_FAIL_EXPECTED = "1111";
	public final String CARRIER_LOGIN_PASSWORD_LOCKED = "111111";
	public final String CARRIER_LOGIN_PASSWORD_SUSPENDED = "999999";
	public final String CARRIER_LOGIN_PASSWORD_PASSWORDCHANGE = "letmein11";

////~~~~~~~~~~~~~~~~~~~~~Card Num Strings for Card Control Android login~~~~~~~~~~~~~~~~//	
//	public final String CARDPIN_LOGIN_NUMBER_6344 = "7083050910386616344";
//	public final String CARD_LOGIN_FAIL_EXPECTED = "1234567891234567891";
//	public final String CARD_LOGIN_LOCK_EXPECTED = "7083059961002500561";
//	public final String PASSCODE_CARD_LOGIN_5542 = "7083059810269845542";
//	public final String CARD_ACH_LOGIN_2800 = "7083050612969802800";
////~~~~~~~~~~~~~~~~~~~~~Card Num Strings for Card Control Android login~~~~~~~~~~~~~~~~//	
//	public final String CARDPIN_LOGIN_PIN_6344 = "9854";
//	public final String CARD_LOGIN_PIN_FAIL_EXPECTED = "1111";
//	public final String CARD_LOGIN_PIN_LOCK_EXPECTED = "9999";
//	public final String PASSCODE_CARD_LOGIN_5542_PASSCODE = "985477";
//	public final String SECURE_FUEL_0561_PIN = "9854";
//	public final String CARD_ACH_2800_PIN = "9854";
	// ~~~~~~~~~~~~~~~~~~~~~Profile Setup~~~~~~~~~~~~~~~~//
	public final String FIRST_NAME = "John";
	public final String LAST_NAME = "Wayne";
	public final String DATE_OF_BIRTH = "05/05/1999";
	public final String PHONE_NUMBER = "8608675309";
	public final String EMAIL_ADDRESS = "efs.testers@efsllc.com";
	public final String SOCIAL_SECURITY = "9999";
	public final String HOME_ADDRESS = "1 Hancock Street Portland, ME USA 04101";
	public final String HOME_ADDRESS_LINE_TWO = "Unit 5";
	public final String SEC_ANSWERS = "test";
	//~~~~~~~~~~~~~~~~~~~~~Card Control Register check strings~~~~~~~~~~~~~~~~//
	public final String REGISTER_CHECK_AMOUNT = "100.22";
	public final String REGISTER_CHECK_NUMBER = "1246917168";
	//~~~~~~~~~~~~~~~~~~~~~Card Control SecureFuel strings~~~~~~~~~~~~~~~~//
	public final String UNIT_NUMBER_SECUREFUEL = "1234";
	//~~~~~~~~~~~~~~~~~~~~~Card Control Transfer funds strings~~~~~~~~~~~~~~~~//
	public final String EDITED_AMOUNT = "1.01";
	public final String TRANSFER_FUNDS_AMOUNT = "22.22";
	//~~~~~~~~~~~~~~~~~~~~~Card Tab strings~~~~~~~~~~~~~~~~//
	public final String DRIVERSEARCH = "John";
	public final String UNITSEARCH = "12";
	public final String CARDSEARCH = "0470";
	public final String IDSEARCH = "12";
	public final String POLICYSEARCH = "2";
	public final String MANUAL_PASSCODE = "985477";
	//~~~~~~~~~~~~~~~~~~~~~Searcg Along a route Tab strings~~~~~~~~~~~~~~~~//
	public final String DESTINATION = "Salt Lake City";
	
	
}