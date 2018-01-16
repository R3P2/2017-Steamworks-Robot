package robot.util;

import edu.wpi.first.wpilibj.AnalogGyro;
import robot.Robot;

public class R_Gyro extends AnalogGyro{

	public R_Gyro(int channel) {
		super(channel);
		// TODO Auto-generated constructor stub
	}
	
	
//	public double getAngleDifference(double targetAngle) {
//		double currentAngle = getRawAngle(getAngle());
//		double difference = targetAngle - currentAngle;
//		
//		if (difference > 180) {
//			difference -= 360;
//		} else if (difference < -180) {
//			difference += 360;
//		}
//		
//		return difference;
//	}
	
	public double getRawAngle(){
		return -getAngle() % 360;
	}
	
	public double getNormalizedAngle(){
		
		double angle = getRawAngle();
		
		if(angle > 180){
			return -angle % 180;
		}else{
			return angle;
		}
	}
	
	public void turn(double angle){
		double speed;
		speed = (angle > 0)? 0.25: -0.25;
		Robot.chassisSubsystem.setMovementAuto(1.0, speed);
	}

}
