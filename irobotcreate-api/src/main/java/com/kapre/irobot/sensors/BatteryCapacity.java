package com.kapre.irobot.sensors;

public class BatteryCapacity extends UnsignedTwoBytes {

  public BatteryCapacity(String packetName, byte[] data) {
    super(packetName, data);
  }

  public int getBatteryCapacity() {
    return getValue();
  }
}
