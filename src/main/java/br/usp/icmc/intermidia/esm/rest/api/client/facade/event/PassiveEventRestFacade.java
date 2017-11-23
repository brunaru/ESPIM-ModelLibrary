package br.usp.icmc.intermidia.esm.rest.api.client.facade.event;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;
import br.usp.icmc.intermidia.esm.rest.api.client.model.event.PassiveEvent;

public class PassiveEventRestFacade extends EventRestFacade<PassiveEvent> implements RestFacade<PassiveEvent> {

	public static final String RESOURCE = "passive-events";

	public PassiveEventRestFacade() {
		super(RESOURCE);
	}

}
