package br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.model.intervention.EmptyIntervention;

public class EmptyInterventionRestFacade extends InterventionRestFacade<EmptyIntervention> implements RestFacade<EmptyIntervention> {

	public static final String RESOURCE = "empty-interventions";

	public EmptyInterventionRestFacade() {
		super(RESOURCE);
	}

}
