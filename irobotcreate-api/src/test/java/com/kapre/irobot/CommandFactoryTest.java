package com.kapre.irobot;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.kapre.irobot.enums.Baud;
import com.kapre.irobot.enums.Demo;

public class CommandFactoryTest {

  @Test
  public void testBaudAndDemo() {
    Command command = CommandFactory.setBaud(Baud._300);
    byte[] comm = command.getCommand();
    assertTrue(comm[0] == (byte) 129);
    assertTrue(comm[1] == (byte) 0x00);

    command = CommandFactory.demo(Demo.BANJO);
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 136);
    assertTrue(comm[1] == (byte) 9);

    command = CommandFactory.demo(Demo.ABORT);
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 136);
    assertTrue(comm[1] == (byte) 255);
  }

  @Test
  public void testStartSafeFull() {
    Command command = CommandFactory.start();
    byte[] comm = command.getCommand();
    assertTrue(comm[0] == (byte) 128);

    command = CommandFactory.setSafe();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 131);

    command = CommandFactory.setFull();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 132);
  }

  @Test
  public void testDriveAndDriveDirect() {
    Command command = CommandFactory.drive((short) -200, (short) 500);
    byte[] comm = command.getCommand();
    assertTrue(comm[0] == (byte) 137);
    assertTrue(comm[1] == (byte) 0xff);
    assertTrue(comm[2] == (byte) 0x38);
    assertTrue(comm[3] == (byte) 0x01);
    assertTrue(comm[4] == (byte) 0xf4);

    command = CommandFactory.drive((short) 100, (short) 0);
    comm = command.getCommand();

    command = CommandFactory.driveDirect((short) -500, (short) 500);
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 145);
    assertTrue(comm[1] == (byte) 0xfe);
    assertTrue(comm[2] == (byte) 0x0c);
    assertTrue(comm[3] == (byte) 0x01);
    assertTrue(comm[4] == (byte) 0xf4);
  }

  @Test
  public void testLed() {
    Command command = CommandFactory.setLed(false, true, 0, 128);
    byte[] comm = command.getCommand();
    assertTrue(comm[0] == (byte) 139);
    assertTrue(comm[1] == (byte) 0x08);
    assertTrue(comm[2] == (byte) 0x00);
    assertTrue(comm[3] == (byte) 128);

    command = CommandFactory.setLed(true, true, 255, 128);
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 139);
    assertTrue(comm[1] == (byte) 0x0a);
    assertTrue(comm[2] == (byte) 0xff);
    assertTrue(comm[3] == (byte) 128);
  }

  @Test
  public void testDigitalOut() {
    Command command = CommandFactory.setDigitalOutput(true, true, true);
    byte[] comm = command.getCommand();
    assertTrue(comm[0] == (byte) 147);
    assertTrue(comm[1] == (byte) 0x07);

    command = CommandFactory.setDigitalOutput(true, false, false);
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 147);
    assertTrue(comm[1] == (byte) 0x04);

    command = CommandFactory.setDigitalOutput(false, true, false);
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 147);
    assertTrue(comm[1] == (byte) 0x02);

    command = CommandFactory.setDigitalOutput(false, false, true);
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 147);
    assertTrue(comm[1] == (byte) 0x01);

    command = CommandFactory.setDigitalOutput(false, false, false);
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 147);
    assertTrue(comm[1] == (byte) 0x00);

    command = CommandFactory.setDigitalOutput(true, true, false);
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 147);
    assertTrue(comm[1] == (byte) 0x06);
  }

  @Test
  public void testPwmLowSide() {
    Command command = CommandFactory.setPwmLowSide(128, 128, 128);
    byte[] comm = command.getCommand();
    assertTrue(comm[0] == (byte) 144);
    assertTrue(comm[1] == (byte) 0x80);
    assertTrue(comm[1] == (byte) 0x80);
    assertTrue(comm[1] == (byte) 0x80);
  }

  @Test
  public void testLowSide() {
    Command command = CommandFactory.setLowSide(true, true, true);
    byte[] comm = command.getCommand();
    assertTrue(comm[0] == (byte) 138);
    assertTrue(comm[1] == (byte) 0x07);

    command = CommandFactory.setLowSide(true, false, false);
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 138);
    assertTrue(comm[1] == (byte) 0x01);

    command = CommandFactory.setLowSide(false, true, false);
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 138);
    assertTrue(comm[1] == (byte) 0x02);

    command = CommandFactory.setLowSide(false, false, true);
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 138);
    assertTrue(comm[1] == (byte) 0x04);

    command = CommandFactory.setLowSide(true, true, false);
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 138);
    assertTrue(comm[1] == (byte) 0x03);
  }

  @Test
  public void testSendIR() {
    Command command = CommandFactory.sendIR(128);
    byte[] comm = command.getCommand();
    assertTrue(comm[0] == (byte) 151);
    assertTrue(comm[1] == (byte) 0x80);
  }
}
