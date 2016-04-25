package com.kapre.irobot.sensors;

public class ChargingSourcesAvailable extends AbstractSensorData {
  private boolean homeBase;
  private boolean internalCharger;

  public ChargingSourcesAvailable(String packetName, byte[] response) {
    super(packetName);
    internalCharger = ((response[0] & 0x01) > 0);
    homeBase = ((response[0] & 0x02) > 0);
  }

  public boolean isHomeBase() {
    return homeBase;
  }

  public boolean isInternalCharger() {
    return internalCharger;
  }

  public String toString() {
    return String.format("[%s] = [Home Base = %s, Internal Charger = %s]",
        getPacketName(), homeBase, internalCharger);
  }
}
