package androidSharedClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sleep {

	
	private static final WebElement Element = null;


	public Sleep() {
	}

	
	
	public Sleep WaitOrSleep3000(String xpath) throws Exception {
	
	
		WebDriverWait wait = new WebDriverWait(Capabilities.driver, 3000);
	//wait.until(ExpectedConditions.presenceOfElementLocated(locator);
	//wait.until(ExpectedConditions.visibilityOfAllElements(HelpScreenContinue));
		return this;
	}
	

	
	
	
	public Sleep ThreadSleep3000() throws Exception {

		try {
			Thread.sleep(3000, 3000);
			System.out.println("App Sleeps 3000, 3000");

		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}

		return this;
	}

	public Sleep ThreadSleep1() throws Exception {

		try {
			Thread.sleep(1); // put to sleep to load next automation.
			
		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}

		return this;
	}

	public Sleep ThreadSleep2000() throws Exception {

		try {
			Thread.sleep(2000); // put to sleep to load next automation.
		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}

		return this;
	}
	
	
	public Sleep Sleep9() throws Exception {

		try {
			 TimeUnit.SECONDS.sleep(9); // put to sleep to load next automation.
			 System.out.println("Sleep 15 seconds");

		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}

		return this;
	}
}
