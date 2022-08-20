package frc.robot.commands;

import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
	
	public static OI oi;
	
  private final Shooter theCannon;
  
  Timer timer;

  private float resetTime;
	int time = 0;
	public Shoot(){
		super("Shoot");
		resetTime = 3.0f;
		theCannon = Robot.getShooter();
		timer = new Timer();
		
		requires(theCannon);
	}
	
	protected void execute() {
    theCannon.shoot(); 
    timer.start();
	System.out.println("time: " + time);
	time++;

	}
	
	
	@Override
	protected void end() {
		
		theCannon.shootOff();
	}

	

	@Override
	protected void initialize() {
		oi = new OI();
		
	}

	@Override
	protected void interrupted() {
		
		 
	}

	protected boolean isFinished(){
		if (time > 5) {
			time = 0;
			return true;
		}else {
			return false;
		}
		// if(timer.get() < resetTime) {
		//   return false;
		// }

		// else {
		//   timer.stop();
		//   timer.reset();
		//   return true;
		// }
			
	}
	
	
}
