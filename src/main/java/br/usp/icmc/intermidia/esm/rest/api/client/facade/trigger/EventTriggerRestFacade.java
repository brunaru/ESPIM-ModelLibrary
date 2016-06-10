package br.usp.icmc.intermidia.esm.rest.api.client.facade.trigger;

import java.net.URI;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class EventTriggerRestFacade extends GenericRestFacade<EventTrigger> implements RestFacade<EventTrigger> {

	private static final String RESOURCE = "triggers";

	private static final String[] linkNames = {};

	public EventTriggerRestFacade () {
		super(RESOURCE, linkNames);
	}

	@Override
	public boolean putRelationship(URI objectLocation, URI relationshipLocation) {
		return false;
	}

}
