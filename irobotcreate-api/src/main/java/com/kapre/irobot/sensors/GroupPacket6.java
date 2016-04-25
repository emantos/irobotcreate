package com.kapre.irobot.sensors;

import java.util.Arrays;

import com.kapre.irobot.enums.SensorPacket;

public class GroupPacket6 extends AbstractSensorData {

  private GroupPacket1 packet1;
  private GroupPacket2 packet2;
  private GroupPacket3 packet3;
  private GroupPacket4 packet4;
  private GroupPacket5 packet5;

  public GroupPacket6(String packetName, byte[] response) {
    super(packetName);
    packet1 = new GroupPacket1(SensorPacket.GROUP_PACKET_1.packetName,
        Arrays.copyOfRange(response, 0, 10));
    packet2 = new GroupPacket2(SensorPacket.GROUP_PACKET_2.packetName,
        Arrays.copyOfRange(response, 10, 16));
    packet3 = new GroupPacket3(SensorPacket.GROUP_PACKET_3.packetName,
        Arrays.copyOfRange(response, 16, 26));
    packet4 = new GroupPacket4(SensorPacket.GROUP_PACKET_4.packetName,
        Arrays.copyOfRange(response, 26, 40));
    packet5 = new GroupPacket5(SensorPacket.GROUP_PACKET_5.packetName,
        Arrays.copyOfRange(response, 40, 52));
  }

  public GroupPacket1 getPacket1() {
    return packet1;
  }

  public GroupPacket2 getPacket2() {
    return packet2;
  }

  public GroupPacket3 getPacket3() {
    return packet3;
  }

  public GroupPacket4 getPacket4() {
    return packet4;
  }

  public GroupPacket5 getPacket5() {
    return packet5;
  }

  public String toString() {
    return String.format("[%s] = [%s, %s, %s, %s, %s]", getPacketName(),
        packet1.toString(), packet2.toString(), packet3.toString(),
        packet4.toString(), packet5.toString());
  }

}
