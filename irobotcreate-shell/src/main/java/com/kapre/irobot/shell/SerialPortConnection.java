package com.kapre.irobot.shell;

import com.kapre.irobot.Connection;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortTimeoutException;

public class SerialPortConnection implements Connection {

  private SerialPort serialPort;
  private int recvTimeout;

  public SerialPortConnection(String portAddress, int defaultTimeout) {
    serialPort = new SerialPort(portAddress);
    recvTimeout = defaultTimeout;
  }

  public void open() {
    try {
      serialPort.openPort();
      serialPort.setParams(SerialPort.BAUDRATE_57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
          SerialPort.PARITY_NONE);
    } catch (SerialPortException e) {
      throw new ConnectionException("Error opening serial port", e);
    }
  }

  public void send(byte[] bytes) {
    try {
      serialPort.writeBytes(bytes);
    } catch (SerialPortException e) {
      throw new ConnectionException("Error sending through serial port", e);
    }
  }

  public byte[] recv(int length) {
    try {
      return serialPort.readBytes(length, recvTimeout);
    } catch (SerialPortTimeoutException e) {
      throw new ConnectionException(
          "Not able to receive " + length + " amount of bytes from serial port within " + recvTimeout, e);
    } catch (SerialPortException e) {
      throw new ConnectionException("Error receiving through serial port", e);
    }
  }

  public void close() {
    try {
      serialPort.closePort();
    } catch (SerialPortException e) {
      throw new ConnectionException("Error closing serial port", e);
    }
  }

}
