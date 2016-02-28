package org.usfirst.frc.team5980.robot.subsystems;



import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftSubsystem extends Subsystem {
	//Initializes motor for lift
	Victor liftMotor = new Victor(5);
	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setLiftPower(double power) {
		liftMotor.set(power);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new LiftCommand());
    }
}

