package org.usfirst.frc.team5846.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BackRedLeftPegAuto extends CommandGroup {

    public BackRedLeftPegAuto() {
    	
    	addSequential(new DriveBackwardCmd(-67)); //Drive straight for x inches
	 	
    	addSequential(new GyroTurnCmd(60), 4); //Turn x degrees
    	
    	//addSequential(new AutoTurnLeftCmd(0.74)); //Timed turning for x seconds (May change to GyroTurnCmd for precise turning)
    	
    	
    	//addSequential(new WaitCommand(1.0)); //Wait for x seconds
    	
    	//addSequential(new PixyCmd()); //Lines up the robot to the target using the pixy
    	
    	addSequential(new DriveBackwardCmd(-85)); //Drive straight for x inches
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
