package com.kapre.irobot.sensors;

public class WallSignal extends UnsignedTwoBytes {

  public WallSignal(String packetName, byte[] data) {
    super(packetName, data);
  }

  public int getWallSignal() {
    return getValue();
  }
}
