package com.kapre.irobot.enums;

import com.google.common.base.Optional;

public enum ChargingState {

  NOT_CHARGING(0, "Not Charging"),
  RECONDITIONING_CHARGING(1, "Reconditioning Charging"),
  FULL_CHARGING(2, "Full Charging"),
  TRICKLE_CHARGING(3, "Trickle Charging"),
  WAITING(4, "Waiting"),
  CHARGING_FAULT_CONDITION(5, "Charging Fault Condition");

  public int code;
  public String stateName;

  ChargingState(int code, String stateName) {
    this.code = code;
    this.stateName = stateName;
  }

  public static Optional<ChargingState> getChargingState(int code) {
    for (ChargingState state : ChargingState.values()) {
      if (state.code == code) {
        return Optional.of(state);
      }
    }

    return Optional.absent();
  }
}
