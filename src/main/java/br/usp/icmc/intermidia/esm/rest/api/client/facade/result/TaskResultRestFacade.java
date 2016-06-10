package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class TaskResultRestFacade extends ResultRestFacade<TaskResult> implements RestFacade<TaskResult> {

	private static final String RESOURCE = "task-result";
	/* Relationships */
	private static final String TASK = "task";

	private static final String[] linkNames = { TASK, PARTICIPANT };

	public TaskResultRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public boolean putRelationship(URI objectLocation, URI relationshipLocation) {
		String relationship = relationshipLocation.toString();
		if (relationship.contains(PARTICIPANT)) {
			return putParticipantRelationship(objectLocation, relationshipLocation);
		} else if (relationship.contains(TASK)) {
			TaskResult taskResult = get(objectLocation);
			taskResult.setTask(relationshipLocation);
			return patch(taskResult, objectLocation);
		} else {
			return false;
		}		
	}

}
