package com.paraam.cpeagent;

import javax.inject.Named;

import org.h2.jdbcx.JdbcConnectionPool;
import org.skife.jdbi.v2.DBI;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.yammer.dropwizard.config.Configuration;
// import com.yammer.dropwizard.db.DatabaseConfiguration;
// import com.fasterxml.jackson.annotation.JsonProperty;



// import javax.validation.Valid;
// import javax.validation.constraints.NotNull;


public class SimulatorModule extends AbstractModule  {

	final JdbcConnectionPool ds = JdbcConnectionPool.create("jdbc:h2:test","sa", "");
	final DBI dbi = new DBI(ds);

	@Override
	protected void configure() {

	}

	@Provides
	public SimulatorConfiguration configuration(Configuration configuration) {
		return (SimulatorConfiguration) configuration;
	}


	@Provides
	@Named("dbi")
	public DBI provideDBI() {
		return dbi;
	}

	@Provides
	@Named("http_port")
	public int provideHttpPort(SimulatorConfiguration configuration) {
		return configuration.getHttp_port();
	}


	/*
	@Provides
	@Named("trap_port")
	public int provideTrapPort(BrowserConfiguration configuration) {
		return configuration.getTrap_port() ;
	}
	
	@Valid
    @NotNull
    @JsonProperty("database")
    private DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
	public void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }


	 */


}
