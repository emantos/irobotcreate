package com.kapre.irobot.impl;

import com.kapre.irobot.enums.OpCode;

public class DigitalOutputCommand extends AbstractCommand {
  public DigitalOutputCommand(Boolean pin20, Boolean pin7, Boolean pin19) {
    byte pin = 0x00;
    if (pin19) {
      pin = (byte) (pin | 0x01);
    }
    if (pin7) {
      pin = (byte) (pin | 0x02);
    }
    if (pin20) {
      pin = (byte) (pin | 0x04);
    }
    setCommand(new byte[] { (byte) OpCode.DIGITAL_OUTPUT.op(), pin });
  }
}
