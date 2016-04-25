package com.kapre.irobot.sensors;

public class SignedTwoBytes extends AbstractSensorData {
  public short value = 0;

  public SignedTwoBytes(String packetName, byte[] data) {
    super(packetName);
    this.value = (short) (((this.value | data[0]) << 8) | data[1]);
  }

  public short getValue() {
    return value;
  }

  public String toString() {
    return String.format("[%s] = %d", getPacketName(), getValue());
  }
}
