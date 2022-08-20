/*----------------------------------------------------------------------------*/
/* Copyright (c) 2016 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams.   		  */
/* Edited by Isidoro and Lex 												  */
/*         																	  */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

//import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Victor;

//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.RobotMap;
import frc.robot.commands.*;
//import org.usfirst.frc.team2035.robot.subsystems.*;

public class DriveTrain extends Subsystem {
	
	private static Joystick stick;
	private SpeedController motorFrontLeft;
	private SpeedController motorBackLeft;
	private SpeedController motorFrontRight;
	private SpeedController motorBackRight;
	// private Solenoid GearShiftRight;
	// private Solenoid GearShiftLeft;
	//private DoubleSolenoid gearShifter;

	private DifferentialDrive drive;
  private SpeedControllerGroup motorLeft;
  private SpeedControllerGroup motorRight;

public DriveTrain() {
	super("Drive Train");
	
	motorFrontLeft = new Victor(RobotMap.F_LEFT_MOTOR_PWM);  // initialize the motor as a victor on channel 0
    motorBackLeft = new Victor(RobotMap.B_LEFT_MOTOR_PWM);
    motorFrontRight = new Victor(RobotMap.F_RIGHT_MOTOR_PWM);
    motorBackRight = new Victor(RobotMap.B_RIGHT_MOTOR_PWM);

    motorLeft = new SpeedControllerGroup(motorFrontLeft,motorBackLeft); 
    motorRight = new SpeedControllerGroup(motorFrontRight,motorBackRight); 

    stick = new Joystick(RobotMap.JOYSTICK_A_USB_NUMBER);	// initialize the joystick on USB 0
    drive = new DifferentialDrive(motorLeft,motorRight);
    // GearShiftRight = new Solenoid(RobotMap.DRIVE_TRAIN_SHIFT_RIGHT);
    // GearShiftLeft = new Solenoid(RobotMap.DRIVE_TRAIN_SHIFT_LEFT);
    //gearShifter = new DoubleSolenoid(RobotMap.PCM_ID_DRIVER, RobotMap.DRIVE_TRAIN_AIR_IN, RobotMap.DRIVE_TRAIN_AIR_OUT);
}
//
public void init()
{
	
}

protected void initDefaultCommand()
{
	
}

public void arcadeDrive() {
    drive.arcadeDrive(stick.getY(), -(stick.getX()));
}
public void arcadeWithPOV() {
	int pov = stick.getPOV();
	double povD = pov;
	double x = Math.sin(povD);
	double y = Math.cos(povD);
	if (pov == -1) {
		drive.arcadeDrive(0, 0);
	}else {
		drive.arcadeDrive(y, -x);
	}

	SmartDashboard.putNumber("pov", pov);
}


public void shiftLowGear()
{
	// GearShiftRight.set(true);
	// GearShiftLeft.set(true);
	// System.out.println("Gotta Go LOW");
	//gearShifter.set(DoubleSolenoid.Value.kReverse);
}

public void shiftHighGear()
{
	
	// GearShiftRight.set(false);
	// GearShiftLeft.set(false);
	// System.out.println("Gotta Go HIGH");
	//gearShifter.set(DoubleSolenoid.Value.kForward);
}


public void end()
{
	
}
}
