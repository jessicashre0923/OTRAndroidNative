package androidSharedClasses;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollOptions {
	AndroidLogs androidLogs = new AndroidLogs();
	Sleep appSleep = new Sleep();
	AppStringsAndroid androidText = new AppStringsAndroid();

	public ScrollOptions() {
	}

	public ScrollOptions Refresh() throws Exception {

		try {
			// this is the long press move to new location on screen needed for pull to
			// refresh
			new TouchAction<>(Capabilities.driver).longPress(PointOption.point(700, 410))
					.moveTo(PointOption.point(700, 1110)).release().perform();
			appSleep.ThreadSleep1();
			androidLogs.CapturedLogs(androidText.INFO, "Pull to refresh completed");
		} catch (org.openqa.selenium.WebDriverException e) {
			System.err.format("IOException: %s%n", e);
			System.out.println(e.getMessage());
			androidLogs.CapturedLogs(androidText.FAIL, "Pull to refresh failed.");
		}

		return this;
	}

	public ScrollOptions ScrollDown() throws Exception {

		try {
			// this is the long press move to new location on screen needed for pull to
			// refresh
			new TouchAction<>(Capabilities.driver).longPress(PointOption.point(700, 1400))
					.moveTo(PointOption.point(700, 500)).release().perform();
			appSleep.ThreadSleep1();
			androidLogs.CapturedLogs(androidText.INFO, "Scroll down completed");
		} catch (org.openqa.selenium.WebDriverException e) {
			System.err.format("IOException: %s%n", e);
			System.out.println(e.getMessage());
			androidLogs.CapturedLogs(androidText.FAIL, "Scroll down failed");
		}

		return this;
	}

	public ScrollOptions ScrollUp() throws Exception {

		try {
			new TouchAction<>(Capabilities.driver).longPress(PointOption.point(700, 500))
					.moveTo(PointOption.point(700, 1400)).release().perform();
			appSleep.ThreadSleep1();
			androidLogs.CapturedLogs(androidText.INFO, "Scroll up completed");
		} catch (org.openqa.selenium.WebDriverException e) {
			System.err.format("IOException: %s%n", e);
			System.out.println(e.getMessage());
			androidLogs.CapturedLogs(androidText.FAIL, "Scroll up failed");
		}

		return this;
	}
}
