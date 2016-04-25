package com.kapre.irobot.sensors;

public class UnsignedTwoBytes extends AbstractSensorData {

  private int value = 0;

  public UnsignedTwoBytes(String packetName, byte[] data) {
    super(packetName);
    this.value = (int) (((this.value | data[0]) << 8) | data[1]);
  }

  public int getValue() {
    return value;
  }

  public String toString() {
    return String.format("[%s] = %d", getPacketName(), getValue());
  }
}
