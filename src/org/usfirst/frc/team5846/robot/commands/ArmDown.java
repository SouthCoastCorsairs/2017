package org.usfirst.frc.team5846.robot.commands;

import org.usfirst.frc.team5846.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmDown extends Command {

    public ArmDown() {
    	requires(Robot.gearpickup);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearpickup.initalizeCounter2();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.getButton8()) {
    		Robot.gearpickup.armDown();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.gearpickup.isSwitch2Set();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gearpickup.armStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
