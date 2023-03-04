package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{

    private final Solenoid solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
    private final Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);

    private final WPI_TalonFX intakeMotor = new WPI_TalonFX(14);

    private final CANSparkMax intakeLeftShooter = new CANSparkMax(5, MotorType.kBrushless);
    private final CANSparkMax intakeRightShooter = new CANSparkMax(6, MotorType.kBrushless);

    private final MotorControllerGroup intakeShooter = new MotorControllerGroup(intakeLeftShooter, intakeRightShooter);

    public Intake() {
        intakeMotor.setInverted(false);
        intakeLeftShooter.setInverted(false);
        intakeRightShooter.setInverted(true);

        resetEncoders();
    }

    public void enableCompressor(){
        compressor.enableDigital();
    }

    public void grab() {
        solenoid.set(true);
    }

    public void release() {
        solenoid.set(false);
    }

    public void setIntakeMotor(double speed) {
        intakeMotor.set(speed);
    }

    public void resetEncoders() {
        intakeMotor.setSelectedSensorPosition(0);
    }

    public void setIntakeShooter(double speed){
        intakeShooter.set(speed);
    }

    public double getIntakeEncoder(){
        return intakeMotor.getSelectedSensorPosition();
    }

    public double getIntakeShooterVelocity(){
        return (intakeLeftShooter.getEncoder().getPosition() + intakeRightShooter.getEncoder().getPosition()) / 2;
    }
}

