package br.usp.icmc.intermidia.esm.rest.api.client.facade.trigger;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class EventRestFacade extends GenericRestFacade<EventTrigger> implements RestFacade<EventTrigger> {

	private static final String RESOURCE = "triggers";

	private static final String[] linkNames = {};

	public EventRestFacade() {
		super(RESOURCE, linkNames);
	}

	@Override
	public URI putRelationship(URI objectLocation, URI relationshipLocation) {
		return null;
	}

}
