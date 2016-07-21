package br.usp.icmc.intermidia.esm.rest.api.client.facade.event;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class ActiveEventRestFacade extends EventRestFacade<ActiveEvent> implements RestFacade<ActiveEvent> {

	public static final String RESOURCE = "active-events";
	/* Relationships */
	public static final String INTERVENTIONS = "interventions";
	/* Intervention types */
	public static final String INTERVENTION_MEDIA = "media-interventions";
	public static final String INTERVENTION_QUESTION = "question-interventions";
	public static final String INTERVENTION_TASK = "task-interventions";

	private static final String[] linkNames = { INTERVENTIONS, TRIGGERS, SENSORS, RESULTS };

	public ActiveEventRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public boolean putRelationship(URI objectLocation, URI relationshipLocation) {
		String relationship = relationshipLocation.toString();
		if (relationship.contains(INTERVENTIONS)) {
			return putInterventionsRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(TRIGGERS)) {
			return putTriggerRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(SENSORS)) {
			return putSensorRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(RESULTS)) {
			return putResultsRelationship(objectLocation, relationshipLocation);
		} else {
			return false;
		}
	}

	private boolean putInterventionsRelationship(URI objectLocation, URI relationshipLocation) {
		ActiveEvent event = get(objectLocation);
		List<URI> interventions = new ArrayList<URI>();
		interventions.addAll(getRelationshipLinks(event.getLinks().get(INTERVENTIONS), INTERVENTION_QUESTION));
		interventions.addAll(getRelationshipLinks(event.getLinks().get(INTERVENTIONS), INTERVENTION_TASK));
		interventions.addAll(getRelationshipLinks(event.getLinks().get(INTERVENTIONS), INTERVENTION_MEDIA));	
		interventions.add(relationshipLocation);
		event.setInterventions(interventions);
		return patch(event, objectLocation);
	}

}
