package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.model.result.TaskResult;

public class TaskResultRestFacade extends ResultRestFacade<TaskResult> implements RestFacade<TaskResult> {

	public static final String RESOURCE = "task-results";
	/* Relationships */
	public static final String TASK = "task";

	public TaskResultRestFacade() {
		super(RESOURCE);
	}

}
