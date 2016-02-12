package org.usfirst.frc.team5980.robot.subsystems;

import org.usfirst.frc.team5980.robot.commands.ArcadeDriveCommand;
import org.usfirst.frc.team5980.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    Victor leftBackMotor = new Victor(0);
    Victor leftFrontMotor = new Victor(1);
    Victor rightBackMotor = new Victor(2);
    Victor rightFrontMotor = new Victor(3);
   
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void setDrivePower(double leftPower, double rightPower) {
    	rightBackMotor.setInverted(true);
    	rightFrontMotor.setInverted(true);
    	leftBackMotor.set(leftPower);
    	leftFrontMotor.set(leftPower);
    	rightBackMotor.set(rightPower);
    	rightFrontMotor.set(rightPower);
    	SmartDashboard.putNumber("Left Motor Power:", leftPower);
    	SmartDashboard.putNumber("Right Motor Power:", rightPower);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArcadeDriveCommand());
    }
}

