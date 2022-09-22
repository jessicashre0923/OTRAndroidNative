package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidCarrierClasses.TextBoxXpaths;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class HomeLandingPageTestAll {

	AppiumDriver<WebElement> driver;
	TextBoxXpaths appText = new TextBoxXpaths();
	AndroidLogs androidLogs = new AndroidLogs();
	RepoCardAndroid elements = new RepoCardAndroid();
	AppStringsAndroid androidText = new AppStringsAndroid();
	ScrollOptions scroll = new ScrollOptions();
	RegisterCheckAndroid registerCheck = new RegisterCheckAndroid();
	SecureFuel secureFuel = new SecureFuel();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;
	private String env;
	private String accountNumber;
	private String passwordOrPin;
	private String recuringCashAmmountCollected;
	private String oneTimeCashCollected;
	private String unitID;
	private String smartFundsBalanceCollected;
	
	public void HomeLandingPage(String environment, String accountNumber, String passwordOrPin) throws Exception {

		
		
			this.env = environment;
			this.accountNumber = accountNumber;
			this.passwordOrPin = passwordOrPin;
			//System.out.println("I am in Card Pass expected environment is:" + environment);
			homePage();
		}
		
	public void homePage() throws Exception {
		AndroidLogs AndroidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		RepoCardAndroid elements = new RepoCardAndroid();
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

System.out.println("**Please Wait or watch the html documents for updates**");
System.out.println("The Home screen test takes a while and seems like it is doing nothing as it checking to see if items exist or not");
//Help screen for home page				
		WebElement HelpScreenContinue = elements.HelpScreenContinue();
		Thread.sleep(3000);
		if (HelpScreenContinue != null && HelpScreenContinue.isEnabled()) {
			HelpScreenContinue.click();
			AndroidLogs.CapturedLogs(pass, "Help Screen continue Button is found and pressed.");
		} else {
			AndroidLogs.CapturedLogs(info, "Help Screen continue Button is not found");
		}
		

//Home card header expected seen (One sided cards Both Company and SmartFunds alone)
		androidLogs.setupTest("HOME LANDING PAGE");
		
		Thread.sleep(3000);
		AndroidLogs.CapturedLogs(info, "Checking for Home header");
		WebElement HomeHeader = elements.HomeHeader();
		Thread.sleep(3000);
		if (HomeHeader != null && HomeHeader.isEnabled()) {
			AndroidLogs.CapturedLogs(pass, "Home Header seen home page found");
			
//Look for recuring cash 			
			WebElement RecuringCashAmmount = elements.RecuringCashAmmount();
			Thread.sleep(3000);
			if (RecuringCashAmmount != null && RecuringCashAmmount.isEnabled()) {
//check for recurring cash 
				AndroidLogs.CapturedLogs(pass, "Recuring cash found");
				recuringCashAmmountCollected = elements.RecuringCashAmmount().getText();
				androidLogs.CapturedLogs(info, "Recuring Cash Ammount stored as: " + recuringCashAmmountCollected);
		
			}else {
				AndroidLogs.CapturedLogs(info, "Recuring cash not found");
			}

//Check for one time cash
			WebElement OneTimeCashAmmount = elements.OneTimeCashAmmount();
			Thread.sleep(3000);
			if (OneTimeCashAmmount != null && OneTimeCashAmmount.isEnabled()) {
				AndroidLogs.CapturedLogs(pass, "One time cash found");
				oneTimeCashCollected = elements.OneTimeCashAmmount().getText();
				androidLogs.CapturedLogs(info, "Recuring Cash Ammount stored as: " + oneTimeCashCollected);
				
				
			}else {
				AndroidLogs.CapturedLogs(info, "One time cash not found");
			}
		
			
//check for register check option  			
			Thread.sleep(3000);
			WebElement RegisterCheckIconButton = elements.RegisterCheckIconButton();
			Thread.sleep(3000);
			if (RegisterCheckIconButton != null && RegisterCheckIconButton.isDisplayed()) {
				androidLogs.CapturedLogs(pass, "Register check option seen");
			//	registerCheck.registerCheckAndroid(env, accountNumber,passwordOrPin);
			} else {
				androidLogs.CapturedLogs(info, "Register check icon button not found");
			}			

			
//check for securefuel check in			
			Thread.sleep(3000);
			WebElement FuelCheckInButton = elements.FuelCheckInButton();
			Thread.sleep(3000);
			if (FuelCheckInButton != null && FuelCheckInButton.isEnabled()) {
				androidLogs.CapturedLogs(pass, "Fuel check in option seen");
			} else {
				androidLogs.CapturedLogs(info, "Fuel check in button not found");
			}
//check for Dynamic pin 
			Thread.sleep(3000);
			WebElement DynamicPINButton = elements.DynamicPINButton();
			Thread.sleep(3000);
			if (DynamicPINButton != null && DynamicPINButton.isEnabled()) {
				androidLogs.CapturedLogs(pass, "Dynamic PIN button Seen");
			} else {
				androidLogs.CapturedLogs(info, "Dynamic PIN button button not found or unavailable in this card type");
			}
			
//check for Recent transactions 
			Thread.sleep(3000);
			WebElement RecentTransactions = elements.RecentTransactions();
			Thread.sleep(3000);
			if (RecentTransactions != null && RecentTransactions.isEnabled()) {
				AndroidLogs.CapturedLogs(pass, "Transactions Header seen home page found");
			} else {
				androidLogs.CapturedLogs(info, "Transactions Header not found");
			}
					
		} else {
			AndroidLogs.CapturedLogs(info, "Home Header not found");
		}

		
//Company header expected for Universal (Dual sided cards)
		androidLogs.setupTest("COMPANY LANDING PAGE");
		AndroidLogs.CapturedLogs(info, "Checking for Company header");
		Thread.sleep(3000);
		WebElement CompanyHeader = elements.CompanyHeader();
		Thread.sleep(3000);
		if (CompanyHeader != null && CompanyHeader.isEnabled()) {
			AndroidLogs.CapturedLogs(pass, "Company Header seen home page found");
			
//Look for recuring cash 			
			WebElement RecuringCashAmmount = elements.RecuringCashAmmount();
			Thread.sleep(3000);
			if (RecuringCashAmmount != null && RecuringCashAmmount.isEnabled()) {
				AndroidLogs.CapturedLogs(pass, "Recuring cash found");
				recuringCashAmmountCollected = elements.RecuringCashAmmount().getText();
				androidLogs.CapturedLogs(info, "Recuring Cash Ammount stored as: " + recuringCashAmmountCollected);
		
			}else {
				AndroidLogs.CapturedLogs(pass, "Recuring cash not found");
			}

//Check for one time cash
			WebElement OneTimeCashAmmount = elements.OneTimeCashAmmount();
			Thread.sleep(3000);
			if (OneTimeCashAmmount != null && OneTimeCashAmmount.isEnabled()) {
				AndroidLogs.CapturedLogs(pass, "One time cash found");
				oneTimeCashCollected = elements.OneTimeCashAmmount().getText();
				androidLogs.CapturedLogs(info, "Recuring Cash Ammount stored as: " + oneTimeCashCollected);
				
				
			}else {
				AndroidLogs.CapturedLogs(pass, "One time cash not found");
			}
		
			
//check for register check option  			
			Thread.sleep(3000);
			WebElement RegisterCheckIconButton = elements.RegisterCheckIconButton();
			Thread.sleep(3000);
			if (RegisterCheckIconButton != null && RegisterCheckIconButton.isDisplayed()) {
				androidLogs.CapturedLogs(pass, "Register check option seen");
			} else {
				androidLogs.CapturedLogs(info, "Register check icon button not found");
			}			

			
//check for securefuel check in			
			Thread.sleep(3000);
			WebElement FuelCheckInButton = elements.FuelCheckInButton();
			Thread.sleep(3000);
			if (FuelCheckInButton != null && FuelCheckInButton.isEnabled()) {
				androidLogs.CapturedLogs(pass, "Fuel check in option seen");
			} else {
				androidLogs.CapturedLogs(info, "Fuel check in button not found");
			}

//check for Dynamic pin 
			Thread.sleep(3000);
			WebElement DynamicPINButton = elements.DynamicPINButton();
			Thread.sleep(3000);
			if (DynamicPINButton != null && DynamicPINButton.isEnabled()) {
				androidLogs.CapturedLogs(pass, "Dynamic PIN button Seen");
			} else {
				androidLogs.CapturedLogs(info, "Dynamic PIN button button not found or unavailable in this card type");
			}		
			
			
			
//SmartFunds header expected for Universal (Dual sided cards)
			androidLogs.setupTest("SMARTFUNDS LANDING PAGE");
			Thread.sleep(3000);
			WebElement SmartFundsHeader = elements.SmartFundsHeader();
			if (SmartFundsHeader != null && SmartFundsHeader.isEnabled()) {
				SmartFundsHeader.click();
				AndroidLogs.CapturedLogs(pass, "SmartFunds Header seen");

//check for smartfunds balance
				WebElement SmartFundsBalance = elements.SmartFundsBalance();
				Thread.sleep(3000);
				if (SmartFundsBalance != null && SmartFundsBalance.isEnabled()) {
					AndroidLogs.CapturedLogs(pass, "One time cash found");
					smartFundsBalanceCollected = elements.SmartFundsBalance().getText();
					androidLogs.CapturedLogs(info, "Recuring Cash Ammount stored as: " + smartFundsBalanceCollected);
					
					
				}else {
					AndroidLogs.CapturedLogs(info, "One time cash not found");
				}			
			
//check for register check option  			
				Thread.sleep(3000);
				if (RegisterCheckIconButton != null && RegisterCheckIconButton.isDisplayed()) {
					androidLogs.CapturedLogs(pass, "Register check option seen");
					registerCheck.registerCheckAndroid(env, accountNumber,passwordOrPin);
										
				} else {
					androidLogs.CapturedLogs(info, "Register check icon button not found");
				}						
				
//check for Transfer funds
				Thread.sleep(3000);
				WebElement TransferFundsButton = elements.TransferFundsButton();
				if (TransferFundsButton != null && TransferFundsButton.isEnabled()) {
					androidLogs.CapturedLogs(pass, "Transfer funds button seen");
				} else {
					androidLogs.CapturedLogs(info, "Transfer funds button not found or unavailable in this card type");
				}		
				
//Check Dynamic Pin				
				Thread.sleep(3000);
					if (DynamicPINButton != null && DynamicPINButton.isEnabled()) {
						androidLogs.CapturedLogs(pass, "Dynamic PIN button seen");
				} else {
					androidLogs.CapturedLogs(info, "Dynamic PIN button button not found or unavailable in this card type");
				}			
				
				Thread.sleep(3000);
				CompanyHeader.click();
				AndroidLogs.CapturedLogs(pass, "Switched back to company side");
				Thread.sleep(3000);
			
		} else {
			AndroidLogs.CapturedLogs(info, "Company Header not found");
		}
		}
		
	
//Check that Home tab is seen
		Thread.sleep(3000);	
		WebElement HomeTab = elements.HomeTab();
		Thread.sleep(3000);
		if (HomeTab != null && HomeTab.isEnabled()) {
			androidLogs.CapturedLogs(pass, "Home tab seen");
		} else {
			androidLogs.CapturedLogs(fail, "Home tab is not found");
		}	
		
//Check that transaction tab is seen 
		Thread.sleep(3000);	
		WebElement TransactionsTab = elements.TransactionsTab();
		Thread.sleep(3000);
		if (TransactionsTab != null && TransactionsTab.isEnabled()) {
			androidLogs.CapturedLogs(pass, "Transactions tab seen");
		} else {
			androidLogs.CapturedLogs(fail, "Transactions tab is not found");
		}
		
		
//Check that FindFuel tab is seen 
		Thread.sleep(3000);	
		WebElement FindFuelTab = elements.FindFuelTab();
		Thread.sleep(3000);
		if (FindFuelTab != null && FindFuelTab.isEnabled()) {
			androidLogs.CapturedLogs(pass, "Find Fuel tab seen");
		} else {
			androidLogs.CapturedLogs(fail, "Find Fuel tab is not found");
		}	
		
	}
}

