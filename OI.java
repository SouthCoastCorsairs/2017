package org.usfirst.frc.team5846.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick logistick = new Joystick(0); //Driving Joystick in port (x)
	//Ports are here 
	private Joystick logistick2 = new Joystick(1); //Manipulating Joystick in port (y)
	
	Button ropeButton = new JoystickButton(logistick2, 1);
	Button quarterButton = new JoystickButton(logistick, 5);
	Button halfButton = new JoystickButton(logistick, 3);
	Button fullButton = new JoystickButton(logistick, 6);
	
	
	
	public double getJoystickY() {
		return logistick.getRawAxis(1);
		//Beam me up captain!
	}
	
	public double getJoystickX() {
		return logistick.getRawAxis(0);
	}
	
	public double getJoystick2X() {
		return logistick2.getRawAxis(0);
	}
	
	public double getJoystick2Y() {
		return logistick2.getRawAxis(1);
	}
	
	
	
	
	
	//// CREATING BUTTONS
	
	public boolean getButton5() {
		return logistick.getRawButton(5);
		//Take it nice and slow
	}
	
	public boolean getButton3() {
		return logistick.getRawButton(3);
		//Let's go FASTER
	}
	
	public boolean getButton6() {
		return logistick.getRawButton(6);
		//WAAAY TOO FAAST!!!!!!!
	}
	
	public boolean getButton1() {
		return logistick2.getRawButton(1);
	}
	
	public boolean reverseButton() {
		return logistick.getRawButton(1);
	}
	
	
	
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	 //`Joystick stick = new Joystick(0);
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

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}





/**
 * Written by Justin Wolkowicz, Andrew Sullivan, Cameron McAlpine, Zach Martin, Daniel Perry, and Elijah Jope.
 * Mentored by Melissa Pijoan
 */
