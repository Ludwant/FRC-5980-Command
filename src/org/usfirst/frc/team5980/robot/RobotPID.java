package org.usfirst.frc.team5980.robot;

public class RobotPID {
	double kp, ki, kd;
	double target;
	double alpha = 0.8;
	double totalError = 0;
	double lastError = 0;
	
	public RobotPID(double kp, double ki, double kd) {
		this.kp = kp;
		this.ki = ki;
		this.kd = kd;
	}
	public void setTarget(double t) {
		target = t;
	}
	
	public double getCorrection(double current) {
		double error = target - current;
		totalError = alpha * totalError + error;
		double changeInError = error - lastError;
		double correction = kp * error + ki * totalError + kd * changeInError;
		lastError = error;
		return correction;
	}
	
}
