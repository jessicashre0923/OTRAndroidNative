package androidCardClasses;

import org.openqa.selenium.WebElement;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;

public class OpenCardControlDirectLogin extends AndroidLogs {
	
	 		AppiumDriver<WebElement> driver;	
	 		private String cardNum;	 			
	 		private String cardType;
	 		String appName = "Card Control";
	 		
			public void openCardControl () throws Exception {
	
				AndroidLogs androidLogs = new AndroidLogs();
				PhonePicker phone = new PhonePicker();
//CardDirectLoginPass CardLogin = new CardDirectLoginPass();
				CreateProfile SetupProfile = new CreateProfile();
				EnvironmentPicker environmentPicker=new EnvironmentPicker();
				AppStringsAndroid androidText = new  AppStringsAndroid();
				ForgotPINorPasscode forgotPasscode = new ForgotPINorPasscode();
				LogOutCardControl Logout = new LogOutCardControl();
				BiometricsAndroid Biometrics = new BiometricsAndroid();
				DynamicPIN dynamicPIN = new DynamicPIN();
				TransferFunds TransferFunds = new TransferFunds();
				MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
				CardProgressSpinner loadingSpinner = new CardProgressSpinner();
				CardDirectLoginPass Login = new CardDirectLoginPass();
				GetACard getACard = new GetACard();
//				String pass = androidText.PASS;
//				String fail = androidText.FAIL;
				String info = androidText.INFO;

				
				//phone picker 
				System.out.println(phone.autoPhonePickerCard(appName));
				//forgot pin passcode 5542
				//Environment picker
				environmentPicker.EnvironmentPickerButton();
				multiCard.MultiCardLoginCheck();
				//Forgot Passcode
				forgotPasscode.ForgotPINorPasscode(environmentPicker.getEnviroment(), getACard.getCardNum(), getACard.getPasswordOrPin());
				//check for biometrics modal
				
//TODO progress spinners not working...			
				//loadingSpinner.loginButtonSpinner();
				Biometrics.BiometricsAndroid();
//TODO add a home page loading spinner.				
				//Dynamic PIN
				dynamicPIN.dynamicPIN();
				//Transfer funds
				TransferFunds.TransferFunds();
				//logout
				Logout.logoutCardControl();
				androidLogs.CapturedLogs(info, "Logged out of 5542");
				androidLogs.setupTest("Testing on 6344 starting");
				androidLogs.CapturedLogs(info, "Testing on 6344 starting");
					
				
				//info Icon and show passcode/pin on login page. This is missing XPATHS. 
//				informationIcon.InformationIcon();
				//welcome.welomeScreen();
				environmentPicker.EnvironmentPickerButton();
				multiCard.MultiCardLoginCheck();
				//6344
				getACard.setEnv(environmentPicker.getEnviroment());
				getACard.CardPassExpected("6344");
				cardType = "6344 CARD";
				Login.CardPassExpected(environmentPicker.getEnviroment(), getACard.getCardNum(), getACard.getPasswordOrPin(), this.cardType);
				
//CardLogin.CardPassExpected(environmentPicker.getEnviroment(), this.cardNum);

//TODO progress spinners not working...			
				//loadingSpinner.loginButtonSpinner();
				//check for biometrics modal
				Biometrics.BiometricsAndroid();
				//profile
				SetupProfile.ProfileSetup(environmentPicker.getEnviroment());
				
	}
			public void setCardNum(String cardNumNow) {
				this.cardNum = cardNumNow;
				System.out.println("SET Card Number: "+ cardNum);
			}


			public String getCardNum() {
				System.out.println("GET Card number: "+ cardNum);
				return cardNum;
			}
}
