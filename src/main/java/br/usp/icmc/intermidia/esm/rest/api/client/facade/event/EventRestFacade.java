package br.usp.icmc.intermidia.esm.rest.api.client.facade.event;

import java.net.URI;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public abstract class EventRestFacade<T extends Event> extends GenericRestFacade<T> implements RestFacade<T> {

	/* Relationships */
	public static final String TRIGGERS = "triggers";
	public static final String SENSORS = "sensors";
	public static final String RESULTS = "results";

	private static final String[] linkNames = { TRIGGERS, SENSORS, RESULTS };

	public EventRestFacade(String resource) {
		super(resource, linkNames);
	}

	public EventRestFacade(String resource, String[] links) {
		super(resource, links);
	}

	@Override
	public boolean putRelationship(URI objectLocation, URI relationshipLocation) {
		String relationship = relationshipLocation.toString();
		if (relationship.contains(TRIGGERS)) {
			return putTriggerRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(SENSORS)) {
			return putSensorRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(RESULTS)) {
			return putResultsRelationship(objectLocation, relationshipLocation);
		} else {
			return false;
		}
	}

	protected boolean putSensorRelationship(URI objectLocation, URI relationshipLocation) {
		T event = get(objectLocation);
		List<URI> sensors = getRelationshipLinks(event.getLinks().get(SENSORS), SENSORS);
		sensors.add(relationshipLocation);	
		event.setSensors(sensors);
		return patch(event, objectLocation);
	}

	protected boolean putTriggerRelationship(URI objectLocation, URI relationshipLocation) {
		T event = get(objectLocation);
		List<URI> triggers = getRelationshipLinks(event.getLinks().get(TRIGGERS), TRIGGERS);
		triggers.add(relationshipLocation);
		event.setTriggers(triggers);
		return patch(event, objectLocation);
	}

	protected boolean putResultsRelationship(URI objectLocation, URI relationshipLocation) {
		T event = get(objectLocation);
		List<URI> results = getRelationshipLinks(event.getLinks().get(RESULTS), RESULTS);
		results.add(relationshipLocation);
		event.setResults(results);
		return patch(event, objectLocation);
	}

}
