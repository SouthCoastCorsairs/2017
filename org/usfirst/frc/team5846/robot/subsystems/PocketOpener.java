package org.usfirst.frc.team5846.robot.subsystems;

import org.usfirst.frc.team5846.robot.RobotMap;
import org.usfirst.frc.team5846.robot.commands.PocketOpenerCmd;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PocketOpener extends Subsystem {
	private Talon openWallet = new Talon(RobotMap.POCKET_OPENER);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new PocketOpenerCmd());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }


	public void Open(double openPower) {
		openWallet.set(openPower);
	}

	public void stop2() {
		this.Open(0);
	}
}
