package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarAutoWithBackOut extends CommandGroup {
    
    public  LowBarAutoWithBackOut() {
    	
    	addSequential(new SimpleCommandGroup()); //Runs the standard autonomous, ending with shooting the ball
    	addSequential(new DriveBackwardsAuto(-50, 0.5, -60)); //Drives Backwards off of the Batter

    }
}
