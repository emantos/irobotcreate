package com.kapre.irobot.enums;

public enum Event {
  WHEEL_DROP((byte) 1),
  NWHEEL_DROP((byte) 255),
  FRONT_WHEEL_DROP((byte) 2),
  NFRONT_WHEEL_DROP((byte) 254),
  LEFT_WHEEL_DROP((byte) 3),
  NLEFT_WHEEL_DROP((byte) 253),
  RIGHT_WHEEL_DROP((byte) 4),
  NRIGHT_WHEEL_DROP((byte) 252),
  BUMP((byte) 5),
  NBUMP((byte) 251),
  LEFT_BUMP((byte) 6),
  NLEFT_BUMP((byte) 250),
  RIGHT_BUMP((byte) 7),
  NRIGHT_BUMP((byte) 249),
  VIRTUAL_WALL((byte) 8),
  NVIRTUAL_WALL((byte) 248),
  WALL((byte) 9),
  NWALL((byte) 247),
  CLIFF((byte) 10),
  NCLIFF((byte) 246),
  LEFT_CLIFF((byte) 11),
  NLEFT_CLIFF((byte) 245),
  FRONT_LEFT_CLIFF((byte) 12),
  NFRONT_LEFT_CLIFF((byte) 244),
  FRONT_RIGHT_CLIFF((byte) 13),
  NFRONT_RIGHT_CLIFF((byte) 243),
  RIGHT_CLIFF((byte) 14),
  NRIGHT_CLIFF((byte) 242),
  HOME_BASE((byte) 15),
  NHOME_BASE((byte) 241),
  ADVANCE_BUTTON((byte) 16),
  NADVANCE_BUTTON((byte) 240),
  PLAY_BUTTON((byte) 17),
  NPLAY_BUTTON((byte) 239),
  DIGITAL_INPUT0((byte) 18),
  NDIGITAL_INPUT0((byte) 238),
  DIGITAL_INPUT1((byte) 19),
  NDIGITAL_INPUT1((byte) 237),
  DIGITAL_INPUT2((byte) 20),
  NDIGITAL_INPUT2((byte) 236),
  DIGITAL_INPUT3((byte) 21),
  NDIGITAL_INPUT3((byte) 235),
  OI_MODE_PASSIVE((byte) 22),
  NOI_MODE_PASSIVE((byte) 234);

  public Byte byteEquivalent;

  Event(Byte eventEquivalent) {
    byteEquivalent = eventEquivalent;
  }
}
