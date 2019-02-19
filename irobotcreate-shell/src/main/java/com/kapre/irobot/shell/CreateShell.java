package com.kapre.irobot.shell;

import java.io.Console;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.kapre.irobot.Command;
import com.kapre.irobot.Connection;
import com.kapre.irobot.IRobotCreate;
import com.kapre.irobot.IRobotCreateException;
import com.kapre.irobot.SensorData;
import com.kapre.irobot.enums.OpCode;
import com.kapre.irobot.impl.BaudCommand;
import com.kapre.irobot.impl.DemoCommand;
import com.kapre.irobot.impl.DigitalOutputCommand;
import com.kapre.irobot.impl.DriveCommand;
import com.kapre.irobot.impl.LedCommand;
import com.kapre.irobot.impl.LowSideDriver;
import com.kapre.irobot.impl.MoveToCommand;
import com.kapre.irobot.impl.OpCommand;
import com.kapre.irobot.impl.SensorCommand;
import com.kapre.irobot.impl.TurnCommand;
import com.kapre.irobot.impl.WaitCommand;
import jssc.SerialPortList;

public class CreateShell {

  private static final int DEFAULT_TIMEOUT = 10000;

  public static void main(String[] args) {
    Console console = System.console();

    Optional<String> serialPort = getSerialPort(console);

    /* Bail out if no serial port is present */
    if (!serialPort.isPresent()) {
      console.printf("No serial port detected.\n");
      return;
    }

    Connection connection = new SerialPortConnection(serialPort.get(), DEFAULT_TIMEOUT);
    IRobotCreate executor = new IRobotCreate(connection);
    
    CommandInterpreter<Command> commandInterpreter = buildInterpreter();
    try {
      /* open connection to irobot */
      executor.init();
      
      while (true) {
        /* read command */
        String cmd = console.readLine("> ");
        
        /* quit if given quit command */
        if (cmd.trim().equalsIgnoreCase("quit")) {
          break;
        }

        try {
          /* Interpret command given and build Command object */
          Optional<? extends Command> result = commandInterpreter
              .interpret(cmd);
          if (!result.isPresent()) {
            console.format("'%s' is not a valid command\n", cmd);
            continue;
          }

          /* execute command object */
          Command command = result.get();
          Optional<SensorData> response = executor.execute(command);
          if(response.isPresent()) {
            console.format("Command successful. Response: %s\n", response.get().toString());
          } else {
            console.format("Command successful.\n");
          }
        } catch (InterpreterException e) {
          printException(console, e);
        } catch (IRobotCreateException e) {
          printException(console, e);
        }
      }
      executor.shutdown();
    } catch (RuntimeException e) {
      printException(console, e);
    } 
  }
  
  private static void printException(Console console, RuntimeException e) {
    console.format("Exception : \n");
    e.printStackTrace(console.writer());
    console.format("\n");
  }

  /* build our command interpreter */
  public static CommandInterpreter<Command> buildInterpreter() {
    return new CommandInterpreterBuilder<Command>()
    	.add("start", null, OpCommand.class, Lists.newArrayList(OpCode.START))
    	.add("safe", null, OpCommand.class, Lists.newArrayList(OpCode.SAFE))
    	.add("full", null, OpCommand.class, Lists.newArrayList(OpCode.FULL))
    	.add("baud", "<i>", BaudCommand.class)
    	.add("demo", "<i>", DemoCommand.class)
    	.add("drive", "<s> <s>", DriveCommand.class, Lists.newArrayList(OpCode.DRIVE))
    	.add("drivedirect", "<s> <s>", DriveCommand.class, Lists.newArrayList(OpCode.DRIVE_DIRECT))
    	.add("led", "<f> <f> <i> <i>", LedCommand.class)
    	.add("dout", "<f> <f> <f>", DigitalOutputCommand.class)
    	.add("lowside", "<f> <f> <f>", LowSideDriver.class)
    	.add("lowsidepwm", "<i> <i> <i>", LowSideDriver.class)
    	.add("sendir", "<i>", OpCommand.class, Lists.newArrayList(OpCode.SEND_IR))
    	.add("waittime", "<i>", OpCommand.class, Lists.newArrayList(OpCode.WAIT_TIME))
    	.add("waitdistance", "<s>", WaitCommand.class, Lists.newArrayList(OpCode.WAIT_DISTANCE))
    	.add("waitangle", "<s>", WaitCommand.class, Lists.newArrayList(OpCode.WAIT_ANGLE))
    	.add("moveto", "<s> <s>", MoveToCommand.class)
    	.add("turn", "<s> <s>", TurnCommand.class)
    	.add("sensor", "<i>", SensorCommand.class)
    	.build();
  }

  /* get list of serial ports and prompt user for selection */
  public static Optional<String> getSerialPort(Console console) {
    String[] portNames = SerialPortList.getPortNames();
    if (portNames.length > 0) {
      for (int i = 0; i < portNames.length; i++) {
        console.format("[Port No] %d ==> %s\n", i, portNames[i]);
      }
      while (true) {
        try {
          int choice = Integer.valueOf(console.readLine("Enter Port No:"));
          if (choice >= 0 && choice < portNames.length) {
            return Optional.of(portNames[choice]);
          }
        } catch (NumberFormatException e) {
        }
      }
    }

    return Optional.absent();
  }
}
