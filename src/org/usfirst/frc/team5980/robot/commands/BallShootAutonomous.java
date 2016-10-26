package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/*
 *
 */
public class BallShootAutonomous extends Command {
	double stopTime;
    public BallShootAutonomous() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.grabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stopTime = System.currentTimeMillis() + 1000;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Turns the motor on 
    	Robot.grabber.setGrabPower(-1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stopTime < System.currentTimeMillis();
    }

    // Called once after isFinished returns true
    protected void end() {
    	//turns the motor off 
    	Robot.grabber.setGrabPower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//turns the motor off when command is interrupted
    	Robot.grabber.setGrabPower(0);
    }
}
