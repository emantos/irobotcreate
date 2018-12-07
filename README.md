irobotcreate
============

irobotcreate is my attempt to create a Command-based API written in Java for the iRobot Create.

My testing device is a raspberry pi connected to the irobot create via the UART over USB.

I have also tested the API on a Lenovo Laptop connected to the irobot create via UART

How to Use
==========

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

API
===

Under construction :D

* Import maven dependency to your project
<code>
  ...
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
  ...
</code>

* In your code, create an instance of the SerialPortConnection (to your serial port), and the IRobotCreate.

<code>
  Connection connection = new SerialPortConnection("/dev/ttyUSB0", DEFAULT_TIMEOUT);
  IRobotCreate executor = new IRobotCreate(connection);
</code>

* Create command instance and execute it (always start with start and setFull).

<code>
  Command start = CommandFactory.start();
  Command setFull = CommandFactory.setFull();
  Command moveTo = CommandFactory.moveTo(100, 500);
  
  executor.execute(start);
  executor.execute(setFull);
  executor.execute(moveTo);
</code>

