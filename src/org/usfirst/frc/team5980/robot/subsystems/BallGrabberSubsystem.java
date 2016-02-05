package org.usfirst.frc.team5980.robot.subsystems;



import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallGrabberSubsystem extends Subsystem {
    
    Victor ballGrabMotor = new Victor(4);
    
    public void setGrabPower(double power)
    {
    	ballGrabMotor.set(power);
    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	//setDefaultCommand(new BallGrabCommand());
    	
    	
    }
}

