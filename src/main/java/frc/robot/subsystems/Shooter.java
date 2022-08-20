package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;


public class Shooter extends Subsystem{
	private Relay shoot;
	private DoubleSolenoid moveShooter;
	
	public Shooter() {
		super("Shooter");
		moveShooter = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.SHOOTER_UP, RobotMap.SHOOTER_DOWN);
		shoot = new Relay(RobotMap.SHOOT_CHANNEL);
	
	}
	
	public void shoot(){
		shoot.set(Value.kOn);
		
  }

  public void shootOff(){
		shoot.set(Value.kOff);
		
  }
  
  
	
	public void shooterUp(){
		
		moveShooter.set(DoubleSolenoid.Value.kForward);
		System.out.println(moveShooter.get());

	}
	
	public void shooterDown(){

		moveShooter.set(DoubleSolenoid.Value.kReverse);
		System.out.println(moveShooter.get());

		
	}
	
	public void shooterStop(){
		
		moveShooter.set(DoubleSolenoid.Value.kOff);
	}
	
	
	public void initDefaultCommand(){
		//use spike for the shoot command and compressor
		
		
	}
	
	
}
