package com.bitbosh.DropwizardHeroku.api;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("events")
@Produces(MediaType.APPLICATION_JSON)
public class EventResource {

  @GET
  public List<Event> allEvents() {
    Event event = new Event();
    event.setDate(new Date());
    event.setName("Birthday");
    event.setId(1L);
    event.setDescription("BYOB");
    event.setLocation("Ollies");
    return Collections.singletonList(event);
  }

}
