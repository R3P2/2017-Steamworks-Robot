package robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.RobotMap;
import robot.commands.JoystickCommand;
import robot.util.R_Gyro;
import robot.util.R_Victor;

public class ChassisSubsystem extends Subsystem {

	Encoder leftEncoder = new Encoder(RobotMap.ENCODER_LEFT_PORT_1, RobotMap.ENCODER_LEFT_PORT_2);
	Encoder rightEncoder = new Encoder(RobotMap.ENCODER_RIGHT_PORT_1, RobotMap.ENCODER_RIGHT_PORT_2);

	DoubleSolenoid PistonOne = new DoubleSolenoid(RobotMap.SOLENOID_ONE_1, RobotMap.SOLENOID_ONE_2);
	DoubleSolenoid PistonTwo = new DoubleSolenoid(RobotMap.SOLENOID_TWO_2, RobotMap.SOLENOID_TWO_1);

	DigitalInput proximitySensor = new DigitalInput(RobotMap.PROXIMITY_SENSOR_PORT);

	R_Victor leftMotor = new R_Victor(RobotMap.LEFT_MOTOR_PORT, RobotMap.MotorSensitivity);
	R_Victor rightMotor = new R_Victor(RobotMap.RIGHT_MOTOR_PORT, RobotMap.MotorSensitivity);

	R_Victor climbMotor = new R_Victor(RobotMap.CLIMB_MOTOR_PORT, 0.3);

	// public SPI gyro = new SPI(RobotMap.GYRO_PORT);
	
	public R_Gyro gyro = new R_Gyro(RobotMap.GYRO_PORT);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new JoystickCommand());
		rightMotor.setInverted(true);
		rightEncoder.setReverseDirection(true);
		gyro.calibrate();
	}

	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

	public double getEncoderRate() {
		return (leftEncoder.get() + rightEncoder.get()) / 2;
	}

	public void setPistons(boolean state) {
		PistonOne.set(state ? Value.kForward : Value.kReverse);
		PistonTwo.set(state ? Value.kForward : Value.kReverse);
	}

	public void startClimb(double speed) {
		if (speed > 0.3 || speed < -0.3) {
			climbMotor.set(Math.abs(speed));
		} else {
			climbMotor.set(0);
		}
	}

	public void setSpeed(double speed) {

		leftMotor.set(speed);
		rightMotor.set(speed);

	}

	public void setMovementTele(double speed, double turn) {

		double EncoderRate = getEncoderRate();

		if (turn > 0.1 || turn < -0.1) {
			if (turn > 0) {
				leftMotor.setPID(turn, EncoderRate);
				rightMotor.setPID(-turn, EncoderRate);
			} else {
				leftMotor.setPID(-turn, EncoderRate);
				rightMotor.setPID(turn, EncoderRate);
			}
		} else {
			leftMotor.setPID(speed, EncoderRate);
			rightMotor.setPID(speed, EncoderRate);
		}

	}

	public void setMovementAuto(double speed, double turn) {

		double EncoderRate = getEncoderRate();
		
		if (turn != 0) {
			if (turn > 0) {
				leftMotor.setPID(turn, EncoderRate);
				rightMotor.setPID(-turn, EncoderRate);
			} else {
				leftMotor.setPID(-turn, EncoderRate);
				rightMotor.setPID(turn, EncoderRate);
			}
		} else {
			leftMotor.setPID(speed, EncoderRate);
			rightMotor.setPID(speed, EncoderRate);
		}
	}

	public boolean getProximity() {

		return proximitySensor.get();

	}

	public void callSmartdashboard() {
		// SmartDashboard.putData("Gyro", gyro);
		SmartDashboard.putData("Left Motor", leftMotor);
		SmartDashboard.putData("Right Motor", rightMotor);
		SmartDashboard.putData("Left Encoder", rightEncoder);
		SmartDashboard.putData("Right Encoder", leftEncoder);
		SmartDashboard.putNumber("Gyro", gyro.getNormalizedAngle());
		SmartDashboard.putBoolean("Proximity Sensor", getProximity());
		//TODO: Gear Visual
		SmartDashboard.putNumber("Robot Gear", RobotMap.MotorSensitivity);
	}

}
