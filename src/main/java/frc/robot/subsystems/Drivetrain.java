package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANIDConstants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * This is the Subsystem for out two-motor {@link WPI_TalonSRX Talon SRX} tank drive.
 * 
 * <p>
 * Also, a base for subsystems that handles registration in the constructor, and
 * provides a more intuitive
 * method for setting the default command.
 * 
 * @author William M. Kanar
 */
public class Drivetrain extends SubsystemBase {
    private WPI_TalonSRX rightMotor;
    private WPI_TalonSRX leftMotor;

    public Drivetrain() {
        rightMotor = new WPI_TalonSRX(CANIDConstants.rightDriveMotorID); // CAN ID set in Tuner X
        leftMotor = new WPI_TalonSRX(CANIDConstants.leftDriveMotorID); // CAN ID set in Tuner X
        rightMotor.setInverted(false);
        leftMotor.setInverted(true);
        rightMotor.setNeutralMode(NeutralMode.Brake);
        leftMotor.setNeutralMode(NeutralMode.Brake);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    /**
     * Sets the left motor's speed to left, and the right motor's speed to right
     * 
     * @param right a double from -1 to 1 for the speed
     * @param left  a double from -1 to 1 for the speed
     */
    public void driveTank(double right, double left) {
        rightMotor.set(MathUtil.clamp(right, -1, 1));
        leftMotor.set(MathUtil.clamp(left, -1, 1));
    }
}
