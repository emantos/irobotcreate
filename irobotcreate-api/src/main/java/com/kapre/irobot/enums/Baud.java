package com.kapre.irobot.enums;

import com.google.common.base.Optional;

public enum Baud {
  _300(0, 300),
  _600(1, 600),
  _1200(2, 1200),
  _2400(3, 2400),
  _4800(4, 4800),
  _9600(5, 9600),
  _14400(6, 14400),
  _19200(7, 19200),
  _28800(8, 28800),
  _38400(9, 38400),
  _57600(10, 57600),
  _115200(11, 115200);

  private int baudCode;
  private int actualBaudCode;

  Baud(int code, int actualBaudCode) {
    this.baudCode = code;
    this.actualBaudCode = actualBaudCode;
  }

  public int getBaudCode() {
    return baudCode;
  }

  public int getBaud() {
    return actualBaudCode;
  }

  public static Optional<Baud> getBaud(int actualBaudCode) {
    for (Baud baud : Baud.values()) {
      if (actualBaudCode == baud.getBaud()) {
        return Optional.of(baud);
      }
    }
    return Optional.absent();
  }
}
