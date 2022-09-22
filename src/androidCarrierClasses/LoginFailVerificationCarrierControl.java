package androidCarrierClasses;

import java.sql.ResultSet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.Capabilities;
import androidSharedClasses.ConnectionHandler;

public class LoginFailVerificationCarrierControl {
	public LoginFailVerificationCarrierControl() {
	}

//TODO Add to all 		
private String env;
//TODO Add to all 		
	public void FailExpected(String environment) throws Exception {
		this.env = environment;
		FailExpected();
	}
	
	AndroidLogs androidLogs = new AndroidLogs();
	AppStringsAndroid androidText = new AppStringsAndroid();
	RepoCarrierAndroid elements = new RepoCarrierAndroid();
	String pass = androidText.PASS;
	String fail = androidText.FAIL;
	String info = androidText.INFO;

	public void FailExpected() throws Exception {
//TODO Add to all
		androidLogs.CapturedLogs(info, "FAILED LOGIN");
		androidText = new AppStringsAndroid(env);
		System.out.println("I am in login fail environment is:" + env);
		
	

		androidLogs.setupTest("Fail login testing");
		androidLogs.CapturedLogs(info, "Login Failed Expected Testing started.");
			
		WebElement LoginCarrierTextBox = elements.LoginCarrierTextBox();
		Thread.sleep(3000);
		if (LoginCarrierTextBox != null && LoginCarrierTextBox.isEnabled()) {
			LoginCarrierTextBox.click();
			LoginCarrierTextBox.clear();
			LoginCarrierTextBox.sendKeys(androidText.getENVData("CARRIER_LOGIN_ID_FAIL_EXPECTED"));
			androidLogs.CapturedLogs(pass, "UserName entered.");
		
		} else {
			androidLogs.CapturedLogs(fail, "UserName text box is not found");
		}


		WebElement LoginCarrierPasswordTextBox = elements.LoginCarrierPasswordTextBox();
		Thread.sleep(3000);
		if (LoginCarrierPasswordTextBox != null && LoginCarrierPasswordTextBox.isDisplayed()) {
			LoginCarrierPasswordTextBox.click();
			LoginCarrierPasswordTextBox.clear();
			LoginCarrierPasswordTextBox.sendKeys(androidText.getENVData("CARRIER_LOGIN_PASSWORD_FAIL_EXPECTED"));
		
			androidLogs.CapturedLogs(pass, "Password entered.");

		} else {
			androidLogs.CapturedLogs(fail, "Password text box is not found");

		}

		
		WebElement loginKey = elements.LoginButtonCarrierControl();
		Thread.sleep(3000);
		if (loginKey != null && loginKey.isEnabled()) {
			loginKey.click();
			androidLogs.CapturedLogs(pass, "Login Button Pressed.");

		} else {
			androidLogs.CapturedLogs(fail, "Login Button is not found");
		}

		Thread.sleep(3000);
		WebElement SomethingWentWrongOkButton = elements.SomethingWentWrongOkButton();
		Thread.sleep(3000);
		if (SomethingWentWrongOkButton != null && SomethingWentWrongOkButton.isEnabled()) {
			SomethingWentWrongOkButton.click();
			androidLogs.CapturedLogs(pass, "Something Went Wrong OK button selected");

		} else {
			androidLogs.CapturedLogs(fail, "Something Went Wrong OK button not found");
		}

	}

//locked login starts	
public void LockedLoginExpected(String env) throws Exception {
	androidLogs.CapturedLogs(info,"LOCKED LOGIN");
		this.env = env;
		System.out.println("I am in login locked environment is:" + env);
		
		AndroidLogs androidLogs = new AndroidLogs();
		androidText = new AppStringsAndroid(env);
		
//TODO	It is now time to move 	TextBoxXpaths appText = new TextBoxXpaths(); to the new system....
		TextBoxXpaths appText = new TextBoxXpaths();
		RepoCarrierAndroid elements = new RepoCarrierAndroid();

		androidLogs.setupTest("Locked login testing");
		androidLogs.CapturedLogs(info, "Locked Login Expected Testing started.");

		
	
		// check test account is not prior suspended.
		ConnectionHandler dbCheck = new ConnectionHandler(env);
		// ConnectionHandler db = new ConnectionHandler();
		dbCheck.execute("mysql","update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '100045'");
		androidLogs.CapturedLogs(pass, "Expected Carrier account reset in database prior to test.");
		
		// phones logs in as expected.
		Thread.sleep(3000);
		WebElement LockedLoginCarrierTextBox = elements.LockedLoginCarrierTextBox();
		Thread.sleep(3000);
		if (LockedLoginCarrierTextBox != null && LockedLoginCarrierTextBox.isEnabled()) {
			LockedLoginCarrierTextBox.click();
			LockedLoginCarrierTextBox.clear();
			
			Thread.sleep(3000);
			// send carrier number2 to the carrier controll app
			LockedLoginCarrierTextBox.sendKeys(androidText.getENVData("CARRIER_LOGIN_ID_LOCKED"));
			androidLogs.CapturedLogs(pass, "Carrier Locked number entered.");
		} else {
			androidLogs.CapturedLogs(fail, "Carrier Locked number text box is not found");
		}

		// Find the login Password/pin textbox tell if find or fail.
		
		Thread.sleep(3000);
		WebElement LockedLoginCarrierPasswordTextBox = elements.LockedLoginCarrierPasswordTextBox();
		Thread.sleep(3000);
		if (LockedLoginCarrierPasswordTextBox != null && LockedLoginCarrierPasswordTextBox.isEnabled()) {
			LockedLoginCarrierPasswordTextBox.click();
			LockedLoginCarrierPasswordTextBox.clear();
		
			androidLogs.CapturedLogs(info, "Carrier password textbox cleared");
			LockedLoginCarrierPasswordTextBox.sendKeys(androidText.getENVData("CARRIER_LOGIN_PASSWORD_LOCKED"));
			androidLogs.CapturedLogs(pass, "password entered.");

		} else {
			androidLogs.CapturedLogs(fail, "Password text box is not found");
		}

		
		ResultSet lockNumberDB = dbCheck.query("mysql",String.format("SELECT sec_company_attribute.value FROM sec_company_attribute JOIN sec_user ON sec_user.company_id = sec_company_attribute.company_id WHERE sec_user.user_id = %s", "'100045' AND sec_company_attribute.type_id IN (24)"));
		lockNumberDB.next();
		String lockNumber = lockNumberDB.getString("value");
		System.out.println("This is the number set for Login Attempted max: "+lockNumber);
		int intLockNumber = Integer.parseInt(lockNumber);  
		System.out.println("This is the number set for Login Attempted max: "+intLockNumber);
		
		int loginAttempt = 0;
		while (loginAttempt < intLockNumber) {
			Thread.sleep(3000);
			WebElement loginKey = elements.LoginButtonCarrierControl();
			Thread.sleep(3000);

			if (loginKey != null && loginKey.isEnabled()) {
				loginKey.click();
				androidLogs.CapturedLogs(pass, "Login Button Pressed.");
				loginAttempt++;
				System.out.println("Locked Login count: " + String.valueOf(loginAttempt));

			} else {
						
			androidLogs.CapturedLogs(fail, "Login Button is not found");
			}

			Thread.sleep(3000);
			WebElement somethingWentWrongModaltext = elements.SomethingWentWrongModal();
			Thread.sleep(3000);
			if (somethingWentWrongModaltext != null && somethingWentWrongModaltext.isDisplayed()) {
				androidLogs.CapturedLogs(pass, "Something Went Wrong Modal is seen");
				Thread.sleep(3000);
				WebElement SomethingWentWrongOkButton = elements.SomethingWentWrongOkButton();
				Thread.sleep(3000);	
				if (SomethingWentWrongOkButton != null && SomethingWentWrongOkButton.isEnabled()) {
					SomethingWentWrongOkButton.click();
					androidLogs.CapturedLogs(pass, "Ok Button Pressed");
				} else {
					androidLogs.CapturedLogs(fail, "Ok Button not found");
				} 
					} else {	
					androidLogs.CapturedLogs(info, "Something Went Wrong Modal not found");	
					
				}
			
				Thread.sleep(3000);
				WebElement InvalidUserNameOrPasswordModal = elements.InvalidUserNameOrPasswordModal();
				Thread.sleep(3000);
				if (InvalidUserNameOrPasswordModal != null && InvalidUserNameOrPasswordModal.isDisplayed()) {
					androidLogs.CapturedLogs(pass, "Invalid Username Modal is seen");
				
					WebElement SomethingWentWrongOkButton = elements.SomethingWentWrongOkButton();
					Thread.sleep(3000);	
					if (SomethingWentWrongOkButton != null && SomethingWentWrongOkButton.isEnabled()) {
						SomethingWentWrongOkButton.click();
						androidLogs.CapturedLogs(pass, "Ok Button Pressed");
					}

				} else {
					androidLogs.CapturedLogs(info, "Invalid Username Modal not found");
				
				}
					Thread.sleep(3000);
					WebElement DismissLockedAcountModal = elements.DismissLockedAcountModal();
					Thread.sleep(3000);
					if (DismissLockedAcountModal != null && DismissLockedAcountModal.isEnabled()) {
						androidLogs.CapturedLogs(pass, "Locked account Modal is seen");
						WebElement DismissLockedAcountButton = elements.DismissLockedAcountButton();
						Thread.sleep(3000);	
						DismissLockedAcountButton.click();
						
						//database functionality
						dbCheck.execute("mysql","update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '100045'");
						androidLogs.CapturedLogs(info, "Account unlocked in databse");

				} else {
					androidLogs.CapturedLogs(info, "Locked Account Modal not found");
					}
						
			}
		Thread.sleep(3000);
		WebElement loginKey = elements.LoginButtonCarrierControl();
		Thread.sleep(3000);
		if (loginKey != null && loginKey.isEnabled()) {
			loginKey.click();
			androidLogs.CapturedLogs(pass, "Login Button Pressed.");

		
		Thread.sleep(3000);
		WebElement DismissLockedAcountModal = elements.DismissLockedAcountModal();
		Thread.sleep(3000);	
		if (DismissLockedAcountModal != null && DismissLockedAcountModal.isEnabled()) {
			androidLogs.CapturedLogs(pass, "Locked expected locked account Modal is seen");
			WebElement DismissLockedAcountButton = elements.DismissLockedAcountButton();
			Thread.sleep(3000);	
			DismissLockedAcountButton.click();
				
				//database functionality
				dbCheck.execute("mysql","update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '100045'");
				androidLogs.CapturedLogs(info, "Account unlocked in databse");
			}else {
			androidLogs.CapturedLogs(info, "Lock expected locked account Modal not found");
		} 
		}else {
			androidLogs.CapturedLogs(fail, "Login Button is not found");
		}
	}
	
	

