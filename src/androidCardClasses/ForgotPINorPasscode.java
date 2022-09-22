package androidCardClasses;

import java.sql.ResultSet;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ConnectionHandler;
import io.appium.java_client.AppiumDriver;

public class ForgotPINorPasscode {
	
	private String env;
	private String cardNum;
	private String passwordOrPin;
	private String secAnswer1;
	private String secAnswer2;
	private String secAnswer3;
	private String cardID;
	private String lastEight;
	
	public ForgotPINorPasscode ForgotPINorPasscode(String environment, String cardNumber, String passwordOrPin) throws Exception {
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
	

	public ForgotPINorPasscode ForgotPINorPasscode() throws Exception {
		androidLogs.setupTest("FORGOT PASSCODE FROM LOGIN TESTS");
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
		Thread.sleep(3000);
		if (ForgotPINorPasscode != null && ForgotPINorPasscode.isEnabled()) {
			ForgotPINorPasscode.click();
			androidLogs.CapturedLogs(pass, "Forgot pin or passcode link clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Forgot pin or passcode link not found");
		}

		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeCardNumberTextBox = elements.ForgotPINorPasscodeCardNumberTextBox();
		Thread.sleep(3000);
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
		Thread.sleep(3000);
		if (ForgotPINorPasscodeNextButton != null && ForgotPINorPasscodeNextButton.isEnabled()) {
			ForgotPINorPasscodeNextButton.click();
			androidLogs.CapturedLogs(pass, "Next clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Next not found");
		}


//enter correct sec answer working flow					
		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeSecurityAnswerTextbox = elements.ForgotPINorPasscodeSecurityAnswerTextbox();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeSecurityAnswerTextbox != null && ForgotPINorPasscodeSecurityAnswerTextbox.isEnabled()) {
			ForgotPINorPasscodeSecurityAnswerTextbox.click();
			ForgotPINorPasscodeSecurityAnswerTextbox.sendKeys(this.secAnswer1);
			androidLogs.CapturedLogs(pass, "Security answer entered");
		} else {
			androidLogs.CapturedLogs(fail, "Security answer textbox not found");
		}

		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeNextButton2 = elements.ForgotPINorPasscodeNextButton();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeNextButton2 != null && ForgotPINorPasscodeNextButton2.isEnabled()) {
			ForgotPINorPasscodeNextButton2.click();
			androidLogs.CapturedLogs(pass, "Next clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Next not found");
		}
		
		
//fail expected because you put in the last eight
		androidLogs.setupTest("Last eight of the card fail Function test");
		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeNewPasscodeTextbox = elements.ForgotPINorPasscodeNewPasscodeTextbox();
		if (ForgotPINorPasscodeNewPasscodeTextbox != null && ForgotPINorPasscodeNewPasscodeTextbox.isEnabled()) {
			ForgotPINorPasscodeNewPasscodeTextbox.click();
			ForgotPINorPasscodeNewPasscodeTextbox.sendKeys(lastEight);
			androidLogs.CapturedLogs(pass, "New passcode entered");
		} else {
			androidLogs.CapturedLogs(fail, "New passcode textbox not found");
		}

		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeConfirmPasscodeTextbox = elements.ForgotPINorPasscodeConfirmPasscodeTextbox();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeConfirmPasscodeTextbox != null
				&& ForgotPINorPasscodeConfirmPasscodeTextbox.isEnabled()) {
			ForgotPINorPasscodeConfirmPasscodeTextbox.click();
			ForgotPINorPasscodeConfirmPasscodeTextbox.sendKeys(lastEight);
			androidLogs.CapturedLogs(pass, "Confirm passcode entered");
		} else {
			androidLogs.CapturedLogs(fail, "Confirm passcode textbox not found");
		}
		
		
//TODO add a check for the text box shown...
		
		Thread.sleep(3000);
		WebElement ForgotPINorPasscodeNextButton3 = elements.ForgotPINorPasscodeNextButton();
		Thread.sleep(3000);
		if (ForgotPINorPasscodeNextButton3 != null && ForgotPINorPasscodeNextButton3.isEnabled()) {
			ForgotPINorPasscodeNextButton3.click();
			androidLogs.CapturedLogs(pass, "Next clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Next not found");
		}
		
		
