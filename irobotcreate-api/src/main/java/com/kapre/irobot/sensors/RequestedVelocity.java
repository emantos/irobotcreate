package com.kapre.irobot.sensors;

public class RequestedVelocity extends SignedTwoBytes {

  public RequestedVelocity(String packetName, byte[] data) {
    super(packetName, data);
  }

  public short getRequestedVelocity() {
    return getValue();
  }

}
