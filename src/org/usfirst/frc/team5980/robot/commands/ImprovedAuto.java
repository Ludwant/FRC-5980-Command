package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ImprovedAuto extends CommandGroup {
    
    public  ImprovedAuto() {
    	//Command Group for Position 1
    	addParallel(new LowerArmAuto());
    	addSequential(new DriveForwardAuto(227, 0.7, 0));
    	addSequential(new RotateToHeading(-59, 0.4));
    	addSequential(new DriveForwardAuto(120, 0.7, -60));
    	addSequential(new BallShootAutonomous());
    	//addParallel(new RaiseArmAuto());
    	addSequential(new RotateToHeading(120, 0.5));
    	addSequential(new DriveForwardAuto(120, 0.7, 120));
    	addSequential(new RotateToHeading(180, 0.5));
    	addSequential(new DriveForwardAuto(231, 0.7, 180));
    	
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
