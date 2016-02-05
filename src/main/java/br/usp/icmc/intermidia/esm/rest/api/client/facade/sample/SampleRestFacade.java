package br.usp.icmc.intermidia.esm.rest.api.client.facade.sample;

import java.net.URI;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public abstract class SampleRestFacade<T extends Sample> extends GenericRestFacade<T> implements RestFacade<T> {

	/* Relationships */
	protected static final String TRIGGERS = "triggers";
	protected static final String SENSORS = "sensors";
	protected static final String RESULTS = "results";

	private static final String[] linkNames = { TRIGGERS, SENSORS, RESULTS };

	public SampleRestFacade(String resource) {
		super(resource, linkNames);
	}

	public SampleRestFacade(String resource, String[] links) {
		super(resource, links);
	}

	@Override
	public URI putRelationship(URI objectLocation, URI relationshipLocation) {
		String relationship = relationshipLocation.toString();
		if (relationship.contains(TRIGGERS)) {
			return putTriggerRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(SENSORS)) {
			return putSensorRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(RESULTS)) {
			return putResultsRelationship(objectLocation, relationshipLocation);
		} else {
			return null;
		}
	}

	protected URI putSensorRelationship(URI objectLocation, URI relationshipLocation) {
		T sample = get(objectLocation);
		List<URI> sensors = getRelationshipLinks(sample.getLinks().get(SENSORS), SENSORS);
		sensors.add(relationshipLocation);
		sample.setSensors(sensors);
		return put(sample, objectLocation);
	}

	protected URI putTriggerRelationship(URI objectLocation, URI relationshipLocation) {
		T sample = get(objectLocation);
		List<URI> triggers = getRelationshipLinks(sample.getLinks().get(TRIGGERS), TRIGGERS);
		triggers.add(relationshipLocation);
		sample.setTriggers(triggers);
		return put(sample, objectLocation);
	}

	protected URI putResultsRelationship(URI objectLocation, URI relationshipLocation) {
		T sample = get(objectLocation);
		List<URI> results = getRelationshipLinks(sample.getLinks().get(RESULTS), RESULTS);
		results.add(relationshipLocation);
		sample.setResults(results);
		return put(sample, objectLocation);
	}

}
