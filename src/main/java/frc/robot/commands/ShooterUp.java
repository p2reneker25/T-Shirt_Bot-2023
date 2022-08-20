package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;


public class ShooterUp extends Command{
	public static OI oi;
	
	private final Shooter theCannon;
	public ShooterUp(){
		super("ShooterUp");
		theCannon = Robot.getShooter();
		
		requires(theCannon);
	}
	
	protected void execute() {
		theCannon.shooterUp();
	}
	
	
	@Override
	protected void end() {
		
		theCannon.shooterStop();
	}

	

	@Override
	protected void initialize() {
		oi = new OI();
	}

	@Override
	protected void interrupted() {
		theCannon.shooterStop();
		 
	}

	protected boolean isFinished(){
		
		return false;
		
	}
	
	
	
	
}
