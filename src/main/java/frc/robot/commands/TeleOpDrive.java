package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

/**
 * This is the {@link Command command} for out two-motor Talon SRX tank drive.
 * 
 * <p>
 * Also, A state machine representing a complete action to be performed by the
 * robot. Commands are run by the CommandScheduler, and can be composed into
 * CommandGroups to allow users to build complicated multistep actions without
 * the need to roll the state machine logic themselves.
 * 
 * Commands are run synchronously from the main robot loop; no multithreading is
 * used, unless specified explicitly from the command implementation.
 * 
 * @author William M. Kanar
 */
public class TeleOpDrive extends Command {
    private final Drivetrain m_drivetrain;

    /**
     * 
     * @param subsystem the {@link Drivetrain} to operate.
     */
    public TeleOpDrive(Drivetrain subsystem) {

        m_drivetrain = subsystem;
        addRequirements(m_drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_drivetrain.driveTank(0, 0);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_drivetrain.driveTank(RobotContainer.getDriverControllerAxis(1), RobotContainer.getDriverControllerAxis(5));
    }
}
