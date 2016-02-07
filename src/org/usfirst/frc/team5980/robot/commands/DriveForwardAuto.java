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
	RobotPID stopPID = new RobotPID((1/2636), 0, 0);
	int distance;
	double encoderTarget;
	double speed;
	double heading;
    public DriveForwardAuto(int distance, double speed, double heading) {
        // Use requires() here to declare subsystem dependencies
    	this.distance = distance;
    	this.speed = speed;
    	this.heading = heading;
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	encoderTarget = Robot.sensors.getRightEncoder() + distance * SensorInput.encoderCountsPerInch;
    	drivePID.setTarget(heading);
    	stopPID.setTarget(encoderTarget);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double stopCorrection = stopPID.getCorrection(Robot.sensors.getRightEncoder());
    	if(stopCorrection > 1) {
    		stopCorrection = 1;
    	}
    	double correction = drivePID.getCorrection(Robot.sensors.getYaw());
    	Robot.drive.setDrivePower((speed-correction)*stopCorrection, (speed+correction)*stopCorrection);
    	SmartDashboard.putNumber("Encoder Value:", Robot.sensors.getRightEncoder());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.sensors.getRightEncoder() > encoderTarget;
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
