package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SimpleCommandGroup extends CommandGroup {
    
    public  SimpleCommandGroup() {
    	//Command Group for Position 1
    	addParallel(new LowerArmAuto());
    	addSequential(new DriveForwardAuto(231, 0.55, 0));
    	addSequential(new RotateToHeading(-59, 0.3));
    	addSequential(new DriveForwardAuto(120, 0.5, -60));
    	addSequential(new BallShootAutonomous());
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
