package robot.commands;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;
import robot.util.R_Gyro;

/**
 *
 */
public class TurnToAngle extends Command {

	double angle;
	R_Gyro gyro; 
			
    public TurnToAngle(double angle) {
        requires(Robot.chassisSubsystem);
        this.angle = angle;
        gyro = Robot.chassisSubsystem.gyro;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassisSubsystem.setSpeed(0);
    	gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	gyro.turn(angle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(gyro.getNormalizedAngle() >= angle){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassisSubsystem.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
