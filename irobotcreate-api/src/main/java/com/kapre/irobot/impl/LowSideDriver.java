package com.kapre.irobot.impl;

import com.kapre.irobot.enums.OpCode;

public class LowSideDriver extends AbstractCommand {
  public LowSideDriver(Integer dutyCycle0) {
    this(dutyCycle0, 0, 0);
  }

  public LowSideDriver(Integer dutyCycle0, Integer dutyCycle1) {
    this(dutyCycle0, dutyCycle1, 0);
  }

  public LowSideDriver(Integer dutyCycle0, Integer dutyCycle1,
      Integer dutyCycle2) {
    if ((dutyCycle0 > 128 || dutyCycle0 < 0)
        || (dutyCycle1 > 128 || dutyCycle1 < 0)
        || (dutyCycle2 > 128 || dutyCycle2 < 0)) {
      throw new IllegalArgumentException();
    }
    setCommand(new byte[] { (byte) OpCode.PWM.op(), (byte) (dutyCycle2 & 0xff),
        (byte) (dutyCycle1 & 0xff), (byte) (dutyCycle0 & 0xff) });
  }

  public LowSideDriver(Boolean driver0) {
    this(driver0, false, false);
  }

  public LowSideDriver(Boolean driver0, Boolean driver1) {
    this(driver0, driver1, false);
  }

  public LowSideDriver(Boolean driver0, Boolean driver1, Boolean driver2) {
    byte comm = 0x00;
    if (driver0) {
      comm = (byte) (comm | 0x01);
    }
    if (driver1) {
      comm = (byte) (comm | 0x02);
    }
    if (driver2) {
      comm = (byte) (comm | 0x04);
    }
    setCommand(new byte[] { (byte) OpCode.LOW_SIDE_DRIVER.op(), comm });
  }
}
