package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import frc.robot.OI;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ShiftLowGear extends Command {


    private final DriveTrain train;
    public static OI oi;

    public ShiftLowGear() {
    
    	train = Robot.getDriveTrain();
    	requires(train);
    	
    }
    
    protected void initialize() {
       
        train.shiftLowGear();
    	oi = new OI();
    }
    
    protected void execute() {
       	
    	train.shiftLowGear();
    }
    
    protected boolean isFinished() {
    	return true;
    }
    protected void end() {
    	train.shiftHighGear();
    }
    
    protected void interrupted() {
    	train.shiftHighGear();
    }

}
