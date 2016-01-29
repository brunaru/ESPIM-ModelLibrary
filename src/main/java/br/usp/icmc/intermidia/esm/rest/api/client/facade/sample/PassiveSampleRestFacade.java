package br.usp.icmc.intermidia.esm.rest.api.client.facade.sample;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class PassiveSampleRestFacade extends SampleRestFacade<PassiveSample> implements RestFacade<PassiveSample> {

	private static final String RESOURCE = "passive-samples";

	public PassiveSampleRestFacade() {
		super(RESOURCE);
	}

}
