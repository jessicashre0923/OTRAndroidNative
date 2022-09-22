package androidSharedClasses;

import java.awt.Robot;
import java.awt.AWTException;


public class MoveMouse {

	public static void KeepMacAwake() throws AWTException
		    {
		    Robot robot = new Robot();

		   // robot.setAutoDelay(5);
		   // robot.setAutoWaitForIdle(true);

		    robot.mouseMove(0, 0);
		    robot.delay(1000);
		    robot.mouseMove(200, 10);
		    robot.delay(1000);
		    robot.mouseMove(40, 130);

		    System.exit(0);
		    }
}

