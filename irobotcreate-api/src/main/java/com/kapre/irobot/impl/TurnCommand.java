package com.kapre.irobot.impl;

import com.kapre.irobot.Command;

public class TurnCommand extends AbstractCompositeCommand {
  public TurnCommand(Short angle) {
    this(angle, (short) 100);
  }

  public TurnCommand(Short angle, Short velocity) {
    Command turn = angle > 0 ? DriveCommand.turnCCLW(velocity) : DriveCommand
        .turnCLW(velocity);
    setCommand(turn, WaitCommand.waitAngle(angle), DriveCommand.stop());
  }
}
