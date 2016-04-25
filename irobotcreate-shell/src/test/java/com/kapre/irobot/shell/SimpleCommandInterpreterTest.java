package com.kapre.irobot.shell;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kapre.irobot.Command;

public class SimpleCommandInterpreterTest {

  @Test
  public void test() throws InterpreterException {
    CommandInterpreter<Command> interpreter = CreateShell.buildInterpreter();

    assertFalse(interpreter.interpret("nonexistent").isPresent());

    Command command = interpreter.interpret("start").get();
    byte[] comm = command.getCommand();
    assertTrue(comm[0] == (byte) 128);

    command = interpreter.interpret("safe").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 131);

    command = interpreter.interpret("full").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 132);

    command = interpreter.interpret("baud 300").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 129);
    assertTrue(comm[1] == (byte) 0x00);

    command = interpreter.interpret("demo 9").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 136);
    assertTrue(comm[1] == (byte) 9);

    command = interpreter.interpret("demo").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 136);
    assertTrue(comm[1] == (byte) 255);

    command = interpreter.interpret("drive").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 137);
    assertTrue(comm[1] == (byte) 0x00);
    assertTrue(comm[2] == (byte) 0x00);
    assertTrue(comm[3] == (byte) 0x00);
    assertTrue(comm[4] == (byte) 0x00);

    command = interpreter.interpret("drive -200 500").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 137);
    assertTrue(comm[1] == (byte) 0xff);
    assertTrue(comm[2] == (byte) 0x38);
    assertTrue(comm[3] == (byte) 0x01);
    assertTrue(comm[4] == (byte) 0xf4);

    command = interpreter.interpret("drivedirect").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 145);
    assertTrue(comm[1] == (byte) 0x00);
    assertTrue(comm[2] == (byte) 0x00);
    assertTrue(comm[3] == (byte) 0x00);
    assertTrue(comm[4] == (byte) 0x00);

    command = interpreter.interpret("drivedirect -500 500").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 145);
    assertTrue(comm[1] == (byte) 0xfe);
    assertTrue(comm[2] == (byte) 0x0c);
    assertTrue(comm[3] == (byte) 0x01);
    assertTrue(comm[4] == (byte) 0xf4);

    command = interpreter.interpret("led false true 0 128").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 139);
    assertTrue(comm[1] == (byte) 0x08);
    assertTrue(comm[2] == (byte) 0x00);
    assertTrue(comm[3] == (byte) 128);

    command = interpreter.interpret("led true true 255 128").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 139);
    assertTrue(comm[1] == (byte) 0x0a);
    assertTrue(comm[2] == (byte) 0xff);
    assertTrue(comm[3] == (byte) 128);

    command = interpreter.interpret("dout true true true").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 147);
    assertTrue(comm[1] == (byte) 0x07);

    command = interpreter.interpret("dout true false false").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 147);
    assertTrue(comm[1] == (byte) 0x04);

    command = interpreter.interpret("dout false true false").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 147);
    assertTrue(comm[1] == (byte) 0x02);

    command = interpreter.interpret("dout false false true").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 147);
    assertTrue(comm[1] == (byte) 0x01);

    command = interpreter.interpret("dout false false false").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 147);
    assertTrue(comm[1] == (byte) 0x00);

    command = interpreter.interpret("dout true true false").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 147);
    assertTrue(comm[1] == (byte) 0x06);

    command = interpreter.interpret("lowsidepwm 128 128 128").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 144);
    assertTrue(comm[1] == (byte) 0x80);
    assertTrue(comm[1] == (byte) 0x80);
    assertTrue(comm[1] == (byte) 0x80);

    command = interpreter.interpret("lowside true true true").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 138);
    assertTrue(comm[1] == (byte) 0x07);

    command = interpreter.interpret("lowside true false false").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 138);
    assertTrue(comm[1] == (byte) 0x01);

    command = interpreter.interpret("lowside false true false").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 138);
    assertTrue(comm[1] == (byte) 0x02);

    command = interpreter.interpret("lowside false false true").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 138);
    assertTrue(comm[1] == (byte) 0x04);

    command = interpreter.interpret("lowside true true false").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 138);
    assertTrue(comm[1] == (byte) 0x03);

    command = interpreter.interpret("sendir 128").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 151);
    assertTrue(comm[1] == (byte) 0x80);

    command = interpreter.interpret("sendir 255").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 151);
    assertTrue(comm[1] == (byte) 0xff);

    command = interpreter.interpret("waittime 128").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 155);
    assertTrue(comm[1] == (byte) 0x80);

    command = interpreter.interpret("waitdistance 500").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 156);
    assertTrue(comm[1] == (byte) 0x01);
    assertTrue(comm[2] == (byte) 0xf4);

    command = interpreter.interpret("waitangle 500").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 157);
    assertTrue(comm[1] == (byte) 0x01);
    assertTrue(comm[2] == (byte) 0xf4);

    command = interpreter.interpret("moveto 500 100").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 137);
    assertTrue(comm[1] == (byte) 0x00);
    assertTrue(comm[2] == (byte) 0x64);
    assertTrue(comm[3] == (byte) 0x7f);
    assertTrue(comm[4] == (byte) 0xff);
    assertTrue(comm[5] == (byte) 0x9c);
    assertTrue(comm[6] == (byte) 0x01);
    assertTrue(comm[7] == (byte) 0xf4);
    assertTrue(comm[8] == (byte) 137);
    assertTrue(comm[9] == (byte) 0x00);
    assertTrue(comm[10] == (byte) 0x00);
    assertTrue(comm[11] == (byte) 0x00);
    assertTrue(comm[12] == (byte) 0x00);

    try {
      command = interpreter.interpret("moveto -500 100").get();
      fail("passing a negative distance and positive velocity should have raised an exception.");
    } catch (InterpreterException e) {
      if (!(e.getCause().getCause() instanceof IllegalArgumentException)) {
        fail("Should have gotten an IllegalArgumentException");
      }
    }

    command = interpreter.interpret("turn 90 50").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 0x89);
    assertTrue(comm[1] == (byte) 0x00);
    assertTrue(comm[2] == (byte) 0x32);
    assertTrue(comm[3] == (byte) 0x00);
    assertTrue(comm[4] == (byte) 0x01);
    assertTrue(comm[5] == (byte) 0x9d);
    assertTrue(comm[6] == (byte) 0x00);
    assertTrue(comm[7] == (byte) 0x5a);
    assertTrue(comm[8] == (byte) 0x89);
    assertTrue(comm[9] == (byte) 0x00);
    assertTrue(comm[10] == (byte) 0x00);
    assertTrue(comm[11] == (byte) 0x00);
    assertTrue(comm[12] == (byte) 0x00);

    command = interpreter.interpret("sensor 7").get();
    comm = command.getCommand();
    assertTrue(comm[0] == (byte) 142);
    assertTrue(comm[1] == (byte) 7);
  }
}
