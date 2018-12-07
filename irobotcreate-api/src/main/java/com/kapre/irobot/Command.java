package com.kapre.irobot;


public interface Command {
  byte[] getCommand();

  boolean isExpectResponse();

  int getResponseLength();

  <K extends SensorData> K getResponse(byte[] response);
}
