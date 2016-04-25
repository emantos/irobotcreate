package com.kapre.irobot.enums;

import com.google.common.base.Optional;

public enum Demo {
  ABORT(255),
  COVER(0),
  COVER_DOCK(1),
  SPOT_COVER(2),
  MOUSE(3),
  DRIVE_FIGURE_EIGHT(4),
  WIMP(5),
  HOME(6),
  TAG(7),
  PACHELBEL(8),
  BANJO(9);

  private int demoNumber;

  Demo(int demoNumber) {
    this.demoNumber = demoNumber;
  }

  public int getDemoNumber() {
    return demoNumber;
  }

  public static Optional<Demo> getDemo(int num) {
    for (Demo demo : Demo.values()) {
      if (demo.getDemoNumber() == num) {
        return Optional.of(demo);
      }
    }
    return Optional.absent();
  }
}
