package br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention.Intervention;

public abstract class InterventionRestFacade<T extends Intervention> extends GenericRestFacade<T> implements RestFacade<T> {

	private static final String[] linkNames = {};

	public InterventionRestFacade(String resource) {
		super(resource, linkNames);
	}

	public InterventionRestFacade(String resource, String[] links) {
		super(resource, links);
	}

	@Override
	public boolean putRelationship(URI objectLocation, URI relationshipLocation) {
		return false;
	}
}
