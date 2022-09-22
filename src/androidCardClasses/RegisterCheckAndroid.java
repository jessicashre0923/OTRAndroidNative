package androidCardClasses;

import java.sql.ResultSet;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ConnectionHandler;
import io.appium.java_client.AppiumDriver;

public class RegisterCheckAndroid {

	private String env;
	private String cardNum;
	private String passwordOrPin;
	
	public void registerCheckAndroid(String environment ,String cardNumber, String passwordOrPin ) throws Exception {
		this.env = environment;
		this.cardNum = cardNumber;
		this.passwordOrPin = passwordOrPin;
		registerCheckAndroid();
	}

	static AppiumDriver<WebElement> driver;
	RepoCardAndroid elements=new RepoCardAndroid();
	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new  AppStringsAndroid();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;

	
	
	public RegisterCheckAndroid registerCheckAndroid() throws Exception {
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		androidLogs.setupTest("Register checks Test");
		Thread.sleep(3000);
		
		
	//	ResultSet profileIDDB = dbACPTCheck.query("infx",String.format("SELECT profile_id FROM ach_profile_card_xref WHERE card_num ='"+getAccount.getCardNum()+"'"));	

		
		System.out.println("Card num for query:" + this.cardNum);
		//Database interaction 	
				ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
				ResultSet balanceDBBefore = dbACPTCheck.query("infx",String.format("SELECT * FROM payr_cash_adv WHERE card_num ='"+cardNum+"'ORDER BY trans_id DESC limit 1"));	
				
				
				balanceDBBefore.next();
				String cashAdvID = balanceDBBefore.getString("cash_adv_id");
				String balanceBefore = balanceDBBefore.getString("balance");
				System.out.println(balanceBefore);
				int balanceBeforeInt;
				
				try {
				balanceBeforeInt = Integer.parseInt(balanceBefore);
				}
				catch (NumberFormatException e) {
					balanceBeforeInt = 0;
				}

				
		if (balanceBeforeInt < 200.00) {
			androidLogs.CapturedLogs(info, "Not enough balance to use register check");
			dbACPTCheck.execute("infx", "UPDATE payr_cash_adv SET balance = '200.00' WHERE cash_adv_id ="+cashAdvID);
			androidLogs.CapturedLogs(info, "Added $200.00 to account");
			} else {
				androidLogs.CapturedLogs(info, "More than $200.00 found to use register check");
			}
				
		//SQL query to delete used check number
		androidLogs.CapturedLogs(info, "Connecting to databse");
		ConnectionHandler dbACPT = new ConnectionHandler(env);
		dbACPT.execute("infx", "delete from checks where check_num ='1246917168'");
		androidLogs.CapturedLogs(info, "Used check number deleted");
		
			
		
		Thread.sleep(3000);
		WebElement RegisterCheckIconButton = elements.RegisterCheckIconButton();
		Thread.sleep(3000);
		if (RegisterCheckIconButton != null && RegisterCheckIconButton.isDisplayed()) {
			RegisterCheckIconButton.click();
			androidLogs.CapturedLogs(pass, "Register check icon button clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Register check icon button not found");
		}
		
		Thread.sleep(3000);
		WebElement AmountTextBoxRegisterCheck = elements.AmountTextBoxRegisterCheck();
		Thread.sleep(3000);
		if (AmountTextBoxRegisterCheck != null && AmountTextBoxRegisterCheck.isDisplayed()) {
			AmountTextBoxRegisterCheck.sendKeys(androidText.REGISTER_CHECK_AMOUNT);
			androidLogs.CapturedLogs(pass, "Register check amount entered");
		} else {
			androidLogs.CapturedLogs(fail, "Register check amount textbox not found");
		}
		
		Thread.sleep(3000);
		WebElement NextButtonRegisterCheck = elements.NextButtonRegisterCheck();
		Thread.sleep(3000);
		if (NextButtonRegisterCheck != null && NextButtonRegisterCheck.isEnabled()) {
			NextButtonRegisterCheck.click();
			androidLogs.CapturedLogs(pass, "Next button clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Next button amount screen not found");
		}
		
		Thread.sleep(4000);
		WebElement CheckNumberTextBox = elements.CheckNumberTextBox();
		Thread.sleep(3000);
		if (CheckNumberTextBox != null && CheckNumberTextBox.isEnabled()) {
			CheckNumberTextBox.sendKeys(androidText.REGISTER_CHECK_NUMBER);
			androidLogs.CapturedLogs(pass, "Check number entered");
		} else {
			androidLogs.CapturedLogs(fail, "Check number textbox not found");
		}
		
		Thread.sleep(4000);
		WebElement NextButtonRegisterCheck2 = elements.NextButtonRegisterCheck();
		Thread.sleep(3000);
		if (NextButtonRegisterCheck2 != null && NextButtonRegisterCheck2.isEnabled()) {
			NextButtonRegisterCheck2.click();
			androidLogs.CapturedLogs(pass, "Next button clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Next button check number screen not found");
		}
		
		Thread.sleep(5000);
		WebElement SubmitButtonRegisterCheck = elements.SubmitButtonRegisterCheck();
		Thread.sleep(3000);
		if (SubmitButtonRegisterCheck != null && SubmitButtonRegisterCheck.isEnabled()) {
			SubmitButtonRegisterCheck.click();
			Thread.sleep(3000);
			androidLogs.CapturedLogs(pass, "Submit button clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Submit button not found");
		}
		
		Thread.sleep(5000);
		WebElement DismissButtonRegisterCheck = elements.DismissButtonRegisterCheck();
		Thread.sleep(3000);
		if (DismissButtonRegisterCheck != null && DismissButtonRegisterCheck.isEnabled()) {
			DismissButtonRegisterCheck.click();
			androidLogs.CapturedLogs(pass, "Dismiss button clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Dismiss button not found");
		}
		
		Thread.sleep(3000);
		WebElement CancelButtonRegisterCheck = elements.CancelButtonRegisterCheck();
		Thread.sleep(3000);
		if (CancelButtonRegisterCheck != null && CancelButtonRegisterCheck.isEnabled()) {
			CancelButtonRegisterCheck.click();
			androidLogs.CapturedLogs(pass, "Cancel button clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Cancel button not found");
		}
		
		Thread.sleep(3000);
		WebElement DismissButtonRegisterCheck2 = elements.DismissButtonRegisterCheck();
		Thread.sleep(3000);
		if (DismissButtonRegisterCheck2 != null && DismissButtonRegisterCheck2.isEnabled()) {
			DismissButtonRegisterCheck2.click();
			androidLogs.CapturedLogs(pass, "Dismiss button clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Dismiss button not found");
		}
		
		Thread.sleep(3000);
		WebElement DismissCodeButtonRegisterCheck = elements.DismissCodeButtonRegisterCheck();
		Thread.sleep(3000);
		if (DismissCodeButtonRegisterCheck != null && DismissCodeButtonRegisterCheck.isEnabled()) {
			DismissCodeButtonRegisterCheck.click();
			androidLogs.CapturedLogs(pass, "Dismiss code button clicked");
		} else {
			androidLogs.CapturedLogs(fail, "Dismiss code button not found");
		}
		
		
		dbACPT.execute("infx", "delete from checks where check_num ='1248174135'");
		androidLogs.CapturedLogs(info, "Used check number deleted");
		
		
		//Database interaction 	
		androidLogs.CapturedLogs(info, "Checking for transID");
		ResultSet trasnIDDB = dbACPTCheck.query("infx",String.format("SELECT trans_id FROM payr_cash_adv WHERE card_num ='"+cardNum+"' ORDER BY trans_id DESC limit 1"));	
		trasnIDDB.next();
		String transID = trasnIDDB.getString("trans_id");
		androidLogs.CapturedLogs(info, String.format("Trans ID is found as: " + transID));
		ResultSet balanceDB = dbACPTCheck.query("infx",String.format("SELECT balance FROM payr_cash_adv WHERE card_num ='"+cardNum+"' ORDER BY trans_id DESC limit 1"));	
		balanceDB.next();
		String balance = balanceDB.getString("balance");
		dbACPTCheck.execute("infx", "UPDATE payr_cash_adv SET balance ="+balanceBefore+"WHERE trans_id ="+transID);
		ResultSet balanceDBReset = dbACPTCheck.query("infx",String.format("SELECT balance FROM payr_cash_adv WHERE card_num ='"+cardNum+"' ORDER BY trans_id DESC limit 1"));	
		balanceDBReset.next();
		String resetBalance = balanceDBBefore.getString("balance");
		androidLogs.CapturedLogs(info, String.format("Balance before transaction is: $" + balanceBefore));
		androidLogs.CapturedLogs(info, String.format("Register Check amount: $" + androidText.REGISTER_CHECK_AMOUNT));
		androidLogs.CapturedLogs(info, String.format("Balance after transaction is: $" + balance));
		androidLogs.CapturedLogs(info, String.format("Reset balance to: $" + resetBalance));
		

//TODO add spinner check so we can open line item after creation		
//		Thread.sleep(3000);
//		WebElement OpenNewRegisterCheck = elements.OpenNewRegisterCheck();
//		if (OpenNewRegisterCheck != null && OpenNewRegisterCheck.isEnabled()) {
//			OpenNewRegisterCheck.click();
//			androidLogs.CapturedLogs(pass, "New regoister check line clicked to open it");
//		} else {
//			androidLogs.CapturedLogs(fail, "New regoister check line not found");
//		}
//		
//		Thread.sleep(3000);
//		WebElement CloseNewRegisterCheckPage = elements.CloseNewRegisterCheckPage();
//		if (CloseNewRegisterCheckPage != null && CloseNewRegisterCheckPage.isEnabled()) {
//			CloseNewRegisterCheckPage.click();
//			androidLogs.CapturedLogs(pass, "Close button clicked");
//		} else {
//			androidLogs.CapturedLogs(fail, "Close button not found");
//		}
		
		
		return this;
	}
}
