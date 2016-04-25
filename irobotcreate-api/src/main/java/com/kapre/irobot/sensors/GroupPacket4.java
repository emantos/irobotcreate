package com.kapre.irobot.sensors;

import com.kapre.irobot.enums.SensorPacket;

public class GroupPacket4 extends AbstractSensorData {

  private WallSignal wallSignal;
  private CliffSignal cliffLeftSignal;
  private CliffSignal cliffFrontLeftSignal;
  private CliffSignal cliffFrontRightSignal;
  private CliffSignal cliffRightSignal;
  private CargoBayDigitalInputs cargoBayDigitalInputs;
  private CargoBayAnalogSignal cargoBayAnalogSignal;
  private ChargingSourcesAvailable chargingSourcesAvailable;

  public GroupPacket4(String packetName, byte[] response) {
    super(packetName);
    wallSignal = new WallSignal(SensorPacket.WALL_SIGNAL.packetName,
        new byte[] { response[0], response[1] });
    cliffLeftSignal = new CliffSignal(
        SensorPacket.CLIFF_LEFT_SIGNAL.packetName, new byte[] { response[2],
            response[3] });
    cliffFrontLeftSignal = new CliffSignal(
        SensorPacket.CLIFF_FRONT_LEFT_SIGNAL.packetName, new byte[] {
            response[4], response[5] });
    cliffFrontRightSignal = new CliffSignal(
        SensorPacket.CLIFF_FRONT_RIGHT_SIGNAL.packetName, new byte[] {
            response[6], response[7] });
    cliffRightSignal = new CliffSignal(
        SensorPacket.CLIFF_RIGHT_SIGNAL.packetName, new byte[] { response[8],
            response[9] });
    cargoBayDigitalInputs = new CargoBayDigitalInputs(
        SensorPacket.CARGO_BAY_DIGITAL_INPUTS.packetName,
        new byte[] { response[10] });
    cargoBayAnalogSignal = new CargoBayAnalogSignal(
        SensorPacket.CARGO_BAY_ANALOG_SIGNAL.packetName, new byte[] {
            response[11], response[12] });
    chargingSourcesAvailable = new ChargingSourcesAvailable(
        SensorPacket.CHARGING_SOURCES_AVAILABLE.packetName,
        new byte[] { response[13] });
  }

  public WallSignal getWallSignal() {
    return wallSignal;
  }

  public CliffSignal getCliffLeftSignal() {
    return cliffLeftSignal;
  }

  public CliffSignal getCliffFrontLeftSignal() {
    return cliffFrontLeftSignal;
  }

  public CliffSignal getCliffFrontRightSignal() {
    return cliffFrontRightSignal;
  }

  public CliffSignal getCliffRightSignal() {
    return cliffRightSignal;
  }

  public CargoBayDigitalInputs getCargoBayDigitalInputs() {
    return cargoBayDigitalInputs;
  }

  public CargoBayAnalogSignal getCargoBayAnalogSignal() {
    return cargoBayAnalogSignal;
  }

  public ChargingSourcesAvailable getChargingSourcesAvailable() {
    return chargingSourcesAvailable;
  }

  public String toString() {
    return String.format("[%s] = [%s, %s, %s, %s, %s, %s, %s, %s]",
        getPacketName(), wallSignal.toString(), cliffLeftSignal.toString(),
        cliffFrontLeftSignal.toString(), cliffFrontRightSignal.toString(),
        cliffRightSignal.toString(), cargoBayDigitalInputs.toString(),
        cargoBayAnalogSignal.toString(), chargingSourcesAvailable.toString());
  }
}
