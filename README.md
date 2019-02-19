iRobotCreate
============

irobotcreate is my attempt to create a Command-based API written in Java for the iRobot Create.

My testing device is a raspberry pi connected to the irobot create via the UART over USB.

I have also tested the API on a Lenovo Laptop connected to the irobot create via UART

How to Use (CLI)
================

1. Connect the serial usb cable from computer to robot.
2. Build the api source code, go to irobotcreate-api directory and <code>mvn clean install</code>
4. Build the shell source code, go to irobotcreate-shell directory and <code>mvn clean package</code>
5. Run the shell <code>java -jar target/irobotcreate-shell-1.0-SNAPSHOT-jar-with-dependencies.jar</code>
6. Choose which serial port to use.

The Shell
=========

* The first command to be sent should be <code>start</code> followed by <code>safe</code> or <code>full</code>
* <code>moveto 2000 100</code> moves the robot 2000mm forward with 100mm/sec velocity
* <code>turn 180 50</code> Turn-around using 50mm/sec velocity
* And many more.

How to Use (programmatically)
==================================

* Import maven dependency to your project
  ```xml
  <dependency>
    <groupId>com.kapre</groupId>
    <artifactId>irobotcreate-api</artifactId>
    <version>1.0-SNAPSHOT</version>
  </dependency>
  <dependency>
    <groupId>com.kapre</groupId>
    <artifactId>irobotcreate-shell</artifactId>
    <version>1.0-SNAPSHOT</version>
  </dependency>
  ```

* In your code, create an instance of the SerialPortConnection (to your serial port), and the IRobotCreate.

  ```java
  Connection connection = new SerialPortConnection("/dev/ttyUSB0", DEFAULT_TIMEOUT);
  IRobotCreate executor = new IRobotCreate(connection);
  
  executor.init()
  ```

* Create command instance and execute it (always start with start and setFull).

  ```java
  Command start = CommandFactory.start();
  Command setFull = CommandFactory.setFull();
  Command moveTo = CommandFactory.moveTo(2000, 100);

  executor.execute(start);
  executor.execute(setFull);
  executor.execute(moveTo);
  ```
* The <code>CommandFactory</code> is a factory class for all primitive commands supported by <code>iRobot's Create</code>. You can also create composite commands (commands made up of several primitives). Check the <code>MoveToCommand</code> class for an example on how to create a composite command.
