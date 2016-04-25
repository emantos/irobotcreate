package com.kapre.irobot.enums;

import com.google.common.base.Optional;

public enum InfraredCharacter {
  LEFT(129),
  FORWARD(130),
  RIGHT(131),
  SPOT(132),
  MAX(133),
  SMALL(134),
  MEDIUM(135),
  LARGE_CLEAN(136),
  PAUSE(137),
  POWER(138),
  ARC_FORWARD_LEFT(139),
  ARC_FORWARD_RIGHT(140),
  DRIVE_STOP(141),
  SEND_ALL(142),
  SEEK_DOCK(143),
  RESERVED(240),
  RED_BUOY(248),
  GREEN_BUOY(244),
  FORCE_FIELD(242),
  RED_BUOY_GREEN_BUOY(252),
  RED_BUOY_FORCE_FIELD(250),
  GREEN_BUOY_FORCE_FIELD(246),
  RED_BUOY_GREEN_BUOY_FORCE_FIELD(254);

  public int value;

  InfraredCharacter(int value) {
    this.value = value;
  }

  public static Optional<InfraredCharacter> getCharacter(int value) {
    for (InfraredCharacter c : InfraredCharacter.values()) {
      if (c.value == value) {
        return Optional.of(c);
      }
    }

    return Optional.absent();
  }
}
