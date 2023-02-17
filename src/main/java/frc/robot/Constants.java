// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.RobotContainer.eDriveMode;

public final class Constants {
  public static final int DRIVER_CONTROLLER_PORT = 0;
  public static final eDriveMode DRIVE_MODE = eDriveMode.ARCADE;

  public static final class DrivetrainCalibration {
    public static final int FRONT_RIGHT_CAN_ID = 0;
    public static final int FRONT_LEFT_CAN_ID = 0;
    public static final int BACK_RIGHT_CAN_ID = 0;
    public static final int BACK_LEFT_CAN_ID = 0;
  }
}
