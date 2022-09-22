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

public class CardsOverviewCompany {
	AndroidLogs androidLogs = new AndroidLogs();
	RepoCarrierAndroid elements=new RepoCarrierAndroid();
	ScrollOptions scroll=new ScrollOptions();
	static AppiumDriver<WebElement> driver;
	DesiredCapabilities cap = new DesiredCapabilities();
	AppStringsAndroid androidText = new AppStringsAndroid();
	public CardsOverviewCompany CardsOverview() throws Exception {
		androidLogs.setupTest("Tests for Company Card overview");
		
		Thread.sleep(3000);
		WebElement CardsTab = elements.CardsTab();
		Thread.sleep(3000);
		if (CardsTab.isEnabled()) {
			CardsTab.click();
			androidLogs.CapturedLogs(androidText.PASS, "Cards Tab is opened.");

			// card:
			Thread.sleep(3000);
			WebElement CardSelection2 = elements.CardSelection();
			Thread.sleep(3000);
			if(CardSelection2!=null && CardSelection2.isEnabled()) {
				CardSelection2.click();
				androidLogs.CapturedLogs(androidText.PASS, "Cards search Tab is opened.");
				Thread.sleep(3000);
				WebElement SearchIcon2 = elements.SearchIcon();
				if(SearchIcon2!=null && SearchIcon2.isEnabled()) {
					SearchIcon2.click();
					}
				
				else if(elements.ClearSearchBoxIcon()!=null && elements.ClearSearchBoxIcon().isEnabled()) {
					elements.ClearSearchBoxIcon().click();
				}
				
			// card search:
				Thread.sleep(3000);
				WebElement CardSearch = elements.CardSearch();
				Thread.sleep(3000);
			if (CardSearch.isDisplayed()) {
				CardSearch.sendKeys("0010");
				Thread.sleep(3000);
				Actions actionReturn = new Actions(Capabilities.driver);
				actionReturn.sendKeys(Keys.RETURN).build().perform();
				androidLogs.CapturedLogs(androidText.PASS, "Card Number entered.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Card Number text box was not found");
			}
			
			Thread.sleep(3000);
			WebElement CardSearchResultCell = elements.CardSearchResultCell();
			Thread.sleep(3000);
			if (CardSearchResultCell.isDisplayed()) {
				androidLogs.CapturedLogs(androidText.PASS, "Card search result found.");
				CardSearchResultCell.click();

				Thread.sleep(5000);
				WebElement CompanyCardImage = elements.CompanyCardImage();
				Thread.sleep(3000);
				if (CompanyCardImage != null && CompanyCardImage.isEnabled()) {
					androidLogs.CapturedLogs(androidText.PASS, "Company tab selected");
					// load cash
					Thread.sleep(3000);
					WebElement LoadCashButton = elements.LoadCashButton();
					Thread.sleep(3000);
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
					Thread.sleep(3000);
					// remove cash
					WebElement RemoveCashButton = elements.RemoveCashButton();
					Thread.sleep(3000);
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
				
					// network override and disable
					Thread.sleep(3000);
					WebElement NetworkOverridesButton = elements.NetworkOverridesButton();
					Thread.sleep(3000);
					if (NetworkOverridesButton != null && NetworkOverridesButton.isEnabled()) {
						NetworkOverridesButton.click();
						androidLogs.CapturedLogs(androidText.PASS, "Netowrk override button selected");
						elements.NetworkOverridePlusButton().click();
						elements.EnableNetworkOverrideButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "Network override enabled");
						Thread.sleep(3000);
						elements.NetworkOverridesButton().click();
						Thread.sleep(3000);
						elements.DisableNetworkOverrideModalButton().click();
						Thread.sleep(3000);
						androidLogs.CapturedLogs(androidText.PASS, "Network override disabled");
						
					} else {
						androidLogs.CapturedLogs(androidText.INFO, "Network overrides button not found");
					}

					// Card information
					Thread.sleep(3000);
					WebElement CardInformationButton = elements.CardInformationButton();
					Thread.sleep(3000);
					if (CardInformationButton != null && CardInformationButton.isEnabled()) {
						CardInformationButton.click();
						androidLogs.CapturedLogs(androidText.PASS, "Card information selected");
						elements.OverrideMileageButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "Override mileage button selected");
						elements.OverrideMileageNextButton().click();
						Thread.sleep(3000);
						elements.MileageTextBox().sendKeys("100");
						androidLogs.CapturedLogs(androidText.PASS, "Mileage textbox entered");
						Thread.sleep(3000);
						elements.MileageSaveButton().click();
					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "Card information button not found");
					}

					Thread.sleep(3000);
					//Card information to override Hubometer
					Thread.sleep(3000);
					WebElement CardInformationButton2 = elements.CardInformationButton();
					Thread.sleep(3000);
					if (CardInformationButton2 != null && CardInformationButton2.isEnabled()) {
						CardInformationButton2.click();
						androidLogs.CapturedLogs(androidText.PASS, "Card information selected");
						elements.OverrideMileageButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "Override mileage button selected");
						elements.HubometerRadioButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "Hubometer button selected");
						elements.OverrideMileageNextButton().click();
						Thread.sleep(3000);
						elements.MileageTextBox().sendKeys("100");
						androidLogs.CapturedLogs(androidText.PASS, "Hubometer text box entered");
						Thread.sleep(3000);
						elements.MileageSaveButton().click();
					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "Card information button not found");
					}
					
					// Change status
					Thread.sleep(3000);
					WebElement ChangeStatusButton = elements.ChangeStatusButton();
					Thread.sleep(3000);
					if (ChangeStatusButton != null && ChangeStatusButton.isEnabled()) {
						Thread.sleep(3000);
						ChangeStatusButton.click();
						androidLogs.CapturedLogs(androidText.PASS, "Change status button selected");
						Thread.sleep(3000);
						elements.HoldStatus().click();
						Thread.sleep(3000);
						elements.StatusChangeSaveButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "Status set to Hold");
						Thread.sleep(3000);

