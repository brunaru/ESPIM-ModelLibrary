package br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.model.intervention.Intervention;

public abstract class InterventionRestFacade<T extends Intervention> extends GenericRestFacade<T> implements RestFacade<T> {

	public InterventionRestFacade(String resource) {
		super(resource);
	}

	public InterventionRestFacade(String resource, String[] links) {
		super(resource);
	}
}
