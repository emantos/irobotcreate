package com.kapre.irobot.enums;

import com.google.common.base.Optional;

public enum OiMode {
  OFF(0),
  PASSIVE(1),
  SAFE(2),
  FULL(3);

  public int number;

  OiMode(int number) {
    this.number = number;
  }

  public static Optional<OiMode> getOiMode(int number) {
    for (OiMode mode : OiMode.values()) {
      if (mode.number == number) {
        return Optional.of(mode);
      }
    }

    return Optional.absent();
  }
}
