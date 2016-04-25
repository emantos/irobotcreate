package com.kapre.irobot.sensors;

public class UnsignedByteData extends AbstractSensorData {
  private int value;

  public UnsignedByteData(String packetName, byte[] response) {
    super(packetName);
    this.value = response[0] & 0xff;
  }

  public int getValue() {
    return value;
  }

  public String toString() {
    return String.format("[%s] = %d", getPacketName(), value);
  }

}
