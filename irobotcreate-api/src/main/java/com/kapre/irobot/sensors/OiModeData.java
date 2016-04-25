package com.kapre.irobot.sensors;

import com.google.common.base.Optional;
import com.kapre.irobot.enums.OiMode;

public class OiModeData extends UnsignedByteData {
  public OiModeData(String packetName, byte[] response) {
    super(packetName, response);
  }

  public Optional<OiMode> getOiMode() {
    return OiMode.getOiMode(getValue());
  }
}
