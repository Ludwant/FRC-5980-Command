package org.usfirst.frc.team5980.robot;

import edu.wpi.first.wpilibj.Encoder;

public class SensorInput {
	static Encoder leftEncoder = new Encoder(0, 1);
	static Encoder rightEncoder = new Encoder(2, 3);
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
