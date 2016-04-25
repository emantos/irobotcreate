package com.kapre.irobot.impl;

import com.kapre.irobot.enums.Demo;
import com.kapre.irobot.enums.OpCode;

public class DemoCommand extends AbstractCommand {
  public DemoCommand() {
    this(Demo.ABORT);
  }

  public DemoCommand(Demo demo) {
    this(demo.getDemoNumber());
  }

  public DemoCommand(Integer parameter) {
    setCommand(new byte[] { (byte) OpCode.DEMO.op(),
        (byte) Demo.getDemo(parameter).or(Demo.ABORT).getDemoNumber() });
  }
}