//fail expected because new passcodes don't match put in the last eight
				androidLogs.setupTest("Passcodes don't match fail Function test");
				Thread.sleep(3000);
				if (ForgotPINorPasscodeNewPasscodeTextbox != null && ForgotPINorPasscodeNewPasscodeTextbox.isEnabled()) {
					ForgotPINorPasscodeNewPasscodeTextbox.click();
					ForgotPINorPasscodeNewPasscodeTextbox.sendKeys("12345678");
					androidLogs.CapturedLogs(pass, "New passcode entered");
				} else {
					androidLogs.CapturedLogs(fail, "New passcode textbox not found");
				}

				Thread.sleep(3000);
				if (ForgotPINorPasscodeConfirmPasscodeTextbox != null
						&& ForgotPINorPasscodeConfirmPasscodeTextbox.isEnabled()) {
					ForgotPINorPasscodeConfirmPasscodeTextbox.click();
					ForgotPINorPasscodeConfirmPasscodeTextbox.sendKeys("87654321");
					androidLogs.CapturedLogs(pass, "Confirm passcode entered");
				} else {
					androidLogs.CapturedLogs(fail, "Confirm passcode textbox not found");
				}
//TODO add a check for the text box shown...
		
				Thread.sleep(3000);
				WebElement ForgotPINorPasscodeNextButton4 = elements.ForgotPINorPasscodeNextButton();
				Thread.sleep(3000);
				if (ForgotPINorPasscodeNextButton4 != null && ForgotPINorPasscodeNextButton3.isEnabled()) {
					ForgotPINorPasscodeNextButton4.click();
					androidLogs.CapturedLogs(pass, "Next clicked");
				} else {
					androidLogs.CapturedLogs(fail, "Next not found");
				}
				
				
//fail expected because passcode needs to a min of 5 numbers (no modal for this the button just does not work.
				androidLogs.setupTest("Passcodes min of five fail Function test");
				Thread.sleep(3000);
				if (ForgotPINorPasscodeNewPasscodeTextbox != null && ForgotPINorPasscodeNewPasscodeTextbox.isEnabled()) {
					ForgotPINorPasscodeNewPasscodeTextbox.click();
					ForgotPINorPasscodeNewPasscodeTextbox.sendKeys("1234");
					androidLogs.CapturedLogs(pass, "New passcode entered");
				} else {
					androidLogs.CapturedLogs(fail, "New passcode textbox not found");
				}

				Thread.sleep(3000);
				if (ForgotPINorPasscodeConfirmPasscodeTextbox != null
						&& ForgotPINorPasscodeConfirmPasscodeTextbox.isEnabled()) {
					ForgotPINorPasscodeConfirmPasscodeTextbox.click();
					ForgotPINorPasscodeConfirmPasscodeTextbox.sendKeys("1234");
					androidLogs.CapturedLogs(pass, "Confirm passcode entered");
				} else {
					androidLogs.CapturedLogs(fail, "Confirm passcode textbox not found");
				}
//TODO add a check for the text box shown...
		
				Thread.sleep(3000);
			
				if (ForgotPINorPasscodeNextButton3 != null && ForgotPINorPasscodeNextButton3.isEnabled()) {
					ForgotPINorPasscodeNextButton3.click();
					androidLogs.CapturedLogs(fail, "Next clicked");
				} else {
					androidLogs.CapturedLogs(pass, "Next Should not be found per passcode length");
				}
				
				
				
//pass expected because new passcodes is right
				androidLogs.setupTest("New Passcode Function test");
				Thread.sleep(3000);
				if (ForgotPINorPasscodeNewPasscodeTextbox != null && ForgotPINorPasscodeNewPasscodeTextbox.isEnabled()) {
					ForgotPINorPasscodeNewPasscodeTextbox.click();
					ForgotPINorPasscodeNewPasscodeTextbox.sendKeys(passwordOrPin);
					androidLogs.CapturedLogs(pass, "New passcode entered");
				} else {
					androidLogs.CapturedLogs(fail, "New passcode textbox not found");
				}

				Thread.sleep(3000);
				if (ForgotPINorPasscodeConfirmPasscodeTextbox != null
						&& ForgotPINorPasscodeConfirmPasscodeTextbox.isEnabled()) {
					ForgotPINorPasscodeConfirmPasscodeTextbox.click();
					ForgotPINorPasscodeConfirmPasscodeTextbox.sendKeys(passwordOrPin);
					androidLogs.CapturedLogs(pass, "Confirm passcode entered");
				} else {
					androidLogs.CapturedLogs(fail, "Confirm passcode textbox not found");
				}
//TODO add a check for the text box shown...

				

		Thread.sleep(3000);
	
		if (ForgotPINorPasscodeNextButton3 != null && ForgotPINorPasscodeNextButton3.isEnabled()) {
			ForgotPINorPasscodeNextButton3.click();
			androidLogs.CapturedLogs(pass, "Next clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Next not found");
		}

		Thread.sleep(3000);
		WebElement ContinueToHomeButton = elements.ContinueToHomeButton();
		Thread.sleep(3000);
		if (ContinueToHomeButton != null && ContinueToHomeButton.isEnabled()) {
			ContinueToHomeButton.click();
			androidLogs.CapturedLogs(pass, "Continue to home clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Continue to home not found");
		}
		return this;
	}
}
