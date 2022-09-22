package androidCardClasses;

import java.sql.ResultSet;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ConnectionHandler;
import io.appium.java_client.AppiumDriver;

public class SecurityQuestionsFail {
	
	private String env;
	private String cardNum;
	private String passwordOrPin;
	private String secAnswer1;
	private String secAnswer2;
	private String secAnswer3;
	private String cardID;
	private String lastEight;
	
	public SecurityQuestionsFail ForgotPINorPasscode(String environment, String cardNumber, String passwordOrPin) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		this.lastEight = cardNumber.substring(cardNumber.length()-8);
				
		//System.out.println("I am in login fail environment is:" + environment);
		ForgotPINorPasscode();
		return this;
	}

	static AppiumDriver<WebElement> driver;
	RepoCardAndroid elements = new RepoCardAndroid();
	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new AppStringsAndroid();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	

	public SecurityQuestionsFail ForgotPINorPasscode() throws Exception {
		androidLogs.setupTest("Fail all security questions");
		androidText = new AppStringsAndroid(env);
		
		
		
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
		androidLogs.CapturedLogs(info, "Finding card ID started");
		ResultSet cardID = dbACPTCheck.query("infx",String.format("SELECT card_id FROM cards WHERE card_num = '"+this.cardNum+"'"));
		cardID.next();
		
		String cardIDFound = cardID.getString("card_id");
		this.cardID = cardIDFound;
		androidLogs.CapturedLogs(info, "Card ID found");
				
		
		androidLogs.CapturedLogs(info, "Finding security Answers started");
		ResultSet secAnswerFound = dbACPTCheck.query("mysql",String.format("select answer1, answer2, answer3 from sec_answer where user_id = '"+this.cardID+"'"));
		secAnswerFound.next();
		
		String answer1 = secAnswerFound.getString("answer1");
		String answer2 = secAnswerFound.getString("answer2");
		String answer3 = secAnswerFound.getString("answer3");
		this.secAnswer1 = answer1;
		this.secAnswer2 = answer2;
		this.secAnswer3 = answer3;
		androidLogs.CapturedLogs(info, "Security answers found");
		
		
		Thread.sleep(5000);
		WebElement ForgotPINorPasscode = elements.ForgotPINorPasscode();
		if (ForgotPINorPasscode != null && ForgotPINorPasscode.isEnabled()) {
			ForgotPINorPasscode.click();
			androidLogs.CapturedLogs(pass, "Forgot pin or passcode link clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Forgot pin or passcode link not found");
		}

		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeCardNumberTextBox = elements.ForgotPINorPasscodeCardNumberTextBox();
		if (ForgotPINorPasscodeCardNumberTextBox != null && ForgotPINorPasscodeCardNumberTextBox.isEnabled()) {
			ForgotPINorPasscodeCardNumberTextBox.click();
			ForgotPINorPasscodeCardNumberTextBox.sendKeys(cardNum);
			androidLogs.CapturedLogs(pass,
					"Forgot pin or passcode card number textbox clicked and entered");
		} else {
			androidLogs.CapturedLogs(fail, "Forgot pin or passcode card number textbox not found");
		}

		
		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeNextButton = elements.ForgotPINorPasscodeNextButton();
		if (ForgotPINorPasscodeNextButton != null && ForgotPINorPasscodeNextButton.isEnabled()) {
			ForgotPINorPasscodeNextButton.click();
			androidLogs.CapturedLogs(pass, "Next clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Next not found");
		}


//enter wrong security answers 1					
		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeSecurityAnswerTextbox = elements.ForgotPINorPasscodeSecurityAnswerTextbox();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeSecurityAnswerTextbox != null && ForgotPINorPasscodeSecurityAnswerTextbox.isEnabled()) {
			ForgotPINorPasscodeSecurityAnswerTextbox.click();
			ForgotPINorPasscodeSecurityAnswerTextbox.sendKeys("False answer 1");
			androidLogs.CapturedLogs(pass, "Security answer entered");
		} else {
			androidLogs.CapturedLogs(fail, "Security answer textbox not found");
		}

		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeNextButton2 = elements.ForgotPINorPasscodeNextButton();
		if (ForgotPINorPasscodeNextButton2 != null && ForgotPINorPasscodeNextButton2.isEnabled()) {
			ForgotPINorPasscodeNextButton2.click();
			androidLogs.CapturedLogs(pass, "Next clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Next not found");
		}

		
//enter wrong security answers 2					
				Thread.sleep(3000);
				
				if (ForgotPINorPasscodeSecurityAnswerTextbox != null && ForgotPINorPasscodeSecurityAnswerTextbox.isEnabled()) {
					ForgotPINorPasscodeSecurityAnswerTextbox.click();
					ForgotPINorPasscodeSecurityAnswerTextbox.sendKeys("False answer 2");
					androidLogs.CapturedLogs(pass, "Security answer entered");
				} else {
					androidLogs.CapturedLogs(fail, "Security answer textbox not found");
				}

				Thread.sleep(3000);
			
				if (ForgotPINorPasscodeNextButton2 != null && ForgotPINorPasscodeNextButton2.isEnabled()) {
					ForgotPINorPasscodeNextButton2.click();
					androidLogs.CapturedLogs(pass, "Next clicked");
				} else {
					androidLogs.CapturedLogs(fail, "Next not found");
				}
				
				
//enter wrong security answers 3					
				Thread.sleep(3000);
					if (ForgotPINorPasscodeSecurityAnswerTextbox != null && ForgotPINorPasscodeSecurityAnswerTextbox.isEnabled()) {
					ForgotPINorPasscodeSecurityAnswerTextbox.click();
					ForgotPINorPasscodeSecurityAnswerTextbox.sendKeys("False answer 3");
					androidLogs.CapturedLogs(pass, "Security answer entered");
				} else {
					androidLogs.CapturedLogs(fail, "Security answer textbox not found");
				}

				Thread.sleep(3000);
					if (ForgotPINorPasscodeNextButton2 != null && ForgotPINorPasscodeNextButton2.isEnabled()) {
					ForgotPINorPasscodeNextButton2.click();
					androidLogs.CapturedLogs(pass, "Next clicked");
				} else {
					androidLogs.CapturedLogs(fail, "Next not found");
				}
					
					
					WebElement cardSuspendedOKButton = elements.cardSuspendedOKButton();
					Thread.sleep(3000);
					if (cardSuspendedOKButton != null && cardSuspendedOKButton.isEnabled()) {
						cardSuspendedOKButton.click();
						androidLogs.CapturedLogs(pass, "Card suspended modal seen and ok button pressed");
					}else {
						androidLogs.CapturedLogs(fail, "Card suspended modal not seen");
					}		
					
//Resetting card to active status in databse 					
			androidLogs.CapturedLogs(info, "Reseting card back to active status from databse prior to login");	
			System.out.println("Reseting card back to active status from databse prior to login");
			dbACPTCheck.execute("mysql", "update sec_user set status_id = 'A', passwd_fail_count = 0, login_attempted = NULL, token_failed_count = NULL where user_id ='"+ this.cardNum+"'");	
			androidLogs.CapturedLogs(info, "Card reset back to active for next test");

		return this;
	}
}
