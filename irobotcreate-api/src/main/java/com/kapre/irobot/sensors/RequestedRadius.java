package com.kapre.irobot.sensors;

public class RequestedRadius extends SignedTwoBytes {

  public RequestedRadius(String packetName, byte[] data) {
    super(packetName, data);
  }

  public short getRequestedRadius() {
    return getValue();
  }
}
