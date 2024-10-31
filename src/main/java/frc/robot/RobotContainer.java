// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.TeleOpDrive;
import frc.robot.subsystems.Drivetrain;


import org.ejml.simple.UnsupportedOperation;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems and commands are defined here...
  public final Drivetrain m_drivetrain = new Drivetrain();
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private static final CommandXboxController m_driverController = new CommandXboxController(
      OperatorConstants.kDriverControllerPort);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    m_drivetrain.setDefaultCommand(new TeleOpDrive(m_drivetrain));
  }

  /**
   * @param axis an int for which axis.
   *             axis =
   *             <p>
   *             0: Get the X axis value of left stick of the controller.
   *             Left[-1,1]Right
   *             <p>
   *             1: Get the Y axis value of left stick of the controller.
   *             Up[-1,1]Down
   *             <p>
   *             2: Get the axis value of left trigger of the controller.
   *             Natural[0,1]Depressed
   *             <p>
   *             3: Get the axis value of right trigger of the controller.
   *             Natural[0,1]Depressed
   *             <p>
   *             4: Get the X axis value of right stick of the controller.
   *             Left[-1,1]Right
   *             <p>
   *             5: Get the Y axis value of right stick of the controller.
   *             Up[-1,1]Down
   * @return The axis value.
   */
  public static double getDriverControllerAxis(int axis) {
    return m_driverController.getRawAxis(axis);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

  }

  // Configure default commands

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    throw new UnsupportedOperation();
  }
}
