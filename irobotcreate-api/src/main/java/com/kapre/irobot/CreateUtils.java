package com.kapre.irobot;

public class CreateUtils {
  public static String toHexString(byte[] comms) {
    StringBuilder str = new StringBuilder();
    for (byte comm : comms) {
      str.append(String.format("%02x ", comm));
    }
    return str.toString();
  }
}
