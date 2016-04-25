package com.kapre.irobot;


public interface Command {
  byte[] getCommand();

  boolean isExpectResponse();

  int getLengthResponse();

  <K extends SensorData> K getResponse(byte[] response);
}
