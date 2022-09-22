package androidCarrierClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ScrollOptions;
import io.appium.java_client.AppiumDriver;

public class CardsOverviewSmartfunds {
	AndroidLogs androidLogs = new AndroidLogs();
	RepoCarrierAndroid elements=new RepoCarrierAndroid();
	ScrollOptions scroll=new ScrollOptions();
	static AppiumDriver<WebElement> driver;
	DesiredCapabilities cap = new DesiredCapabilities();
	AppStringsAndroid androidText = new AppStringsAndroid();
	public CardsOverviewSmartfunds CardsOverviewSubuser() throws Exception {
		androidLogs.setupTest("Tests for Card Overiew");
		Thread.sleep(3000);
		WebElement CardsTab = elements.CardsTab();
		if (CardsTab.isEnabled()) {
			CardsTab.click();
			androidLogs.CapturedLogs(androidText.PASS, "Cards Tab is opened.");
			// card:
			
			Thread.sleep(2000);
			WebElement CardSelection2 = elements.CardSelection();
			if(CardSelection2!=null && CardSelection2.isEnabled()) {
				CardSelection2.click();
				androidLogs.CapturedLogs(androidText.PASS, "Cards search Tab is opened.");
				WebElement SearchIcon2 = elements.SearchIcon();
				if(SearchIcon2!=null && SearchIcon2.isEnabled()) {
					SearchIcon2.click();
					}
				
				else if(elements.ClearSearchBoxIcon()!=null && elements.ClearSearchBoxIcon().isEnabled()) {
					elements.ClearSearchBoxIcon().click();
				}
				
				

			// card search:
				Thread.sleep(2000);
				WebElement CardSearch = elements.CardSearch();
			if (CardSearch.isDisplayed()) {
				CardSearch.sendKeys("5542");
				
				Actions actionReturn = new Actions(Capabilities.driver);
				actionReturn.sendKeys(Keys.RETURN).build().perform();
				androidLogs.CapturedLogs(androidText.PASS, "Card Number entered.");
				Thread.sleep(1000);
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Card Number text box was not found");
			}
			Thread.sleep(2000);
			WebElement CardSearchResultCell = elements.CardSearchResultCell();
			if (CardSearchResultCell.isDisplayed()) {
				androidLogs.CapturedLogs(androidText.PASS, "Card search result found.");
				CardSearchResultCell.click();

				Thread.sleep(5000);
				// Code directed to Smartfunds card on 5542 John wayne
				WebElement SmartfundsCardImage = elements.SmartfundsCardImage();
				if (SmartfundsCardImage != null && SmartfundsCardImage.isEnabled()) {
					Thread.sleep(3000);
					androidLogs.CapturedLogs(androidText.PASS, "Smartfunds tab opened");
					// load cash
					WebElement LoadCashButton = elements.LoadCashButton();
					if (LoadCashButton != null && LoadCashButton.isEnabled()) {
						LoadCashButton.click();
						androidLogs.CapturedLogs(androidText.PASS, "Load cash button selected");
						elements.LoadCashAmountTextBox().sendKeys("1.99");
						androidLogs.CapturedLogs(androidText.PASS, "load cash amount entered");
						elements.LoadCashNextButton().click();
						elements.LoadCashAmountButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "load cash completed");
					} else {
						androidLogs.CapturedLogs(androidText.INFO, "Load cash button not found");
					}

					// remove cash
					Thread.sleep(3000);
					Thread.sleep(3000);
					WebElement RemoveCashButton = elements.RemoveCashButton();
					if (RemoveCashButton != null && RemoveCashButton.isEnabled()) {
						RemoveCashButton.click();
						androidLogs.CapturedLogs(androidText.PASS, "Remove cash button selected");
						elements.RemoveCashAmountTextBox().sendKeys("1.99");
						androidLogs.CapturedLogs(androidText.PASS, "Remove cash amount entered");
						Thread.sleep(3000);
						elements.RemoveCashNextButton().click();
						Thread.sleep(5000);
						elements.RemoveCashAmountButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "Remove cash completed");
					} else {
						androidLogs.CapturedLogs(androidText.INFO, "Remove cash button not found");
					}

					// Card information
					Thread.sleep(2000);
					WebElement CardInformationButton = elements.CardInformationButton();
					if (CardInformationButton != null && CardInformationButton.isEnabled()) {
						CardInformationButton.click();
						androidLogs.CapturedLogs(androidText.PASS, "Card information selected");
						Thread.sleep(3000);
						elements.CardInformationBackButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "Card information back button selected");
					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "Card information button not found");
					}

					// Change status
					Thread.sleep(2000);
					WebElement ChangeStatusButton = elements.ChangeStatusButton();
					if (ChangeStatusButton != null && ChangeStatusButton.isEnabled()) {
						Thread.sleep(3000);
						ChangeStatusButton.click();
						androidLogs.CapturedLogs(androidText.PASS, "Change status button selected");
						Thread.sleep(3000);
						elements.HoldStatus().click();
						elements.StatusChangeSaveButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "Status set to Hold");
						Thread.sleep(3000);
						elements.ChangeStatusButton().click();
						Thread.sleep(3000);
						elements.InactiveStatus().click();
						elements.StatusChangeSaveButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "Status set to Inactive");
						Thread.sleep(3000);
						elements.ChangeStatusButton().click();
						Thread.sleep(3000);
						elements.ActiveStatus().click();
						elements.StatusChangeSaveButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "Status set to Active");
					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "Change status button not found");
					}

					Thread.sleep(2000);
					scroll.ScrollDown();
					Thread.sleep(2000);
					WebElement ActivityViewAllTop = elements.ActivityViewAllTop();
					if (ActivityViewAllTop != null && ActivityViewAllTop.isEnabled()) {
						ActivityViewAllTop.click();
						androidLogs.CapturedLogs(androidText.PASS, "View all top button clicked");
//						scroll.ScrollDown();
//						scroll.ScrollUp();
//						elements.TransactionActivityCell().click();
//						Thread.sleep(2000);
//						elements.TransactionActivityCellBackButton().click();
//						Thread.sleep(2000);
						elements.TransactionActivityViewAllBackButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "Transaction view all back button clicked");

					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "View all top button not found");
					}

					scroll.ScrollDown();
					scroll.ScrollDown();
					scroll.ScrollDown();
					scroll.ScrollDown();
					
					Thread.sleep(2000);
					WebElement ActivityViewAllBottom = elements.ActivityViewAllBottom();
					if (ActivityViewAllBottom != null && ActivityViewAllBottom.isEnabled()) {
						ActivityViewAllBottom.click();
						androidLogs.CapturedLogs(androidText.PASS, "View all bottom button clicked");
						Thread.sleep(3000);
						elements.TransactionActivityViewAllBackButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "View all back button clicked");
					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "View all bottom button not found");
					}
					Thread.sleep(3000);
					Capabilities.driver.navigate().back();
					
				} else {
					androidLogs.CapturedLogs(androidText.FAIL, "Smarfunds tab not found");
				}
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Card search result was not found");
			}}
		
		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Cards Tab was not found.");
		}

		return this;

	}
}
