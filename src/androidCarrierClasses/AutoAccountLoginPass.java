package androidCarrierClasses;

import java.sql.ResultSet;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ConnectionHandler;

public class AutoAccountLoginPass{

	public AutoAccountLoginPass() {
	}
	
private String env;
private String carrierNum;
private String passwordOrPin;
	
public void PassExpected(String environment, String carrierNumber, String passwordOrPin) throws Exception {
	this.env = environment;
	this.carrierNum = carrierNumber;
	this.passwordOrPin = passwordOrPin;
	PassExpected();
}
	

	@Test
	public void PassExpected() throws Exception {

		AndroidLogs androidLogs = new AndroidLogs();
		AppStringsAndroid androidText = new AppStringsAndroid(env);
		RepoCarrierAndroid elements = new RepoCarrierAndroid();
		String pass = androidText.PASS;
		String fail = androidText.FAIL;
		String info = androidText.INFO;

		androidLogs.setupTest("LOGIN");
		androidLogs.CapturedLogs(pass, "Login Pass Expected");
		// check test account is not prior suspended.
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);

		//ResultSet carrier_info = dbACPTCheck.query("mysql",String.format("select status_id from sec_user where user_id = %s", "100045"));
		ResultSet carrier_info = dbACPTCheck.query("mysql",String.format("select * from sec_user where user_id='"+carrierNum+"'"));
		carrier_info.next();
		
		if (carrier_info.getString("status_id").equals("S")) {
			androidLogs.CapturedLogs("Test Info", "Carrier Account Was Suspended prior to testing");
			dbACPTCheck.execute("mysql",
					"update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id='"+carrierNum+"'");
			
		} else {
			androidLogs.CapturedLogs(info,
					String.format("Carrier Account status is: %s", carrier_info.getString("status_id")));
			androidLogs.CapturedLogs(info, "Carrier Account is active and ready for testing ");

		}

		WebElement LoginCarrierTextBox = elements.LoginCarrierTextBox();
		Thread.sleep(2000);
		if (LoginCarrierTextBox != null && LoginCarrierTextBox.isEnabled()) {
			LoginCarrierTextBox.click();
			LoginCarrierTextBox.clear();
			Thread.sleep(2000);
			androidLogs.CapturedLogs(info, "Carrier number textbox cleared");
			LoginCarrierTextBox.sendKeys(this.carrierNum);
			androidLogs.CapturedLogs(pass, "Carrier number entered");
		} else {
			androidLogs.CapturedLogs(fail,
					"Carrier number for " + this.carrierNum + " text box is not found");
		}
		Thread.sleep(3000);

		// Find the login Password/pin textbox tell if find or fail.
		Thread.sleep(2000);
		WebElement LoginCarrierPasswordTextBox = elements.LoginCarrierPasswordTextBox();
		Thread.sleep(2000);
		if (LoginCarrierPasswordTextBox != null && LoginCarrierPasswordTextBox.isEnabled()) {
			LoginCarrierPasswordTextBox.click();
			LoginCarrierPasswordTextBox.clear();
			Thread.sleep(2000);
			androidLogs.CapturedLogs(info, "Carrier Password textbox cleared");
			LoginCarrierPasswordTextBox.sendKeys(this.passwordOrPin);
			androidLogs.CapturedLogs(pass,
					"Pin text box for " + this.passwordOrPin + " is entered.");
		} else {
			androidLogs.CapturedLogs(fail,
					"Pin text box for " + this.carrierNum + " is not found");
		}
		
		Thread.sleep(2000);
		WebElement LoginCarrierShowHidepassword = elements.LoginCarrierShowHidepassword();  
		if (LoginCarrierShowHidepassword != null && LoginCarrierShowHidepassword.isEnabled()) {
			LoginCarrierShowHidepassword.click();
			androidLogs.CapturedLogs(info, "Password unhidden");
			LoginCarrierShowHidepassword.click();
			androidLogs.CapturedLogs(info, "Password hidden");
		}

		Thread.sleep(3000);
		WebElement LoginButtonCarrierControl = elements.LoginButtonCarrierControl();

		if (LoginButtonCarrierControl != null && LoginButtonCarrierControl.isEnabled()) {
			LoginButtonCarrierControl.click();
			androidLogs.CapturedLogs(pass, "Login Button selected.");
		} else {
			androidLogs.CapturedLogs(fail, "Login Button not found");
		}
	}
}
