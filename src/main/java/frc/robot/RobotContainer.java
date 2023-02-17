// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.commands.drivetrain.CurvatureDrive;
import frc.robot.commands.drivetrain.TankDrive;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {

  public enum eDriveMode {
    ARCADE,
    TANK,
    CURVATURE;
  }

  private final CommandXboxController driverController = new CommandXboxController(Constants.DRIVER_CONTROLLER_PORT);
  private final Drivetrain drivetrain = new Drivetrain();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    switch (Constants.DRIVE_MODE) {
      case ARCADE:
        drivetrain.setDefaultCommand(
            new ArcadeDrive(drivetrain, driverController::getLeftY, driverController::getRightX));
        break;
      case TANK:
        drivetrain.setDefaultCommand(
            new TankDrive(drivetrain, driverController::getLeftY, driverController::getRightY));
      case CURVATURE:
        drivetrain.setDefaultCommand(
            new CurvatureDrive(drivetrain, driverController::getLeftY, driverController::getRightX, driverController.a()));
      default:
        break;
    }
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
