// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drivetrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {
  private final Drivetrain cmd_drivetrain;
  private final DoubleSupplier cmd_leftSupplier;
  private final DoubleSupplier cmd_rightSupplier;

  public TankDrive(Drivetrain drivetrain, DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
    cmd_drivetrain = drivetrain;
    cmd_leftSupplier = leftSupplier;
    cmd_rightSupplier = rightSupplier;
    addRequirements(cmd_drivetrain);
  }

  @Override
  public void execute() {
    cmd_drivetrain.tankDrive(-cmd_leftSupplier.getAsDouble(), -cmd_rightSupplier.getAsDouble());
  }

  @Override
  public void end(boolean interrupted) {
    cmd_drivetrain.stop();
  }
}
