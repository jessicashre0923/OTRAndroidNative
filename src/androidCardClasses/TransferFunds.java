package androidCardClasses;

import java.sql.ResultSet;

import org.openqa.selenium.WebElement;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ConnectionHandler;
import io.appium.java_client.AppiumDriver;
import java.sql.ResultSet;


public class TransferFunds {
	
	private String env;
	private String cardNum;
	private String passwordOrPin;
	
		public void TransferFunds(String environment, String cardNumber, String passwordOrPin) throws Exception {
			this.env = environment;
			this.cardNum = cardNumber;
			this.passwordOrPin = passwordOrPin;
			TransferFunds();
		}
	
	static AppiumDriver<WebElement> driver;
	RepoCardAndroid elements=new RepoCardAndroid();
	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new  AppStringsAndroid();
	OneTimeTransferFunds OneTimeTransferFunds= new OneTimeTransferFunds();
	RepeatDailyTransferFunds RepeatDailyTransferFunds=new RepeatDailyTransferFunds();
	RepeatWeeklyTransferFunds RepeatWeeklyTransferFunds =new RepeatWeeklyTransferFunds();
	RepeatMonthlyTransferFunds RepeatMonthlyTransferFunds=new RepeatMonthlyTransferFunds();
	RepeatOnceNewSFLoadedTransferFunds RepeatOnceNewSFLoadedTransferFunds=new RepeatOnceNewSFLoadedTransferFunds();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	
	public TransferFunds TransferFunds() throws Exception {;
	//androidText = new AppStringsAndroid(env);	
	androidLogs.setupTestYellow("TRANSFER FUNDS");
		
//Help screen for home page
			Thread.sleep(3000);
			WebElement HelpScreenContinue = elements.HelpScreenContinue();
			Thread.sleep(3000);
			if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
				HelpScreenContinue.click();
				androidLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
			} else {
				androidLogs.CapturedLogs(info, "Help Screen continue Button is not found");
			}
	
//Database interaction 
			System.out.println("Card Found: " + this.cardNum);
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);
		                                                                                                                   
		ResultSet balanceDBBefore = dbACPTCheck.query("infx",String.format("SELECT balance FROM payr_cash_adv WHERE card_num ='"+this.cardNum+"' ORDER BY trans_id DESC limit 1"));	
		balanceDBBefore.next();
		String balanceBefore = balanceDBBefore.getString("balance");
		
		
//Run one time transfer funds
		androidLogs.setupTestYellow("ON TIME TRANSFER FUNDS");
		OneTimeTransferFunds.OneTimeTransferFunds();
		
		//Database interaction 	
		androidLogs.CapturedLogs(info, "Checking for transID");
		
		ResultSet trasnIDDB = dbACPTCheck.query("infx",String.format("SELECT trans_id FROM payr_cash_adv WHERE card_num ='"+this.cardNum+"' ORDER BY trans_id DESC limit 1"));	
		trasnIDDB.next();
		String transID = trasnIDDB.getString("trans_id");
		androidLogs.CapturedLogs(info, String.format("Trans ID is found as: " + transID));
		ResultSet balanceDB = dbACPTCheck.query("infx",String.format("SELECT balance FROM payr_cash_adv WHERE card_num ='"+this.cardNum+"' ORDER BY trans_id DESC limit 1"));	
		balanceDB.next();
		String balance = balanceDB.getString("balance");
		dbACPTCheck.execute("infx", "UPDATE payr_cash_adv SET balance ="+balanceBefore+"WHERE trans_id ="+transID);
		ResultSet balanceDBReset = dbACPTCheck.query("infx",String.format("SELECT balance FROM payr_cash_adv WHERE card_num ='"+this.cardNum+"' ORDER BY trans_id DESC limit 1"));	
		balanceDBReset.next();
		String resetBalance = balanceDBBefore.getString("balance");
		androidLogs.CapturedLogs(info, String.format("Balance before transaction is: $" + balanceBefore));
		androidLogs.CapturedLogs(info, String.format("One time transfer funds amount: $" + androidText.TRANSFER_FUNDS_AMOUNT));
		androidLogs.CapturedLogs(info, String.format("Balance after transaction is: $" + balance));
		androidLogs.CapturedLogs(info, String.format("Reset balance to: $" + resetBalance));
		
	
		androidLogs.setupTestYellow("REPEAT DAILY TRANSFER FUNDS");
		RepeatDailyTransferFunds.RepeatDailyTransferFunds();
		
		androidLogs.setupTestYellow("REPEAT WEEKLY TRANSFER FUNDS");
		RepeatWeeklyTransferFunds.RepeatWeeklyTransferFunds();
		
		androidLogs.setupTestYellow("REPEAT MONTHLY TRANSFER FUNDS");
		RepeatMonthlyTransferFunds.RepeatMonthlyTransferFunds();
		
		androidLogs.setupTestYellow("REPEAT PER NEW FUNDS TRANSFER FUNDS");
		RepeatOnceNewSFLoadedTransferFunds.RepeatOnceNewSFLoadedTransferFunds();
		
		return this;
	}
}
