package br.usp.icmc.intermidia.esm.rest.api.client.facade.intervention;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class MediaInterventionRestFacade extends InterventionRestFacade<MediaIntervention> implements RestFacade<MediaIntervention> {

	public static final String RESOURCE = "media-interventions";

	public MediaInterventionRestFacade() {
		super(RESOURCE);
	}

}
