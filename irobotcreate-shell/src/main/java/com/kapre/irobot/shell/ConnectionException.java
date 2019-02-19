package com.kapre.irobot.shell;

public class ConnectionException extends RuntimeException {

  private static final long serialVersionUID = -494807961572595232L;

  public ConnectionException(String message) {
    super(message);
  }

  public ConnectionException(String message, Throwable cause) {
    super(message, cause);
  }

}
