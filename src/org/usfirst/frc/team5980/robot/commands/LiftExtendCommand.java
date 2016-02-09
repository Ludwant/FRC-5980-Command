package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftExtendCommand extends Command {
	int encoderTarget = -5760;
    public LiftExtendCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.lift.setLiftPower(0.7);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.sensors.getLiftEncoder() > -5760;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.setLiftPower(0);
    	Robot.sensors.resetLiftEncoder();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.lift.setLiftPower(0);
    	
    }
}
