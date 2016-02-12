package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;
import org.usfirst.frc.team5980.robot.RobotPID;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateToHeading extends Command {
	RobotPID turnPID = new RobotPID(.1, 0 , 0);
	long stopTime;
	float heading;
	double speed;
    public RotateToHeading(float heading, double speed) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
        this.heading = heading;
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	turnPID.setTarget(heading);
    	stopTime = System.currentTimeMillis() + 3000;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// The correction is going to be a factor between -1 and 1
    	//    that multiplies the speed.  Think of the correction as a percentage
    	//    of the full speed, which you're calling "speed."  Since you want to 
    	//    rotate (spin), you want the power to the two motors to be equal in 
    	//    magnitude and opposite
    	double correction = turnPID.getCorrection(Robot.sensors.getYaw());
    	if (Math.abs(correction) > 1) {
    		if (correction > 1) correction = 1;
    		else correction = -1;
    	}
    	Robot.drive.setDrivePower(-speed * correction, speed * correction);
    	//Robot.drive.setDrivePower(speed+correction, speed-correction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// You need to determine when to finish the command!
    	
        return Math.abs(Robot.sensors.getYaw() - heading) < 2 || 
        		System.currentTimeMillis() > stopTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
