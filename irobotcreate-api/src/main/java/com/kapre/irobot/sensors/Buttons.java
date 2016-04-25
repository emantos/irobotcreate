package com.kapre.irobot.sensors;

public class Buttons extends AbstractSensorData {
  private boolean advanceButton;
  private boolean playButton;

  public Buttons(String packetName, byte[] response) {
    super(packetName);
    playButton = ((response[0] & 1) > 0);
    advanceButton = ((response[0] & 4) > 0);
  }

  public boolean isAdvanceButton() {
    return advanceButton;
  }

  public boolean isPlayButton() {
    return playButton;
  }

  public String toString() {
    return String.format("[%s] = [Advance Button = %s, Play Button = %s]",
        getPacketName(), Boolean.valueOf(advanceButton).toString(), Boolean
            .valueOf(playButton).toString());
  }
}
