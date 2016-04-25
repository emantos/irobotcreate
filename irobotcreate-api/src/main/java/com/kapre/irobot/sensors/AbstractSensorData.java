package com.kapre.irobot.sensors;

import com.kapre.irobot.SensorData;

public abstract class AbstractSensorData implements SensorData {

  private String packetName;

  public AbstractSensorData(String packetName) {
    this.packetName = packetName;
  }

  public String getPacketName() {
    return packetName;
  }
}
