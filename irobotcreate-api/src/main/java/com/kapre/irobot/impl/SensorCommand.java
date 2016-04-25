package com.kapre.irobot.impl;

import java.lang.reflect.Constructor;

import com.kapre.irobot.SensorData;
import com.kapre.irobot.enums.OpCode;
import com.kapre.irobot.enums.SensorPacket;

public class SensorCommand extends AbstractCommand {

  private SensorPacket sensorPacket = null;

  public SensorCommand(Integer packetId) {
    if (packetId < 0 || packetId > 42) {
      throw new IllegalArgumentException("packetId must be between 0 and 42");
    }

    sensorPacket = SensorPacket.getSensorPacket(packetId).get();
    setCommand(new byte[] { (byte) OpCode.SENSOR.op(), packetId.byteValue() });
  }

  public boolean isExpectResponse() {
    return true;
  }

  public int getLengthResponse() {
    return sensorPacket.numBytesResponse;
  }

  @SuppressWarnings("unchecked")
  public <K extends SensorData> K getResponse(byte[] response) {
    try {
      Constructor<? extends SensorData> responseConstructor = sensorPacket.responseClassType
          .getConstructor(String.class, byte[].class);
      return (K) responseConstructor.newInstance(sensorPacket.packetName,
          response);
    } catch (Exception e) {
      throw new RuntimeException(
          "This shouldn't have happened but if it did, contact me at emantos@gmail.com");
    }
  }
}
