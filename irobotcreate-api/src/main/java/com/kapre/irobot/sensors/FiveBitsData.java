package com.kapre.irobot.sensors;

public abstract class FiveBitsData extends AbstractSensorData {
  public Boolean[] parameters = new Boolean[] { null, null, null, null, null };

  public FiveBitsData(String packetName, byte[] response) {
    super(packetName);
    if (response != null && response.length > 0) {
      parameters[0] = ((response[0] & 0x01) > 0);
      parameters[1] = ((response[0] & 0x02) > 0);
      parameters[2] = ((response[0] & 0x04) > 0);
      parameters[3] = ((response[0] & 0x08) > 0);
      parameters[4] = ((response[0] & 0x10) > 0);
    }
  }

  public Boolean getParameter(int num) {
    return parameters[num];
  }

  public String toString() {
    String[] parameterNames = getParameterNames();
    return String.format(
        "[%s] = [%s = %s, %s = %s, %s = %s, %s = %s, %s = %s]",
        getPacketName(), parameterNames[0], nullOrStr(parameters[0]),
        parameterNames[1], nullOrStr(parameters[1]), parameterNames[2],
        nullOrStr(parameters[2]), parameterNames[3], nullOrStr(parameters[3]),
        parameterNames[4], nullOrStr(parameters[4]));
  }

  private String nullOrStr(Boolean b) {
    return b == null ? "null" : b.toString();
  };

  protected abstract String[] getParameterNames();
}
