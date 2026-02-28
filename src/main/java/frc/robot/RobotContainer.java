// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;



public class RobotContainer {

  private final CommandXboxController joystic = new CommandXboxController(0);
  //private final Intake_Neo_Kraken intake = new Intake_Neo_Kraken();
  //private final Intake_Kraken_Kraken intake = new Intake_Kraken_Kraken();

  private final Intake_Neo_Kraken intake = new Intake_Neo_Kraken();


  private SendableChooser<Command> autoChooser;
  
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    joystic.x().whileTrue(new InstantCommand(intake::rollerStart)).onFalse(new InstantCommand(intake::rollerStop));
    joystic.y().whileTrue(new InstantCommand(intake::deployOut)).onFalse(new InstantCommand(intake::deployBack));
  }

  public Command getAutonomousCommand() {
        return autoChooser.getSelected();
}
}