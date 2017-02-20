package org.usfirst.frc.team5846.robot;



/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//MOTORS
	public static final int BACK_LEFT_DRIVE = 1; //1
	public static final int FRONT_LEFT_DRIVE = 0; //0
	public static final int BACK_RIGHT_DRIVE = 3; //3
	public static final int FRONT_RIGHT_DRIVE = 2; //2
	public static final int POCKET_OPENER = 4; //4
	public static final int ROPE_CLIMBER = 5; //5
	
	//ENCODERS
	public static final int DRIVE_ENCODER_A = 2;
	public static final int DRIVE_ENCODER_B = 1;
	public static final int DRIVE_ENCODER_A2 = 3;
	public static final int DRIVE_ENCODER_B2 = 4;
	
	//PIDs
	public static final double P_DRIVE = 1.0;
	public static final double I_DRIVE = 0.0;
	public static final double D_DRIVE = 0.0;
	
}
