package com.student.webservices.config;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class AppResourceConfig extends ResourceConfig {
	
	public AppResourceConfig() {
		// if there are more than two packages then separate them with semicolon
		// exmaple : packages("org.foo.rest;org.bar.rest");
		packages("com.student.webservices.controllers");
		register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
	}
}
