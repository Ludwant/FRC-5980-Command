package org.usfirst.frc.team5980.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ChevalPosition5Auto extends CommandGroup {
    
    public  ChevalPosition5Auto() {
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
    	addSequential(new DriveBackwardsAuto(-47, 0.5, 0));
    	addSequential(new LowerArmAuto());
    	addSequential(new DriveBackwardsAuto(-240, 0.7, 0));
    	addParallel(new RaiseArmAuto());
    	addSequential(new RotateToHeading(-120, 0.5));
    	addSequential(new DriveForwardAuto(80, 0.5, -120));
    	addSequential(new BallShootAutonomous());
    }
}
