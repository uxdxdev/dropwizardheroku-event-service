package com.bitbosh.dropwizardheroku.event.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.skife.jdbi.v2.DBI;

import com.bitbosh.dropwizardheroku.event.repository.EventDao;

import mockit.Expectations;
import mockit.Mocked;

public class EventResourceUnitTest {

  @Test
  public void EventResource_constructsSuccessfully_IfEventDaoNotNull(@Mocked DBI jdbi, @Mocked EventDao eventDao) {

    new Expectations() {
      {
        jdbi.onDemand(withAny(EventDao.class));
        result = eventDao; // return valid EventDao

        eventDao.createEventDatabaseTable();
        times = 1;
      }
    };

    EventResource eventResource = new EventResource(jdbi);
  }

  @Test(expected = NullPointerException.class)
  public void EventResource_throwsNullPointerExceptions_IfEventDaoNull(@Mocked DBI jdbi) {

    new Expectations() {
      {
        jdbi.onDemand(withAny(EventDao.class));
        result = null; // Do not return valid EventDao
      }
    };

    EventResource eventResource = new EventResource(jdbi);
  }

  @Test
  public void getEvent_expectedEventDaoMethodsInvoked_IfEventDaoNotNull(@Mocked DBI jdbi, @Mocked EventDao eventDao) {

    new Expectations() {
      {
        jdbi.onDemand(withAny(EventDao.class));
        result = eventDao;

        eventDao.createEventDatabaseTable();
        times = 1;

        eventDao.getEventByName(anyString);
        times = 1;
      }
    };

    EventResource eventResource = new EventResource(jdbi);

    Event event = eventResource.getEvent("test");
  }

  @Test(expected = NullPointerException.class)
  public void getEvent_throwsNullPointerException_IfEventDaoNull(@Mocked DBI jdbi) {

    new Expectations() {
      {
        jdbi.onDemand(withAny(EventDao.class));
        result = null;
      }
    };

    EventResource eventResource = new EventResource(jdbi);

    Event event = eventResource.getEvent("test");
  }

  @Test
  public void createEvent_expectedEventDaoMethodsInvoked_IfEventDaoNotNull(@Mocked DBI jdbi, @Mocked EventDao eventDao,
      @Mocked Event event) {

    new Expectations() {
      {
        jdbi.onDemand(withAny(EventDao.class));
        result = eventDao;

        eventDao.createEventDatabaseTable();
        times = 1;

        eventDao.createEvent(event.getName(), event.getLocation(), event.getLocation(), event.getDate());
        times = 1;
      }
    };

    EventResource eventResource = new EventResource(jdbi);
    eventResource.createEvent(event);
  }

  @Test(expected = NullPointerException.class)
  public void createEvent_throwsNullPointerException_IfEventDaoNull(@Mocked DBI jdbi, @Mocked Event event) {

    new Expectations() {
      {
        jdbi.onDemand(withAny(EventDao.class));
        result = null;
      }
    };

    EventResource eventResource = new EventResource(jdbi);
    eventResource.createEvent(event);
  }

  @Test
  public void getEvents_returnsEventList_IfEventListInjectedNotNull(@Mocked DBI jdbi, @Mocked EventDao eventDao) {

    List<Event> expectedList = new ArrayList<Event>();
    String expectedName = "testName";
    String expectedLocation = "testLocation";
    String expectedDescription = "testDescription";
    Date date = new Date();

    expectedList.add(new Event("testName", "testLocation", "testDescription", date));

    new Expectations() {
      {
        jdbi.onDemand(withAny(EventDao.class));
        result = eventDao;

        eventDao.createEventDatabaseTable();
        times = 1;

        eventDao.getEvents();
        result = expectedList;
        times = 1;
      }
    };

    EventResource eventResource = new EventResource(jdbi);
    ApiResponse response = eventResource.getEvents();
    List<Event> actualList = (List<Event>) response.getList();

    String actualName = actualList.get(0).getName();
    String actualLocation = actualList.get(0).getLocation();
    String actualDescription = actualList.get(0).getDescription();

    assertEquals(expectedName, actualName);
    assertEquals(expectedLocation, actualLocation);
    assertEquals(expectedDescription, actualDescription);
  }

  @Test
  public void getEvents_returnsNull_IfEventListInjectedNull(@Mocked DBI jdbi, @Mocked EventDao eventDao) {

    List<Event> expectedList = new ArrayList();

    new Expectations() {
      {
        jdbi.onDemand(withAny(EventDao.class));
        result = eventDao;

        eventDao.createEventDatabaseTable();
        times = 1;

        eventDao.getEvents();
        result = expectedList;
        times = 1;
      }
    };

    EventResource eventResource = new EventResource(jdbi);
    ApiResponse response = eventResource.getEvents();
    List<Event> actualList = (List<Event>) response.getList();

    assertEquals(expectedList, actualList);
  }
  
  @Test
  public void eventListSortedNewestToOldest(@Mocked DBI jdbi, @Mocked EventDao eventDao){
	  List<Event> expectedList = new ArrayList<Event>();
	  
	  Event newEvent = new Event();
	  newEvent.setName("New Event");
	  newEvent.setDate(new Date());
	  
	  Event oldEvent = new Event();
	  oldEvent.setName("Old Event");
	  Calendar cal = Calendar.getInstance();
	  cal.set(1970, 1, 1);
	  Date date = cal.getTime();	  	  
	  oldEvent.setDate(date);
	  
	  cal.set(1950, 1, 1);
	  date = cal.getTime();
	  Event olderEvent = new Event();
	  olderEvent.setDate(date);

	  // Add events out or order	  
	  expectedList.add(olderEvent); // index 0
	  expectedList.add(newEvent); // index 1
	  expectedList.add(oldEvent); // index 2
	  

	  
	    new Expectations() {
	      {
	        jdbi.onDemand(withAny(EventDao.class));
	        result = eventDao;

	        eventDao.createEventDatabaseTable();
	        times = 1;

	        eventDao.getEvents();
	        result = expectedList;
	        times = 1;
	      }
	    };

	    EventResource eventResource = new EventResource(jdbi);
	    ApiResponse response = eventResource.getEvents();
	    List<Event> actualList = (List<Event>) response.getList();
	    
	    // Check if events in list are ordered by Date
	    assertEquals(olderEvent, actualList.get(0));	    
	    assertEquals(oldEvent, actualList.get(1));	    
	    assertEquals(newEvent, actualList.get(2));
	    	    
  }
}
