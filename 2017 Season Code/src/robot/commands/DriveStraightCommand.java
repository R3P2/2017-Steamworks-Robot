package robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import robot.Robot;
import robot.RobotMap;

public class DriveStraightCommand extends Command {

	private double distance; 	// In feet
	//private double time; 	// In seconds
	private double speed;
	
	
    public DriveStraightCommand(double distance, double speed) {
        requires(Robot.chassisSubsystem);
        this.distance = distance * RobotMap.MAX_ENCODER_COUNTS_PER_FT;
        //this.time = time;
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassisSubsystem.setSpeed(0);
    	Robot.chassisSubsystem.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassisSubsystem.setSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.chassisSubsystem.getEncoderRate() >= distance){
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
