package com.kapre.irobot;

import com.google.common.base.Optional;

public class IRobotCreate {

  private Connection connection;

  public IRobotCreate(Connection connection) {
    this.connection = connection;
  }

  public void init() {
    connection.open();
  }

  public Optional<SensorData> execute(Command command) {
    connection.send(command.getCommand());
    if (command.isExpectResponse()) {
      byte[] response = connection.recv(command.getLengthResponse());
      if (response != null && response.length == command.getLengthResponse()) {
        return Optional.of(command.getResponse(response));
      } else {
        throw new RuntimeException("Response is null or not of expected length.");
      }
    }

    return Optional.absent();
  }

  public void shutdown() {
    connection.close();
  }
}
