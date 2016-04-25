package com.kapre.irobot.sensors;

import com.kapre.irobot.enums.SensorPacket;

public class GroupPacket5 extends AbstractSensorData {

  private OiModeData oiMode;
  private UnsignedByteData songNumber;
  private UnsignedByteData songPlaying;
  private UnsignedByteData numStreamPackets;
  private RequestedVelocity requestedVelocity;
  private RequestedRadius requestedRadius;
  private RequestedVelocity requestedVelocityRight;
  private RequestedVelocity requestedVelocityLeft;

  public GroupPacket5(String packetName, byte[] response) {
    super(packetName);
    oiMode = new OiModeData(SensorPacket.OI_MODE.packetName,
        new byte[] { response[0] });
    songNumber = new UnsignedByteData(SensorPacket.SONG_NUMBER.packetName,
        new byte[] { response[1] });
    songPlaying = new UnsignedByteData(SensorPacket.SONG_PLAYING.packetName,
        new byte[] { response[2] });
    numStreamPackets = new UnsignedByteData(
        SensorPacket.NUM_STREAM_PACKETS.packetName, new byte[] { response[3] });
    requestedVelocity = new RequestedVelocity(
        SensorPacket.REQUESTED_VELOCITY.packetName, new byte[] { response[4],
            response[5] });
    requestedRadius = new RequestedRadius(
        SensorPacket.REQUESTED_RADIUS.packetName, new byte[] { response[6],
            response[7] });
    requestedVelocityRight = new RequestedVelocity(
        SensorPacket.REQUESTED_RIGHT_VELOCITY.packetName, new byte[] {
            response[8], response[9] });
    requestedVelocityLeft = new RequestedVelocity(
        SensorPacket.REQUESTED_LEFT_VELOCITY.packetName, new byte[] {
            response[10], response[11] });
  }

  public OiModeData getOiMode() {
    return oiMode;
  }

  public UnsignedByteData getSongNumber() {
    return songNumber;
  }

  public UnsignedByteData getSongPlaying() {
    return songPlaying;
  }

  public UnsignedByteData getNumStreamPackets() {
    return numStreamPackets;
  }

  public RequestedVelocity getRequestedVelocity() {
    return requestedVelocity;
  }

  public RequestedRadius getRequestedRadius() {
    return requestedRadius;
  }

  public RequestedVelocity getRequestedVelocityRight() {
    return requestedVelocityRight;
  }

  public RequestedVelocity getRequestedVelocityLeft() {
    return requestedVelocityLeft;
  }

  public String toString() {
    return String.format("[%s] = [%s, %s, %s, %s, %s, %s, %s, %s]",
        getPacketName(), oiMode.toString(), songNumber.toString(),
        songPlaying.toString(), numStreamPackets.toString(),
        requestedVelocity.toString(), requestedRadius.toString(),
        requestedVelocityRight.toString(), requestedVelocityLeft.toString());
  }

}
