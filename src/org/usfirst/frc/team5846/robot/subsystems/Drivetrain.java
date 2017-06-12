package org.usfirst.frc.team5846.robot.subsystems;

import org.usfirst.frc.team5846.robot.Robot;
import org.usfirst.frc.team5846.robot.RobotMap;
import org.usfirst.frc.team5846.robot.commands.DriveWithJoystickCmd;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	public static final double REDUCE_TURNPOWER = .90;

   //MOTORS
   private Talon frontleftDrive = new Talon(RobotMap.FRONT_LEFT_DRIVE); //motors
   private Talon frontrightDrive = new Talon(RobotMap.FRONT_RIGHT_DRIVE);
   private Talon backleftDrive = new Talon(RobotMap.BACK_LEFT_DRIVE);
   private Talon backrightDrive = new Talon(RobotMap.BACK_RIGHT_DRIVE);
   
   //GYRO
   public final AHRS ahrs = new AHRS(SPI.Port.kMXP);
   
   //ENCODERS
   public Encoder driveEncoder = new Encoder(RobotMap.DRIVE_ENCODER_A, RobotMap.DRIVE_ENCODER_B);
   public Encoder driveEncoderLeft = new Encoder(RobotMap.DRIVE_ENCODER_A2, RobotMap.DRIVE_ENCODER_B2);
   
  
   
   public PIDController driveDistancePID = new PIDController(RobotMap.P_DRIVE, RobotMap.I_DRIVE, RobotMap.D_DRIVE, new DriveDistanceSource(), new DriveDistanceOutput());
   
    final double GYRO_P = (0.018); //P value of the gyro (may change) 0.0196
    public double speed = 1;
    public boolean timerStart = false;
	public boolean atTarget = false;
	public Timer timer = new Timer();
   //Defining the motors and stuff for each side of the drive train

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoystickCmd());
    }
    
    public void drive(double turnPower, double fowardPower) { //Arcade drive for teleop
    	turnPower *= REDUCE_TURNPOWER;
    	frontleftDrive.set(- fowardPower + (turnPower));
    	backleftDrive.set(- fowardPower + (turnPower));
    	frontrightDrive.set(fowardPower + (turnPower));
    	backrightDrive.set(fowardPower + (turnPower));
    }
    
    public void tankDrive(double leftPower, double rightPower) { //Tank drive for autonomous
    	//turnPower *= REDUCE_TURNPOWER;
    	frontleftDrive.set(leftPower);
    	backleftDrive.set(leftPower);
    	frontrightDrive.set(rightPower);
    	backrightDrive.set(rightPower);
    }
    
    
    public void slowDown() {
    	this.tankDrive(0, 0);
    }
    public void stopTank() {
    	this.tankDrive(0, 0);
    	
//    	if (driveEncoder.get() > (driveEncoderLeft.get() + 10)) {
//    		while (driveEncoder.get() < (driveEncoderLeft.get() + 10)) {
//    			tankDrive(0, 0.1);
//    		}
//    		this.tankDrive(0, 0);
//    	}
//    	else if (driveEncoderLeft.get() > (driveEncoder.get() + 10)) {
//    		while (driveEncoderLeft.get() < (driveEncoder.get() + 10)) {
//    			tankDrive(-0.1, 0);
//    		}
//    		this.tankDrive(0, 0);
//    	}
    }
    
    public void stop() {
    	this.drive(0, 0);
    }
    
    public void initEncoder() {
    	driveEncoder.setDistancePerPulse(6*Math.PI / 360); 
    	driveEncoderLeft.setDistancePerPulse(6*Math.PI / 360);
    }
    
    public double convertAngleToTankDrive(double Angle) {
    	if(Angle > 90) {
    		Angle = 90;
    	}
    	if(Angle <-90) {
    		Angle = -90;
    	}
    	
    	double Power = Math.sin(Angle * (Math.PI/180));
    	
    	return Power;
    	
    	
    }
     
    
    
    public boolean isAtDistance(double distance) {
    	if (driveEncoder.getDistance() > (distance) && driveEncoderLeft.getDistance() > (distance)) {
    		Robot.drivetrain.stopTank();
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    
    
    public double headingCorrection (double heading){
    	double driftError = heading - getAngle();
    	
    	if (driftError < -180){
    		driftError = driftError + 360;
    	}
    	else if (driftError > 180){
    		driftError = driftError - 360;
    	}
    	
    	
    	return ((GYRO_P)*driftError);
    	//setSpeed(((GYRO_P)*driftError), -((GYRO_P)*driftError));
    	
    }
    
    public double turnAngleAdditional(double target){
    	double speed;

    	speed = headingCorrection(target);
    	
    	if (speed > .25){
    		speed = .25; 
    	}
    	if(speed < -.25){ 
    		speed = -.25;
    	}
    	
    	if (speed < .15 && speed > 0){//real robot is .25 everywhere
    		speed = .15;
    	}
    	if(speed > -.15 && speed < 0){ 
    		speed = -.15;
    	}
    	
    	return speed;
    	//setTurnSpeed(speed);
    }
    
    public void setTurnSpeed(double speed){
    	tankDrive((speed), (speed));
    }
    
//Logic Methods

    public boolean isAtTurnTarget(double target){
    	atTarget = false;
    	
    	double error = target - getAngle();
    	
    	if (error < -180){
    		error = error + 360;
    	}
    	else if (error > 180){
    		error = error - 360;
    	}

    	if ((error < 5) && (error > -5)){
    		return true;
    	}
    	else {
    		return false;

    		//if(timerStart == false){
//   				timerStart = true;
//   				timer.start();
   			}
    		
//   		}else{
//   		
//   			if(timerStart == true){
//    			timer.stop();
//    			timer.reset();
//    			timerStart = false;
//   			}
    
    	
//   		if(timer.get() >.25){
//   			atTarget = true;
//    	}
    	
//    	return atTarget;
    	
    }
    
    private class DriveDistanceSource implements PIDSource {

		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			// TODO Auto-generated method stub
			return PIDSourceType.kDisplacement;
		}

		@Override
		public double pidGet() {
			// TODO Auto-generated method stub
			return driveEncoder.getDistance();
		}
    	
    }
    
    public class DriveDistanceOutput implements PIDOutput {

		@Override
		public void pidWrite(double output) {
			// TODO Auto-generated method stub
			//frontleftDrive.pidWrite(output);
			//backleftDrive.pidWrite(output);
			//frontrightDrive.pidWrite(-output);
			//backrightDrive.pidWrite(- output);
			
		}
}
    public void updateSmartDashboard() {
    	
    	
    }
    public double getAngle(){
    	return ahrs.getAngle();
    }
    public double getGyroRate() {
    	return ahrs.getRate();
    }
    public double getRateRight() {
    	return driveEncoder.getRate();
    }
    public double getRateLeft() {
    	return driveEncoderLeft.getRate();
    }
    public void resetDriveEncoders() {
    	driveEncoder.reset();
    	driveEncoderLeft.reset();
    }
 
}

