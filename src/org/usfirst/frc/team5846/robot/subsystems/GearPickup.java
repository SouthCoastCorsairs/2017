package org.usfirst.frc.team5846.robot.subsystems;

import org.usfirst.frc.team5846.robot.RobotMap;
import org.usfirst.frc.team5846.robot.commands.GearPickupCmd;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearPickup extends Subsystem {
	public double intakePower = 0;
	private Victor WindowVictor = new Victor(RobotMap.GEAR_PICKUP_VICTOR);
	private Victor IntakeVictor = new Victor(RobotMap.GEAR_PICKUP_VICTOR2);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new GearPickupCmd());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Intake() {
    	IntakeVictor.set(intakePower);
    }
    
    public void Window(double fowardPower) {
    	WindowVictor.set(fowardPower);
    }
    
    
}

