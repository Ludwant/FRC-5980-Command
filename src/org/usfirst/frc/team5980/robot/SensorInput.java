package org.usfirst.frc.team5980.robot;



import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;

public class SensorInput {
	static Encoder leftEncoder = new Encoder(0, 1);
	static Encoder rightEncoder = new Encoder(2, 3);
	static AHRS navx;
	public SensorInput() {
		try {
			navx = new AHRS(SPI.Port.kMXP);
		}
		catch(RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
		}
	}
	public static float getYaw() {
		float yaw;
		yaw = navx.getYaw();
		return yaw;
	}
	public static float getPitch() {
		float pitch;
		pitch = navx.getPitch();
		return pitch;
	}
	public static float getRoll() {
		float roll;
		roll = navx.getRoll();
		return roll;
	}
	public static void resetNavX() {
		navx.reset();
	}
	public static double getLeftEncoder() {
		double encoderValue;
		encoderValue = leftEncoder.get();
		return encoderValue;
	}
	public static double getRightEncoder() {
		double encoderValue;
		encoderValue = rightEncoder.get();
		return encoderValue;
	}
	
	public static void resetRightEncoder() {
		rightEncoder.reset();
	}
	
	public static void resetLeftEncoder() {
		leftEncoder.reset();
	}
}
