package org.usfirst.frc.team5980.robot;



import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;

public class SensorInput {
	//initializes all of the sensors for use in commands
	public static double encoderCountsPerInch = 33;
	static Encoder leftEncoder = new Encoder(0, 1);
	static Encoder rightEncoder = new Encoder(2, 3);
	static Encoder liftEncoder = new Encoder(4, 5);
	double x = 0;
	double y = 0;
	double lastLeftEncoder;
	double lastRightEncoder;
	static AHRS navx;
	//static DigitalInput liftExtendLimit = new DigitalInput(4);
	//static DigitalInput liftRetractLimit = new DigitalInput(5);
	public SensorInput() {
		//try catch statement for initializing the NavX
		try {
			navx = new AHRS(SPI.Port.kMXP);
		}
		catch(RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
		}
	}
	//method for getting the yaw of the NavX
	public float getYaw() {
		float yaw;
		yaw = navx.getYaw();
		return -yaw;
	}
	//method for getting the pitch of the NavX
	public float getPitch() {
		float pitch;
		pitch = navx.getPitch();
		return pitch;
	}
	//method for getting the Roll of the NavX
	public float getRoll() {
		float roll;
		roll = navx.getRoll();
		return roll;
	}
	//method for resetting the yaw of the NavX
	public void resetYaw() {
		navx.zeroYaw();
	}
	//method for getting the left encoder value on the drive train
	public int getLeftEncoder() {
		int encoderValue;
		encoderValue = leftEncoder.get();
		return -encoderValue;
	}
	//method for getting the right encoder of the drive train
	public int getRightEncoder() {
		int encoderValue;
		encoderValue = rightEncoder.get();
		return encoderValue;
	}
	//getting the value of the lift encoder
	public int getLiftEncoder() {
		return liftEncoder.get(); 
	}
	//resets the right drive train encoder
	public void resetRightEncoder() {
		rightEncoder.reset();
	}
	//resets the left drive train encoder
	public void resetLeftEncoder() {
		leftEncoder.reset();
	}
	//resets the lift encoder
	public void resetLiftEncoder() {
		liftEncoder.reset();
	}
	//updates the coordinate system for DriveForwardAuto
	public void updatePosition() {
		double leftEncoderValue = getLeftEncoder();
		double rightEncoderValue = getRightEncoder();
		double changeInLeft = leftEncoderValue - lastLeftEncoder;
		double changeInRight = rightEncoderValue - lastRightEncoder;
		double distance = (changeInLeft+changeInRight)/2;
		x += distance * Math.cos(Math.toRadians(getYaw()));
		y += distance * Math.sin(Math.toRadians(getYaw()));
		lastLeftEncoder = leftEncoderValue;
		lastRightEncoder = rightEncoderValue;
	}
	//gets the x value of the coordinate system
	public double getX() {
		return x / encoderCountsPerInch;
	}
	//gets the y value of the coordinate system
	public double getY() {
		return y / encoderCountsPerInch;
	}
	//resets the coordinate system
	public void resetPosition() {
		x = 0;
		y = 0;
		resetRightEncoder();
		resetLeftEncoder();
		lastLeftEncoder = 0;
		lastRightEncoder = 0;
	}
	/*
	public boolean getExtendLimitBool() {
		return liftExtendLimit.get();
	}
	public boolean getRetractLimitBool() {
		return liftRetractLimit.get();
	}
	*/
}
