package com.kapre.irobot.sensors;

public class Distance extends SignedTwoBytes {
  public Distance(String packetName, byte[] data) {
    super(packetName, data);
  }

  public short getDistance() {
    return getValue();
  }
}
