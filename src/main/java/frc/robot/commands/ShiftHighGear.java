package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import frc.robot.OI;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ShiftHighGear extends Command {


    private final DriveTrain train;
    public static OI oi;

    public ShiftHighGear() {
    	super("StandardDrive");
    	train = Robot.getDriveTrain();
    	requires(train);
    
    }
    
    protected void initialize() {
       
        train.shiftHighGear();
    	oi = new OI();
    }
    
    protected void execute() {

    	train.shiftHighGear();
    }
    
    protected boolean isFinished() {
    	return true;
    }
    protected void end() {
    	
    }
    
    protected void interrupted() {
    	
    }

}