package com.kapre.irobot.sensors;

public class BatteryTemperature extends AbstractSensorData {

  private byte temp;

  public BatteryTemperature(String packetName, byte[] response) {
    super(packetName);
    temp = response[0];
  }

  public byte getTemperature() {
    return temp;
  }

  public String toString() {
    return String.format("[%s] = %d", getPacketName(), temp);
  }
}
