package br.usp.icmc.intermidia.esm.rest.api.client.facade.event;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.model.event.ActiveEvent;

public class ActiveEventRestFacade extends EventRestFacade<ActiveEvent> implements RestFacade<ActiveEvent> {

	public static final String RESOURCE = "active-events";
	/* Relationships */
	public static final String INTERVENTIONS = "interventions";
	/* Intervention types */
	public static final String INTERVENTION_MEDIA = "media-interventions";
	public static final String INTERVENTION_QUESTION = "question-interventions";
	public static final String INTERVENTION_TASK = "task-interventions";
	public static final String INTERVENTION_EMPTY = "empty-interventions";

	public ActiveEventRestFacade() {
		super(RESOURCE);
	}

}
