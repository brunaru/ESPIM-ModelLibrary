package br.usp.icmc.intermidia.esm.rest.api.client.facade.sample;

import java.net.URI;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class ActiveSampleRestFacade extends SampleRestFacade implements RestFacade<Sample> {

	private static final String RESOURCE = "active-samples";
	/* Relationships */
	private static final String INTERVENTIONS = "interventions";
	private static final String TRIGGERS = "triggers";
	private static final String SENSORS = "sensors";

	private static final String[] linkNames = { INTERVENTIONS, TRIGGERS, SENSORS };

	public ActiveSampleRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public URI putRelationship(URI objectLocation, URI relationshipLocation) {
		String relationship = relationshipLocation.toString();
		if (relationship.contains(INTERVENTIONS)) {
			return putInterventionsRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(TRIGGERS)) {
			return putTriggerRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(SENSORS)) {
			return putSensorRelationship(objectLocation, relationshipLocation);
		} else {
			return null;
		}		
	}

	private URI putInterventionsRelationship(URI objectLocation, URI relationshipLocation) {
		ActiveSample sample = (ActiveSample) get(objectLocation);
		List<URI> interventions = getRelationshipLinks(sample.getLinks().get(INTERVENTIONS), INTERVENTIONS);
		interventions.add(relationshipLocation);
		sample.setInterventions(interventions);
		return put(sample, objectLocation);
	}

}
