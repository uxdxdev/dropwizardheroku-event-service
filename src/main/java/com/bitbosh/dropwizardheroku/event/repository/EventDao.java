package com.bitbosh.dropwizardheroku.event.repository;

import java.util.Date;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.bitbosh.dropwizardheroku.event.api.Event;

public interface EventDao {
  @SqlUpdate("create table if not exists event (id serial primary key, name varchar(100), location varchar(100), description varchar(100), date date)")
  void createEventDatabaseTable();

  @SqlUpdate("insert into event (name, location, description, date) values (:name, :location, :description, :date)")
  void createEvent(@Bind("name") String name, @Bind("location") String location,
      @Bind("description") String description, @Bind("date") Date date);

  @Mapper(EventMapper.class)
  @SqlQuery("select * from event where name = :name")
  Event getEventByName(@Bind("name") String name);

  @Mapper(EventMapper.class)
  @SqlQuery("select * from event where date > now()")
  List<Event> getEvents();

  @Mapper(EventMapper.class)
  @SqlQuery("delete from event where id=:id")
  void deleteEventById(@Bind("id") int id);
}
