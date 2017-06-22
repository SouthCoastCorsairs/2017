package org.usfirst.frc.team5846.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Vision extends Subsystem {
	//I2C
	public static I2C pixy = new I2C(Port.kOnboard, 0x54);
	public static char xPosition;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public static void printPixyStuff(){
    	byte[] pixyValues = new byte[64];
    	pixyValues[0] = (byte) 0b01010101;
    	pixyValues[1] = (byte) 0b10101010;

    	pixy.readOnly(pixyValues, 64);
    	if (pixyValues != null) {
    		int i = 0;
    		while (!(pixyValues[i] == 85 && pixyValues[i + 1] == -86) && i < 50) {
    			i++;
    		}
    		i++;
    		if (i > 50)
    			i = 49;
    		xPosition = (char) (((pixyValues[i + 7] & 0xff) << 8) | (pixyValues[i + 6] & 0xff));
    		char yPosition = (char) ((pixyValues[i + 9] & 0xff << 8) | pixyValues[i + 8] & 0xff);
    		char width = (char) ((pixyValues[i + 11] & 0xff << 8) | pixyValues[i + 10] & 0xff);
    		char height = (char) ((pixyValues[i + 13] & 0xff << 8) | pixyValues[i + 12] & 0xff);
    		
    		//SmartDashboard.putNumber("xPosition", xPosition);
    		//SmartDashboard.putNumber("yPosition", yPosition);
    		//SmartDashboard.putNumber("width", width);
			//SmartDashboard.putNumber("height", height);
			//SmartDashboard.putNumber("Raw 5", pixyValues[5]);
		}
}
    
}

