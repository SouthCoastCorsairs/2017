
package org.usfirst.frc.team5846.robot;

import org.usfirst.frc.team5846.robot.commands.LeftPegAuto;
import org.usfirst.frc.team5846.robot.commands.DriveStraightCmd;
import org.usfirst.frc.team5846.robot.commands.GyroTurnCmd;
import org.usfirst.frc.team5846.robot.commands.PixyCmd;
import org.usfirst.frc.team5846.robot.commands.RightPegAuto;
import org.usfirst.frc.team5846.robot.commands.MiddlePegAuto;
import org.usfirst.frc.team5846.robot.subsystems.Drivetrain;
import org.usfirst.frc.team5846.robot.subsystems.PID;
import org.usfirst.frc.team5846.robot.subsystems.PocketOpener;
import org.usfirst.frc.team5846.robot.subsystems.RopeClimber;
import org.usfirst.frc.team5846.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
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
	

	public static OI oi;
	public static Drivetrain drivetrain = new Drivetrain();
	public static PocketOpener pocketopener = new PocketOpener();
	public static RopeClimber ropeclimber = new RopeClimber();
	public static Vision vision = new Vision();
	public static PID pid = new PID();
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		chooser.addDefault("Middle Peg", new MiddlePegAuto()); //Autonomous chooser for the middle peg
		
		chooser.addObject("Right Peg", new RightPegAuto()); //Autonomous chooser for the right peg
		
		chooser.addObject("Left Peg", new LeftPegAuto()); //Autonomous chooser for the left peg
		
		//chooser.addObject("Pixy", new PixyCmd()); //Autonomous chooser for testing the pixy camera command
		
		chooser.addObject("5 Point Line", new DriveStraightCmd(100)); //Autonomous chooser for testing driving straight for 4 feet
		
		chooser.addObject("Turn Left", new GyroTurnCmd(60)); //Autonomous chooser for testing the turning to 35 degrees
		
		chooser.addObject("Turn Right", new GyroTurnCmd(-60)); //Autonomous chooser for testing the turning to -35 degrees
		
		SmartDashboard.putData("Auto mode", chooser);
		//SmartDashboard.putBoolean("PIDStatus", this.drivetrain.driveDistancePID.onTarget());
		//SmartDashboard.putNumber("PIDError", this.drivetrain.driveDistancePID.getError());
		Robot.drivetrain.initEncoder();
		 CameraServer.getInstance().startAutomaticCapture();

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		Robot.drivetrain.driveEncoder.reset();
		Robot.drivetrain.ahrs.reset();
		autonomousCommand = chooser.getSelected();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		//SmartDashboard.putBoolean("isAtAngle", Robot.drivetrain.isAtTurnTarget(60)); //Is the robot at 35 degrees?
		
		//SmartDashboard.putBoolean("isAtNegativeAngle", Robot.drivetrain.isAtTurnTarget(-60)); //Is the robot at -35 degrees?
		
		SmartDashboard.putNumber("Gyro", Robot.drivetrain.getAngle()); //Gets the angle from the gyro
		
		SmartDashboard.putNumber("Right Encoder", Robot.drivetrain.driveEncoder.get()); //Gets the distance in inches from the encoders
		
		SmartDashboard.putNumber("Left Encoder", Robot.drivetrain.driveEncoderLeft.get());
		
		SmartDashboard.putNumber("Right Distance", Robot.drivetrain.driveEncoder.getDistance()); //Gets the distance in inches
		
		SmartDashboard.putNumber("Left Distance", Robot.drivetrain.driveEncoderLeft.getDistance());
		
		//SmartDashboard.putBoolean("isAtDistance", Robot.drivetrain.isAtDistance(100)); //Did the robot drive 100 inches?
		//Vision.printPixyStuff();
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		Robot.drivetrain.driveEncoder.reset();
		Robot.drivetrain.ahrs.reset();
		//Vision.printPixyStuff();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		SmartDashboard.putNumber("Gyro", Robot.drivetrain.getAngle());
		
		SmartDashboard.putNumber("Right Encoder", Robot.drivetrain.driveEncoder.get());
		
		SmartDashboard.putNumber("Right Distance", Robot.drivetrain.driveEncoder.getDistance());
		
		SmartDashboard.putNumber("Left Distance", Robot.drivetrain.driveEncoderLeft.getDistance());
		
		//SmartDashboard.putBoolean("isAtDistance", Robot.drivetrain.isAtDistance(100));
		
		//SmartDashboard.putBoolean("isAtAngle", Robot.drivetrain.isAtTurnTarget(35));
		
		SmartDashboard.putNumber("Left Encoder", Robot.drivetrain.driveEncoderLeft.get());
		
		//Vision.printPixyStuff();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
