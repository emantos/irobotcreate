package com.kapre.irobot.impl;

import com.kapre.irobot.enums.OpCode;

public class DriveCommand extends AbstractCommand {

  public static final Short STRAIGHT = (short) 32767;
  public static final Short CCLW = (short) 2001;
  public static final Short CLW = (short) -2001;

  public static DriveCommand stop() {
    return new DriveCommand(OpCode.DRIVE, (short) 0, (short) 0);
  }

  public static DriveCommand getDrive(short velocity, short radius) {
    return new DriveCommand(OpCode.DRIVE, velocity, radius);
  }

  public static DriveCommand getDriveDirect(short velocityLeft,
      short velocityRight) {
    return new DriveCommand(OpCode.DRIVE_DIRECT, velocityLeft, velocityRight);
  }

  public static DriveCommand turnCCLW(short velocity) {
    return new DriveCommand(OpCode.DRIVE, velocity, CCLW);
  }

  public static DriveCommand turnCLW(short velocity) {
    return new DriveCommand(OpCode.DRIVE, velocity, CLW);
  }

  public static DriveCommand straight(short velocity) {
    return new DriveCommand(OpCode.DRIVE, velocity, null);
  }

  public DriveCommand(OpCode op) {
    this(op, (short) 0, (short) 0);
  }

  public DriveCommand(OpCode op, Short firstParameter) {
    this(op, firstParameter, null);
  }

  public DriveCommand(OpCode op, Short firstParameter, Short secondParameter) {
    if (secondParameter == null) {
      secondParameter = STRAIGHT;
    } else if (secondParameter > 2000) {
      secondParameter = (short) 0x0001;
    } else if (secondParameter < -2000) {
      secondParameter = (short) 0xffff;
    }
    setCommand(new byte[] { (byte) op.op(), (byte) (firstParameter >>> 8),
        (byte) (firstParameter & 0xff), (byte) (secondParameter >>> 8),
        (byte) (secondParameter & 0xff) });
  }
}
