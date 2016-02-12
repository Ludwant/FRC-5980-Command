package org.usfirst.frc.team5980.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
    
	Victor armMotor = new Victor(6);
	
	public void setArmPower(double power)
    {
    	armMotor.set(power);
    }
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

