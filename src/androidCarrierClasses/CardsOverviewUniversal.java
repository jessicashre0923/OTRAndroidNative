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

public class CardsOverviewUniversal {
	AndroidLogs androidLogs = new AndroidLogs();
	RepoCarrierAndroid elements = new RepoCarrierAndroid();
	ScrollOptions scroll = new ScrollOptions();
	static AppiumDriver<WebElement> driver;
	DesiredCapabilities cap = new DesiredCapabilities();
	AppStringsAndroid androidText = new AppStringsAndroid();

	public CardsOverviewUniversal CardsOverview() throws Exception {

		androidLogs.setupTest("Cards overview on universal card");
		
		Thread.sleep(4000);
		WebElement CardsTab = elements.CardsTab();
		if (CardsTab.isEnabled()) {
			CardsTab.click();
			androidLogs.CapturedLogs(androidText.PASS, "Cards Tab is opened.");

			// card:
			Thread.sleep(2000);
			WebElement CardSelection2 = elements.CardSelection();
			WebElement ClearSearchBoxIcon = elements.ClearSearchBoxIcon();
			if (CardSelection2 != null && CardSelection2.isEnabled()) {
				CardSelection2.click();
				androidLogs.CapturedLogs(androidText.PASS, "Cards search Tab is opened.");
				Thread.sleep(2000);
				WebElement SearchIcon2 = elements.SearchIcon();
				if (SearchIcon2 != null && SearchIcon2.isEnabled()) {
					SearchIcon2.click();
					
				}
				
				else if (ClearSearchBoxIcon != null && ClearSearchBoxIcon.isEnabled()) {
					ClearSearchBoxIcon.click();
					androidLogs.CapturedLogs(androidText.PASS, "Clear search box icon clicked");
				}else {
					androidLogs.CapturedLogs(androidText.FAIL, "Clear search box or search icon not found");
				}

				// card search:
				Thread.sleep(2000);
				WebElement CardSearch = elements.CardSearch();
				if (CardSearch.isDisplayed()) {
					CardSearch.sendKeys("0470");

					Actions actionReturn = new Actions(Capabilities.driver);
					actionReturn.sendKeys(Keys.RETURN).build().perform();
					androidLogs.CapturedLogs(androidText.PASS, "Card Number entered.");
				} else {
					androidLogs.CapturedLogs(androidText.FAIL, "Card Number text box was not found");
				}
				
				Thread.sleep(3000);
				WebElement CardSearchResultCell = elements.CardSearchResultCell();
				if (CardSearchResultCell.isDisplayed()) {
					androidLogs.CapturedLogs(androidText.PASS, "Card search result found.");
					CardSearchResultCell.click();

					Thread.sleep(5000);
					// Code directed to Universal card tab on 100045
					Thread.sleep(2000);
					WebElement CompanyTab = elements.CompanyTab();
					if (CompanyTab != null && CompanyTab.isEnabled()) {
						CompanyTab.click();
						androidLogs.CapturedLogs(androidText.PASS, "Company tab selected");

						// load cash
						Thread.sleep(2000);
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

						// network override and disable
						Thread.sleep(2000);
						WebElement NetworkOverridesButton = elements.NetworkOverridesButton();
						if (NetworkOverridesButton != null && NetworkOverridesButton.isEnabled()) {
							NetworkOverridesButton.click();
							androidLogs.CapturedLogs(androidText.PASS, "Netowrk override button selected");
							elements.NetworkOverridePlusButton().click();
							elements.EnableNetworkOverrideButton().click();
							androidLogs.CapturedLogs(androidText.PASS, "Network override enabled");
							Thread.sleep(3000);
							elements.NetworkOverridesButton().click();
							elements.DisableNetworkOverrideModalButton().click();
							androidLogs.CapturedLogs(androidText.PASS, "Network override disabled");
							
						} else {
							androidLogs.CapturedLogs(androidText.INFO, "Network overrides button not found");
						}

						// Card information
						Thread.sleep(2000);
						WebElement CardInformationButton = elements.CardInformationButton();
						if (CardInformationButton != null && CardInformationButton.isEnabled()) {
							CardInformationButton.click();
							androidLogs.CapturedLogs(androidText.PASS, "Card information selected");
							elements.OverrideMileageButton().click();
							androidLogs.CapturedLogs(androidText.PASS, "Override mileage button selected");
							elements.OverrideMileageNextButton().click();
							elements.MileageTextBox().sendKeys("100");
							androidLogs.CapturedLogs(androidText.PASS, "Mileage textbox entered");
							elements.MileageSaveButton().click();
						} else {
							androidLogs.CapturedLogs(androidText.FAIL, "Card information button not found");
						}
						Thread.sleep(3000);
						// Card information to override Hubometer
						Thread.sleep(2000);
						WebElement CardInformationButton2 = elements.CardInformationButton();
						if (CardInformationButton2 != null && CardInformationButton2.isEnabled()) {
							CardInformationButton2.click();
							androidLogs.CapturedLogs(androidText.PASS, "Card information selected");
							elements.OverrideMileageButton().click();
							androidLogs.CapturedLogs(androidText.PASS, "Override mileage button selected");
							elements.HubometerRadioButton().click();
							androidLogs.CapturedLogs(androidText.PASS, "Hubometer button selected");
							elements.OverrideMileageNextButton().click();
							elements.MileageTextBox().sendKeys("100");
							androidLogs.CapturedLogs(androidText.PASS, "Hubometer text box entered");
							elements.MileageSaveButton().click();
						} else {
							androidLogs.CapturedLogs(androidText.FAIL, "Card information button not found");
						}
						Thread.sleep(3000);
						// Change status
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

						// Activity
						Thread.sleep(2000);
						scroll.ScrollDown();
						Thread.sleep(2000);
						WebElement ActivityViewAllTop = elements.ActivityViewAllTop();
						if (ActivityViewAllTop != null && ActivityViewAllTop.isEnabled()) {
							ActivityViewAllTop.click();
							androidLogs.CapturedLogs(androidText.PASS, "View all top button clicked");
							scroll.ScrollDown();
							scroll.ScrollUp();
							elements.TransactionActivityCell().click();
							androidLogs.CapturedLogs(androidText.PASS, "Transaction activity opened");
							Thread.sleep(2000);
							elements.TransactionActivityCellBackButton().click();
							androidLogs.CapturedLogs(androidText.PASS, "Transaction activity back button selected");
							Thread.sleep(2000);
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

					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "Company tab not found");
					}

					//TODO Smartfunds tab on universal card
					Thread.sleep(3000);
					WebElement SmartfundsTab = elements.SmartfundsTab();
					if (SmartfundsTab != null && SmartfundsTab.isEnabled()) {
						SmartfundsTab.click();
						Thread.sleep(3000);
						androidLogs.CapturedLogs(androidText.INFO, "SmartFunds tab loaded.");

						// load cash
						Thread.sleep(2000);
						WebElement LoadCashButton = elements.LoadCashButton();
						if (LoadCashButton != null && LoadCashButton.isEnabled()) {
							LoadCashButton.click();
							androidLogs.CapturedLogs(androidText.PASS, "Load cash selected");
							elements.LoadCashAmountTextBox().sendKeys("1.99");
							elements.LoadCashNextButton().click();
							elements.LoadCashAmountButton().click();
							androidLogs.CapturedLogs(androidText.PASS, "Load cash completed");
						} else {
							androidLogs.CapturedLogs(androidText.INFO, "Load cash button not found");
						}

						// remove cash
						Thread.sleep(3000);
						WebElement RemoveCashButton = elements.RemoveCashButton();
						if (RemoveCashButton != null && RemoveCashButton.isEnabled()) {
							RemoveCashButton.click();
							androidLogs.CapturedLogs(androidText.PASS, "Remove cash button clicked");
							elements.RemoveCashAmountTextBox().sendKeys("1.99");
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
							androidLogs.CapturedLogs(androidText.PASS, "Card information opened");
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
							androidLogs.CapturedLogs(androidText.PASS, "Change status clicked");
							Thread.sleep(3000);
							elements.HoldStatus().click();
							elements.StatusChangeSaveButton().click();
							androidLogs.CapturedLogs(androidText.PASS, "Status set to Hold");
							Thread.sleep(3000);
							elements.ChangeStatusButton().click();
							Thread.sleep(3000);
							elements.InactiveStatus().click();
							elements.StatusChangeSaveButton().click();
							androidLogs.CapturedLogs(androidText.PASS, "Status set to inactive");
							Thread.sleep(3000);
							elements.ChangeStatusButton().click();
							Thread.sleep(3000);
							elements.FollowsStatus().click();
							elements.StatusChangeSaveButton().click();
							androidLogs.CapturedLogs(androidText.PASS, "Status set to Follow");
							Thread.sleep(3000);
							elements.ChangeStatusButton().click();
							Thread.sleep(3000);
							elements.ActiveStatus().click();
							elements.StatusChangeSaveButton().click();
							androidLogs.CapturedLogs(androidText.PASS, "Status set to active");
						} else {
							androidLogs.CapturedLogs(androidText.FAIL, "Change status button not found");
						}

						// Activity
						// Activity taking long to load inside view all

						Thread.sleep(2000);
						scroll.ScrollDown();
						Thread.sleep(2000);
						WebElement ActivityViewAllTop = elements.ActivityViewAllTop();
						if (ActivityViewAllTop != null && ActivityViewAllTop.isEnabled()) {
							ActivityViewAllTop.click();
							androidLogs.CapturedLogs(androidText.PASS, "View all top button selected");
						scroll.ScrollDown();
						scroll.ScrollUp();
						elements.TransactionActivityCell().click();
						Thread.sleep(2000);
						elements.TransactionActivityCellBackButton().click();
						Thread.sleep(2000);
							elements.TransactionActivityViewAllBackButton().click();

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
							androidLogs.CapturedLogs(androidText.PASS, "View all bottom button selected");
							Thread.sleep(3000);
							elements.TransactionActivityViewAllBackButton().click();
						} else {
							androidLogs.CapturedLogs(androidText.FAIL, "View all bottom button not found");
						}

						Capabilities.driver.navigate().back();

					} else {
						androidLogs.CapturedLogs(androidText.FAIL, "Smartfunds tab not found");
					}

				} else {
					androidLogs.CapturedLogs(androidText.FAIL, "Card search result was not found");
				}
			}

		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Cards Tab was not opened.");

		}

		return this;

	}
}
