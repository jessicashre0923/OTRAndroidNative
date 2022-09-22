package androidCarrierClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import io.appium.java_client.AppiumDriver;

public class CardsTab {
  
	AndroidLogs androidLogs = new AndroidLogs();
	RepoCarrierAndroid elements=new RepoCarrierAndroid();
	static AppiumDriver<WebElement> driver;
	DesiredCapabilities cap = new DesiredCapabilities();
	CardsOverviewUniversal cardsOverview = new CardsOverviewUniversal();
	AppStringsAndroid androidText = new AppStringsAndroid();
		
	public CardsTab CardsTab() throws Exception {
		//find Cards Tab and click it.
		androidLogs.setupTest("Testing Cards tab");
		
		Thread.sleep(3000);
		WebElement CardsTab = elements.CardsTab();
		if (CardsTab.isEnabled()) { 
			CardsTab.click();
			androidLogs.CapturedLogs(androidText.PASS, "Cards tab opened");
			
			//driver:
			Thread.sleep(3000);
			WebElement DriverSelection = elements.DriverSelection();
			if(DriverSelection!=null && DriverSelection.isEnabled()) {
				DriverSelection.click();
				androidLogs.CapturedLogs(androidText.PASS, "Driver Tab selected");
			elements.SearchIcon().click();
			
			//driver search:
			Thread.sleep(3000);
			WebElement DriverSearch = elements.DriverSearch();
			if (DriverSearch.isDisplayed()) {
				DriverSearch.sendKeys(androidText.DRIVERSEARCH);
				Actions actionReturn = new Actions(Capabilities.driver);
				actionReturn.sendKeys(Keys.RETURN).build().perform();
				androidLogs.CapturedLogs(androidText.PASS, "Driver name entered.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Driver text box was not found");
			}

			Thread.sleep(3000);
			if (elements.DriverSearchResult().isDisplayed()) {
				//driverSearchResult.click();
				androidLogs.CapturedLogs(androidText.PASS, "Driver search result found.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Driver search result was not found");
			}
			}
			
			
			//unit:
			Thread.sleep(3000);
			WebElement UnitSelection = elements.UnitSelection();
			if(UnitSelection!=null && UnitSelection.isEnabled()) {
				UnitSelection.click();
				Thread.sleep(2000);
			elements.ClearSearchBoxIcon().click();
			//element.SearchIcon().click();

			//unit search:		
			Thread.sleep(3000);
			WebElement UnitSearch = elements.UnitSearch();
			if (UnitSearch.isDisplayed()) {
				//elements.SearchIcon().click();
				UnitSearch.sendKeys(androidText.UNITSEARCH);
				
				Actions actionReturn = new Actions(Capabilities.driver);
				actionReturn.sendKeys(Keys.RETURN).build().perform();
				androidLogs.CapturedLogs(androidText.PASS, "Unit number entered.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Unit text box was not found");
			}
			
			Thread.sleep(3000);
			if (elements.UnitSearchResult().isDisplayed()) {
				//unitSearchResult.click();
				androidLogs.CapturedLogs(androidText.PASS, "Unit search result found.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Unit search result was not found");
			}}
			
			//card:
			Thread.sleep(3000);
			WebElement CardSelection = elements.CardSelection();
			if(CardSelection!=null && CardSelection.isEnabled()) {
				CardSelection.click();
			elements.ClearSearchBoxIcon().click();
			//elements.SearchIcon().click();
			//card search:
			
			Thread.sleep(3000);
			WebElement CardSearch = elements.CardSearch();
			if (CardSearch.isDisplayed()) {
				CardSearch.sendKeys(androidText.CARDSEARCH);
				
				Actions actionReturn = new Actions(Capabilities.driver);
				actionReturn.sendKeys(Keys.RETURN).build().perform();
				androidLogs.CapturedLogs(androidText.PASS, "Card Number entered.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Card Number text box was not found");
			}
			
			Thread.sleep(3000);
			if (elements.CardSearchResult().isDisplayed()) {
				//element.CardSearchResult().click();

				androidLogs.CapturedLogs(androidText.PASS, "Card search result found.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Card search result was not found");
			}}
			
			//driver ID: 
			Thread.sleep(3000);
			WebElement DriverIDSelection = elements.DriverIDSelection();
			if (DriverIDSelection!=null && DriverIDSelection.isEnabled()) {
				DriverIDSelection.click();
			elements.ClearSearchBoxIcon().click();
			//element.SearchIcon().click();
			//driver id search:
			
			Thread.sleep(3000);
			WebElement DriverIDSearch = elements.DriverIDSearch();
			if (DriverIDSearch.isDisplayed()) {
				DriverIDSearch.sendKeys(androidText.IDSEARCH);

				Actions actionReturn = new Actions(Capabilities.driver);
				actionReturn.sendKeys(Keys.RETURN).build().perform();
				androidLogs.CapturedLogs(androidText.PASS, "Driver ID entered.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Driver ID text box was not found");
			}
			
			Thread.sleep(3000);
			if (elements.DriverIDSearchResult().isDisplayed()) {
				//unitSearchResult.click();

				androidLogs.CapturedLogs(androidText.PASS, "Driver ID search result found.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Driver ID search result was not found");
			}}
			
			//Policy:
			Thread.sleep(3000);
			WebElement PolicySelection = elements.PolicySelection();
			if(PolicySelection!=null && PolicySelection.isEnabled()) {
				PolicySelection.click();
				
			Thread.sleep(3000);
			elements.ClearSearchBoxIcon().click();
			//element.SearchIcon().click();
			//policy search:
			
			Thread.sleep(3000);
			WebElement PolicySearch = elements.PolicySearch();
			if (PolicySearch.isDisplayed()) {
				PolicySearch.sendKeys(androidText.POLICYSEARCH);
				
				Actions actionReturn = new Actions(Capabilities.driver);
				actionReturn.sendKeys(Keys.RETURN).build().perform();
				androidLogs.CapturedLogs(androidText.PASS, "Policy number entered.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Policy text box was not found");
			}
			
			Thread.sleep(3000);
			if (elements.PolicySearchResult().isDisplayed()) {
				//unitSearchResult.click();
				androidLogs.CapturedLogs(androidText.PASS, "Policy search result found.");
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Policy search result was not found");
			}}
			
			} else {
				androidLogs.CapturedLogs(androidText.FAIL, "Cards Tab was not found.");
			

			}
		
		
						
		return this;
		

	}
}

