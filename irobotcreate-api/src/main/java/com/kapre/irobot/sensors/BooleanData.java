package com.kapre.irobot.sensors;

import com.google.common.base.Optional;

public class BooleanData extends AbstractSensorData {
  private Optional<Boolean> flag = Optional.absent();

  public BooleanData(String packetName, byte[] response) {
    super(packetName);
    if (response != null && response.length > 0) {
      if (response[0] > 0) {
        flag = Optional.of(true);
      } else {
        flag = Optional.of(false);
      }
    }
  }

  public Optional<Boolean> getFlag() {
    return flag;
  }

  public String toString() {
    return String.format("[%s] = %s", getPacketName(), flag.isPresent() ? flag
        .get().toString() : "No response.");
  }
}
