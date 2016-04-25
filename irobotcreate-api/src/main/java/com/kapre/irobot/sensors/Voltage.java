package com.kapre.irobot.sensors;

public class Voltage extends UnsignedTwoBytes {

  public Voltage(String packetName, byte[] data) {
    super(packetName, data);
  }

  public int getVoltage() {
    return getValue();
  }
}
