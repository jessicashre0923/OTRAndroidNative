package androidSharedClasses;

public class LoginInfo {
	
	public String accountNum;
	public String passOrPin;
	public String env;
	private AndroidLogs androidLogs = new AndroidLogs();
	
	public LoginInfo() {}
	
	
	public String getAccountNum() {
		if(this.accountNum != null) {
			
			return accountNum.trim();
			
		}
		return accountNum;
	}
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	
	public String getPassOrPin() {
		
		if(this.passOrPin != null) {
			
			return passOrPin.trim();
			
		}
		
		
		return passOrPin;
	}
	public void setPassOrPin(String passOrPin) {
		this.passOrPin = passOrPin;
	}
	public String getEnv() {
		return env;
	}
	public void setEnv(String env) {
		
		this.env = env;
	}


	public AndroidLogs getAndroidLogs() {
		return androidLogs;
	}


	public void setAndroidLogs(AndroidLogs androidLogs) {
		this.androidLogs = androidLogs;
	}
	
	
}
