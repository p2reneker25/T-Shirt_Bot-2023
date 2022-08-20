package frc.robot.commands;

import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.command.Command;


public class ShooterDown extends Command{
	public static OI oi;
	
	private final Shooter theCannon;
	

	public ShooterDown(){
		super("ShooterDown");
		theCannon = Robot.getShooter();
		
		requires(theCannon);
	}
	
	protected void execute() {
		theCannon.shooterDown();

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
