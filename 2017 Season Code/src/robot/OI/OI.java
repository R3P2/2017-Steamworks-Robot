package robot.OI;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	GameController gameController = new XBoxController(0);

	public double getSpeed() {
		if (gameController.getLeftTriggerAxis() > 0.15) {
			return -(gameController.getLeftTriggerAxis());
		} else if (gameController.getRightTriggerAxis() > 0.15) {
			return gameController.getRightTriggerAxis();
		} else {
			return 0;
		}
	}

	public double getTurn() {

		return gameController.getRightXAxis();

	}

	public double getClimbAxis() {
		return gameController.getLeftYAxis();
	}

	public boolean getDriveForward() {

		return gameController.isADown();

	}

	public boolean isDumpButton() {
		return gameController.isBDown();
	}

	public boolean isTurnToAngle() {
		return gameController.isXDown();
	}
	
	public boolean gearUp() {
		return gameController.isRightBumperDown();
	}
	
	public boolean gearDown() {
		return gameController.isLeftBumperDown();
	}
	
	public boolean switchForward() {
		return gameController.isButton1Down();
	}
	
	public boolean switchBackwards() {
		return gameController.isButton2Down();
	}
	
	

}
