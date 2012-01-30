package com.abouchama;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sample {EventHandler} that just logs the events it receives
 */
public class LoggingEventListener implements EventHandler {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingEventListener.class);

    public void handleEvent(Event event) {
    	
        StringBuffer buffer = new StringBuffer();
        buffer.append(String.format("Event [%n"));
        buffer.append(String.format("Topic: %s%n", event.getTopic()));
        for (String name : event.getPropertyNames()) {
            buffer.append(String.format("%n%s = %s", name, event.getProperty(name)));
        }
        
        buffer.append("]");
        LOGGER.info(buffer.toString());
        
    }
}