	public void SuspendedLoginExpected(String env) throws Exception {
		androidLogs.CapturedLogs(info,"SUSPENDED LOGIN");
		this.env = env;
		System.out.println("I am in suspended login environment is:" + env);
		
		AndroidLogs androidLogs = new AndroidLogs();
		androidText = new AppStringsAndroid(env);
		
//TODO	It is now time to move 	TextBoxXpaths appText = new TextBoxXpaths(); to the new system....
		TextBoxXpaths appText = new TextBoxXpaths();
		RepoCarrierAndroid elements = new RepoCarrierAndroid();		ConnectionHandler dbCheck = new ConnectionHandler(env);

		androidLogs.setupTest("Suspended login testing");
		androidLogs.CapturedLogs(info, "Suspended Login Expected Testing started.");
	
		ResultSet suspenededNumberDB = dbCheck.query("mysql",String.format("SELECT sec_company_attribute.value FROM sec_company_attribute JOIN sec_user ON sec_user.company_id = sec_company_attribute.company_id WHERE sec_user.user_id = %s", "'100045' AND sec_company_attribute.type_id IN (25)"));
		suspenededNumberDB.next();
		String suspendedNumber = suspenededNumberDB.getString("value");
		System.out.println("This is the number set for Login Attempted max: "+suspendedNumber);
		int intSuspenededNumber = Integer.parseInt(suspendedNumber);  
		System.out.println("This is the number set for Login Attempted max: "+intSuspenededNumber);
		
		
		int loginAttempt = 0;
		while (loginAttempt < intSuspenededNumber) {
			Thread.sleep(3000);
			WebElement loginKey = elements.LoginButtonCarrierControl();
			Thread.sleep(3000);
			if (loginKey != null && loginKey.isEnabled()) {
				loginKey.click();
				androidLogs.CapturedLogs(pass, "Login Button Pressed.");
				loginAttempt++;
				System.out.println("Suspended Login Count: " + String.valueOf(loginAttempt));
				
				Thread.sleep(3000);
				WebElement InvalidUserNameOrPasswordModal = elements.InvalidUserNameOrPasswordModal();
				Thread.sleep(3000);
				if (InvalidUserNameOrPasswordModal != null && InvalidUserNameOrPasswordModal.isDisplayed()) {
					androidLogs.CapturedLogs(pass, "Invalid Username Modal is seen");
					
				
					WebElement SomethingWentWrongOkButton = elements.SomethingWentWrongOkButton();
					Thread.sleep(3000);	
					if (SomethingWentWrongOkButton != null && SomethingWentWrongOkButton.isDisplayed()) {
						SomethingWentWrongOkButton.click();
						androidLogs.CapturedLogs(pass, "Ok Button Pressed");
						
						//database functionality
						dbCheck.execute("mysql", "update sec_user set login_attempted = NULL where user_id = '100045'");
						androidLogs.CapturedLogs(info,
						"Databse checked and login attempted field is equals to Null");
					}

				} else {
					androidLogs.CapturedLogs(info, "Invalid Username Modal not found");
					
					Thread.sleep(3000);
					WebElement passSuspended = elements.DismissSuspendedAcountButton();
					Thread.sleep(3000);
					if (passSuspended != null && passSuspended.isDisplayed()) {
						passSuspended.click();
						androidLogs.CapturedLogs(pass, "Suspended Dismiss button selected");
						
						//database functionality
						dbCheck.execute("mysql","update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '100045'");
						androidLogs.CapturedLogs(info, "Account reset in databse");
											
					} else {
						androidLogs.CapturedLogs(info, "Suspended Dismiss button not found");
					}
				}
				
				
			} else {
				androidLogs.CapturedLogs(info, "Login Button not found");
			}
		}
				
				WebElement loginKey = elements.LoginButtonCarrierControl();
				Thread.sleep(3000);
				if (loginKey != null && loginKey.isEnabled()) {
					loginKey.click();
					androidLogs.CapturedLogs(pass, "Login Button Pressed.");
					
				WebElement passSuspended = elements.DismissSuspendedAcountButton();
				Thread.sleep(3000);
				if (passSuspended != null && passSuspended.isDisplayed()) {
					passSuspended.click();
					androidLogs.CapturedLogs(pass, "Suspended Dismiss button selected");
					
					//database functionality
					dbCheck.execute("mysql","update sec_user set status_id = 'A', passwd_fail_count = 0 where user_id = '100045'");
					androidLogs.CapturedLogs(info, "Account reset in databse");
										
				} else {
					androidLogs.CapturedLogs(info, "Suspended Dismiss button not found");
				}
				
				} else {
					androidLogs.CapturedLogs(info, "Login Button not found");
				}

		}
		
	}
