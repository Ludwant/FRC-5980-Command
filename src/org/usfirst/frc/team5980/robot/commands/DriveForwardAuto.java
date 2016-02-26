package org.usfirst.frc.team5980.robot.commands;

import org.usfirst.frc.team5980.robot.Robot;
import org.usfirst.frc.team5980.robot.RobotPID;
import org.usfirst.frc.team5980.robot.SensorInput;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveForwardAuto extends Command {
	RobotPID drivePID = new RobotPID(0.03, 0, 0);
	RobotPID stopPID = new RobotPID(0.01, 0, 0);
	RobotPID coordinatePID = new RobotPID(0.04, 0, 0);
	int distance;
	double encoderTarget;
	double maxSpeed;
	double heading;
	double speed = 0;
    public DriveForwardAuto(int distance, double speed, double heading) {
        // Use requires() here to declare subsystem dependencies
    	this.distance = distance;
    	this.maxSpeed = speed;
    	this.heading = heading;
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	encoderTarget = Robot.sensors.getRightEncoder() + distance * SensorInput.encoderCountsPerInch;
    	drivePID.setTarget(heading);
    	stopPID.setTarget(encoderTarget);
    	coordinatePID.setTarget(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double stopCorrection = stopPID.getCorrection(Robot.sensors.getRightEncoder());
    	if(stopCorrection > 1) {
    		stopCorrection = 1;
    	}
    	double correction = drivePID.getCorrection(Robot.sensors.getYaw());
    	if(heading == 0) {
    		correction += coordinatePID.getCorrection(Robot.sensors.getY());
    	}
    	if(speed < maxSpeed) {
    		speed += 0.03;
    	}
    	Robot.drive.setDrivePower((speed-correction)*stopCorrection, (speed+correction)*stopCorrection);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.sensors.getRightEncoder() > encoderTarget-200;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.setDrivePower(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
