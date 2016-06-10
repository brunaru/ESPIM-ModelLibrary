package br.usp.icmc.intermidia.esm.rest.api.client.facade.program;

import java.net.URI;
import java.util.List;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.Constants;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class ProgramRestFacade extends GenericRestFacade<Program> implements RestFacade<Program> {

	private static final String RESOURCE = "programs";
	/* Relationships */
	private static final String PARTICIPANTS = "participants";
	private static final String OBSERVERS = "observers";
	private static final String EVENTS = "events";

	private static final String[] linkNames = { PARTICIPANTS, OBSERVERS, EVENTS };

	public ProgramRestFacade() {
		super(RESOURCE, linkNames);
	}
	
	public List<Program> findByParticipantsEmail(String email) {
		String s = Constants.REST_API_ADDRESS + RESOURCE + "/" + "search/findByParticipantsEmail?email=" + email;
		return findMultipleByEmail(email, s, "findByParticipantsEmail");
	}

	public List<Program> findByObserversEmail(String email) {
		String s = Constants.REST_API_ADDRESS + RESOURCE + "/" + "search/findByObserversEmail?email=" + email;
		return findMultipleByEmail(email, s, "findByObserversEmail");
	}

	@Override
	public boolean putRelationship(URI objectLocation, URI relationshipLocation) {
		String relationship = relationshipLocation.toString();
		if (relationship.contains(PARTICIPANTS)) {
			return putParticipantRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(OBSERVERS)) {
			return putObserverRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(EVENTS)) {
			return putEventRelationship(objectLocation, relationshipLocation);
		} else {
			return false;
		}
	}

	private boolean putParticipantRelationship(URI programLocation, URI relationshipLocation) {
		Program program = get(programLocation);
		List<URI> participants = getRelationshipLinks(program.getLinks().get(PARTICIPANTS), PARTICIPANTS);
		participants.add(relationshipLocation);
		program.setParticipants(participants);
		return patch(program, programLocation);
	}

	private boolean putEventRelationship(URI programLocation, URI relationshipLocation) {
		Program program = get(programLocation);
		List<URI> events = getRelationshipLinks(program.getLinks().get(EVENTS), EVENTS);
		events.add(relationshipLocation);
		program.setEvents(events);
		return patch(program, programLocation);
	}

	private boolean putObserverRelationship(URI programLocation, URI relationshipLocation) {
		Program program = get(programLocation);
		List<URI> observers = getRelationshipLinks(program.getLinks().get(OBSERVERS), OBSERVERS);
		observers.add(relationshipLocation);
		program.setObservers(observers);
		return patch(program, programLocation);
	}

}
