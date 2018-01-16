package robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import robot.RobotMap;
import robot.OI.AutoSelector.AutoPath;
import robot.OI.AutoSelector.BoilerPosition;
import robot.OI.AutoSelector.RobotPosition;
import robot.commands.DriveStraightCommand;
import robot.commands.DumpCommand;
import robot.commands.TurnToAngle;

/**
 *
 */
public class AutoCommands extends CommandGroup {

	RobotPosition robotPosition;
	BoilerPosition boilerPosition;
	AutoPath autopath;

	public AutoCommands(RobotPosition robotPosition, BoilerPosition boilerPosition, AutoPath autopath) {

		boolean doesBoilerMatch = robotPosition.side == boilerPosition.side;
		//Move forward for the baseline
//		addSequential(new DriveStraightCommand(RobotMap.BASE_LINE_DISTANCE, 10, 1));
//
//		if (autopath == AutoPath.GEAR || autopath == AutoPath.GEAR_AND_SHOOT) {
//
//			//Now we know we are doing gears
//			
//			if (robotPosition != RobotPosition.CENTER) {
//				
//				//We have to adjust for the slanted airship since we are
//				//not in the center
//				
//				if (robotPosition == RobotPosition.LEFT) {
//
//					//Now we have to turn to the right
//					addSequential(new TurnToAngle(RobotMap.GEAR_ANGLE));
//
//				} else {
//
//					//Now we have to turn to the left
//					addSequential(new TurnToAngle(-RobotMap.GEAR_ANGLE));
//
//				}
//				
//				//We have to move the extra distance for the slant
//				addSequential(new DriveStraightCommand(RobotMap.BASELINE_TO_GEAR_DISTANCE, 5, 0.75));
//
//				if (autopath == AutoPath.GEAR_AND_SHOOT && doesBoilerMatch) {
//
//					//If we are moving to shoot, we have to move backwards
//					addSequential(new DriveStraightCommand(RobotMap.GEAR_TO_BOILER_DISTANCE, 5, 0.75));
//					addSequential(new DumpCommand());
//
//				}
//			}
//
//		}else if (autopath == AutoPath.SHOOT){
//			
//			//distance if robot is in center
//			double distance = 5;
//			int angle;
//			
//			//drive to baseline
//			addSequential(new DriveStraightCommand(-RobotMap.BASE_LINE_DISTANCE, 10, 0.85));
//			
//			if(robotPosition == RobotPosition.LEFT){
//				distance = 7;
//			}else if(robotPosition == RobotPosition.RIGHT){
//				distance = 4;
//			}
//			
//			if(boilerPosition == BoilerPosition.RIGHT){
//				angle = 90;
//			}else{
//				angle = -90;
//			}
//			
//			addSequential(new TurnToAngle(angle));
//			addSequential(new DriveStraightCommand(distance, 10, 1));
//			addSequential(new TurnToAngle(angle));
//			addSequential(new DriveStraightCommand(RobotMap.BASELINE_TO_BOILER_DISTANCE, 10, 0.75));

		}




	}
//
//}
