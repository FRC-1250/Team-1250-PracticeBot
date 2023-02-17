// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainCalibration;

public class Drivetrain extends SubsystemBase {

  private final CANSparkMax frontLeft = new CANSparkMax(DrivetrainCalibration.FRONT_LEFT_CAN_ID, MotorType.kBrushless);
  private final CANSparkMax frontRight = new CANSparkMax(DrivetrainCalibration.FRONT_RIGHT_CAN_ID, MotorType.kBrushless);
  private final CANSparkMax backLeft = new CANSparkMax(DrivetrainCalibration.BACK_LEFT_CAN_ID, MotorType.kBrushless);
  private final CANSparkMax backRight = new CANSparkMax(DrivetrainCalibration.BACK_RIGHT_CAN_ID, MotorType.kBrushless);
  private final MotorControllerGroup left = new MotorControllerGroup(frontLeft, backLeft);
  private final MotorControllerGroup right = new MotorControllerGroup(frontRight, backRight);
  private final DifferentialDrive differentialDrive = new DifferentialDrive(left, right);

  public Drivetrain() {
    left.setInverted(true);
    right.setInverted(false);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    differentialDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    differentialDrive.arcadeDrive(xSpeed, zRotation);
  }

  public void curvatureDrive(double xSpeed, double zRotation, boolean allowTurnInPlace) {
    differentialDrive.curvatureDrive(xSpeed, zRotation, allowTurnInPlace);
  }

  public void stop() {
    differentialDrive.stopMotor();
  }

  @Override
  public void periodic() {
  }
}
