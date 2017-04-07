package com.bitbosh.DropwizardHeroku;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class MainConfiguration extends Configuration {


	@Valid
	@NotNull
	private DataSourceFactory database = new DataSourceFactory();

	/**
     * A getter for the database factory.
     *
     * @return An instance of database factory deserialized from the
     * configuration file passed as a command-line argument to the application.
	 * @throws URISyntaxException 
     */
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() throws URISyntaxException {
    	
    	// Overwrite the value read from the database property of the config.yml file 
    	// and use the value provided by Heroku environment.   
    	URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        this.database.setUser(username);
        this.database.setPassword(password);
        this.database.setUrl(dbUrl);
        return database;
    }
    
    /**
     * Needed to set the database factory when the config.yml file is loaded.
     * @param dataSourceFactory
     */
    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.database = dataSourceFactory;
    }
}
