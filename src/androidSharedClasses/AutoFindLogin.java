package androidSharedClasses;

import java.sql.ResultSet;
import androidCardClasses.CardDirectLoginPass;


public class AutoFindLogin {
	
private String env;
private String accountNum;
private String passwordOrPin;
private String memberID;
private String unitID;
private String accountType;
private String mysqlRowMissing;
int lastFour;


private LoginInfo loginInfo = new LoginInfo();


	
	public void CardPassExpected(String account) throws Exception {
		AndroidLogs androidLogs = new AndroidLogs();
		//androidLogs.setupTest("Auto account selector started");
		this.accountNum = account;
		this.accountType = account;
		
	

		
		
		CardDirectLoginPass Login = new CardDirectLoginPass();
		
		EnvironmentPicker environmentPicker=new EnvironmentPicker();
		AutoAccountSelector getAccount = new AutoAccountSelector();
	
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		getAccount.setEnv(env);
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
		
//		String pass = androidText.PASS;
//		String fail = androidText.FAIL;
		String info = androidText.INFO;
		
		System.out.println("Locating an account to test with on the " + env + " server, using a " +accountType + " Card");
		androidLogs.CapturedLogs(info, "Locating an account to test with on the " + env + " server, using a " +accountType + " Card");
		
	
		
		switch (accountNum) {
		case "COMPANY":  lastFour = 1;
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		
	
				androidLogs.setupTestYellow("COMPANY CARD");
				environmentPicker.SetEnvironment();
				env = environmentPicker.getEnviroment();
				getAccount.setEnv(env);
				getAccount.CardPassExpected("COMPANY");	
				accountType = "COMPANY";
				androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
				

		ResultSet companyCardInfx = dbACPTCheck.query("infx",String.format("select first 1 cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'N' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' order by c.lastupdated desc"));
		//		ResultSet companyCardInfx = dbACPTCheck.query("infx",String.format("select cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'N' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' order by c.lastupdated desc limit 1"));
		companyCardInfx.next();
		String newCompanyCard = companyCardInfx.getString("card_num");
		String newCompanyCardPin = companyCardInfx.getString("pin");
			
		
		this.accountNum = newCompanyCard;
		this.passwordOrPin = newCompanyCardPin;
		
		accountNum = accountNum.trim();
		System.out.println("This is the Company card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		
//TODO make sure card is not set to a non useable status	
		
		ResultSet companyCardMysql = dbACPTCheck.query("mysql",String.format("select * from sec_user where user_id='"+accountNum+"'"));
		

//TODO setup mysql record if missing
		if (!companyCardMysql.next()) {
			System.out.println(accountType+" Card row is missing from  mysql side need to login with card first");
			androidLogs.CapturedLogs(info, accountType+" Card row is missing from  mysql side need to login with card first");
		}else {	
		String newCompanyCardDB = companyCardMysql.getString("user_id");
		String newCompanyCardDBStatus = companyCardMysql.getString("status_id");
		System.out.println(accountType+" Card found on MYSQL side =: " + newCompanyCardDB);
		System.out.println(accountType+" Card status on MYSQL side =: " + newCompanyCardDBStatus);

	
		
		if (this.accountNum.equalsIgnoreCase(newCompanyCardDB)){
		androidLogs.CapturedLogs(info, accountType+" card found in both databses");
		System.out.println(accountType+" Card Status on mysql side =: " + newCompanyCardDBStatus);
		androidLogs.CapturedLogs(info, accountType+" card status is: " +newCompanyCardDBStatus);
		
		if(newCompanyCardDBStatus.equalsIgnoreCase("S")) {
		System.out.println(accountType+" card is not Active on mysql side");
		androidLogs.CapturedLogs(info, accountType+" card is not Active updating to Active status");
		dbACPTCheck.execute("mysql", "UPDATE sec_user SET status_id ='A'WHERE user_id ='"+accountNum+"'");
		dbACPTCheck.execute("mysql", "UPDATE sec_user SET passwd_fail_count ='0'WHERE user_id ='"+accountNum+"'");
		androidLogs.CapturedLogs(info, accountType+" card status is being set back to Active and fail count = 0");
		
		ResultSet companyCardMysqlNewStatus = dbACPTCheck.query("mysql",String.format("select * from sec_user where user_id='"+accountNum+"'"));
		companyCardMysqlNewStatus.next();		
		String CompanyCardDBStatusNow = companyCardMysqlNewStatus.getString("status_id");
		
		System.out.println(accountType+" Card Status on mysql side =: " + CompanyCardDBStatusNow);
		androidLogs.CapturedLogs(info, accountType+" card status is: " +CompanyCardDBStatusNow);
		}else {
		System.out.println("Status of S was not seen on "+accountType+" Card mysql side");
		androidLogs.CapturedLogs(info, "Status of S was not seen on "+accountType+" Card mysql side");
		}
			
		}else {
			System.out.println(accountType+" Card already active on the mysql side");
			androidLogs.CapturedLogs(info, accountType+" already active on the mysql side");
		}
		}
	
		
		
		break;
		
		case "SMARTFUNDS": lastFour = 2;
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		
		//SMARTFUNDS CARD
				androidLogs.setupTestYellow("SMARTFUNDS CARD");
				environmentPicker.SetEnvironment();
				env = environmentPicker.getEnviroment();
				getAccount.setEnv(env);
				getAccount.CardPassExpected("SMARTFUNDS");	
				accountType = "SMARTFUNDS";
				androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
			
		
		ResultSet smartFundsCard = dbACPTCheck.query("infx",String.format("select first 1 cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'P' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' and cp.pin <> 'NULL' and c.card_type <> 'MCFL' order by c.lastupdated desc"));
		
		smartFundsCard.next();
		String newSmartFundsCard = smartFundsCard.getString("card_num");
		String newSmartFundsCardPin = smartFundsCard.getString("pin");
		this.accountNum = newSmartFundsCard;
		this.passwordOrPin = newSmartFundsCardPin;
		accountNum = accountNum.trim();
	
		System.out.println("This is the SmartFunds card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		//TODO make sure card is not set to a non useable status
		
		if (!smartFundsCard.next()) {
			System.out.println(accountType+" Card row is missing from  mysql side need to login with card first");
			androidLogs.CapturedLogs(info, accountType+" Card row is missing from  mysql side need to login with card first");
		}else {	
			
		
				ResultSet smartFundsCardMysql = dbACPTCheck.query("mysql",String.format("select * from sec_user where user_id='"+accountNum+"'"));
				smartFundsCardMysql.next();		
				String newSmartFundsCardDB = smartFundsCardMysql.getString("user_id");
				String newSmartFundsDBStatus = smartFundsCardMysql.getString("status_id");
				System.out.println(accountType+" Card found on MYSQL side =: " + newSmartFundsCardDB);
				System.out.println(accountType+" Card status on MYSQL side =: " + newSmartFundsDBStatus);
				
				System.out.println("This account number = : " + this.accountNum);
				if (this.accountNum.equalsIgnoreCase(newSmartFundsCardDB)){
				androidLogs.CapturedLogs(info, accountType+" card found in both databses");
				System.out.println(accountType+" Card Status on mysql side =: " + newSmartFundsDBStatus);
				androidLogs.CapturedLogs(info, accountType+" card status is: " +newSmartFundsDBStatus);
				
				if(newSmartFundsDBStatus.equalsIgnoreCase("S")) {
				System.out.println(accountType+" is not Active on mysql side");
				androidLogs.CapturedLogs(info, accountType+"card is not Active updating to Active status");
				dbACPTCheck.execute("mysql", "UPDATE sec_user SET status_id ='A'WHERE user_id ='"+accountNum+"'");
				dbACPTCheck.execute("mysql", "UPDATE sec_user SET passwd_fail_count ='0'WHERE user_id ='"+accountNum+"'");
				androidLogs.CapturedLogs(info, accountType+" card status is being set back to Active and fail count = 0");
				
				ResultSet smartFundsCardMysqlNewStatus = dbACPTCheck.query("mysql",String.format("select * from sec_user where user_id='"+accountNum+"'"));
				smartFundsCardMysqlNewStatus.next();		
				String SmartFundsCardDBStatusNow = smartFundsCardMysqlNewStatus.getString("status_id");
				
				System.out.println(accountType+" Card Status on mysql side =: " + SmartFundsCardDBStatusNow);
				androidLogs.CapturedLogs(info, accountType+" card status is: " +SmartFundsCardDBStatusNow);
				}else {
				System.out.println("Status of S was not seen on "+accountType+" Card mysql side");
				androidLogs.CapturedLogs(info, "Status of S was not seen on "+accountType+" Card mysql side");
				}
					
				}else {
					System.out.println(accountType+" Card already active on the mysql side");
					androidLogs.CapturedLogs(info, accountType+" Card already active on the mysql side");
				}
		
		}
		
		
		
		break;
		
		case "UNIVERSAL": lastFour = 3;
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		
		//UNIVERSAL CARD
				androidLogs.setupTestYellow("UNIVERSAL CARD");
				environmentPicker.SetEnvironment();
				env = environmentPicker.getEnviroment();
				getAccount.setEnv(env);
				getAccount.CardPassExpected("UNIVERSAL");	
				accountType = "UNIVERSAL";
				androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
			
		
		ResultSet universalCard = dbACPTCheck.query("infx",String.format("select first 1 cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'B' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A'order by c.lastupdated desc"));
		//		ResultSet universalCard = dbACPTCheck.query("infx",String.format("select first 1 cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'B' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' limit 1"));

		universalCard.next();
		
		String newuniversalCard = universalCard.getString("card_num");
		String newuniversalCardPin = universalCard.getString("pin");
		
		this.accountNum = newuniversalCard;
		this.passwordOrPin = newuniversalCardPin;
		accountNum = accountNum.trim();
		System.out.println("This is the Universal card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		//TODO make sure card is not set to a non useable status
		if (!universalCard.next()) {
			System.out.println(accountType+" Card row is missing from  mysql side need to login with card first");
			androidLogs.CapturedLogs(info, accountType+" Card row is missing from  mysql side need to login with card first");
		}else {	
			
		ResultSet universalCardMysql = dbACPTCheck.query("mysql",String.format("select * from sec_user where user_id='"+accountNum+"'"));
		universalCardMysql.next();		
		String newUniversalCardDB = universalCardMysql.getString("user_id");
		String newUniversalCardBStatus = universalCardMysql.getString("status_id");
		System.out.println(accountType+" Card found on MYSQL side =: " + newUniversalCardDB);
		System.out.println(accountType+" Card status on MYSQL side =: " + newUniversalCardBStatus);
		
		if (this.accountNum.equalsIgnoreCase(newUniversalCardDB)){
		androidLogs.CapturedLogs(info, accountType+" card found in both databses");
		System.out.println(accountType+" Card Status on mysql side =: " + newUniversalCardBStatus);
		androidLogs.CapturedLogs(info, accountType+" card status is: " +newUniversalCardBStatus);
		
		if(newUniversalCardBStatus.equalsIgnoreCase("S")) {
		System.out.println(accountType+" card is not Active on mysql side");
		androidLogs.CapturedLogs(info, accountType+" card is not Active updating to Active status");
		dbACPTCheck.execute("mysql", "UPDATE sec_user SET status_id ='A'WHERE user_id ='"+accountNum+"'");
		dbACPTCheck.execute("mysql", "UPDATE sec_user SET passwd_fail_count ='0'WHERE user_id ='"+accountNum+"'");
		androidLogs.CapturedLogs(info, accountType+" card status is being set back to Active and fail count = 0");
		
		ResultSet universalCardMysqlNewStatus = dbACPTCheck.query("mysql",String.format("select * from sec_user where user_id='"+accountNum+"'"));
		universalCardMysqlNewStatus.next();		
		String UniversalDBStatusNow = universalCardMysqlNewStatus.getString("status_id");
		
		System.out.println(accountType+" Card Status on mysql side =: " + UniversalDBStatusNow);
		androidLogs.CapturedLogs(info, accountType+" card status is: " +UniversalDBStatusNow);
		}else {
		System.out.println(accountType+" Card already active on the mysql side");
		androidLogs.CapturedLogs(info, accountType+" Card already active on the mysql side");
		}
			
		}else {
			System.out.println(accountType+" card not found on mysql side");
			androidLogs.CapturedLogs(info, accountType+" card not found on mysql side");
		}
		}
		
		
		
		break;
		
		case "SETUP_PROFILE": lastFour = 4;
		//TODO Add database login
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		ResultSet setupProfileCardDB = dbACPTCheck.query("infx",String.format("select card_num from ach_profile_card_xref order by profile_id desc limit 1"));
		setupProfileCardDB.next();
		
		String newSetupProfileCardDB = setupProfileCardDB.getString("card_num");
		newSetupProfileCardDB.trim();
		ResultSet setupProfileCardDBData = dbACPTCheck.query("infx",String.format("Select * from card_pins where card_num = '"+newSetupProfileCardDB+"'"));
		setupProfileCardDBData.next();
		
		String setupProfileCardUsing = setupProfileCardDBData.getString("card_num");
		String setupProfileCardUsingPin = setupProfileCardDBData.getString("pin");
		
		this.accountNum = setupProfileCardUsing;
		this.passwordOrPin = setupProfileCardUsingPin;
		
		System.out.println("This is the Setup Profile card found: " +accountNum + " Pin found: " +passwordOrPin);
		accountNum = accountNum.trim();
		break;
		
		
		
		case "PASSCODE": lastFour = 5;
		//TODO Add database login
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		ResultSet setupPasscodeCardDB = dbACPTCheck.query("infx",String.format("select first 1 cp.card_num, cp.pin, cp.* from cards c, card_pins cp where c.card_num = cp.card_num and cp.status = 'A'and cp.valid in ('A','Y') and c.status = 'A'and cp.passcode_enabled_flag = 'Y'and c.dynamic_pin_flag = 'Y' order by cp.passcode_set_date desc"));
//		ResultSet setupPasscodeCardDB = dbACPTCheck.query("infx",String.format("select first 1 cp.card_num, cp.pin, cp.* from cards c, card_pins cp where c.card_num = cp.card_num and cp.status = 'A'and cp.valid in ('A','Y') and c.status = 'A'and cp.passcode_enabled_flag = 'Y'and c.dynamic_pin_flag = 'Y' limit 1"));

		setupPasscodeCardDB.next();		
		String newPasscodeCard = setupPasscodeCardDB.getString("card_num");
		String newPASSCODECardStatus = setupPasscodeCardDB.getString("status");
		this.accountNum = newPasscodeCard;
		accountNum = accountNum.trim();
		System.out.println("This is the Universal card found: " +accountNum);
		System.out.println("Account number after trim should be the new password: "+accountNum+" Should have no spaces at the end");
		
		System.out.println(accountType+" Card found on MYSQL side =: " + newPasscodeCard +" LOGIN WITH CARD IF ERROR SEEN CARD NUMBER NO LONGER HAS PASSCODE");
		androidLogs.CapturedLogs(info, accountType+" Card found on MYSQL side =: " + getMaskedCard() +" LOGIN WITH CARD IF ERROR SEEN CARD NUMBER NO LONGER HAS PASSCODE");
		System.out.println(accountType+" Card status on MYSQL side =: " + newPASSCODECardStatus);
		
		
		String newPasscodeCardPasscode = accountNum.substring(accountNum.length()-6);
		this.passwordOrPin = newPasscodeCardPasscode;
		System.out.println("Account number after trim should be the new password: "+newPasscodeCardPasscode+" Should have no spaces at the end");

		System.out.println(newPasscodeCard);
		System.out.println(newPasscodeCardPasscode);
		
		
		break;
		
		case "SECURE_FUEL_NEEDS_UNIT_NUMBER": lastFour = 6;
		//TODO Add database login
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		androidLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		
		//ResultSet setupSecureFuelCardDB = dbACPTCheck.query("infx",String.format("Select member_id, card_pins.* from cards, card_pins, member where member.secure_fuel_rules in (1, 2) and member.member_id = cards.carrier_id and cards.status = 'A'and cards.card_num = card_pins.card_num and card_pins.status = 'A'and card_pins.valid ='A'"));
		
		//Original 
				//ResultSet setupSecureFuelCardDB = dbACPTCheck.query("infx",String.format("SELECT first 1 card_pins.* from cards, card_pins, member where member.secure_fuel_rules in (1, 2) and member.member_id = cards.carrier_id and cards.status = 'A'and cards.card_num = card_pins.card_num and card_pins.status = 'A'and card_pins.valid ='A'"));
				
				
				//This one works now that I have a card setup for it.. Check for constancy.
				ResultSet setupSecureFuelCardDB = dbACPTCheck.query("infx",String.format("SELECT first 1 member_id, card_pins.* FROM cards, card_pins, member, card_inf WHERE member.secure_fuel_rules IN (1,2) AND member.member_id = cards.carrier_id AND cards.status = 'A' AND cards.card_num = card_pins.card_num AND card_pins.status = 'A' AND card_pins.valid = 'A' AND cards.card_num = card_inf.card_num AND card_inf.info_id <> 'UNIT'"));	
				
		
		
		setupSecureFuelCardDB.next();
		String newSecureFuelCard = setupSecureFuelCardDB.getString("card_num");
		String newSecureFuelCardPin = setupSecureFuelCardDB.getString("pin");
		String newSecureFuelCardMemberID = setupSecureFuelCardDB.getString("member_id");
		this.accountNum = newSecureFuelCard;
		this.passwordOrPin = newSecureFuelCardPin;
		this.memberID = newSecureFuelCardMemberID;
		accountNum = accountNum.trim();
		
		System.out.println("This is the Secure Fuel card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		memberID = memberID.trim();
		System.out.println("Account number after trim shoudl be the new password: "+accountNum+" Should have no spaces at the end");
				
		
		ResultSet secureFuelUnitID = dbACPTCheck.query("infx",String.format("Select * from def_info where carrier_id = '"+memberID+"'" + "and info_id = 'UNIT'"));
		secureFuelUnitID.next();
		
		String newUnitID = secureFuelUnitID.getString("info_validation");
		this.unitID = newUnitID;
		unitID = newUnitID.trim();
		System.out.println("the unit number found is: " + unitID);																								 
		break;
		
		
		
		
		case "Register_Check_Company": lastFour = 7;
		//TODO Add database login
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		androidLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet registerCheckCardDB = dbACPTCheck.query("infx",String.format("select first 3 cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'N' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' and c.contract_id = '-1' and c.payr_chk = 'Y' and  c.payr_ach = 'Y' order by c.lastupdated desc"));

		
		registerCheckCardDB.next();
		registerCheckCardDB.next();
		String newregisterCheckCard = registerCheckCardDB.getString("card_num");
		String newregisterCheckCardPin = registerCheckCardDB.getString("pin");
		this.accountNum = newregisterCheckCard;
		this.passwordOrPin = newregisterCheckCardPin;
		accountNum = accountNum.trim();
		
		System.out.println("Register Check Company card found: " +accountNum + " Pin found: " +passwordOrPin);
		System.out.println("Account number after trim shoudl be the new password: "+accountNum+" Should have no spaces at the end");
		break;
		
		
		
		case "Register_Check_Smartfunds": lastFour = 8;
		//TODO Add database login
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		androidLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet registerCheckCardSmartFundsDB = dbACPTCheck.query("infx",String.format("select first 3 cp.card_num, cp.pin, payr_use, set from cards c, card_pins cp where c.card_num = cp.card_num and payr_use = 'P' and cp.status = 'A' and cp.valid = 'A' and c.status = 'A' and c.contract_id = '-1' and c.payr_chk = 'Y' and  c.payr_ach = 'Y' order by c.lastupdated desc"));

		
		registerCheckCardSmartFundsDB.next();
		registerCheckCardSmartFundsDB.next();
		registerCheckCardSmartFundsDB.next();
		String newregisterCheckSmartFundsCard = registerCheckCardSmartFundsDB.getString("card_num");
		String newregisterCheckSmartFundsPin = registerCheckCardSmartFundsDB.getString("pin");
		this.accountNum = newregisterCheckSmartFundsCard;
		this.passwordOrPin = newregisterCheckSmartFundsPin;
		accountNum = accountNum.trim();
		
		System.out.println("Register Check SmartFunds card found: " +accountNum + " Pin found: " +passwordOrPin);
		System.out.println("Account number after trim shoudl be the new password: "+accountNum+" Should have no spaces at the end");
		break;
		
		
		
		
		
		case "SECURE_FUEL_DOES NOT_NEED_UNIT_NUMBER": lastFour = 9;
		//TODO Add database login
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		androidLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
	
//		ResultSet setupSecureFuelCardDB = dbACPTCheck.query("infx",String.format("Select member_id, card_pins.* from cards, card_pins, member where member.secure_fuel_rules in (1, 2) and member.member_id = cards.carrier_id and cards.status = 'A'and cards.card_num = card_pins.card_num and card_pins.status = 'A'and card_pins.valid ='A'"));

		ResultSet SecureFuelCardDoesNotNeedUnitNumberDB = dbACPTCheck.query("infx",String.format("SELECT first 1 member_id, card_pins.*, card_inf.info_validation FROM cards, card_pins, member, card_inf WHERE member.secure_fuel_rules IN (1,2) AND   member.member_id = cards.carrier_id AND   cards.status = 'A' AND   cards.card_num = card_pins.card_num AND   card_pins.status = 'A' AND   card_pins.valid = 'A' AND   cards.card_num = card_inf.card_num  AND  card_inf.info_id = 'UNIT' and cards.infosrc = 'C' and card_inf.info_validation like 'V%%'"));
		
		SecureFuelCardDoesNotNeedUnitNumberDB.next();
		String newSecureFuelNoUnitCard = SecureFuelCardDoesNotNeedUnitNumberDB.getString("card_num");
		String newSecureFuelNoUnitCardPin = SecureFuelCardDoesNotNeedUnitNumberDB.getString("pin");
		String newSecureFuelNoUnitCardMemberID = SecureFuelCardDoesNotNeedUnitNumberDB.getString("member_id");
		this.accountNum = newSecureFuelNoUnitCard;
		this.passwordOrPin = newSecureFuelNoUnitCardPin;
		this.memberID = newSecureFuelNoUnitCardMemberID;
		accountNum = accountNum.trim();
		
		System.out.println("This is the Secure Fuel card found: " +accountNum + " Pin found: " +passwordOrPin);
		
		memberID = memberID.trim();
		System.out.println("Account number after trim shoudl be the new password: "+accountNum+" Should have no spaces at the end");
				
		
		ResultSet secureFuelUnitID1 = dbACPTCheck.query("infx",String.format("Select * from def_info where carrier_id = '"+memberID+"'" + "and info_id = 'UNIT'"));
		secureFuelUnitID1.next();
		
		String newUnitID1 = secureFuelUnitID1.getString("info_validation");
		this.unitID = newUnitID1;
		unitID = newUnitID1.trim();
		System.out.println("the unit number found is: " + unitID);																								 
		break;
		
		


		case "ACTIVE_CARRIERCONTROL_ACCOUNT": lastFour = 10;
		//TODO Add database login
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		androidLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet activeCarrierControldb = dbACPTCheck.query("infx",String.format("SELECT first 1 passwd, * from member where status = 'A' order by date_updated desc"));
		
		
		activeCarrierControldb.next();
		String activeCarrierControlCard = activeCarrierControldb.getString("member_id");
		String activeCarrierControlPass = activeCarrierControldb.getString("passwd");
		this.accountNum = activeCarrierControlCard;
		this.passwordOrPin = activeCarrierControlPass;
		
		
		System.out.println("Active carrier control account: " +accountNum + " Password found: " +passwordOrPin);
		break;
		
		
		case "FLEET_ONE": lastFour = 11;
		//TODO Add database login
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " Card started");
		
		//FLEET ONE CARD
				androidLogs.setupTestYellow("FLEET ONE CARD");
				environmentPicker.SetEnvironment();
				env = environmentPicker.getEnviroment();
				getAccount.setEnv(env);
				getAccount.CardPassExpected("FLEET_ONE");	
				accountType = "FLEET_ONE";
				androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
			
		
		androidLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet fleetOne = dbACPTCheck.query("infx",String.format("Select * from card_pins where card_num like '501486%%' and status = 'A' and valid = 'A' order by set DESC"));
		
		fleetOne.next();
		String fleetOneCard = fleetOne.getString("card_num");
		String fleetOnePin = fleetOne.getString("pin");
		this.accountNum = fleetOneCard;
		this.passwordOrPin = fleetOnePin;
		accountNum = accountNum.trim();
		System.out.println("Active carrier control account: " +accountNum + " Password found: " +passwordOrPin);
		
		
		break;
		
		
		case "CARRIER_102698": lastFour = 12;
		//TODO Add database login
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " account started");
		
		//CARRIER_102698
				androidLogs.setupTest("AUTO ACCOUNT TAB TEST");
				androidLogs.setupTestYellow("CARRIER_102698");
				environmentPicker.SetEnvironment();
				env = environmentPicker.getEnviroment();
				getAccount.setEnv(env);
				getAccount.CardPassExpected("CARRIER_102698");	
				accountType = "CARRIER_102698";
				androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
				
		
		androidLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet carrier102698 = dbACPTCheck.query("infx",String.format("select passwd, * from member where member_id = '102698'"));
		
		carrier102698.next();
		String member102698 = carrier102698.getString("member_id");
		String password102698 = carrier102698.getString("passwd");
		this.accountNum = member102698;
		this.passwordOrPin = password102698;
		accountNum = accountNum.trim();
		passwordOrPin = passwordOrPin.trim();
	
		
		
		
		loginInfo.setEnv(env);
		loginInfo.setAccountNum(accountNum);
		loginInfo.setPassOrPin(passwordOrPin);
		
		
		
		System.out.println("Active carrier control account: " +accountNum + " Password found: " +passwordOrPin);
		
		break;
		
		
		case "CARRIER_100045": lastFour = 13;
		//TODO Add database login
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " account started");
		
		//CARRIER_100045
		androidLogs.setupTest("AUTO ACCOUNT TAB TEST");
		androidLogs.setupTestYellow("CARRIER_100045");
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		getAccount.setEnv(env);
		getAccount.CardPassExpected("CARRIER_100045");	
		accountType = "CARRIER_100045";
		androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
	
		
		
		androidLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet carrier100045 = dbACPTCheck.query("infx",String.format("select passwd, * from member where member_id = '100045'"));
		
		carrier100045.next();
		String member100045 = carrier100045.getString("member_id");
		String password100045 = carrier100045.getString("passwd");
		this.accountNum = member100045;
		this.passwordOrPin = password100045;
		accountNum = accountNum.trim();
		passwordOrPin = passwordOrPin.trim();
		System.out.println("Active carrier control account: " +accountNum + " Password found: " +passwordOrPin);
		break;
		
		
		case "CARRIER_100644": lastFour = 14;
		//TODO Add database login
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " account started");
		
		//CARRIER_100644
				androidLogs.setupTest("AUTO ACCOUNT TAB TEST");
				androidLogs.setupTestYellow("CARRIER_100644");
				environmentPicker.SetEnvironment();
				env = environmentPicker.getEnviroment();
				getAccount.setEnv(env);
				getAccount.CardPassExpected("CARRIER_100644");	
				accountType = "CARRIER_100644";
				androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
						
		androidLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet carrier100644 = dbACPTCheck.query("infx",String.format("select passwd, * from member where member_id = '100644'"));
		
		carrier100644.next();
		String member100644 = carrier100644.getString("member_id");
		String password100644 = carrier100644.getString("passwd");
		this.accountNum = member100644;
		this.passwordOrPin = password100644;
		accountNum = accountNum.trim();
		passwordOrPin = passwordOrPin.trim();
		System.out.println("Active carrier control account: " +accountNum + " Password found: " +passwordOrPin);
		
		
		break;
		
		
		case "CARRIER_102698db": lastFour = 14;
		//TODO Add database login
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " account started");
		androidLogs.CapturedLogs(info, accountType+ "has a passcode and is added manually check database if errors seen");
		
		//CARRIER_102698db
		androidLogs.setupTest("Billing Tab Functional Test");
		androidLogs.setupTestYellow("CARRIER_102698db");
		environmentPicker.SetEnvironment();
		env = environmentPicker.getEnviroment();
		getAccount.setEnv(env);
		getAccount.CardPassExpected("CARRIER_102698db");	
		accountType = "CARRIER_102698db";
		androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
	
		
		
		androidLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		//ResultSet carrier102698db = dbACPTCheck.query("infx",String.format("select passwd, * from member where member_id = '102698db'"));
		
		//carrier102698db.next();
		String member102698db = "102698db";
		String password102698db = "NGFC123";
		this.accountNum = member102698db;
		this.passwordOrPin = password102698db;
		accountNum = accountNum.trim();
		passwordOrPin = passwordOrPin.trim();
		System.out.println("Active carrier control account: " +accountNum + " Password found: " +passwordOrPin);
		break;
		
		
		
		case "CARRIER_103526": lastFour = 15;
		//TODO Add database login
		androidLogs.CapturedLogs(info, "Finding " +accountType+ " account started");
		androidLogs.CapturedLogs(info, "Some SQL Statements take a minute tot load");
		
		//CARRIER_103526
				androidLogs.setupTest("Billing Tab Functional Test");
				androidLogs.setupTestYellow("CARRIER_103526");
				environmentPicker.SetEnvironment();
				env = environmentPicker.getEnviroment();
				getAccount.setEnv(env);
				getAccount.CardPassExpected("CARRIER_103526");	
				accountType = "CARRIER_103526";
				androidLogs.setupTestYellow("LOCATING " + accountType+ " ON: " + env);
		
		System.out.println("Some SQL Statements take a minute to load Please Wait");
		ResultSet carrier103526 = dbACPTCheck.query("infx",String.format("select passwd, * from member where member_id = '103526'"));
		
		carrier103526.next();
		String member103526 = carrier103526.getString("member_id");
		String password103526 = carrier103526.getString("passwd");
		this.accountNum = member103526;
		this.passwordOrPin = password103526;
		accountNum = accountNum.trim();
		passwordOrPin = passwordOrPin.trim();
		System.out.println("Active carrier control account: " +accountNum + " Password found: " +passwordOrPin);
		break;
		
		default:
			androidLogs.CapturedLogs(info, "No " +accountType+ " card number found");
	
	}
}
	
	public String getMaskedCard() {
	String TempCard = this.accountNum.trim();
	String maskedCard = TempCard.substring(0, 5) + "****" + TempCard.substring(TempCard.length()-4);
	return maskedCard;

	}	
		
		
	public String getUnitID() {
		return unitID;
	}

	public void setUnitID(String unitID) {
		this.unitID = unitID;
	}

	public void setAccountNum(String cardNumNow) {
		this.accountNum = cardNumNow;
		System.out.println("SET Card Number: "+ accountNum);
	}
	
	public String getAccountNum() {
		System.out.println("GET Card number: "+ accountNum);
		return accountNum;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getPasswordOrPin() {
		return passwordOrPin;
	}

	public void setPasswordOrPin(String passwordOrPin) {
		this.passwordOrPin = passwordOrPin;
	}

	public String getMysqlRowMissing() {
		return mysqlRowMissing;
	}

	public void setMysqlRowMissing(String mysqlRowMissing) {
		this.mysqlRowMissing = mysqlRowMissing;
	}

	public LoginInfo getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
	
	
	
}
