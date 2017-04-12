package com.bitbosh.DropwizardHeroku.api;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class EventUnitTest {

  @Test
  public void Event_constructedSuccessfully_IfDefaultCtorCalled() {
    Event event = new Event();
    int expectedId = 0;
    String expectedName = "";
    String expectedDescription = "";
    String expectedLocation = "";
    Date expectedDate = new Date();

    int actualId = event.getId();
    String actualName = event.getName();
    String actualDescription = event.getDescription();
    String actualLocation = event.getLocation();
    Date actualDate = event.getDate();

    assertEquals(expectedId, actualId);
    assertEquals(expectedName, actualName);
    assertEquals(expectedDescription, actualDescription);
    assertEquals(expectedLocation, actualLocation);
    assertEquals(expectedDate, actualDate);
  }

}
