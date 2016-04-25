package com.kapre.irobot.sensors;

import com.google.common.base.Optional;
import com.kapre.irobot.enums.ChargingState;

public class CurrentChargingState extends AbstractSensorData {
  private ChargingState state;

  public CurrentChargingState(String packetName, byte[] data) {
    super(packetName);
    Optional<ChargingState> chargingState = ChargingState
        .getChargingState(data[0]);
    if (chargingState.isPresent()) {
      state = chargingState.get();
    } else {
      throw new RuntimeException("Charging State has invalid value : "
          + data[0]);
    }
  }

  public ChargingState getChargingState() {
    return state;
  }

  public String toString() {
    return String.format("[%s] = [%d - %s]", getPacketName(), state.code,
        state.stateName);
  }
}
