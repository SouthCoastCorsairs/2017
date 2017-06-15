package org.usfirst.frc.team5846.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ActiveRightAuto extends CommandGroup {

    public ActiveRightAuto() {
    	
    	addParallel(new ArmUpAuto());
    	addSequential(new DriveStraightCmd(62));
    	
    	addSequential(new GyroTurnCmd(-60), 3);
    	
    	addSequential(new DriveStraightCmd(85));
    	
    	addParallel(new ArmDownAuto());
    	addSequential(new DriveBackwardCmd(-30));
    	
    	addSequential(new GyroTurnCmd(60), 3);
    	
    	addSequential(new DriveStraightCmd(50));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
