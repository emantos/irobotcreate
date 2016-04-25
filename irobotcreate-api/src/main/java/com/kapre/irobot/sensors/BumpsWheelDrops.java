package com.kapre.irobot.sensors;

public class BumpsWheelDrops extends FiveBitsData {
  public static String[] NAMES = { "Bump Right", "Bump Left",
      "Wheeldrop Right", "Wheeldrop Left", "Wheeldrop Caster" };

  public BumpsWheelDrops(String packetName, byte[] response) {
    super(packetName, response);
  }

  public Boolean getBumpRight() {
    return getParameter(0);
  }

  public Boolean getBumpLeft() {
    return getParameter(1);
  }

  public Boolean getWheeldropRight() {
    return getParameter(2);
  }

  public Boolean getWheeldropLeft() {
    return getParameter(3);
  }

  public Boolean getWheeldropCaster() {
    return getParameter(4);
  }

  public String[] getParameterNames() {
    return NAMES;
  }
}
