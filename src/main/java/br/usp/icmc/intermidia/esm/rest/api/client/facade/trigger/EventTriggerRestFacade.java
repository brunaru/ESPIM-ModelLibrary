package br.usp.icmc.intermidia.esm.rest.api.client.facade.trigger;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.GenericRestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class EventTriggerRestFacade extends GenericRestFacade<EventTrigger> implements RestFacade<EventTrigger> {

	public static final String RESOURCE = "triggers";

	public EventTriggerRestFacade () {
		super(RESOURCE);
	}

}
