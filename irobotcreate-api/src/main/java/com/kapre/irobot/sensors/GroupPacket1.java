package com.kapre.irobot.sensors;

import com.kapre.irobot.enums.SensorPacket;

public class GroupPacket1 extends AbstractSensorData {
  private BumpsWheelDrops bumpsWheelDrops;
  private BooleanData wall;
  private BooleanData cliffLeft;
  private BooleanData cliffFrontLeft;
  private BooleanData cliffFrontRight;
  private BooleanData cliffRight;
  private BooleanData virtualWall;
  private LowSideDriverWheelOvercurrent lowSideDriverWheelOvercurrent;

  public GroupPacket1(String packetName, byte[] response) {
    super(packetName);
    this.bumpsWheelDrops = new BumpsWheelDrops(
        SensorPacket.BUMPS_WHEEL_DROPS.packetName, new byte[] { response[0] });
    this.wall = new BooleanData(SensorPacket.WALL.packetName,
        new byte[] { response[1] });
    this.cliffLeft = new BooleanData(SensorPacket.CLIFF_LEFT.packetName,
        new byte[] { response[2] });
    this.cliffFrontLeft = new BooleanData(
        SensorPacket.CLIFF_FRONT_LEFT.packetName, new byte[] { response[3] });
    this.cliffFrontRight = new BooleanData(
        SensorPacket.CLIFF_FRONT_RIGHT.packetName, new byte[] { response[4] });
    this.cliffRight = new BooleanData(SensorPacket.CLIFF_RIGHT.packetName,
        new byte[] { response[5] });
    this.virtualWall = new BooleanData(SensorPacket.VIRTUAL_WALL.packetName,
        new byte[] { response[6] });
    this.lowSideDriverWheelOvercurrent = new LowSideDriverWheelOvercurrent(
        SensorPacket.LOW_SIDE_DRIVER_OVERCURRENTS.packetName,
        new byte[] { response[7] });
  }

  public BumpsWheelDrops getBumpsWheelDrops() {
    return bumpsWheelDrops;
  }

  public BooleanData getWall() {
    return wall;
  }

  public BooleanData getCliffLeft() {
    return cliffLeft;
  }

  public BooleanData getCliffFrontLeft() {
    return cliffFrontLeft;
  }

  public BooleanData getCliffFrontRight() {
    return cliffFrontRight;
  }

  public BooleanData getCliffRight() {
    return cliffRight;
  }

  public BooleanData getVirtualWall() {
    return virtualWall;
  }

  public LowSideDriverWheelOvercurrent getLowSideDriverWheelOvercurrent() {
    return lowSideDriverWheelOvercurrent;
  }

  public String toString() {
    return String.format("[%s] = [%s, %s, %s, %s, %s, %s, %s, %s]",
        getPacketName(), bumpsWheelDrops.toString(), wall.toString(),
        cliffLeft.toString(), cliffFrontLeft.toString(),
        cliffFrontRight.toString(), cliffRight.toString(),
        virtualWall.toString(), lowSideDriverWheelOvercurrent.toString());
  }
}
