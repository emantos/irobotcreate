package com.kapre.irobot.sensors;

import com.kapre.irobot.enums.SensorPacket;

public class GroupPacket2 extends AbstractSensorData {

  private Infrared infrared;
  private Buttons buttons;
  private Distance distance;
  private Angle angle;

  public GroupPacket2(String packetName, byte[] response) {
    super(packetName);
    infrared = new Infrared(SensorPacket.INFRARED_BYTE.packetName,
        new byte[] { response[0] });
    buttons = new Buttons(SensorPacket.BUTTONS.packetName,
        new byte[] { response[1] });
    distance = new Distance(SensorPacket.DISTANCE.packetName, new byte[] {
        response[2], response[3] });
    angle = new Angle(SensorPacket.ANGLE.packetName, new byte[] { response[4],
        response[5] });
  }

  public Infrared getInfrared() {
    return infrared;
  }

  public Buttons getButtons() {
    return buttons;
  }

  public Distance getDistance() {
    return distance;
  }

  public Angle getAngle() {
    return angle;
  }

  public String toString() {
    return String.format("[%s] = [%s, %s, %s, %s]", getPacketName(),
        infrared.toString(), buttons.toString(), distance.toString(),
        angle.toString());
  }
}
