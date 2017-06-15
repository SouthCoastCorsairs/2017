package org.usfirst.frc.team5846.robot.subsystems;

import org.usfirst.frc.team5846.robot.RobotMap;
import org.usfirst.frc.team5846.robot.commands.GearPickupCmd;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearPickup extends Subsystem {
	public double intakePower = 0;
	private Victor WindowVictor = new Victor(RobotMap.GEAR_PICKUP_VICTOR);
	private Victor IntakeVictor = new Victor(RobotMap.GEAR_PICKUP_VICTOR2);
	 DigitalInput limitSwitch = new DigitalInput(6);
	 DigitalInput limitSwitch2 = new DigitalInput(7);
	 
	   Counter counter = new Counter(limitSwitch);
	   Counter counter2 = new Counter(limitSwitch2);
	
	 public boolean isSwitchSet() {
	    	return counter.get() > 0;
	    }
	 
	 public boolean isSwitch2Set() {
		 return counter.get() > 0;
	 }
	    
	    public void initializeCounter() {
	        counter.reset();
	    }
	    
	    public void initalizeCounter2() {
	    	counter2.reset();
	    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new GearPickupCmd());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void armUp() {
    	WindowVictor.set(0.3);
    }
    public void armDown() {
    	WindowVictor.set(-0.3);
    }
    public void armStop() {
    	WindowVictor.set(0);
    }
    public void Intake() {
    	IntakeVictor.set(intakePower);
    }   
    public void Window(double fowardPower) {
    	WindowVictor.set(fowardPower);
    }
    
    
}

