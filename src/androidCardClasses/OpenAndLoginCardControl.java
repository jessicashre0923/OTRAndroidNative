 package androidCardClasses;



import org.openqa.selenium.WebElement;
import androidSharedClasses.AndroidLogs;
import androidSharedClasses.AppStringsAndroid;
import androidSharedClasses.BiometricsAndroid;
import androidSharedClasses.EnvironmentPicker;
import androidSharedClasses.PhonePicker;
import io.appium.java_client.AppiumDriver;



public class OpenAndLoginCardControl extends AndroidLogs{
	
	AppiumDriver<WebElement> driver;	

	// static WebDriver driverWeb;
	private String cardNum;	
	private String cardType;
	String appName = "Card Control";

	public void openCardControl() throws Exception {
		//AndroidLogs logs = new AndroidLogs();
		PhonePicker phone = new PhonePicker();
		LoginFailVerification failLogin = new LoginFailVerification();
		//LoginPassVerification passLogin = new LoginPassVerification();
		AppStringsAndroid androidText = new  AppStringsAndroid();
		AndroidLogs logs = new AndroidLogs();
		EnvironmentPicker environmentPicker=new EnvironmentPicker();
		CardDirectLoginPass CardLogin = new CardDirectLoginPass();
		BiometricsAndroid Biometrics = new BiometricsAndroid();
		CreateProfile createProfile = new CreateProfile();
		MultiCardLoginCheck multiCard = new MultiCardLoginCheck();
		//ForgotPINorPasscode forgotPINorPasscode=new ForgotPINorPasscode();
		TransferFunds TransferFunds = new TransferFunds();
		CardDirectLoginPass Login = new CardDirectLoginPass();
		GetACard getACard = new GetACard();

		
		System.out.println(phone.autoPhonePickerCard(appName));
		environmentPicker.EnvironmentPickerButton();
		logs.setupTestYellow("LOCKED AND SUSPENDED TESTS");
		logs.CapturedLogs(androidText.INFO, "Normal Automation starting point Android Card Control Login Logout");
		multiCard.MultiCardLoginCheck();
		environmentPicker.EnvironmentPickerButton();
		createProfile.ProfileSetup(environmentPicker.getEnviroment());
				
		//Incorrect Card number and PIN
		//1234
		getACard.setEnv(environmentPicker.getEnviroment());
		getACard.CardPassExpected("1234");
		//Login.CardPassExpected(environmentPicker.getEnviroment(), getACard.getCardNum(), getACard.getPasswordOrPin());
		failLogin.FailExpected(environmentPicker.getEnviroment(), getACard.getCardNum(), getACard.getPasswordOrPin());

		
		//LOCKED LOGIN Correct Card number and incorrect PIN
		//0561
		getACard.setEnv(environmentPicker.getEnviroment());
		getACard.CardPassExpected("0561");
		failLogin.LockedLoginExpected(environmentPicker.getEnviroment(), getACard.getCardNum(), getACard.getPasswordOrPin());

		
//		//Correct Card number and PIN
//		//6344
//		getACard.setEnv(environmentPicker.getEnviroment());
//		getACard.CardPassExpected("6344");
//		cardType = "6344 CARD";
//		Login.CardPassExpected(environmentPicker.getEnviroment(), getACard.getCardNum(), getACard.getPasswordOrPin(),this.cardType);
//		
////CardLogin.CardPassExpected(environmentPicker.getEnviroment(), getACard.getCardNum(), getACard.getPasswordOrPin());
//		
//		//check for biometrics modal
//		Biometrics.BiometricsAndroid();
//			
								
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
