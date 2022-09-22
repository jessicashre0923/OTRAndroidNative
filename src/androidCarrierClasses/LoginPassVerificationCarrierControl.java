package androidCarrierClasses;

import java.sql.ResultSet;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ConnectionHandler;
import androidSharedClasses.LoginInfo;

public class LoginPassVerificationCarrierControl{

	public LoginPassVerificationCarrierControl() {
	}
	
private String env;
private String carrierNum;
private String passwordOrPin;

//TODO how to add a whole class info in by using a function
public void PassExpected(LoginInfo loginInfo) throws Exception {
	PassExpected(loginInfo.getEnv(), loginInfo.getAccountNum(), loginInfo.getPassOrPin());
	
}


public void PassExpected(String environment, String carrierNum, String passwordOrPin) throws Exception {
	this.env = environment;
	this.carrierNum = carrierNum;
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
	
		androidLogs.CapturedLogs(info,"LOGIN PASS");
		// check test account is not prior suspended.
		ConnectionHandler dbACPTCheck = new ConnectionHandler(env);

		ResultSet carrier_info = dbACPTCheck.query("mysql",String.format("select status_id from sec_user where user_id ='"+carrierNum+"'"));

		carrier_info.next();
		if (carrier_info.getString("status_id").equals("S")) {
			androidLogs.CapturedLogs("Test Info", "Carrier Account Was Suspended prior to testing");
			dbACPTCheck.execute("mysql",
					"update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id  = '"+carrierNum+"'");
		} else {
			androidLogs.CapturedLogs(info,
					String.format("Carrier Account status is: %s", carrier_info.getString("status_id")));
			androidLogs.CapturedLogs(info, "Carrier Account is active and ready for testing ");

		}
		Thread.sleep(3000);
		WebElement PassExpectedLoginCarrierTextBox = elements.LoginCarrierTextBox();
		Thread.sleep(3000);
		if (PassExpectedLoginCarrierTextBox != null && PassExpectedLoginCarrierTextBox.isEnabled()) {
			PassExpectedLoginCarrierTextBox.click();
			PassExpectedLoginCarrierTextBox.clear();
			Thread.sleep(3000);
			androidLogs.CapturedLogs(info, "Carrier number textbox cleared");
			PassExpectedLoginCarrierTextBox.sendKeys(carrierNum);
			androidLogs.CapturedLogs(pass, "Carrier number entered");
		} else {
			androidLogs.CapturedLogs(fail,
					"Carrier number for " + this.carrierNum + " text box is not found");
		}
		Thread.sleep(3000);

		// Find the login Password/pin textbox tell if find or fail.
		Thread.sleep(3000);
		WebElement PassExpectedLoginCarrierPasswordTextBox = elements.PassExpectedLoginCarrierPasswordTextBox();
		Thread.sleep(3000);
		if (PassExpectedLoginCarrierPasswordTextBox != null && PassExpectedLoginCarrierPasswordTextBox.isEnabled()) {
			PassExpectedLoginCarrierPasswordTextBox.click();
			PassExpectedLoginCarrierPasswordTextBox.clear();
			Thread.sleep(3000);
			androidLogs.CapturedLogs(info, "Carrier Password textbox cleared");
			PassExpectedLoginCarrierPasswordTextBox.sendKeys(passwordOrPin);
			androidLogs.CapturedLogs(pass,
					"Pin text box for " + carrierNum + " is entered.");
		} else {
			androidLogs.CapturedLogs(fail,
					"Pin text box for " + carrierNum + " is not found");
		}
		
		Thread.sleep(3000);
		WebElement LoginCarrierShowHidepassword = elements.LoginCarrierShowHidepassword(); 
		Thread.sleep(3000);
		if (LoginCarrierShowHidepassword != null && LoginCarrierShowHidepassword.isEnabled()) {
			LoginCarrierShowHidepassword.click();
			androidLogs.CapturedLogs(info, "Password unhidden");
			LoginCarrierShowHidepassword.click();
			androidLogs.CapturedLogs(info, "Password hidden");
		}

		Thread.sleep(3000);
		WebElement LoginButtonCarrierControl = elements.LoginButtonCarrierControl();
		Thread.sleep(3000);
		if (LoginButtonCarrierControl != null && LoginButtonCarrierControl.isEnabled()) {
			LoginButtonCarrierControl.click();
			androidLogs.CapturedLogs(pass, "Login Button selected.");
		} else {
			androidLogs.CapturedLogs(fail, "Login Button not found");
		}
	}
}
