package com.kapre.irobot.sensors;

public class LowSideDriverWheelOvercurrent extends FiveBitsData {
  private static String[] NAMES = { "LD-1", "LD-0", "LD-2", "Right Wheel",
      "Left Wheel" };

  public LowSideDriverWheelOvercurrent(String packetName, byte[] response) {
    super(packetName, response);
  }

  public Boolean getLd0() {
    return getParameter(1);
  }

  public Boolean getLd1() {
    return getParameter(0);
  }

  public Boolean getLd2() {
    return getParameter(2);
  }

  public Boolean getRightWheel() {
    return getParameter(3);
  }

  public Boolean getLeftWheel() {
    return getParameter(4);
  }

  protected String[] getParameterNames() {
    return NAMES;
  }
}
