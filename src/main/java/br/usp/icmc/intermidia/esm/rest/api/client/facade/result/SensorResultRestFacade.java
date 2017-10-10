package br.usp.icmc.intermidia.esm.rest.api.client.facade.result;

import br.usp.icmc.intermidia.esm.rest.api.client.facade.RestFacade;

public class SensorResultRestFacade extends ResultRestFacade<SensorResult> implements RestFacade<SensorResult> {

	public static final String RESOURCE = "sensor-results";
	/* Relationships */
	public static final String SENSOR = "sensor";

	public SensorResultRestFacade() {
		super(RESOURCE);
	}

}
