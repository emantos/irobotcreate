package com.kapre.irobot.sensors;

public class CargoBayDigitalInputs extends AbstractSensorData {
  public boolean deviceDetect;
  public boolean digitalInput3;
  public boolean digitalInput2;
  public boolean digitalInput1;
  public boolean digitalInput0;

  public CargoBayDigitalInputs(String packetName, byte[] response) {
    super(packetName);
    digitalInput0 = ((response[0] & 0x01) > 0);
    digitalInput1 = ((response[0] & 0x02) > 0);
    digitalInput2 = ((response[0] & 0x04) > 0);
    digitalInput3 = ((response[0] & 0x08) > 0);
    deviceDetect = ((response[0] & 0x10) > 0);
  }

  public boolean isDeviceDetect() {
    return deviceDetect;
  }

  public boolean isDigitalInput3() {
    return digitalInput3;
  }

  public boolean isDigitalInput2() {
    return digitalInput2;
  }

  public boolean isDigitalInput1() {
    return digitalInput1;
  }

  public boolean isDigitalInput0() {
    return digitalInput0;
  }

  public String toString() {
    return String.format("[%s] = [device detect = %s, digital input 3 = %s, "
        + "digital input 2 = %s, digital input 1 = %s, digital input 0 = %s]",
        getPacketName(), deviceDetect, digitalInput3, digitalInput2,
        digitalInput1, digitalInput0);
  }
}
