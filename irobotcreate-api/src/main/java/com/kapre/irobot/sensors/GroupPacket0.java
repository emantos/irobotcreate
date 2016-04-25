package com.kapre.irobot.sensors;

import java.util.Arrays;

import com.kapre.irobot.enums.SensorPacket;

public class GroupPacket0 extends AbstractSensorData {

  private GroupPacket1 packet1;
  private GroupPacket2 packet2;
  private GroupPacket3 packet3;

  public GroupPacket0(String packetName, byte[] response) {
    super(packetName);
    packet1 = new GroupPacket1(SensorPacket.GROUP_PACKET_1.packetName,
        Arrays.copyOfRange(response, 0, 10));
    packet2 = new GroupPacket2(SensorPacket.GROUP_PACKET_2.packetName,
        Arrays.copyOfRange(response, 10, 16));
    packet3 = new GroupPacket3(SensorPacket.GROUP_PACKET_3.packetName,
        Arrays.copyOfRange(response, 16, 26));
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

  public String toString() {
    return String.format("[%s] = [%s, %s, %s]", getPacketName(),
        packet1.toString(), packet2.toString(), packet3.toString());
  }
}
