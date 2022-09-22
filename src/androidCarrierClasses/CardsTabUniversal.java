package androidCarrierClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import io.appium.java_client.AppiumDriver;

public class CardsTabUniversal {

	AndroidLogs androidLogs = new AndroidLogs();
	RepoCarrierAndroid elements = new RepoCarrierAndroid();
	AppStringsAndroid androidText = new AppStringsAndroid();
	static AppiumDriver<WebElement> driver;
	DesiredCapabilities cap = new DesiredCapabilities();

	public CardsTabUniversal CardsTabUniversal() throws Exception {

		androidLogs.setupTest("Tests Universal Cards");
		
		Thread.sleep(2000);
		WebElement CardsTab = elements.CardsTab();
		if (CardsTab.isEnabled()) {
			CardsTab.click();
			androidLogs.CapturedLogs(androidText.PASS, "Cards tab opened");
			
			// driver:
			elements.DriverSelection().click();
			androidLogs.CapturedLogs(androidText.PASS, "Driver Tab selected");
			elements.SearchIcon().click();

			// driver search:
			Thread.sleep(2000);
			WebElement DriverSearch = elements.DriverSearch();
			if (DriverSearch.isDisplayed()) {
				DriverSearch.sendKeys("John");

				// element.PhysicalSearchButton().click();

				Actions actionReturn = new Actions(Capabilities.driver);

				actionReturn.sendKeys(Keys.RETURN).build().perform();
				androidLogs.CapturedLogs(androidText.PASS, "Driver name entered.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Driver text box was not found");
			}

			if (elements.DriverSearchResult().isDisplayed()) {
				// driverSearchResult.click();
				androidLogs.CapturedLogs(androidText.PASS, "Driver search result found.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Driver search result was not found");
			}

			// unit:
			elements.UnitSelection().click();
			elements.ClearSearchBoxIcon().click();
			// element.SearchIcon().click();
			// unit search:
			Thread.sleep(2000);
			WebElement UnitSearch = elements.UnitSearch();
			if (UnitSearch.isDisplayed()) {
				UnitSearch.sendKeys("1234");

				// element.PhysicalSearchButton().click();

				Actions actionReturn = new Actions(Capabilities.driver);
				actionReturn.sendKeys(Keys.RETURN).build().perform();
				androidLogs.CapturedLogs(androidText.PASS, "Unit number entered.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Unit text box was not found");
			}

			if (elements.UnitSearchResult().isDisplayed()) {
				// unitSearchResult.click();
				androidLogs.CapturedLogs(androidText.PASS, "Unit search result found.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Unit search result was not found");
			}

			// card:
			elements.CardSelection().click();
			elements.ClearSearchBoxIcon().click();
			// element.SearchIcon().click();
			// card search:
			Thread.sleep(2000);
			WebElement CardSearch = elements.CardSearch();
			if (CardSearch.isDisplayed()) {
				CardSearch.sendKeys("0010");

				// element.PhysicalSearchButton().click();
				Actions actionReturn = new Actions(Capabilities.driver);
				actionReturn.sendKeys(Keys.RETURN).build().perform();
				androidLogs.CapturedLogs(androidText.PASS, "Card Number entered.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Card Number text box was not found");
			}

			if (elements.CardSearchResult().isDisplayed()) {
				// element.CardSearchResult().click();
				androidLogs.CapturedLogs(androidText.PASS, "Card search result found.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Card search result was not found");
			}

			// driver ID:
			elements.DriverIDSelection().click();
			elements.ClearSearchBoxIcon().click();
			// element.SearchIcon().click();
			// driver id search:
			Thread.sleep(2000);
			WebElement DriverIDSearch = elements.DriverIDSearch();
			if (DriverIDSearch.isDisplayed()) {
				DriverIDSearch.sendKeys("1234");

				// element.PhysicalSearchButton().click();
				Actions actionReturn = new Actions(Capabilities.driver);
				actionReturn.sendKeys(Keys.RETURN).build().perform();
				androidLogs.CapturedLogs(androidText.PASS, "Driver ID entered.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Driver ID text box was not found");
			}

			if (elements.DriverIDSearchResult().isDisplayed()) {
				// unitSearchResult.click();
				androidLogs.CapturedLogs(androidText.PASS, "Driver ID search result found.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Driver ID search result was not found");
			}

			// Policy:
			elements.PolicySelection().click();
			elements.ClearSearchBoxIcon().click();
			// element.SearchIcon().click();
			// policy search:
			Thread.sleep(2000);
			WebElement PolicySearch = elements.PolicySearch();
			if (PolicySearch.isDisplayed()) {
				PolicySearch.sendKeys("3");

				// element.PhysicalSearchButton().click();
				Actions actionReturn = new Actions(Capabilities.driver);
				actionReturn.sendKeys(Keys.RETURN).build().perform();
				androidLogs.CapturedLogs(androidText.PASS, "Policy number entered.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Policy text box was not found");
			}

			if (elements.PolicySearchResult().isDisplayed()) {
				// unitSearchResult.click();
				androidLogs.CapturedLogs(androidText.PASS, "Policy search result found.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Policy search result was not found");
			}

		} else {
			androidLogs.CapturedLogs(androidText.FAIL, "Cards Tab was not found.");
		}

		return this;

	}
}
