package androidSharedClasses;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AndroidRecorder {

	public AndroidRecorder() {
		// no-arg constructor
	}

	public void ScreenShot(String desc) {
		AndroidLogs location = new AndroidLogs();
		// TODO make it so the image has a new name every time it is made and use the new
		// name for the Basic extent.
		try {
			
			// takes a screenshot and saves it in a file
			File screenshot = ((TakesScreenshot) Capabilities.driver).getScreenshotAs(OutputType.FILE);
			// copy the file to the required path
			//FileUtils.copyFile(screenshot, new File(location.getDirPath() + "Capture.jpeg"));
			FileUtils.copyFile(screenshot, new File(location.getDirPath() + "Android_" + desc + ".jpeg"));
		
			
		} catch (Exception e) {
			// if it fails to take screenshot then this block will execute
			System.out.println("Failure to take screenshot " + e);
		}
	}

	public void StartPixelRecorder(String args[]) throws InterruptedException, IOException {

		// Activate Terminal
		try {
			String[] go = { "osascript", "-e", "tell application \"Terminal\" to activate" };
			Process process = Runtime.getRuntime().exec(go);
			process.waitFor();

		} catch (IOException ex) {
			System.out.println(ex.toString());
		} catch (InterruptedException ex) {
			System.out.println(ex.toString());
		}

		// Open ScreenRecorder
		System.out.println("Phone recorder started.");

		String cmd = "/Users/W446813/AutomationLogs/logs/Recording/RecordingManager/PixelRecorder.sh";
		String pixelRecord = "/Users/W446813/AutomationLogs/logs/Recording/RecordingManager/PixelRecorder.sh";

		System.out.println("cmd = " + cmd);
		ProcessBuilder pbStart = new ProcessBuilder("open", "-a", cmd, pixelRecord);
		pbStart.redirectErrorStream(true);
		try {
			Process p = pbStart.start();
			// Thread t = new Thread(new InputStreamConsumer(p.getInputStream()));
			// t.start();
			int exitCode = p.waitFor();
			// t.join();
			System.out.println("Exited with " + exitCode);
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace();
		}

	}

	public void StartGalaxyS7Recorder(String args[]) throws InterruptedException, IOException {

		// Activate Terminal
		try {
			String[] go = { "osascript", "-e", "tell application \"Terminal\" to activate" };
			Process process = Runtime.getRuntime().exec(go);
			process.waitFor();

		} catch (IOException ex) {
			System.out.println(ex.toString());
		} catch (InterruptedException ex) {
			System.out.println(ex.toString());
		}

		// Open ScreenRecorder

		String cmd = "/Users/W446813/AutomationLogs/logs/Recording/RecordingManager/GalaxyS7Recorder.sh";
		String pixelRecord = "/Users/W446813/AutomationLogs/logs/Recording/RecordingManager/GalaxyS7Recorder.sh";

		System.out.println("cmd = " + cmd);
		ProcessBuilder pbStart = new ProcessBuilder("open", "-a", cmd, pixelRecord);
		pbStart.redirectErrorStream(true);
		try {
			Process p = pbStart.start();
			// Thread t = new Thread(new InputStreamConsumer(p.getInputStream()));
			// t.start();
			int exitCode = p.waitFor();
			// t.join();
			System.out.println("Exited with " + exitCode);
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace();
		}

	}

}
