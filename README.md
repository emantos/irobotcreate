irobotcreate
============

irobotcreate is my attempt to create a Command-based API written in Java for the iRobot Create.

My testing device is a raspberry pi connected to the irobot create via the UART over USB.

I have also tested the API on a Lenovo Laptop connected to the irobot create via UART

How to Use
==========

1. Connect the serial usb cable from computer to robot.
2. Build the api source code, go to irobotcreate-api directory and <code>mvn clean install</code>
3. Build the shell source code, go to irobotcreate-shell directory and <code>mvn clean package</code>
3. Run the shell <code>java -jar target/irobotcreate-shell-1.0-SNAPSHOT-jar-with-dependencies.jar</code>
4. Choose which serial port to use.

The Shell
=========

* The first command to be sent should be <code>start</code> followed by <code>safe</code> or <code>full</code>
* <code>moveto 2000 100</code> moves the robot 2000mm forward with 100mm/sec velocity
* <code>turn 180 50</code> Turn-around using 50mm/sec velocity
* And many more.

API
===

Under construction :D
