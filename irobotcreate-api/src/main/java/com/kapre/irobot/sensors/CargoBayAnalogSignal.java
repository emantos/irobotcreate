package com.kapre.irobot.sensors;

public class CargoBayAnalogSignal extends UnsignedTwoBytes {

  public CargoBayAnalogSignal(String packetName, byte[] data) {
    super(packetName, data);
  }

  public int getAnalogValue() {
    return getValue();
  }
}
