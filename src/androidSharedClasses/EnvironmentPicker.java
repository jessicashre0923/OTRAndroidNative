package androidSharedClasses;

import org.openqa.selenium.WebElement;

import androidCardClasses.RepoCardAndroid;
import io.appium.java_client.AppiumDriver;

public class EnvironmentPicker {
	static AppiumDriver<WebElement> driver;
	RepoCardAndroid elements=new RepoCardAndroid();
	AndroidLogs logs = new AndroidLogs();
	AppStringsAndroid androidText = new  AppStringsAndroid();
	private String environment;
	private String env;
	
	public EnvironmentPicker EnvironmentPickerButton() throws Exception {
	logs.setupTestYellow("ENVIRONMENT BUTTON PICKER");
	logs.CapturedLogs(androidText.INFO, "Finding Environment Button");
	Thread.sleep(2000);

		
//TODO un-comment wanted environment		
//~~ACPT TEST~~
//		setEnviroment("TEST");
//		WebElement TestButton=elements.TestButton();
//		if (TestButton !=null &&  TestButton.isEnabled()){
//			TestButton.click();
//			logs.CapturedLogs(androidText.PASS, "ACPT Test Server selected as testing option");
//		}else {
//		logs.CapturedLogs(androidText.INFO, "ACPT Test Button not found could be that you already chose an environment");
//	}
		
////~~PARTNER TEST~~
		setEnviroment("PARTNER");
		WebElement PartnerButton=elements.PartnerButton();
		if (PartnerButton !=null &&  PartnerButton.isEnabled()){
			PartnerButton.click();
			logs.CapturedLogs(androidText.PASS, "PARTNER Server selected as testing option");
		}else {
		logs.CapturedLogs(androidText.INFO, "PARTNER Button not found could be that you already chose an environment");
	}
	

//~~AWS SIT~~
//		setEnviroment("AWSSIT");
//		WebElement SITAWSButton=elements.SITAWSButton();
//		if (SITAWSButton !=null && SITAWSButton.isEnabled()){
//			SITAWSButton.click();
//			logs.CapturedLogs(androidText.PASS, "SIT AWS Server selected as testing option");
//		}else {
//		logs.CapturedLogs(androidText.INFO, "SIT AWS Button not found could be that you already chose an environment");
//	}
		
//~~AWS DIT~~
//		setEnviroment("AWSDIT");
//		WebElement AWSDITButton=elements.AWSDITButton();
//		if (AWSDITButton !=null && AWSDITButton.isEnabled()){
//			AWSDITButton.click();
//			logs.CapturedLogs(androidText.PASS, "AWSDIT Button pressed");
//	}else {
//		logs.CapturedLogs(androidText.INFO, "AWSDIT Button not found");
//	}		
		
//~~DIT~~
//		setEnviroment("DIT");
//		WebElement DITButton=elements.DITButton();
//		if (DITButton !=null && DITButton.isEnabled()){
//			DITButton.click();
//			logs.CapturedLogs(androidText.PASS, "DIT Button pressed");
//	}else {
//		logs.CapturedLogs(androidText.INFO, "DIT Button not found");
//	}

		return this;
	}
	
	
	public EnvironmentPicker SetEnvironment() throws Exception {
		logs.setupTest("ENVIRONMENT SELECTOR");
		Thread.sleep(2000);
//TODO un-comment wanted environment		
//~~ACPT TEST~~
//		setEnviroment("TEST");
//		logs.CapturedLogs(androidText.INFO, "ACPT TEST selected as testing option ");
		
////~~PARTNER TEST~~
		setEnviroment("PARTNER");
		logs.CapturedLogs(androidText.INFO, "PARTNER selected as testing option");

//~~AWS SIT~~
//		setEnviroment("AWSSIT");
//		logs.CapturedLogs(androidText.INFO, "AWSSIT selected as testing option");
		
//~~AWS DIT~~
//		setEnviroment("AWSDIT");
//		logs.CapturedLogs(androidText.INFO, "AWSDIT selected as testing option");
		
//~~DIT~~
//		setEnviroment("DIT");
//		logs.CapturedLogs(androidText.INFO, "DIT selected as testing option");

		return this;
	}
	
	
	public EnvironmentPicker EnvironmentPickerButtonSelect(String envSet) throws Exception {
	logs.setupTestYellow("ENVIRONMENT BUTTON PICKER");
	logs.CapturedLogs(androidText.INFO, "Finding Environment Button");
	String env = envSet;
	
	Thread.sleep(2000);
	
	
	int envNum;
	switch (env) {
	case "PARTNER":  envNum = 1;
	WebElement PartnerButton=elements.PartnerButton();
	if (PartnerButton !=null &&  PartnerButton.isEnabled()){
		PartnerButton.click();
		logs.CapturedLogs(androidText.PASS, "PARTNER Server selected as testing option");
	}else {
	logs.CapturedLogs(androidText.INFO, "PARTNER Button not found could be that you already chose an environment");
	}
	break;
	
	
	case "AWSSIT":  envNum = 2;
	setEnviroment("AWSSIT");
	WebElement SITAWSButton=elements.SITAWSButton();
	if (SITAWSButton !=null && SITAWSButton.isEnabled()){
		SITAWSButton.click();
		logs.CapturedLogs(androidText.PASS, "SIT AWS Server selected as testing option");
	}else {
	logs.CapturedLogs(androidText.INFO, "SIT AWS Button not found could be that you already chose an environment");
	}
	break;	
	
	case "AWSDIT":  envNum = 3;
	setEnviroment("AWSDIT");
	WebElement AWSDITButton=elements.AWSDITButton();
	if (AWSDITButton !=null && AWSDITButton.isEnabled()){
		AWSDITButton.click();
		logs.CapturedLogs(androidText.PASS, "AWSDIT Button pressed");
	}else {
	logs.CapturedLogs(androidText.INFO, "AWSDIT Button not found");
	}
	break;
	
	case "DIT":  envNum = 5;
	setEnviroment("DIT");
	WebElement DITButton=elements.DITButton();
	if (DITButton !=null && DITButton.isEnabled()){
		DITButton.click();
		logs.CapturedLogs(androidText.PASS, "DIT Button pressed");
	}else {
	logs.CapturedLogs(androidText.INFO, "DIT Button not found");
	}
	break;
	
	case "TEST":  envNum = 6;
	setEnviroment("TEST");
	WebElement TestButton=elements.TestButton();
	if (TestButton !=null &&  TestButton.isEnabled()){
		TestButton.click();
		logs.CapturedLogs(androidText.PASS, "ACPT Test Server selected as testing option");
	}else {
	logs.CapturedLogs(androidText.INFO, "ACPT Test Button not found could be that you already chose an environment");
	}
	
	default: 
		logs.CapturedLogs(androidText.INFO, "No environement found");
	}
		return this;
}
	
	
	public EnvironmentPicker SetEnvironmentSelect(String envSet) throws Exception {
		String env = envSet;
		logs.setupTest("ENVIRONMENT SELECTOR");
		Thread.sleep(2000);
		
			
		int envNum;
		switch (env) {
		case "PARTNER":  envNum = 1;
		setEnviroment("PARTNER");
		logs.CapturedLogs(androidText.INFO, "PARTNER selected as testing option");
		break;
		
		case "AWSSIT":  envNum = 2;
		setEnviroment("AWSSIT");
		logs.CapturedLogs(androidText.INFO, "AWSSIT selected as testing option");
		break;
		
		
	
		case "AWSDIT":  envNum = 3;
		setEnviroment("AWSDIT");
		logs.CapturedLogs(androidText.INFO, "AWSDIT selected as testing option");
		break;
		
		
		
	
		case "DIT":  envNum = 4;
		setEnviroment("DIT");
		logs.CapturedLogs(androidText.INFO, "DIT selected as testing option");
		break;
		
		
		
		
		case "TEST":  envNum = 5;
		setEnviroment("TEST");
		logs.CapturedLogs(androidText.INFO, "ACPT TEST selected as testing option ");
		break;
		
		default: 
			logs.CapturedLogs(androidText.INFO, "No environement found");
		}
		

		return this;
	}
	

	public void setEnviroment(String env) {
//		System.out.println("SET ENVIROMENT: "+ enviroment);
		this.environment = env;
		System.out.println("SET ENVIROMENT: "+ environment);
	}
	
	
	public String getEnviroment() {
		System.out.println("GET ENVIROMENT: "+ environment);
		return environment;
	}

	
}