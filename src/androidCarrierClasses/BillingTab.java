package androidCarrierClasses;

import org.openqa.selenium.WebElement;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import io.appium.java_client.AppiumDriver;

public class BillingTab {
  
	AndroidLogs androidLogs = new AndroidLogs();
	RepoCarrierAndroid elements = new RepoCarrierAndroid();
	PayInvoiceBilling payInvoice=new PayInvoiceBilling();
	AppStringsAndroid androidText = new AppStringsAndroid();
	static AppiumDriver<WebElement> driver;
	
	
	public BillingTab billingTab() throws Exception {
		androidLogs.setupTest("Tests for Billing Tab");
		Thread.sleep(3000);
			try {
				Thread.sleep(3000);
				WebElement BillingTab = elements.BillingTab();
				Thread.sleep(3000);
				if (BillingTab != null && BillingTab.isEnabled()) {
					Thread.sleep(2000);
					BillingTab.click();
					androidLogs.CapturedLogs(androidText.PASS, "Billing tab opened.");
				
					payInvoice.payInvoice();
					
				} else {
					androidLogs.CapturedLogs(androidText.FAIL, "Billing tab not found.");
				}
		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println(e.getMessage());
			
		}
		
		return this;
	}
}

