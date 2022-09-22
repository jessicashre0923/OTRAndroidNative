package androidCarrierClasses;

import java.sql.ResultSet;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ConnectionHandler;
import androidSharedClasses.EnvironmentPicker;

public class ResetTestAccounts {
	
private String env;
	
	
	
	public void ResetAllAccounts(String environment) throws Exception {
	this.env = environment;
	
	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new AppStringsAndroid();
	ConnectionHandler dbACPT = new ConnectionHandler(env);
	androidLogs.setupTest("Collecting database details");
	ResultSet card_info1 = dbACPT.query("mysql", String.format("select status_i"
			+ "d from sec_user where user_id = %s","100045"));
	ResultSet card_info2 = dbACPT.query("mysql", String.format("select status_id from sec_user where user_id = %s","102698"));
	ResultSet card_info3 = dbACPT.query("infx", String.format("select passwd from member where member_id = %s",androidText.CARRIER_LOGIN_ID_LOCKED_100045));
	ResultSet card_info4 = dbACPT.query("infx", String.format("select passwd from member where member_id = %s",androidText.CARRIER_LOGIN_ID_SMARTFUNDS_100045));
	
	card_info1.next();
	
	androidLogs.CapturedLogs(androidText.INFO, String.format("Card Account status is: %s", card_info1.getString("status_id")));
	
	if (card_info1.getString("status_id").equals("S")) {
		androidLogs.CapturedLogs(androidText.INFO, "Card Account Was Suspended prior to testing");
		dbACPT.execute("mysql", "update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = ' 100045'");
		androidLogs.CapturedLogs(androidText.INFO, "Account 100045 Now acctive and fail count set to 0");
	}else {
		androidLogs.CapturedLogs(androidText.INFO, String.format("Card Account status is: %s", card_info1.getString("status_id")));
		androidLogs.CapturedLogs(androidText.INFO, "Account 100045 is active and ready for testing ");

	}
	
	card_info2.next();
	
	androidLogs.CapturedLogs(androidText.INFO, String.format("Card Account status is: %s", card_info2.getString("status_id")));
	
	
	if (card_info2.getString("status_id").equals("S")) {
	
		androidLogs.CapturedLogs(androidText.INFO, "Card Account Was Suspended prior to testing");
		dbACPT.execute("mysql", "update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '102698'");
		androidLogs.CapturedLogs(androidText.INFO, "Account 102698 Now acctive and fail count set to 0");
	}else {
		androidLogs.CapturedLogs(androidText.INFO, String.format("Card Account status is: %s", card_info2.getString("status_id")));
		androidLogs.CapturedLogs(androidText.INFO, "Account 102698 is active and ready for testing ");

	}
	
	card_info3.next();
	
	if (card_info3.getString("passwd").equals(androidText.CARRIER_LOGIN_PASSWORD_SMARTFUUNDS)) {
		androidLogs.CapturedLogs(androidText.INFO, "Carrier password is as expected: " + androidText.CARRIER_LOGIN_PASSWORD_SMARTFUUNDS);
		androidLogs.CapturedLogs(androidText.INFO, "Account" + androidText.CARRIER_LOGIN_ID_LOCKED_100045 + "Password is correct");
	}else {
		dbACPT.execute("infx", "update member set passwd = " + androidText.CARRIER_LOGIN_PASSWORD_SMARTFUUNDS + "where member_id =" + androidText.CARRIER_LOGIN_ID_LOCKED_100045);
		
		androidLogs.CapturedLogs(androidText.INFO, String.format("password updated to expected from: %s", card_info3.getString("passwd")));
		androidLogs.CapturedLogs(androidText.INFO, "Account" + androidText.CARRIER_LOGIN_ID_LOCKED_100045 + "password is updatd and ready for testing ");

	}
	
card_info4.next();
	
	if (card_info4.getString("passwd").equals(androidText.CARRIER_LOGIN_PASSWORD_SMARTFUUNDS)) {
		androidLogs.CapturedLogs(androidText.INFO, "Carrier password is as expected: " + androidText.CARRIER_LOGIN_ID_SMARTFUNDS_100045);
		androidLogs.CapturedLogs(androidText.INFO, "Account" + androidText.CARRIER_LOGIN_ID_SMARTFUNDS_100045 + "Password is correct");
	}else {
		dbACPT.execute("infx", "update member set passwd = " + androidText.CARRIER_LOGIN_PASSWORD_SMARTFUUNDS + "where member_id =" + androidText.CARRIER_LOGIN_ID_SMARTFUNDS_100045);
		
		androidLogs.CapturedLogs(androidText.INFO, String.format("password updated to expected from: %s", card_info4.getString("passwd")));
		androidLogs.CapturedLogs(androidText.INFO, "Account" + androidText.CARRIER_LOGIN_ID_SMARTFUNDS_100045 + "password is updatd and ready for testing ");

	}
	
	androidLogs.CapturedLogs(androidText.INFO, "Database for automation test accounts Set to active and are ready for testing.");
	
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	//things to add in the future for mysql:// 
	//changing password for subusers this one grabs the hash stores it and then changes the hash back to what it was 
		//so we don't change the actual password. Before doing this for security reasons use a password no one else would be
		//that way no one can just simply paste the hash some where. 
	
	//Step1  is have a variable  of the sec_user.user_password stored off in code.  
		//Make sure real password is not something used elseward like letmein11.  
	//Step 2 -  Set up automation. to change password to what ever.  
	//Verify on screen the password was changed?
	//Verify in DB that user_password has changed?  Might not be need
	//Log in with new password -- verify it works.  
	//Step 3: Save password variable  back to DB.  so password is back to old one.
	
	
}
