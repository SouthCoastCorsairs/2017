package org.usfirst.frc.team5846.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	
	private Joystick logistick = new Joystick(0); //Driving Joystick
	//Ports are here 
	private Joystick logistick2 = new Joystick(1); //Manipulating Joystick

	
	public double getJoystickY() { //Gets the y axis of the driving joystick
		return logistick.getRawAxis(1);
	
	}
	
	public double getJoystickX() { //Gets the x axis of the driving joystick
		return logistick.getRawAxis(0);
	}
	
	public double getJoystick2X() { //Gets the x axis of the manipulating joystick
		return logistick2.getRawAxis(0);
	}
	
	public double getJoystick2Y() { //Gets the y axis of the manipulating joystick
		return logistick2.getRawAxis(1);
	}
	
	public double getPOV() {
		return logistick2.getPOV();
	}
	
	//// CREATING BUTTONS
	
	public boolean getButton5() { //Gets button 5 on the driving joystick
		return logistick.getRawButton(5);
		
	}
	
	public boolean getButton3() { //Gets button 3 on the driving joystick
		return logistick.getRawButton(3);
		
	}
	
	public boolean getButton6() { //Gets button 6 on the driving joystick
		return logistick.getRawButton(6);
		
	}
	
	public boolean getButton1() { //Gets button 1 (trigger) on the manipulating joystick
		return logistick2.getRawButton(1);
	}
	
	public boolean reverseButton() { //Gets button 1 (trigger) on the driving joystick
		return logistick.getRawButton(1);
	}
	
	public boolean climbButton5() {
		return logistick2.getRawButton(5);
	}
	
	public boolean climbButton6() {
		return logistick2.getRawButton(6);
	}
	
	public boolean climbButton3() {
		return logistick2.getRawButton(3);
	}
	
	public boolean climbButton4() {
		return logistick2.getRawButton(4);
	}
	
	public boolean getButton4() {
		return logistick.getRawButton(4);
	}
	
	public boolean getButton2() {
		return logistick2.getRawButton(2);
	}
	
	public boolean getButton7() {
		return logistick2.getRawButton(7);
	}
	
	public boolean getButton8() {
		return logistick2.getRawButton(8);
	}
	
	public boolean reverseButton1() {
		return logistick.getRawButton(11);
	}
	
	public boolean reverseButton2() {
		return logistick.getRawButton(12);
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






