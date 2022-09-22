package androidCarrierClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ConnectionHandler;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class AccountTransferToYourBankAddAccount {
	AndroidLogs androidLogs = new AndroidLogs();
	static AppiumDriver<WebElement> driver;
	RepoCarrierAndroid elements = new RepoCarrierAndroid();
	ScrollOptions scroll = new ScrollOptions();
	AccountTransferToYourBank transfer=new  AccountTransferToYourBank();
	AppStringsAndroid androidText = new AppStringsAndroid();
	public AccountTransferToYourBankAddAccount accountTransferToYourBankAddAccount(String env) throws Exception {
		androidLogs.setupTest("Tests for ACH Transfer");
		ConnectionHandler dbACPT = new ConnectionHandler(env);
		
		Thread.sleep(2000);
		WebElement AccountTab = elements.AccountTab();
		Thread.sleep(3000);
		if (AccountTab.isEnabled()) {
			AccountTab.click();
			androidLogs.CapturedLogs(androidText.PASS, "Account tab opened");
			
			dbACPT.execute("infx", "update ach_ppd_header set expire_date = '2021-01-28 13:38' where dfi_account_number = '1234569854'");
			androidLogs.CapturedLogs(androidText.INFO, "Bank account 1234569854 manually expired in database");
			
			Thread.sleep(2000);
			WebElement TransferToYourBank = elements.TransferToYourBank();
			Thread.sleep(3000);
			if (TransferToYourBank != null &&  TransferToYourBank.isEnabled()) {
				//open Transfer to your bank
				TransferToYourBank.click();
				androidLogs.CapturedLogs(androidText.PASS, "Transfer to your bank account opened");
				
				Thread.sleep(5000);
				WebElement TransferFromSelectContract = elements.TransferFromSelectContract();
				Thread.sleep(3000);
				if(TransferFromSelectContract.isEnabled()) {
					TransferFromSelectContract.click();
					androidLogs.CapturedLogs(androidText.PASS, "Select contract clicked.");
				}else {
					androidLogs.CapturedLogs(androidText.INFO, "Contract not found");
				}
				
				
				WebElement TransferNextButton = elements.TransferNextButton();
				Thread.sleep(3000);
				if(TransferNextButton!=null && TransferNextButton.isEnabled()) {
					TransferNextButton.click();
					androidLogs.CapturedLogs(androidText.PASS, "NEXT button clicked.");
				}else {
					androidLogs.CapturedLogs(androidText.FAIL, "Next button not found");
				}
				
				scroll.ScrollDown();
				scroll.ScrollDown();
				scroll.ScrollDown();
				scroll.ScrollDown();
				//scrolls depend on how many accounts are present
				
				//add new bank account
				Thread.sleep(3000);
				WebElement AddNewBankAccountButton = elements.AddNewBankAccountButton();
				Thread.sleep(3000);
				if(AddNewBankAccountButton!=null && AddNewBankAccountButton.isEnabled()) {
					AddNewBankAccountButton.click();
					androidLogs.CapturedLogs(androidText.PASS, "Add New Bank Account button clicked.");
				}else {
					androidLogs.CapturedLogs(androidText.FAIL, "Add new bank account button not found");
				}
				
				//enter routing number
				Thread.sleep(3000);
				WebElement RoutingNumberTextBox = elements.RoutingNumberTextBox();
				Thread.sleep(3000);
				if(RoutingNumberTextBox!=null && RoutingNumberTextBox.isEnabled()) {
					RoutingNumberTextBox.click();
					RoutingNumberTextBox.sendKeys("324377516");
					androidLogs.CapturedLogs(androidText.PASS, "routing number entered.");
				}else {
					androidLogs.CapturedLogs(androidText.FAIL, "Routing number textbox not found");
				}
				
				//enter account number
				Thread.sleep(2000);
				WebElement AccountNumberTextBox = elements.AccountNumberTextBox();
				Thread.sleep(3000);
				if(AccountNumberTextBox!=null && AccountNumberTextBox.isEnabled()) {
					AccountNumberTextBox.sendKeys("1234569854");
					//need to edit so account numbers can be different
					androidLogs.CapturedLogs(androidText.PASS, "Account number entered.");
				}else {
					androidLogs.CapturedLogs(androidText.FAIL, "Account number textbox not found");
				}
				
				//click on where do i find these and click X
				Thread.sleep(2000);
				WebElement WhereDoIFindTheseButton = elements.WhereDoIFindTheseButton();
				Thread.sleep(3000);
				if(WhereDoIFindTheseButton!=null && WhereDoIFindTheseButton.isEnabled()) {
					WhereDoIFindTheseButton.click();
					androidLogs.CapturedLogs(androidText.PASS, "Where Do I Find These Button clciked.");
					Thread.sleep(3000);
					elements.WhereDoIFindTheseCloseButton().click();
					androidLogs.CapturedLogs(androidText.PASS, "Where Do I Find These Close Button clciked.");
				}else {
					androidLogs.CapturedLogs(androidText.FAIL, "Where do I find these button not found");
				}
				
				//click Next
				Thread.sleep(2000);
				WebElement AddBankAccountNextButton = elements.AddBankAccountNextButton();
				Thread.sleep(3000);
				if(AddBankAccountNextButton!=null && AddBankAccountNextButton.isEnabled()) {
					AddBankAccountNextButton.click();
					androidLogs.CapturedLogs(androidText.PASS, "Next Button clicked.");
				}else {
					androidLogs.CapturedLogs(androidText.FAIL, "Next button not found");
				}
				Thread.sleep(3000);
				//Add bank name
				WebElement BankNameTextBox = elements.BankNameTextBox();
				Thread.sleep(3000);
				if(BankNameTextBox!=null && BankNameTextBox.isEnabled()) {
					BankNameTextBox.sendKeys("Android Automation bank");
					androidLogs.CapturedLogs(androidText.PASS, "Bank Name TextBox clicked and entered.");
				}else {
					androidLogs.CapturedLogs(androidText.FAIL, "Bank name textbox not found");
				}
				
				//add account owner
				WebElement AccountOwnerTextBox = elements.AccountOwnerTextBox();
				Thread.sleep(3000);
				if(AccountOwnerTextBox!=null && AccountOwnerTextBox.isEnabled()) {
					AccountOwnerTextBox.sendKeys("Android Automater");
					androidLogs.CapturedLogs(androidText.PASS, "Account Owner Text Box clicked and entered.");
				}else {
					androidLogs.CapturedLogs(androidText.FAIL, "Account owner textbox not found");
				}
				
				// select savings then checking
				WebElement SavingsButton = elements.SavingsButton();
				Thread.sleep(3000);
				if(SavingsButton!=null && SavingsButton.isEnabled()) {
					SavingsButton.click();
					androidLogs.CapturedLogs(androidText.PASS, "Savings Button clicked.");
				}else {
					androidLogs.CapturedLogs(androidText.INFO, "Savings button not found could be caused by phone dimensions");
				}
				
				Thread.sleep(3000);
				WebElement CheckingButton = elements.CheckingButton();
				Thread.sleep(3000);
				if(CheckingButton!=null && CheckingButton.isEnabled()) {
					CheckingButton.click();
					androidLogs.CapturedLogs(androidText.PASS, "Checking Button clicked.");
				}else {
					androidLogs.CapturedLogs(androidText.INFO, "Checking button not found could be caused by phone dimensions");
				}
				Thread.sleep(3000);
				//click next
				
				WebElement AddBankDetailsNextButton = elements.AddBankDetailsNextButton();
				Thread.sleep(3000);
				if(AddBankDetailsNextButton!=null && AddBankDetailsNextButton.isEnabled()) {
					androidLogs.CapturedLogs(androidText.INFO, "Checking button pre selected by default");

					AddBankDetailsNextButton.click();
					androidLogs.CapturedLogs(androidText.PASS, "NEXT Button clicked.");
				}else {
					androidLogs.CapturedLogs(androidText.FAIL, "Next button not found");
				}
				Thread.sleep(3000);
				//click ok
				WebElement NewBankAccountOKButton = elements.NewBankAccountOKButton();
				Thread.sleep(3000);
				if(NewBankAccountOKButton!=null && NewBankAccountOKButton.isEnabled()) {
					NewBankAccountOKButton.click();
					androidLogs.CapturedLogs(androidText.PASS, "OK Button clicked.");
				}else {
					androidLogs.CapturedLogs(androidText.FAIL, "OK Button not found");
				}
				
				
				dbACPT.execute("infx", "update ach_ppd_header set expire_date = '2021-01-28 13:38' where dfi_account_number = '1234569854'");
				androidLogs.CapturedLogs(androidText.INFO, "Bank account 1234569854 manually expired in database");
				
								
				//leaving transfer to bank section after deleting created bank account
				Thread.sleep(2000);
				elements.TransferToYourBankCloseButton().click();
				androidLogs.CapturedLogs(androidText.PASS, "Transfer to your bank close button clicked");
				
				Thread.sleep(3000);
				elements.TransferToYourBankCancelModalButton().click();
				androidLogs.CapturedLogs(androidText.PASS, "Transfer to your bank cancel modal button clicked");
				
				//Bank account added and expired from database.
				Thread.sleep(2000);
				WebElement TransferToYourBank2 = elements.TransferToYourBank();
				Thread.sleep(3000);
				if (TransferToYourBank2 != null &&  TransferToYourBank.isEnabled()) {
					//open Transfer to your bank
					TransferToYourBank2.click();
					androidLogs.CapturedLogs(androidText.PASS, "Transfer to your bank account opened");
					
					
					//make transfer and cancel the one just made
					Thread.sleep(3000);
					transfer.accountTransferToYourBank();
			
					//elements.TransferToYourBankBackButton().click();
					//logs.CapturedLogs("Test Pass", "Transfer to your bank back button clicked.");
				
				}
				else {
					androidLogs.CapturedLogs(androidText.FAIL, "Transfer to your bank not found.");
				}
				
			}
			else {
				androidLogs.CapturedLogs(androidText.FAIL, "Transfer to your bank not found.");
			}
			
		}
		else {
			androidLogs.CapturedLogs(androidText.FAIL, "Accounts tab not found");
		}
		return this;
	}

}
