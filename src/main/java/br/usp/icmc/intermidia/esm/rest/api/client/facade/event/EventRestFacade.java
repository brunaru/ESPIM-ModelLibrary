package br.usp.icmc.intermidia.esm.rest.api.client.facade.event;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.model.event.Event;

public abstract class EventRestFacade<T extends Event> extends GenericRestFacade<T> implements RestFacade<T> {

	/* Relationships */
	public static final String TRIGGERS = "triggers";
	public static final String SENSORS = "sensors";
	public static final String RESULTS = "results";
	public static final String RESULTS_QUESTION = "question-results";
	public static final String RESULTS_SENSOR = "sensor-results";
	public static final String RESULTS_TASK = "task-results";
	public static final String RESULTS_MEDIA = "media-results";

	public EventRestFacade(String resource) {
		super(resource);
	}
}
