
package com.bitbosh.DropwizardHeroku.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bitbosh.DropwizardHeroku.api.ExampleResource;
import com.bitbosh.DropwizardHeroku.repository.ExampleResourceRepository;

import mockit.Mocked;

public class ExampleResourceUnitTest {

  @Mocked
  ExampleResourceRepository resourceDao;

  private ExampleResource resourceInstance = new ExampleResource(resourceDao);

  @Test
  public void hello_returnsCorrectString_IfMethodInvoked() {
    final String expectedResult = "Hello\n";
    final String actualResult = resourceInstance.hello();
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void query_returnsCorrectStringWithMessage_IfNonEmptyStringMessageAsParameter() {
    final String message = "test";
    final String expectedResult = "You passed " + message + "\n";
    final String actualResult = resourceInstance.query(message);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void query_returnsCorrectStringWithMessage_IfNullStringMessageAsParameter() {
    final String message = null;
    final String expectedResult = "You passed " + message + "\n";
    final String actualResult = resourceInstance.query(message);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void postBody_returnsCorrectStringWithMessage_IfNonEmptyStringMessageAsParameter() {
    final String message = "test";
    final String expectedResult = "You posted " + message + "\n";
    final String actualResult = resourceInstance.postBody(message);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void postBody_returnsCorrectStringWithMessage_IfNullStringMessageAsParameter() {
    final String message = null;
    final String expectedResult = "You posted " + message + "\n";
    final String actualResult = resourceInstance.postBody(message);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void postParam_returnsCorrectStringWithMessage_IfNonEmptyStringMessageAsParameter() {
    final String message = "test";
    final String expectedResult = "You posted " + message + "\n";
    final String actualResult = resourceInstance.postParam(message);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void postParam_returnsCorrectStringWithMessage_IfNullStringMessageAsParameter() {
    final String message = null;
    final String expectedResult = "You posted " + message + "\n";
    final String actualResult = resourceInstance.postParam(message);
    assertEquals(expectedResult, actualResult);
  }

}
