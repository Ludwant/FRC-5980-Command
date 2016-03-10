package org.usfirst.frc.team5980.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

import org.usfirst.frc.team5980.robot.commands.ArmLowerCommand;
import org.usfirst.frc.team5980.robot.commands.ArmRaiseCommand;
import org.usfirst.frc.team5980.robot.commands.BallGrabInCommand;
import org.usfirst.frc.team5980.robot.commands.BallGrabOutCommand;
import org.usfirst.frc.team5980.robot.commands.ExampleCommand;
import org.usfirst.frc.team5980.robot.commands.LiftExtendCommand;
import org.usfirst.frc.team5980.robot.commands.LiftRetractCommand;
import org.usfirst.frc.team5980.robot.commands.RotateToHeading;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	//Making the joysticks and buttons
	public Joystick joystickDrive = new Joystick(RobotMap.driveUSBport);
	public Joystick joystickOperator = new Joystick(RobotMap.opUSBport);
	Button turnToGoal = new JoystickButton(joystickDrive, 5);
	Button grabberIn = new JoystickButton(joystickOperator, 1);
	Button grabberOut = new JoystickButton(joystickOperator, 2);
	Button raiseLift = new JoystickButton(joystickOperator, 5);
	Button lowerLift = new JoystickButton(joystickOperator, 6);
	Button raiseArm = new JoystickButton(joystickOperator, 3);
	Button lowerArm = new JoystickButton(joystickOperator, 4);
	
	public OI() {
		//Setting the buttons to control the motors with the commands
		grabberIn.whileHeld(new BallGrabInCommand());
		grabberOut.whileHeld(new BallGrabOutCommand());
        lowerLift.whileHeld(new LiftRetractCommand());
        raiseLift.whileHeld(new LiftExtendCommand());
        raiseArm.whileHeld(new ArmRaiseCommand());
        lowerArm.whileHeld(new ArmLowerCommand());
		//turnToGoal.whenPressed(new RotateToHeading(60, 0.5));
	}
	
	
	
}

