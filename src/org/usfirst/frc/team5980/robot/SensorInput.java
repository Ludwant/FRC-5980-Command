package org.usfirst.frc.team5980.robot;



import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;

public class SensorInput {
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
		try {
			navx = new AHRS(SPI.Port.kMXP);
		}
		catch(RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
		}
	}
	public float getYaw() {
		float yaw;
		yaw = navx.getYaw();
		return -yaw;
	}
	public float getPitch() {
		float pitch;
		pitch = navx.getPitch();
		return pitch;
	}
	public float getRoll() {
		float roll;
		roll = navx.getRoll();
		return roll;
	}
	public void resetYaw() {
		navx.zeroYaw();
	}
	public int getLeftEncoder() {
		int encoderValue;
		encoderValue = leftEncoder.get();
		return -encoderValue;
	}
	public int getRightEncoder() {
		int encoderValue;
		encoderValue = rightEncoder.get();
		return encoderValue;
	}
	
	public int getLiftEncoder() {
		return liftEncoder.get(); 
	}
	
	public void resetRightEncoder() {
		rightEncoder.reset();
	}
	
	public void resetLeftEncoder() {
		leftEncoder.reset();
	}
	
	public void resetLiftEncoder() {
		liftEncoder.reset();
	}
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
	public double getX() {
		return x / encoderCountsPerInch;
	}
	public double getY() {
		return y / encoderCountsPerInch;
	}
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
