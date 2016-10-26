
package org.usfirst.frc.team5980.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team5980.robot.commands.*;
import org.usfirst.frc.team5980.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	//initializing subsystems and cameras
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final DriveSubsystem drive = new DriveSubsystem();
	public static final BallGrabberSubsystem grabber = new BallGrabberSubsystem();
	public static final LiftSubsystem lift = new LiftSubsystem();
	public static final ArmSubsystem arm = new ArmSubsystem();
	public static OI oi;
	public static SensorInput sensors = new SensorInput();
	CameraServer server = CameraServer.getInstance();

    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
		oi = new OI();
        chooser = new SendableChooser();
        //chooser.addObject("Improved Auto", new ImprovedAuto());
        chooser.addDefault("Position 1 Low Bar Auto", new SimpleCommandGroup());
        //chooser.addObject("Faster Position 1", new ImprovedAuto());
        chooser.addObject("Just-Drive-Forward-For-a-While Auto", new JustDriveForwardForAWhileAuto());
        chooser.addObject("Portcullis Drive  Through Auto", new ChevalDeFriseAuto());
        chooser.addObject("Cheval de Frise Drive Over Auto", new ChevalAuto());
        chooser.addObject("Position 5 Portcullis Auto", new PortcullisPosition5Auto());
        chooser.addObject("Position 4 Portcullis Auto", new PortcullisPosition4Auto());
        chooser.addObject("Position 3 Portcullis Auto", new PortcullisPosition3Auto());
        chooser.addObject("Position 2 Portcullis Auto", new PortcullisPosition2Auto());
        chooser.addObject("Cheval Position 5 Auto", new ChevalPosition5Auto());
        chooser.addObject("Cheval Position 4 Auto", new ChevalPosition4Auto());
        chooser.addObject("Cheval Position 3 Auto", new ChevalPosition3Auto());
        chooser.addObject("Cheval Position 2 Auto", new ChevalPosition2Auto());
        chooser.addObject("Low Bar Auto with Backing Off", new LowBarAutoWithBackOut());
        chooser.addObject("Nothing", new NothingAuto());
        SmartDashboard.putData("Auto mode", chooser);
        server.setQuality(50);
        server.startAutomaticCapture("cam1");
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	//resetting the yaw of the NavX
    	sensors.resetYaw();
        autonomousCommand = (Command) chooser.getSelected();
        /*
         * vvv ATTENTION! IF WE WANT TO USE THE CHOOSER, DELETE THE LINE BELOW vvv
         */
        //autonomousCommand = new SimpleCommandGroup();
        //Uncomment the line below and comment the line above for positions other than 1
        //autonomousCommand = new DriveForwardAuto(160, 0.7, 0);
        /*
		String autoSelected = SmartDashboard.getString("Position1", "Everything Else");
		switch(autoSelected) {
		case "Position 1":
			autonomousCommand = new SimpleCommandGroup();
			break;
		case "Everything Else":
		default:
			autonomousCommand = new DriveForwardAuto(135, 0.5, 0);
			break;
		} 
    	*/
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	sensors.updatePosition();
        Scheduler.getInstance().run();
        
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
