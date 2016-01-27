package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class TaskResultRestFacade extends GenericRestFacade<TaskResult> implements RestFacade<TaskResult> {

	private static final String RESOURCE = "task-result";
	/* Relationships */
	private static final String TASK = "task";

	private static final String[] linkNames = { TASK };

	public TaskResultRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public URI putRelationship(URI objectLocation, URI relationshipLocation) {
		TaskResult taskResult = get(objectLocation);
		taskResult.setTask(relationshipLocation);
		return put(taskResult, objectLocation);
	}

}
