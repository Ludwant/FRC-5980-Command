package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerArmChevalAuto extends Command {
	double stopTime;
    public LowerArmChevalAuto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stopTime = System.currentTimeMillis() + 2000;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arm.setArmPower(-0.1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return stopTime < System.currentTimeMillis();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.setArmPower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
