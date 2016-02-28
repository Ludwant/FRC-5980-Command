package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerArmAuto extends Command {
	double stopTime;
    public LowerArmAuto() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Sets a variable for 2 seconds ahead
    	stopTime = System.currentTimeMillis() + 2000;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Sets the arm to lower
    	Robot.arm.setArmPower(-0.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//Checks whether the time is less than 2 seconds in the future. This makes it so 
    	//the motor turns off after 2 seconds
        return stopTime < System.currentTimeMillis();
    }

    // Called once after isFinished returns true
    protected void end() {
    	//turns off the arm
    	Robot.arm.setArmPower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//Robot.arm.setArmPower(0);
    }
}
