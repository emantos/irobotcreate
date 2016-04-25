package com.kapre.irobot;

import org.junit.Assert;
import org.junit.Test;

public class ResponsePocTest {

  class TestResponse implements SensorData {
    boolean getResponse() {
      return true;
    }
  }

  class Test2Response implements SensorData {
    boolean getResponse2() {
      return false;
    }
  }

  @Test
  public void test() {
    Command test = new Command() {
      public byte[] getCommand() {
        return null;
      }

      public boolean isExpectResponse() {
        return true;
      }

      public int getLengthResponse() {
        return 1;
      }

      @SuppressWarnings("unchecked")
      public <K extends SensorData> K getResponse(byte[] response) {
        if (response[0] == 0) {
          return (K) new TestResponse();
        } else {
          return (K) new Test2Response();
        }
      }
    };

    TestResponse _response = test.getResponse(new byte[] { 0 });
    Test2Response _response2 = test.getResponse(new byte[] { 1 });
    Assert.assertTrue(_response.getResponse());
    Assert.assertFalse(_response2.getResponse2());

    SensorData responseInterface = test.getResponse(new byte[] { 0 });
    SensorData responseInterface2 = test.getResponse(new byte[] { 1 });

    try {
      Test2Response response2 = test.getResponse(new byte[] { 0 });
      Assert.fail("should have produced a class cast exception");
    } catch (ClassCastException e) {

    }

    try {
      TestResponse response1 = test.getResponse(new byte[] { 1 });
      Assert.fail("should have produced a class cast exception");
    } catch (ClassCastException e) {

    }
  }
}
