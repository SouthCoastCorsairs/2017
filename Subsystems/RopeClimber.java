package org.usfirst.frc.team5846.robot.subsystems;

import org.usfirst.frc.team5846.robot.Robot;
import org.usfirst.frc.team5846.robot.RobotMap;
import org.usfirst.frc.team5846.robot.commands.RopeClimberCmd;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RopeClimber extends Subsystem {
	private Talon climbRope = new Talon(RobotMap.ROPE_CLIMBER);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new RopeClimberCmd());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public void climbTheRope() {
		while(Robot.oi.getButton1()){
			climbRope.set(-1);
		}
		climbRope.set(0);
		
		
	}
	
	
	

}

