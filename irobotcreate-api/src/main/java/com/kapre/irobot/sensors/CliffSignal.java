package com.kapre.irobot.sensors;

public class CliffSignal extends UnsignedTwoBytes {

  public CliffSignal(String packetName, byte[] data) {
    super(packetName, data);
  }

  public int getCliffSignal() {
    return getValue();
  }
}
