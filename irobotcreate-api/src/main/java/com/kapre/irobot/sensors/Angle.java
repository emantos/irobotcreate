package com.kapre.irobot.sensors;

public class Angle extends SignedTwoBytes {
  public Angle(String packetName, byte[] data) {
    super(packetName, data);
  }

  public short getAngle() {
    return getValue();
  }
}
