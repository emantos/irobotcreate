package com.kapre.irobot.impl;

import com.kapre.irobot.enums.OpCode;

public class WaitCommand extends AbstractCommand {

  public static WaitCommand waitDistance(short distance) {
    return new WaitCommand(OpCode.WAIT_DISTANCE, distance);
  }

  public static WaitCommand waitAngle(short angle) {
    return new WaitCommand(OpCode.WAIT_ANGLE, angle);
  }

  public WaitCommand(OpCode code) {
    this(code, (short) 0);
  }

  public WaitCommand(OpCode code, Short params) {
    setCommand(new byte[] { (byte) code.op(), (byte) (params >>> 8),
        (byte) (params & 0xff) });
  }
}
