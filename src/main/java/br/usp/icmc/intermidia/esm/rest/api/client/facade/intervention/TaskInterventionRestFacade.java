package br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.model.intervention.TaskIntervention;

public class TaskInterventionRestFacade extends InterventionRestFacade<TaskIntervention> implements RestFacade<TaskIntervention> {

	public static final String RESOURCE = "task-interventions";

	public TaskInterventionRestFacade() {
		super(RESOURCE);
	}

}
