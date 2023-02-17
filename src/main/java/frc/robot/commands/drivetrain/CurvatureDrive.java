// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drivetrain;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class CurvatureDrive extends CommandBase {
  private final Drivetrain cmd_drivetrain;
  private final DoubleSupplier cmd_xSupplier;
  private final DoubleSupplier cmd_rotSupplier;
  private final BooleanSupplier cmd_turnInPlaceSupplier;

  public CurvatureDrive(Drivetrain drivetrain, DoubleSupplier xSupplier, DoubleSupplier rotSupplier,
      BooleanSupplier turnInSupplier) {
    cmd_drivetrain = drivetrain;
    cmd_xSupplier = xSupplier;
    cmd_rotSupplier = rotSupplier;
    cmd_turnInPlaceSupplier = turnInSupplier;
    addRequirements(cmd_drivetrain);
  }

  @Override
  public void execute() {
    cmd_drivetrain.curvatureDrive(-cmd_xSupplier.getAsDouble(), cmd_rotSupplier.getAsDouble(),
        cmd_turnInPlaceSupplier.getAsBoolean());
  }

  @Override
  public void end(boolean interrupted) {
    cmd_drivetrain.stop();
  }
}
