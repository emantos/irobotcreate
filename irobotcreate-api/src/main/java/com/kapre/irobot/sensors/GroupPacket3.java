package com.kapre.irobot.sensors;

import com.kapre.irobot.enums.SensorPacket;

public class GroupPacket3 extends AbstractSensorData {

  private CurrentChargingState chargingState;
  private Voltage voltage;
  private Current current;
  private BatteryTemperature batteryTemperature;
  private BatteryCharge batteryCharge;
  private BatteryCapacity batteryCapacity;

  public GroupPacket3(String packetName, byte[] response) {
    super(packetName);
    chargingState = new CurrentChargingState(
        SensorPacket.CHARGING_STATE.packetName, new byte[] { response[0] });
    voltage = new Voltage(SensorPacket.VOLTAGE.packetName, new byte[] {
        response[1], response[2] });
    current = new Current(SensorPacket.CURRENT.packetName, new byte[] {
        response[3], response[4] });
    batteryTemperature = new BatteryTemperature(
        SensorPacket.BATTERY_TEMPERATURE.packetName, new byte[] { response[5] });
    batteryCharge = new BatteryCharge(SensorPacket.BATTERY_CHARGE.packetName,
        new byte[] { response[6], response[7] });
    batteryCapacity = new BatteryCapacity(
        SensorPacket.BATTERY_CAPACITY.packetName, new byte[] { response[8],
            response[9] });
  }

  public CurrentChargingState getChargingState() {
    return chargingState;
  }

  public Voltage getVoltage() {
    return voltage;
  }

  public Current getCurrent() {
    return current;
  }

  public BatteryTemperature getBatteryTemperature() {
    return batteryTemperature;
  }

  public BatteryCharge getBatteryCharge() {
    return batteryCharge;
  }

  public BatteryCapacity getBatteryCapacity() {
    return batteryCapacity;
  }

  public String toString() {
    return String.format("[%s] = [%s, %s, %s, %s, %s]", getPacketName(),
        chargingState.toString(), voltage.toString(), current.toString(),
        batteryTemperature.toString(), batteryCharge.toString(),
        batteryCapacity.toString());
  }
}
