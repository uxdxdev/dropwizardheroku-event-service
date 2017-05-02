package com.bitbosh.dropwizardheroku.event;

import java.net.URISyntaxException;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.skife.jdbi.v2.DBI;

import com.bitbosh.dropwizardheroku.event.api.EventResource;
import com.bitbosh.dropwizardheroku.event.api.ExampleResource;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Main extends Application<ApplicationConfiguration> {

  public static void main(String[] args) throws Exception {
    new Main().run(args);
  }

  @Override
  public void run(ApplicationConfiguration configuration, Environment environment) throws URISyntaxException {

    // Create a DBIFactory to build instances of Dao classes for each Resource
    // in the application.
    final DBIFactory factory = createDbiFactory();

    // The database configuration details are read from the DataSourcFactory
    // within the
    // MainConfiguration class.
    final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");

    // Register each Resource with jersey and pass in the Dao so that it can
    // interact with the database.
    JerseyEnvironment jerseyEnvironment = environment.jersey();
    jerseyEnvironment.register(new ExampleResource());
    jerseyEnvironment.register(new EventResource(jdbi));
    
    // Enable CORS headers
    final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

    // Configure CORS parameters
    cors.setInitParameter("allowedOrigins", "*");
    cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
    cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

    // Add URL mapping
    cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
  }

  private DBIFactory createDbiFactory() {
    return new DBIFactory();
  }

  @Override
  public void initialize(Bootstrap<ApplicationConfiguration> configuration) {
  }
}