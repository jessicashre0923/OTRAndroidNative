package androidCardClasses;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;

//import io.appium.java_client.AppiumDriver;

public class GetACard {
	
private String env;
private String cardNum;
private String passwordOrPin;
int lastFour;
	
	
	public void CardPassExpected(String cardNum) throws Exception {
		this.cardNum = cardNum;
		System.out.println("I am in Card Pass expected environment is: Cardnum: Pin or Password" + env +cardNum +passwordOrPin);

		AndroidLogs AndroidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid(env);
//		String pass = androidText.PASS;
//		String fail = androidText.FAIL;
		String info = androidText.INFO;
		
		
		
	

		switch (cardNum) {
		case "6344":  lastFour = 1;
		AndroidLogs.CapturedLogs(info, "Card 6344 found");
		this.cardNum = androidText.getENVData("CARDPIN_LOGIN_NUMBER_6344");
		passwordOrPin = androidText.getENVData("CARDPIN_LOGIN_PIN_6344");
		break;
		
		case "0561": lastFour = 2;
		//TODO Add database login
		AndroidLogs.CapturedLogs(info, "Card 0561 found");
		this.cardNum = androidText.getENVData("CARD_LOGIN_LOCK_EXPECTED");
		passwordOrPin = androidText.getENVData("SECURE_FUEL_0561_PIN");
		break;
		
		case "5542": lastFour = 3;
		AndroidLogs.CapturedLogs(info, "Card 5542 found");
		this.cardNum = androidText.getENVData("FORGOT_PIN_PASSCODE_5542");
		this.passwordOrPin = androidText.getENVData("FORGOT_PIN_PASSCODE_5542_PASSCODE");
		break;
		
		case "2800": lastFour = 4;
		//TODO Add database login
		AndroidLogs.CapturedLogs(info, "Card 2800 found");
		this.cardNum = androidText.getENVData("ACH_PIN_LOGIN_2800");
		this.passwordOrPin = androidText.getENVData("ACH_2800_PIN");
		break;
		
		
		case "1234":  lastFour = 5;
		AndroidLogs.CapturedLogs(info, "Card 6344 found");
		this.cardNum = androidText.getENVData("CARD_LOGIN_FAIL_EXPECTED");
		passwordOrPin = androidText.getENVData("CARD_LOGIN_PIN_FAIL_EXPECTED");
		break;
					
		default:
			AndroidLogs.CapturedLogs(info, "No Card number found");
	
	}
		
		
	
	}
	public void setCardNum(String cardNumNow) {
		this.cardNum = cardNumNow;
		System.out.println("SET Card Number: "+ cardNum);
	}
	
	public String getCardNum() {
		System.out.println("GET Card number: "+ cardNum);
		return cardNum;
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
}
