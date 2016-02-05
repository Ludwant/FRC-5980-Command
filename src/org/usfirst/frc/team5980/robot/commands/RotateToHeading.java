package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;
import org.usfirst.frc.team5980.robot.RobotPID;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateToHeading extends Command {
	RobotPID turnPID = new RobotPID(.05, 0 , 0);
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
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double correction = turnPID.getCorrection(Robot.sensors.getYaw());
    	Robot.drive.setDrivePower(speed+correction, speed-correction);
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
