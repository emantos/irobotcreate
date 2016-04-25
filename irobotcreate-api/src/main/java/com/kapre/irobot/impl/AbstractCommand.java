package com.kapre.irobot.impl;

import java.util.Arrays;

import com.kapre.irobot.Command;
import com.kapre.irobot.SensorData;

public class AbstractCommand implements Command {

  private byte[] command;

  public void setCommand(byte[] command) {
    this.command = command;
  }

  public byte[] getCommand() {
    return command;
  }

  public boolean isExpectResponse() {
    return false;
  }

  public int getLengthResponse() {
    return 0;
  }

  public <K extends SensorData> K getResponse(byte[] response) {
    return null;
  }

  protected static byte[] concatAll(byte[] first, byte[]... rest) {
    int totalLength = first.length;
    for (byte[] array : rest) {
      totalLength += array.length;
    }
    byte[] result = Arrays.copyOf(first, totalLength);
    int offset = first.length;
    for (byte[] array : rest) {
      System.arraycopy(array, 0, result, offset, array.length);
      offset += array.length;
    }
    return result;
  }
}
