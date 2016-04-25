package com.kapre.irobot.sensors;

public class BatteryCharge extends UnsignedTwoBytes {

  public BatteryCharge(String packetName, byte[] data) {
    super(packetName, data);
  }

  public int getBatteryCharge() {
    return getValue();
  }
}