//TODO REMOVED BECAUSE IT REALLY MESSES WITH THE CARD..			
//						elements.ChangeStatusButton().click();
//						Thread.sleep(3000);
//						
//						Thread.sleep(3000);
//						elements.InactiveStatus().click();
//						elements.StatusChangeSaveButton().click();
//						androidLogs.CapturedLogs(androidText.PASS, "Status set to Inactive");
					
						Thread.sleep(3000);
						WebElement ChangeStatusButtonActive = elements.ChangeStatusButton();
						Thread.sleep(3000);
			
						if (ChangeStatusButtonActive != null && ChangeStatusButtonActive.isEnabled()) {						
						Thread.sleep(3000);
						ChangeStatusButtonActive.click();
						Thread.sleep(3000);
						elements.ActiveStatus().click();
						Thread.sleep(3000);
						elements.StatusChangeSaveButton().click();
						}else {
						androidLogs.CapturedLogs(androidText.FAIL, "Change status Active button not found");	
						}
						elements.StatusChangeSaveButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "Status set to Active");
					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "Change status button not found");
					}

					// Activity
					Thread.sleep(3000);
					scroll.ScrollDown();
					Thread.sleep(3000);
					
					Thread.sleep(3000);
					WebElement ActivityViewAllTop = elements.ActivityViewAllTop();
					Thread.sleep(3000);
					if (ActivityViewAllTop != null && ActivityViewAllTop.isEnabled()) {
						ActivityViewAllTop.click();
						androidLogs.CapturedLogs(androidText.PASS, "View all top button clicked");
//						scroll.ScrollDown();
//						scroll.ScrollUp();
//						elements.TransactionActivityCell().click();
//						Thread.sleep(3000);
//						elements.TransactionActivityCellBackButton().click();
//						Thread.sleep(3000);
					elements.TransactionActivityViewAllBackButton().click();
					androidLogs.CapturedLogs(androidText.PASS, "Transaction view all back button clicked");

					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "View all top button not found");
					}

					scroll.ScrollDown();
					scroll.ScrollDown();
					scroll.ScrollDown();
					scroll.ScrollDown();
					
					Thread.sleep(3000);
					WebElement ActivityViewAllBottom = elements.ActivityViewAllBottom();
					Thread.sleep(3000);
					if (ActivityViewAllBottom != null && ActivityViewAllBottom.isEnabled()) {
						ActivityViewAllBottom.click();
						androidLogs.CapturedLogs(androidText.PASS, "View all bottom button clicked");
						Thread.sleep(3000);
						elements.TransactionActivityViewAllBackButton().click();
						androidLogs.CapturedLogs(androidText.PASS, "View all back button clicked");
					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "View all bottom button not found");
					}

				} else {
					androidLogs.CapturedLogs(androidText.FAIL, "Company tab not found");
				}

				
					Capabilities.driver.navigate().back();

			

			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Card search result was not found");
			}}
		

		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Cards Tab was not opened.");
		}

		return this;

	}
}
