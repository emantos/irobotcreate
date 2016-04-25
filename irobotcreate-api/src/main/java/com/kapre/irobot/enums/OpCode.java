package com.kapre.irobot.enums;

public enum OpCode {
  START(128),
  BAUD(129),
  SAFE(131),
  FULL(132),
  DEMO(136),
  COVER(135),
  COVER_AND_DOCK(143),
  SPOT(134),
  DRIVE(137),
  DRIVE_DIRECT(145),
  LED(139),
  DIGITAL_OUTPUT(147),
  PWM(144),
  LOW_SIDE_DRIVER(138),
  SEND_IR(151),
  SONG(140),
  PLAY_SONG(141),
  SENSOR(142),
  QUERY_LIST(149),
  STREAM(148),
  PAUSE_RESUME_STREAM(150),
  SCRIPT(152),
  PLAY_SCRIPT(153),
  SHOW_SCRIPT(154),
  WAIT_TIME(155),
  WAIT_DISTANCE(156),
  WAIT_ANGLE(157),
  WAIT_EVENT(158);

  private int opCode;

  OpCode(int opCode) {
    this.opCode = opCode;
  }

  public int op() {
    return opCode;
  }
}
