package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcadeDriveCommand extends Command {
	//Command for using Arcade drive with the drive train
    public ArcadeDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Gets the joystick values and makes the left one the throttle and the right one turning
    	double throttle = -Robot.oi.joystickDrive.getRawAxis(1);
    	double turning = -Robot.oi.joystickDrive.getRawAxis(4);
    	double leftPower = throttle-turning;
    	double rightPower = throttle+turning;
    	if(leftPower >1) {
    		leftPower = 1;
    	}
    	else if (leftPower < -1) {
    		leftPower = -1;
    	}
    	if(rightPower >1) {
    		rightPower = 1;
    	}
    	else if (rightPower < -1) {
    		rightPower = -1;
    	}
    	if (Math.abs(leftPower) < 0.15) {
    		leftPower = 0;
    	}
    	if (Math.abs(rightPower) < 0.15) {
    		rightPower = 0;
    	}
    	Robot.drive.setDrivePower(leftPower, rightPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
