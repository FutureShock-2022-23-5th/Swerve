// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.GrabberConstants;

public class GrabberSubsystem extends SubsystemBase {

  private final CANSparkMax m_Turnplate = new CANSparkMax(GrabberConstants.kGrabberSolenoidChannel, MotorType.kBrushless);

  private final Compressor m_Compressor = new Compressor(PneumaticsModuleType.CTREPCM);
  private final Solenoid m_Solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, GrabberConstants.kGrabberSolenoidChannel);

  /** Creates a new GrabberSubsystem. */
  public GrabberSubsystem() {
    m_Compressor.enableDigital();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}