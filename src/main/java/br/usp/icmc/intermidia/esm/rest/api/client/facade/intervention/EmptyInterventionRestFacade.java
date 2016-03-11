package br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class EmptyInterventionRestFacade extends InterventionRestFacade implements RestFacade<Intervention> {

	private static final String RESOURCE = "empty-interventions";

	public EmptyInterventionRestFacade() {
		super(RESOURCE);
	}

}
