package com.kapre.irobot.shell;

public class InterpreterException extends RuntimeException {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public InterpreterException(Throwable e) {
    super("Interpreter choked!", e);
  }
}
