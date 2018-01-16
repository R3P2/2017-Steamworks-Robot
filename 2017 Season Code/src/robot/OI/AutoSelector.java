package robot.OI;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoSelector {

	SendableChooser<String> robotPosition;
	SendableChooser<String> boilerPosition;
	SendableChooser<String> autoPath;

	public AutoSelector() {

		robotPosition.addDefault("Left", "Left");
		robotPosition.addObject("Center", "Center");
		robotPosition.addObject("Right", "Right");

		boilerPosition.addDefault("Left", "Left");
		boilerPosition.addObject("Right", "Right");

		autoPath.addDefault("Base Line", "Base Line");
		autoPath.addObject("Gear", "Gear");
		autoPath.addObject("Shoot", "Shoot");
		autoPath.addObject("Gear and Shoot", "Gear and Shoot");

	}

	public void updateSmartDashboard() {

		SmartDashboard.putData("Robot Position", robotPosition);
		SmartDashboard.putData("Boiler Position", boilerPosition);
		SmartDashboard.putData("Auto Path", autoPath);

	}

	public enum RobotPosition {

		LEFT(1), CENTER(2), RIGHT(3);

		public int side;

		RobotPosition(int side) {

			this.side = side;

		}

	}

	public enum BoilerPosition {

		LEFT(1), RIGHT(3);

		public int side;
		
		BoilerPosition(int side){
			
			this.side = side;
			
		}

	}

	public enum AutoPath {

		BASE_LINE, GEAR, SHOOT, GEAR_AND_SHOOT;

	}

	public RobotPosition getRobotPosition() {

		switch (robotPosition.getSelected()) {

		case "Left":
			return RobotPosition.LEFT;
		case "Center":
			return RobotPosition.CENTER;
		case "Right":
			return RobotPosition.RIGHT;
		default:
			return RobotPosition.LEFT;
		}

	}

	public BoilerPosition getBoilerPosition() {

		switch (boilerPosition.getSelected()) {

		case "Left":
			return BoilerPosition.LEFT;
		case "Right":
			return BoilerPosition.RIGHT;
		default:
			return BoilerPosition.LEFT;
		}

	}

	public AutoPath getAutoPath() {

		switch (autoPath.getSelected()) {

		case "Base Line":
			return AutoPath.BASE_LINE;
		case "Gear":
			return AutoPath.GEAR;
		case "Shoot":
			return AutoPath.SHOOT;
		case "Gear and Shoot":
			return AutoPath.GEAR_AND_SHOOT;
		default:
			return AutoPath.BASE_LINE;
		}
	}
}
