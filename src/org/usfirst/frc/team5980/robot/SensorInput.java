package org.usfirst.frc.team5980.robot;



import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;

public class SensorInput {
	public static double encoderCountsPerInch = 1440/3.13/Math.PI;
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
		return encoderValue;
	}
	public int getRightEncoder() {
		int encoderValue;
		encoderValue = rightEncoder.get();
		return encoderValue;
	}
	
	public void resetRightEncoder() {
		rightEncoder.reset();
	}
	
	public void resetLeftEncoder() {
		leftEncoder.reset();
	}
}
