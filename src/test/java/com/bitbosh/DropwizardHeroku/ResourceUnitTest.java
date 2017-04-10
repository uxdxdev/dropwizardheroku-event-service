
package com.bitbosh.DropwizardHeroku;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ResourceUnitTest {

  private Resource resource;

  @Before
  public void setup() {
    resource = new Resource();
  }

  @Test
  public void hello_returnsHelloString_IfHelloMethodInvoked() {
    final String expectedResult = "Hello\n";
    final String actualResult = resource.hello();
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void query_returnsCorrectStringWithMessage_IfNonEmptyStringMessageAsParameter() {
    final String message = "test";
    final String expectedResult = "You passed " + message + "\n";
    final String actualResult = resource.query(message);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void query_returnsCorrectStringWithMessage_IfNullStringMessageAsParameter() {
    final String message = null;
    final String expectedResult = "You passed " + message + "\n";
    final String actualResult = resource.query(message);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void postBody_returnsCorrectStringWithMessage_IfNonEmptyStringMessageAsParameter() {
    final String message = "test";
    final String expectedResult = "You posted " + message + "\n";
    final String actualResult = resource.postBody(message);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void postBody_returnsCorrectStringWithMessage_IfNullStringMessageAsParameter() {
    final String message = null;
    final String expectedResult = "You posted " + message + "\n";
    final String actualResult = resource.postBody(message);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void postParam_returnsCorrectStringWithMessage_IfNonEmptyStringMessageAsParameter() {
    final String message = "test";
    final String expectedResult = "You posted " + message + "\n";
    final String actualResult = resource.postParam(message);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void postParam_returnsCorrectStringWithMessage_IfNullStringMessageAsParameter() {
    final String message = null;
    final String expectedResult = "You posted " + message + "\n";
    final String actualResult = resource.postParam(message);
    assertEquals(expectedResult, actualResult);
  }
}
