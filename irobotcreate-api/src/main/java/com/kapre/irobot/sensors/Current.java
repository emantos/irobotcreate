package com.kapre.irobot.sensors;

public class Current extends SignedTwoBytes {
  public Current(String packetName, byte[] data) {
    super(packetName, data);
  }

  public short getCurrent() {
    return getValue();
  }
}
