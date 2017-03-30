package org.usfirst.frc.team5846.robot.subsystems;

import org.usfirst.frc.team5846.robot.Robot;
import org.usfirst.frc.team5846.robot.RobotMap;
import org.usfirst.frc.team5846.robot.commands.RopeClimberCmd;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RopeClimber extends Subsystem {
	public double climbSpeed = -0.3;
	private Spark climbRope = new Spark(RobotMap.ROPE_CLIMBER_SPARK); //Climber motor Spark
	private Talon climbRope2 = new Talon(RobotMap.ROPE_CLIMBER_TALON); //Climber motor Talon

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new RopeClimberCmd()); //The default command of this subsystem
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public void climbTheRope() {	//While button 1 is pressed, the rope climber motor is set to -0.3 speed
		if (Robot.oi.getButton1()){			
			climbRope.set(climbSpeed); //Speed of the climbing motor Spark
			climbRope2.set(climbSpeed);//Speed of the climbing motor Talon
		} else {
			climbRope.set(0);
			climbRope2.set(0);
		}
		
	}
	
	

}

